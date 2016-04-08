import beans.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by neil on 25.03.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Test test = ac.getBean(Test.class);
        test.setEmail("nailalishev@yahoo.com");
    }

}
