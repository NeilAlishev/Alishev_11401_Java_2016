package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class Target implements Country, NuclearPotential {
    private City[] cities;    // города в стране
    private President presidentOfCountry;
    private OppositionLIder oppositionLIder;
    private PresidentsAssistant presidentsAssistant;

    @Override
    public void capitulate(String message) {
        System.out.println(message);
    }

    @Override
    public void callToUN() {
        System.out.println("I am calling to UN!");
    }

    @Override
    public void startWarWith(Country country) {
        System.out.println("No choice, start the war with " + country.toString());
    }

    @Override
    public void buildNukes(int size, int qnt) {
        System.out.println("Building " + qnt + " nukes " + size + " size each");
    }

    @Override
    public void redButton(Target target, NuclearBomb bomb) {
        System.out.println("Pressing red button. Targetting " + target + " with " + bomb);
    }

    @Override
    public void cancelLaunch(NuclearBomb bomb) {
        System.out.println("Cancelling launch on " + bomb);
    }

    @Override
    public void addUranium() {
        System.out.println("Adding uranium...");
    }

    @Override
    public void addPlutonium() {
        System.out.println("Adding plutonium");
    }

    @Override
    public void bury() {
        System.out.println("Burying nuclear bomb");
    }

    @Override
    public void detonate(long timeInMillis) {
        System.out.println("Detonate!");
    }

    @Override
    public void create(Supplements s) {
        System.out.println("Creating bomb...");
    }

    @Override
    public void demine() {
        System.out.println("Demining bomb...");
    }
}
