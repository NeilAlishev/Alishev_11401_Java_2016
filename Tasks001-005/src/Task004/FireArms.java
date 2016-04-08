package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class FireArms implements GenericWeapon {
    private int damage;
    private Money cost;
    private int size;
    private String name;

    @Override
    public void makeDamage(int howMuchDamage) {
        System.out.println("Making " + howMuchDamage + " damage with fire arm");
    }

    @Override
    public void cleanUp() {
        System.out.println("Cleaning up fire arm");
    }

    @Override
    public void breakDown() {
        System.out.println("Fire arm is broken");
    }
}
