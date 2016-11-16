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
    private Integer loops;

    public Query(String firstName, String lastName, String startYear, String endYear, String category, String gender, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        if (!startYear.matches("")) {
            this.startYear = Integer.parseInt(startYear);
        }
        else{
            this.startYear = null;
        }
        if (!endYear.matches("")) {
            this.endYear = Integer.parseInt(endYear);
        }
        else{
            this.endYear = null;
        }
        this.category = category;
        this.gender = gender;
        this.country = country;
        if (this.startYear != null && this.endYear != null){
            this.loops = this.startYear - this.endYear;
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
