package ru.kpfu.itis.NeilAlishev.sem1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
@Aspect
public class Logging {

    private final static Logger logger = Logger.getLogger(Logging.class);

    private Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        StringBuilder info = new StringBuilder();
        long start = System.currentTimeMillis();
        Object result = jp.proceed();
        info.append(jp.getTarget().getClass().getSimpleName()).append(".")
                .append(jp.getSignature().getName())
                .append("(").append(Arrays.toString(jp.getArgs())).append(")")
                .append(" : ").append(result)
                .append(" in ").append(System.currentTimeMillis() - start).append(" msec.");
        logger.info(info);
        return result;
    }

    @Around("execution(* ru.kpfu.itis.NeilAlishev.sem1.repositories.*.*(..))")
    public Object logRepository(ProceedingJoinPoint jp) throws Throwable {
        return logMethodInvocation(jp);
    }

    @Around("execution(* ru.kpfu.itis.NeilAlishev.sem1.service.*.*(..))")
    public Object logService(ProceedingJoinPoint jp) throws Throwable {
        return logMethodInvocation(jp);
    }

}
