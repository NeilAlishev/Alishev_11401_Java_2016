package beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by neil on 12.02.16.
 */
public class President extends PoliticalFigure {
    @Autowired
    private PresidentsAssistant myAssistant;
    @Autowired
    private Country whereIRule;
    @Autowired
    private OppositionLIder enemy;
    @Autowired
    private Money amountOfMoneyInTheCountry;

    public President(String name, int age) {
        super(name, age);
    }


    public PresidentsAssistant getMyAssistant() {
        return myAssistant;
    }

    public void setMyAssistant(PresidentsAssistant myAssistant) {
        this.myAssistant = myAssistant;
    }

    public Country getWhereIRule() {
        return whereIRule;
    }

    public void setWhereIRule(Country whereIRule) {
        this.whereIRule = whereIRule;
    }

    public OppositionLIder getEnemy() {
        return enemy;
    }

    public void setEnemy(OppositionLIder enemy) {
        this.enemy = enemy;
    }

    public Money getAmountOfMoneyInTheCountry() {
        return amountOfMoneyInTheCountry;
    }

    public void setAmountOfMoneyInTheCountry(Money amountOfMoneyInTheCountry) {
        this.amountOfMoneyInTheCountry = amountOfMoneyInTheCountry;
    }

    public void suppressRiot(Riot r){
        System.out.println("Suppressing riot "+ r);
    }

    public void sayHello(){
        System.out.println("Saying hello like a president");
    }
}
