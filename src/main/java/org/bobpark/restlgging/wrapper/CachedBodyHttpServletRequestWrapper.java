package org.bobpark.restlgging.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;

public class CachedBodyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] cachedBody;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public CachedBodyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        InputStream inputStream = request.getInputStream();
        cachedBody = StreamUtils.copyToByteArray(inputStream);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyServletInputStream(cachedBody);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.cachedBody);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }
}
