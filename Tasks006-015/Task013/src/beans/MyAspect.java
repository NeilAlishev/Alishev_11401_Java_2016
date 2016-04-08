package beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Nail Alishev
 *         11-401
 *         task 013
 */
@Aspect
@Component
public class MyAspect {

    @Around("execution(* *.setEmail(String))")
    public Object checkEmail(ProceedingJoinPoint jp) throws Throwable {
        String email = ((String) jp.getArgs()[0]);
        if (email.matches("\\w+@\\w+\\.(com|ru)")) {
            return jp.proceed();
        } else {
            System.out.println("Your email is invalid...");
            return null;
        }
    }
}
