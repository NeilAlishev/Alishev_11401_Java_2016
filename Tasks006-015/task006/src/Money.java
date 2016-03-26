/**
 * Created by neil on 12.02.16.
 */
public class Money {
    private Person whosMoney;
    private int qnt;
    private boolean oldOrNew;
    private String name;

    public void makeMoney(){
        System.out.println("Making money...");
    }
    public void looseMoney(){
        System.out.println("Loosing money...");
    }
    public void donateMoney(){
        System.out.println("Donating money...");
    }

    @Override
    public String toString() {
        return "Money{" +
                "whosMoney=" + whosMoney +
                ", qnt=" + qnt +
                ", oldOrNew=" + oldOrNew +
                ", name='" + name + '\'' +
                '}';
    }
}
