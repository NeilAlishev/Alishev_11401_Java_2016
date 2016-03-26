/**
 * Created by neil on 12.02.16.
 */
public class OppositionLIder extends Person {
    private String party;
    private String motto; //лозунг
    private President enemy;
    private Riot myRiot;

    public OppositionLIder(String name, int age) {
        super(name, age);
    }

    public Riot makingRiot() {
        return new Riot();
    }

    public void beALeaderOf(Riot r) {
        System.out.println("I am a leader of a riot " + r);
    }
}
