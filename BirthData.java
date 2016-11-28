/**
 *
 * @author mark
 */
public class BirthData {


    private String born;
    private String bornCountry;
    private String bornCountryCode;
    private String bornCity;

    BirthData(String born, String bornCountry,
              String bornCountryCode, String bornCity) {

        this.born = born;
        this.bornCountry = bornCountry;
        this.bornCountryCode = bornCountryCode;
        this.bornCity = bornCity;
    }

    public String getBorn() { return born; }

    public String getBCountry() { return bornCountry; }

    public String getBCountryCode() { return bornCountryCode; }

    public String getBCity() { return bornCity; }
}