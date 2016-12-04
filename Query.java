import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stapl on 11/15/2016.
 */
public class Query {
    private String firstName;
    private String lastName;
    private Integer startYear;
    private Integer endYear;
    private String category;
    private String gender;
    private String country;
    private String deathCountry;
    private String city;
    private String deatbCity;
    private Integer deathYear;
    private Integer birthYear;
    private Integer loops;

    public Query(String firstName, String lastName, String startYear, String endYear, String category, String gender, String country, String deathCountry, String city, String deathCity, String deathYear, String birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        if (!startYear.matches("")) {
            if (startYear.matches("[0-9]*")) {
                this.startYear = Integer.parseInt(startYear);
            }
            else{
                this.startYear = null;
            }
        }
        else{
            this.startYear = null;
        }
        if (!endYear.matches("")) {
            if (endYear.matches("[0-9]*")) {
                this.endYear = Integer.parseInt(endYear);
            }
            else{
                this.endYear = null;
            }
        }
        else{
            this.endYear = null;
        }
        if (!deathYear.matches("")){
            if (deathYear.matches("[0-9]*")) {
                this.deathYear = Integer.parseInt(deathYear);
            }
            else{
                this.deathYear = null;
            }
        }
        else{
            this.deathYear = null;
        }
        if (!birthYear.matches("")){
            if (birthYear.matches("[0-9]*")) {
                this.birthYear = Integer.parseInt(birthYear);
            }
            else{
                this.birthYear = null;
            }
        }
        else{
            this.birthYear = null;
        }

        this.deatbCity = deathCity;
        this.deathCountry = deathCountry;
        this.city = city;
        this.category = category;
        this.gender = gender;
        this.country = country;
        if (this.startYear != null && this.endYear != null){
            this.loops = this.endYear - this.startYear + 1;
        }
        else{
            loops = 1;
        }
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Integer getStartYear(){
        return startYear;
    }
    public Integer getEndYear(){
        return endYear;
    }
    public Integer getBirthYear(){ return birthYear;}
    public Integer getDeathYear() { return deathYear; }
    public String getDeathCountry() { return deathCountry; }
    public String getCity() { return city; }
    public String getDeatbCity() { return deatbCity; }
    public String getCategory(){
        return category;
    }
    public String getGender(){
        return gender;
    }
    public String getCountry(){
        return country;
    }
    public Integer getLoops(){
        return loops;
    }
}
