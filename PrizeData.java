/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;

/**
 *
 * @author mark
 */
public class PrizeData {
    private String year;
    private String category;
    private String overallMotivation;
    private String share;
    private String motivation;
    private String city;
    private String country;
    
    PrizeData(String year, String category, String overallMotivation,
            String share, String motivation, String city, String country) {
        
        this.year = year;
        this.category = category;
        this.overallMotivation = overallMotivation;
        this.share = share;
        this.motivation = motivation;
        this.city = city;
        this.country = country;
    }
    
    public String getYear() { return year; }
    
    public String getCategory() { return category; }
    
    public String getO_Motivation() { return overallMotivation; }
    
    public String getShare() { return share; }
    
    public String getMotivation() { return motivation; }
    
    public String getPCity() { return city; }
    
    public String getPCountry() { return country; }
}
