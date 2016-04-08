/**
 * Created by neil on 12.02.16.
 */
public interface GenericWeapon {
    public void makeDamage(int howMuchDamage);
    public void cleanUp();  // Очистить оружие
    public void breakDown();  // Выйти из строя
}
