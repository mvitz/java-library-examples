package de.mvitz.examples.spring.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApiAdvice implements MethodInterceptor {

    private static final Log LOG = LogFactory.getLog(ApiAdvice.class);

    @Override
    public Object invoke(MethodInvocation method) throws Throwable {
        LOG.info("Around before");
        Object val = method.proceed();
        LOG.info("Around after");
        return val;
    }

}
