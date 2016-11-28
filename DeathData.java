/**
 *
 * @author mark
 */
public class DeathData {


    private String died;
    private String diedCountry;
    private String diedCountryCode;
    private String diedCity;

    DeathData(String died, String diedCountry,
              String diedCountryCode, String diedCity) {
        this.died = died;
        this.diedCountry = diedCountry;
        this.diedCountryCode = diedCountryCode;
        this.diedCity = diedCity;
    }

    public String getDeath() { return died; }

    public String getDCountry() { return diedCountry; }

    public String getDCountryCode() { return diedCountryCode; }

    public String getDCity() { return diedCity; }
}