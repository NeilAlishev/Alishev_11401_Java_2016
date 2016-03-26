package beans;

/**
 * Created by neil on 12.02.16.
 */
public interface NuclearBomb extends Bomb {
    public void addUranium();  // Добавляем уран

    public void addPlutonium(); // Добавляем плутон

    public void bury();       // Закопать бомбу
}
