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
