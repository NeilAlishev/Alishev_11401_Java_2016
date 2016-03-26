/**
 * Created by neil on 12.02.16.
 */
public interface Country {

    public void capitulate(String message);     // Капитулировать

    public void callToUN();     // Позвонить в ООН

    public void startWarWith(Country country);      // Развязать войну
}
