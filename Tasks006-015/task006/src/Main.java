import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by neil on 12.02.16.
 */
public class Main {
    public static void main(String[] args) {
       // Полиморфизм
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Object o = ac.getBean(FireArms.class);
        GenericWeapon gw  = ac.getBean(FireArms.class);
        FireArms fa = ac.getBean(FireArms.class);
        testPolimorphism(fa);
        // Позднее связывание
        Person p = (Person)ac.getBean("person");
        p.sayHello();  // вызывается метод описанный в классе President
        // Восходящее преобразование
        Object o2 = ac.getBean(President.class); // Президент - это объект

        // Вызов всех методов
        City city = ac.getBean(City.class);
        FireArms fa2 = ac.getBean(FireArms.class);
        Money m = ac.getBean(Money.class);
        OppositionLIder ol = ac.getBean(OppositionLIder.class);
        Person p2 = (Person)ac.getBean("person");
        PoliticalFigure pf = (PoliticalFigure)ac.getBean("politicalFigure");
        President president = ac.getBean(President.class);
        PresidentsAssistant presidentsAssistant = ac.getBean(PresidentsAssistant.class);
        Riot r = ac.getBean(Riot.class);
        SteelArms sa = ac.getBean(SteelArms.class);
        Supplements sup = ac.getBean(Supplements.class);
        Target t = new Target();
        city.setMoneyThatCityHas(m);
        city.setMayor(p);
        city.setSize(10);
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