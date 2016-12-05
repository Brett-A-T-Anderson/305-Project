import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack Staples on 11/15/2016.
 *
 * This is the query class that is passed to the database class t
 * return information from it. Each field corresponds to an input on our
 * gui. Years are used to generate a loop field so the database can grab in a range.
 * This is a command pattern object, its passed to a database and .executes()
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
    private String deathCity;
    private Integer deathYearStart;
    private Integer birthYearStart;
    private Integer deathYearEnd;
    private Integer birthYearEnd;
    private Integer loops;
    private Integer deathLoops;
    private Integer birthLoops;

    public Query(String firstName, String lastName, String startYear, String endYear, String category, String gender, String country,
                 String deathCountry, String city, String deathCity, String deathYearStart, String deathYearEnd, String birthYearStart, String birthYearEnd){
        this.firstName = firstName;
        this.lastName = lastName;

        /* this section handles all the integer fields in the queury. They are taken in as strings so they have to
        be converted to Integer objects so that they can be used for looping by the database.
         */
        if (!startYear.matches("")) {
            this.startYear = toInteger(startYear);
        }
        else{
            this.startYear = null;
        }
        if (!endYear.matches("")) {
            this.endYear = toInteger(endYear);
        }
        else{
            this.endYear = null;
        }
        if (this.startYear != null && this.endYear != null){
            this.loops = this.endYear - this.startYear + 1;
        }
        else{
            loops = 1;
        }

        if (!deathYearStart.matches("")){
                this.deathYearStart = toInteger(deathYearStart);
        }
        else{
            this.deathYearStart = null;
        }
        if(!deathYearEnd.matches("")){
            this.deathYearEnd = toInteger(deathYearEnd);
        }
        else{
            this.deathYearEnd = null;
        }
        if (this.deathYearStart != null && this.deathYearEnd != null){
            this.deathLoops = this.deathYearEnd - this.deathYearStart + 1;
        }
        else{
            deathLoops = 1;
        }
        if (!birthYearStart.matches("")){
            this.birthYearStart = toInteger(birthYearStart);
        }
        else{
            this.birthYearStart = null;
        }
        if (!birthYearEnd.matches("")){
            this.birthYearEnd = toInteger(birthYearEnd);
        }
        else{
            this.birthYearEnd = null;
        }
        if (this.birthYearStart != null && this.birthYearEnd != null){
            this.birthLoops = this.birthYearEnd - this.birthYearStart + 1;
        }
        else{
            birthLoops = 1;
        }
        this.deathCity = deathCity;
        this.deathCountry = deathCountry;
        this.city = city;
        this.category = category;
        this.gender = gender;
        this.country = country;
    }
    private Integer toInteger(String num){
        if (num.matches("[0-9]*")) {
            return Integer.parseInt(num);
        }
        else{
            return null;
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
    public Integer getBirthYear(){ return birthYearStart;}
    public Integer getDeathYear() { return deathYearStart; }
    public String getDeathCountry() { return deathCountry; }
    public String getCity() { return city; }
    public String getDeathCity() { return deathCity; }
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
    public Integer getDeathLoops(){return deathLoops;}
    public Integer getBirthLoops(){return birthLoops;}
}
