package Task004;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by neil on 12.02.16.
 */
public class City {
    int size;
    private Money moneyThatCityHas;
    private Person mayor;
    private int numberOfPeople;

    public void getSize() {
        System.out.println("Size is " + this.size);
    }

    public void howMuchMoneyIsInTheCoffers() {
        System.out.println("There is " + moneyThatCityHas.getQnt());
    }

    public void whoIsTheMayor() {
        System.out.println("Mayor is " + mayor.getName());
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMoneyThatCityHas(Money moneyThatCityHas) {
        this.moneyThatCityHas = moneyThatCityHas;
    }

    public void setMayor(Person mayor) {
        this.mayor = mayor;
    }
}
