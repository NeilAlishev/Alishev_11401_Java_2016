package beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by neil on 12.02.16.
 */
public class OppositionLIder extends Person {
    private String party;
    private String motto; //лозунг
    @Autowired
    private President enemy;
    @Autowired
    private Riot myRiot;

    public OppositionLIder(String name, int age) {
        super(name, age);
    }

    public President getEnemy() {
        return enemy;
    }

    public void setEnemy(President enemy) {
        this.enemy = enemy;
    }

    public Riot getMyRiot() {
        return myRiot;
    }

    public void setMyRiot(Riot myRiot) {
        this.myRiot = myRiot;
    }

    public Riot makingRiot() {
        return new Riot();
    }

    public void beALeaderOf(Riot r) {
        System.out.println("I am a leader of a riot " + r);
    }
}
