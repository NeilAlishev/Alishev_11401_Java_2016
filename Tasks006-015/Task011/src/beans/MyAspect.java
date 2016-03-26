package beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * @author Nail Alishev
 *         11-401
 *         task 011
 */
@Aspect
@Component
public class MyAspect {

    @Around("execution(void beans.Login.doPost(..))")   // Проверки валидности из класса Login переместил в аспект
    public Object validateUser(ProceedingJoinPoint jp) throws Throwable {
        HttpServletRequest request = jp.getArgs()[0];
        if ((!request.getParameter("email").equals("")) && (!request.getParameter("password").equals(""))) {
            if (UsersRepository.isRegistered(request.getParameter("email"), request.getParameter("password"))) {
                return jp.proceed();
            } else {
                System.out.println("User doesn't exist");
                return null;
            }
        } else {
            System.out.println("invalid input");
            return null;
        }
    }

    @Before("execution(void beans.Login.doGet(..))")
    public void isSignedIn() {   // Если пользователь авторизирован, то его надо перевести на страницу профиля
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            response.sendRedirect("/profile");
        }
    }
}
