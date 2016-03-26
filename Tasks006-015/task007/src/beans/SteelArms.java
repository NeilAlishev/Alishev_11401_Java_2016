package beans;

import org.springframework.stereotype.Component;

/**
 * Created by neil on 12.02.16.
 */
@Component
public class SteelArms implements GenericWeapon {
    private int damage;
    private int size;
    private int mass;
    private Person toWhomBelongs;

    @Override
    public void makeDamage(int howMuchDamage) {
        System.out.println("Making damage with steel arm");
    }

    @Override
    public void cleanUp() {
        System.out.println("Cleaning steel arm");
    }

    @Override
    public void breakDown() {
        System.out.println("Steel arm is broken");
    }
}
