import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by neil on 22.03.16.
 */
public class ApplicationContextSingleton {
    private static ApplicationContext ac;

    public static ApplicationContext getApplicationContext() {
        if (ac == null)
            ac = new ClassPathXmlApplicationContext("spring-config.xml");
        return ac;
    }
}
