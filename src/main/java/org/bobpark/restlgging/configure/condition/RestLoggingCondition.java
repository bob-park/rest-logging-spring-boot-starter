package org.bobpark.restlgging.configure.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RestLoggingCondition implements Condition {

    private static final String PROPERTY_ENABLE = "rest-logging.enable";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty(PROPERTY_ENABLE, Boolean.class, true);
    }
}
