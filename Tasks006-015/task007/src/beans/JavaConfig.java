package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nail Alishev
 *         11-401
 *         task 007
 */
@Configuration
@ComponentScan(basePackages = ("beans"))
public class JavaConfig {

    @Bean
    public OppositionLIder oppositionLIder() {
        return new OppositionLIder("Alexey", 30);
    }

    @Bean
    public Person person() {
        return new Person("Someone", 15);
    }

    @Bean
    public PoliticalFigure politicalFigure() {
        return new PoliticalFigure("Vladimir", 50);
    }

    @Bean
    public President president() {
        return new President("Vladimir", 50);
    }

    @Bean
    public PresidentsAssistant PresidentsAssistant() {
        return new PresidentsAssistant("Peskov", 50);
    }


}
