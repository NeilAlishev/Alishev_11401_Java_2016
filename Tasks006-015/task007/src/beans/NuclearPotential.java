package beans;

/**
 * Реализуется странами, у которых есть ядерное оружие
 */
public interface NuclearPotential extends NuclearBomb {
    public void buildNukes(int size, int qnt);     // размер и количество бомб

    public void redButton(Target target, NuclearBomb bomb);    //  нажать на красную кнопку

    public void cancelLaunch(NuclearBomb bomb); // отменить запуск бомбы
}
