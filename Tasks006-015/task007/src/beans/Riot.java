package beans;

import org.springframework.stereotype.Component;

/**
 * Created by neil on 12.02.16.
 */
@Component
public class Riot {        // Мятеж
    private OppositionLIder ourLider;
    private President enemy;
    private int numberOfPeople;
    private City whereIsTheRiot;

    public static void destroy() {
        System.out.println("Destroying...");
    }

    public void listenToTheCommands() {
        System.out.println("Listening to " + this.ourLider);
    }

    @Override
    public String toString() {
        return "Riot{" +
                "ourLider=" + ourLider +
                ", enemy=" + enemy +
                ", numberOfPeople=" + numberOfPeople +
                ", whereIsTheRiot=" + whereIsTheRiot +
                '}';
    }
}
