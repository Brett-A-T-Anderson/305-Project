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
