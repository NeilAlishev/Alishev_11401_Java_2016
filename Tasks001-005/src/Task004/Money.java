package Task004;

/**
 * Created by neil on 12.02.16.
 */
public class Money {
    private Person whosMoney;
    private int qnt;
    private boolean oldOrNew;
    private String name;

    public void makeMoney() {
        System.out.println("Making money...");
    }

    public void looseMoney() {
        System.out.println("Loosing money...");
    }

    public void donateMoney() {
        System.out.println("Donating money...");
    }

    public Person getWhosMoney() {
        return whosMoney;
    }

    public void setWhosMoney(Person whosMoney) {
        this.whosMoney = whosMoney;

    }
    public int getQnt() {
        return qnt;
    }

}
