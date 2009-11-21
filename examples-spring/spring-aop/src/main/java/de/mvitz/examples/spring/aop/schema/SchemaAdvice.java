package de.mvitz.examples.spring.aop.schema;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class SchemaAdvice {

    private static final Log LOG = LogFactory.getLog(SchemaAdvice.class);

    public Object logDuration(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("Around before");
        Object val = pjp.proceed();
        LOG.info("Around after");
        return val;
    }

}
