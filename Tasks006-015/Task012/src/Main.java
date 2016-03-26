import beans.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Nail Alishev
 *         11-401
 *         task 012
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Test test = ac.getBean(Test.class);
        test.executeSQL("hey'; delete * from users where username = 'SomeName");
    }
}
