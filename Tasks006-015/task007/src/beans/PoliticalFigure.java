package beans;

import org.springframework.stereotype.Component;

/**
 * Created by neil on 12.02.16.
 */
public class PoliticalFigure extends Person {      // Политический деятель
    private String motto;  // лозунг
    private String post;
    private Money amountOfMoney;
    private Country whereRules;

    public PoliticalFigure(String name, int age) {
        super(name, age);
    }

}
