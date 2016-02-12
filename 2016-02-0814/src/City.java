/**
 * Created by neil on 12.02.16.
 */
public class City {
    private int size;
    private Money moneyThatCityHas;
    private Person mayor;
    private int numberOfPeople;

    public void getSize() {
        System.out.println("Size is +" + this.size);
    }

    public void howMuchMoneyIsInTheCoffers() {
        System.out.println("There is " + moneyThatCityHas);
    }

    public void whoIsTheMayor() {
        System.out.println("Mayor is " + mayor);
    }

}
