package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class Main {
    public static void main(String[] args) {
       // Полиморфизм
        Object o = new FireArms();
        GenericWeapon gw  = new FireArms();
        FireArms fa = new FireArms();
        testPolimorphism(fa);
        // Позднее связывание
        Person p = new President("Vladimir", 50);
        p.sayHello();  // вызывается метод описанный в классе President
        // Восходящее преобразование
        Object o2 = new President("Vladimir", 50); // Президент - это объект

        // Вызов всех методов
        City city = new City();
        FireArms fa2 = new FireArms();
        Money m = new Money();
        OppositionLIder ol = new OppositionLIder("Alexey", 35);
        Person p2 = new Person("Peson", 15);
        PoliticalFigure pf = new PoliticalFigure("Lavrov", 60);
        President president = new President("Vladimir", 60);
        PresidentsAssistant presidentsAssistant = new PresidentsAssistant("Peskov", 50);
        Riot r = new Riot();
        SteelArms sa = new SteelArms();
        Supplements sup = new Supplements();
        Target t = new Target();
        city.getSize();
        city.howMuchMoneyIsInTheCoffers();
        city.whoIsTheMayor();
        fa2.breakDown();
        fa2.makeDamage(2);
        fa2.cleanUp();
        m.donateMoney();
        m.looseMoney();
        m.makeMoney();
        ol.sayHello();
        ol.beALeaderOf(r);
        ol.demobilize();
        ol.beParentOf(p);
        p2.drinkMilkWhenYouAreBaby(12);
        p2.produceMilk(14);
        p2.sayHello();
        p2.getYearsToRetirement();
        pf.demobilize();
        president.sayHello();
        presidentsAssistant.getYearsToRetirement();
        r.listenToTheCommands();
        sa.cleanUp();
        sup.getAmmunition(14, m);
        t.addPlutonium();

    }

    public static void testPolimorphism(GenericWeapon gw) {

    }
}