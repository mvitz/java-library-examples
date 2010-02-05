package de.mvitz.examples.spring.aop.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAdvice {

    private static final Log LOG = LogFactory.getLog(AnnotationAdvice.class);

    @Pointcut("execution(void de.mvitz.examples.spring.aop.common.Manager.doSomething())")
    public void managerDoesSomething() {
    }

    @Around("managerDoesSomething()")
    public Object logDuration(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("Around before");
        Object val = pjp.proceed();
        LOG.info("Around after");
        return val;
    }

}
