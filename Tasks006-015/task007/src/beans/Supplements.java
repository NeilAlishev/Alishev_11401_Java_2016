package beans;

import org.springframework.stereotype.Component;

/**
 * Created by neil on 12.02.16.
 */
@Component
public class Supplements {
    private int count;
    private Money cost;
    private Country toWhomBelongs;
    private Person whoMakes;

    public void getGunPowder(int qnt, Money m) {                  // Получить порох
        System.out.println("Getting gunpowder");
    }

    public void getMetal(int qnt, Money m) {                 // Получить металл
        System.out.println("Getting metal");
    }

    public void getAmmunition(int qnt, Money m) {           // Получить аммуницию
        System.out.println("Getting ammunition");
    }

}
