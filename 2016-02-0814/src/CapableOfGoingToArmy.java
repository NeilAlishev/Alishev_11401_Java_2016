/**
 * Created by neil on 12.02.16.
 */
public interface CapableOfGoingToArmy {    // Классы реализующие этот интерфейс могут идти в армию
    public void fightWith(SteelArms s);   // Сражаться с холодным оружием

    public void shootWith(FireArms f);   // Стрелять из огнестрельного оружия

    public void demobilize();

}
