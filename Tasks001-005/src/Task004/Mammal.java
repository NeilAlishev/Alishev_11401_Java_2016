package Task004;

/**
 * Created by neil on 12.02.16.
 */
public interface Mammal {        //Млекопитающее
    public void drinkMilkWhenYouAreBaby(int qnt);

    public void produceMilk(int qnt);

    public void beParentOf(Mammal mammal);
}
