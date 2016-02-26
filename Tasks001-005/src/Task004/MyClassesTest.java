package Task004;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * @author Nail Alishev
 *         11-401
 *         task 004
 */
public class MyClassesTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static City city;
    private static FireArms fireArms;
    private static Money money;
    private static OppositionLIder ol;
    private static Person person;
    private static PoliticalFigure politicalFigure;
    private static President president;
    private static PresidentsAssistant presidentsAssistant;
    private static Riot riot;
    private static SteelArms steelArms;
    private static Supplements supplements;
    private static Target target;

    @BeforeClass
    public static void initialize() {
        System.setOut(new PrintStream(outContent));
        city = new City();
        fireArms = new FireArms();
        money = new Money();
        ol = new OppositionLIder("Alexey", 30);
        person = new Person("Neil", 19);
        person.setSex(Sex.MALE);
        politicalFigure = new PoliticalFigure("Vladimir", 60);
        president = new President("Vladimir", 60);
        presidentsAssistant = new PresidentsAssistant("Dmitriy", 50);
        riot = new Riot();
        steelArms = new SteelArms();
        supplements = new Supplements();
        target = new Target();
    }

    @Test
    public void cityGetSizeMethodShouldPrintCitySize() {
        city.setSize(10);
        city.getSize();
        assertEquals("Size is 10\n", outContent.toString());
    }

    @Test
    public void cityHowMuchMoneyIsInTheCoffersMethodShouldPrintTheAmountOfMoneyThatCityHas() {
        Money m = mock(Money.class);
        when(m.getQnt()).thenReturn(10);
        city.setMoneyThatCityHas(m);
        city.howMuchMoneyIsInTheCoffers();
        assertEquals("There is 10\n", outContent.toString());
    }

    @Test
    public void citywhoIsTheMayorShouldPrintCurrentMayor() {
        Person mayor = mock(Person.class);
        when(mayor.getName()).thenReturn("Metshin");
        city.setMayor(mayor);
        city.whoIsTheMayor();
        assertEquals("Mayor is Metshin\n", outContent.toString());
    }

    @Test
    public void fireArmsMakeDamageShouldPrintTheAmountOfDamageMade() {
        fireArms.makeDamage(10);
        assertEquals("Making 10 damage with fire arm\n", outContent.toString());
    }

    @Test
    public void fireArmsCleanUpShouldPrintCorrectMessage() {
        fireArms.cleanUp();
        assertEquals("Cleaning up fire arm\n", outContent.toString());
    }

    @Test
    public void fireArmsBreakDownShouldPrintCorrectMessage() {
        fireArms.breakDown();
        assertEquals("Fire arm is broken\n", outContent.toString());
    }

    @Test
    public void moneyMakeMoneyShouldPrintCorrectMessage() {
        money.makeMoney();
        assertEquals("Making money...\n", outContent.toString());
    }

    @Test
    public void moneyLooseMoneyShouldPrintCorrectMessage() {
        money.looseMoney();
        assertEquals("Loosing money...\n", outContent.toString());
    }

    @Test
    public void moneyDonateMoneyShouldPrintCorrectMessage() {
        money.donateMoney();
        assertEquals("Donating money...\n", outContent.toString());
    }

    @Test
    public void moneyWhosMoneyShouldReturnPersonWhoOwnsTheMoney() {
        Person moneyOwner = mock(Person.class);
        when(moneyOwner.getName()).thenReturn("Vladimir");
        money.setWhosMoney(moneyOwner);
        assertEquals(moneyOwner, money.getWhosMoney());
    }



    @Test
    public void oppositionLeaderConstructorShouldWorkCorrectly() {
        assertEquals(ol.getName(), "Alexey");
        assertEquals(ol.getAge(), 30);
    }

    @Test
    public void oppositionLeaderMakeRiotMethodShouldReturnNewRiot() {

        assertEquals(Riot.class, ol.makeRiot().getClass());
    }

    @Test
    public void oppositionLeaderBeALeaderOfMethodShouldPrintCorrectMessage() {
        Riot r = mock(Riot.class);
        when(r.toString()).thenReturn("BolotnayaSquare");
        ol.beALeaderOf(r);
        assertEquals("I am a leader of a riot at BolotnayaSquare\n", outContent.toString());
    }

    @Test
    public void personConstructorShouldWorkCorrectly() {
        assertEquals("Neil", person.getName());
        assertEquals(19, person.getAge());
    }

    @Test
    public void personSayHelloShouldPrintHello() {
        person.sayHello();
        assertEquals("hello!\n", outContent.toString());
    }

    @Test
    public void personGetYearsToRetirementShouldReturnCorrectResult() {
        assertEquals(41, person.getYearsToRetirement());
    }

    @Test
    public void personDrinkMilkMethodShouldWorkCorrectly() {
        person.drinkMilkWhenYouAreBaby(1);
        assertEquals("I am not drinking mother's milk anymore!\n", outContent.toString());
    }

    @Test
    public void personProduceMilkMethodShouldWorkCorrectly() {
        person.produceMilk(10);
        assertEquals("Can't produce milk!\n", outContent.toString());
    }

    @Test
    public void personBeParentOfMethodShouldWorkCorrectly() {
        Mammal m = mock(Mammal.class);
        person.beParentOf(m);
        assertEquals("I am a parent of " + m.toString() + "\n", outContent.toString());
    }

    @Test
    public void personFightWithMethodShouldWorkCorrectly() {
        SteelArms sa = mock(SteelArms.class);
        person.fightWith(sa);
        assertEquals("Fighting with " + sa.toString() + "\n", outContent.toString());
    }

    @Test
    public void personShootWithMethodShouldWorkCorrectly() {
        FireArms fa = mock(FireArms.class);
        person.shootWith(fa);
        assertEquals("Fighting with " + fa.toString() + "\n", outContent.toString());
    }

    @Test
    public void personDemobilizeMethodShouldWorkCorrectly() {
        person.demobilize();
        assertEquals("Hooray!\n", outContent.toString());
    }

    @Test
    public void politicalFigureConstructorShouldWorkCorrectly() {
        assertEquals("Vladimir", politicalFigure.getName());
        assertEquals(60, politicalFigure.getAge());
    }

    @Test
    public void presidentConstructorShouldWorkCorrectly() {
        assertEquals("Vladimir", president.getName());
        assertEquals(60, president.getAge());
    }

    @Test
    public void presidentShouldSuppressRiot() {
        Riot r = mock(Riot.class);
        president.suppressRiot(r);
        assertEquals("Suppressing riot " + r + "\n", outContent.toString());
    }

    @Test
    public void presidentShouldSayHello() {
        president.sayHello();
        assertEquals("Saying hello like a president\n", outContent.toString());
    }

    @Test
    public void presidentAssistantConstructorShouldWorkCorrectly() {
        assertEquals("Dmitriy", presidentsAssistant.getName());
        assertEquals(50, presidentsAssistant.getAge());
    }

    @Test
    public void assistPresidentMethodShouldWorkCorrectly() {
        President president = mock(President.class);
        presidentsAssistant.setMyPresident(president);
        presidentsAssistant.assistPresident();
        assertEquals("Assisting president " + president + "\n", outContent.toString());
    }

    @Test
    public void riotDestroyMethodShouldPrintDestroy() {
        riot.destroy();
        assertEquals("Destroying...\n", outContent.toString());
    }

    @Test
    public void listenToTheCommandsMethodShouldWorkCorrectly() {
        OppositionLIder ol = mock(OppositionLIder.class);
        riot.setOurLider(ol);
        riot.listenToTheCommands();
        assertEquals("Listening to " + ol + "\n", outContent.toString());
    }

    @Test
    public void steelArmsMakeDamageMethodTest() {
        steelArms.makeDamage(10);
        assertEquals("Making damage with steel arm\n", outContent.toString());
    }

    @Test
    public void steelArmsCleanUpMethodTest() {
        steelArms.cleanUp();
        assertEquals("Cleaning steel arm\n", outContent.toString());
    }

    @Test
    public void steelArmsBreakDownMethodTest() {
        steelArms.breakDown();
        assertEquals("Steel arm is broken\n", outContent.toString());
    }

    @Test
    public void supplementsGetGunPowderMethodShouldWorkCorrectly() {
        supplements.getGunPowder(10, mock(Money.class));
        assertEquals("Getting gunpowder\n", outContent.toString());
    }

    @Test
    public void supplementsGetMetalMethodShouldWorkCorrectly() {
        supplements.getMetal(10, mock(Money.class));
        assertEquals("Getting metal\n", outContent.toString());
    }

    @Test
    public void supplementsGetAmmunitionMethodShouldWorkCorrectly() {
        supplements.getAmmunition(10, mock(Money.class));
        assertEquals("Getting ammunition\n", outContent.toString());
    }

    @Test
    public void targetCapitulateShouldWorkCorrectly() {
        target.capitulate("Sorry!");
        assertEquals("Sorry!\n", outContent.toString());
    }

    @Test
    public void targetCallToUNMethodShouldWorkCorrectly() {
        target.callToUN();
        assertEquals("I am calling to UN!\n", outContent.toString());
    }

    @Test
    public void targetStartWarWithMethodShouldWorkCorrectly() {
        Country country = mock(Country.class);
        target.startWarWith(country);
        assertEquals("No choice, start the war with " + country.toString() + "\n", outContent.toString());
    }

    @Test
    public void targetBuildNukesShouldWorkCorrectly() {
        target.buildNukes(10, 5);
        assertEquals("Building " + 5 + " nukes " + 10 + " size each\n", outContent.toString());
    }


    @Test
    public void targetCancelLaunchShouldWorkCorrectly() {
        NuclearBomb bomb = mock(NuclearBomb.class);
        target.cancelLaunch(bomb);
        assertEquals("Cancelling launch on " + bomb + "\n", outContent.toString());
    }

    @Test
    public void targetAddUraniumShouldWorkCorrectly() {
        target.addUranium();
        assertEquals("Adding uranium...\n", outContent.toString());
    }

    @Test
    public void targetAddPlutoniumShouldWorkCorrectly() {
        target.addPlutonium();
        assertEquals("Adding plutonium\n", outContent.toString());
    }

    @Test
    public void targetBuryShouldWorkCorrectly() {
        target.bury();
        assertEquals("Burying nuclear bomb\n", outContent.toString());
    }

    @Test
    public void targetDetonateShouldWorkCorrectly() {
        target.detonate(10);
        assertEquals("Detonate!\n", outContent.toString());
    }

    @Test
    public void targetCreateShouldWorkCorrectly() {
        target.create(mock(Supplements.class));
        assertEquals("Creating bomb...\n", outContent.toString());
    }

    @Test
    public void targetDemineShouldWorkCorrectly() {
        target.demine();
        assertEquals("Demining bomb...\n", outContent.toString());
    }

    @After
    public void resetOutContent() {
        outContent.reset();
    }

}
