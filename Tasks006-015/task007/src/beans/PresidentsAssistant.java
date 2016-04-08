package beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by neil on 12.02.16.
 */
public class PresidentsAssistant extends PoliticalFigure {
    @Autowired
    private President myPresident;
    @Autowired
    private OppositionLIder enemy;
    @Autowired
    private Country whereIRule;
    private int howManyYearsOnPost;

    public PresidentsAssistant(String name, int age) {
        super(name, age);
    }

    public President getMyPresident() {
        return myPresident;
    }

    public void setMyPresident(President myPresident) {
        this.myPresident = myPresident;
    }

    public OppositionLIder getEnemy() {
        return enemy;
    }

    public void setEnemy(OppositionLIder enemy) {
        this.enemy = enemy;
    }

    public Country getWhereIRule() {
        return whereIRule;
    }

    public void setWhereIRule(Country whereIRule) {
        this.whereIRule = whereIRule;
    }

    public void assistPresident() {
        System.out.println("Assisting president " + this.myPresident);
    }
}
