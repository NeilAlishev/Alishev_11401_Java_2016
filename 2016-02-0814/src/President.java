/**
 * Created by neil on 12.02.16.
 */
public class President extends PoliticalFigure {
    private PresidentsAssistant myAssistant;
    private Country whereIRule;
    private OppositionLIder enemy;
    private Money amountOfMoneyInTheCountry;

    public President(String name, int age) {
        super(name, age);
    }


    public void suppressRiot(Riot r){
        System.out.println("Suppressing riot "+ r);
    }

    public void sayHello(){
        System.out.println("Saying hello like a president");
    }
}
