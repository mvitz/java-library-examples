package de.mvitz.examples.aspectj;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.aspectj.lang.JoinPoint;

public aspect Log4JTraceAspect pertypewithin(*) {

    private Logger LOG;

    after() returning: staticinitialization(*) {
        LOG = Logger.getLogger(getWithinTypeName());
    }

    pointcut tracedNonVoid() : execution(!void *.*(..)) && !within(Log4JTraceAspect);
    pointcut tracedVoid() : execution(void *.*(..)) && !within(Log4JTraceAspect);
    pointcut traced() : tracedVoid() || tracedNonVoid();

    before() : traced() {
        LOG.debug(signature(thisJoinPointStaticPart) + "Entered");
        NDC.push("   ");
    }

    after() : traced() {
        NDC.pop();
    }

    after() returning(Object result) : tracedNonVoid() {
        LOG.debug(signature(thisJoinPointStaticPart) + "Returned [" + result + "]");
    }

    after() returning() : tracedVoid() {
        LOG.debug(signature(thisJoinPointStaticPart) + "Returned");
    }

    after() throwing(Exception ex) : traced() {
        LOG.debug(signature(thisJoinPointStaticPart) + "Throwed [" + ex + "]");
    }

    private String signature(JoinPoint.StaticPart staticPart) {
        return staticPart.getSignature().toShortString() + ": ";
    }

}
