/**
 *
 * @author mark
 */
public class PrizeData {
    private final String year;
    private final String category;
    private final String overallMotivation;
    private final String share;
    private final String motivation;
    private final String uniName;
    private final String city;
    private final String country;

    PrizeData(String year, String category, String overallMotivation,
              String share, String motivation, String uniName,String city, String country) {

        this.year = year;
        this.category = category;
        this.overallMotivation = overallMotivation;
        this.share = share;
        this.motivation = motivation;
        this.uniName = uniName;
        this.city = city;
        this.country = country;
    }

    public String getYear() { return year; }

    public String getCategory() { return category; }

    public String getO_Motivation() { return overallMotivation; }

    public String getShare() { return share; }

    public String getMotivation() { return motivation; }

    public String getName() { return uniName; }

    public String getPCity() { return city; }

    public String getPCountry() { return country; }
}