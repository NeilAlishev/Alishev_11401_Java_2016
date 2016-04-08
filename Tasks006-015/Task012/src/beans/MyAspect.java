package beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Nail Alishev
 *         11-401
 *         task 012
 */
@Aspect
@Component
public class MyAspect {

    @Around("execution(void beans.Test.executeSQL(String))")
    public Object checkSQL(ProceedingJoinPoint jp) throws Throwable {
        String sql = (String) jp.getArgs()[0];
        if (sql.matches(".*(\'|\")(or|;).*")) {
            System.out.println("You'd better say sorry");
            return null;
        } else {
            return jp.proceed();
        }
    }
}
