package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class Person implements Mammal, CapableOfGoingToArmy {
    private int age;
    private String name;
    private Sex sex;
    private Country whereWasBorn;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("hello!");
    }

    public String getName() {
        return this.name;
    }

    public int getYearsToRetirement() {
        if (age > 60)
            return -1;

        return (60 - age);
    }

    @Override
    public void drinkMilkWhenYouAreBaby(int qnt) {
        if (age > 2) {
            System.out.println("I am not drinking mother's milk anymore!");
        } else {
            System.out.println("Yummy");
        }
    }

    @Override
    public void produceMilk(int qnt) {
        if (this.sex == Sex.MALE) {
            System.out.println("Can't produce milk!");
        } else {
            System.out.println("Producing milk...");
        }
    }

    @Override
    public void beParentOf(Mammal mammal) {
        System.out.println("I am a parent of " + mammal);
    }

    @Override
    public void fightWith(SteelArms s) {
        System.out.println("Fighting with "+s);
    }

    @Override
    public void shootWith(FireArms f) {
        System.out.println("Fighting with "+f);
    }

    @Override
    public void demobilize() {
        System.out.println("Hooray!");
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

}
