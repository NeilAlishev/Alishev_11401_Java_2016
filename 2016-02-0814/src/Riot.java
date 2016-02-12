/**
 * Created by neil on 12.02.16.
 */
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
}
