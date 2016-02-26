package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class PresidentsAssistant extends PoliticalFigure {
    private President myPresident;
    private OppositionLIder enemy;
    private Country whereIRule;
    private int howManyYearsOnPost;

    public PresidentsAssistant(String name, int age) {
        super(name, age);
    }

    public void assistPresident() {
        System.out.println("Assisting president " + this.myPresident);
    }

    public void setMyPresident(President myPresident) {
        this.myPresident = myPresident;
    }
}
