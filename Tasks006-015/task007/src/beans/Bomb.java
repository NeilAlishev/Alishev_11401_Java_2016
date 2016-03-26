package beans;

/**
 * Обычная бомба
 */
public interface Bomb {
    public void detonate(long timeInMillis);     // взорвать бомбу!
    public void create(Supplements s);        // создать бомбу!
    public void demine();         // разминировать бомбу!
}
