/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;

public class Laureate {
    
    public BirthData born;
    public DeathData death;
    public PrizeData prize;
    public MiscData  misc;

   
    
    public void addBirth(String born, String bornCountry, 
                 String bornCountryCode, String bornCity) {
        this.born = new BirthData(born,bornCountry,bornCountryCode,bornCity);
    }
    
    public void addDeath(String died, String diedCountry, 
              String diedCountryCode, String diedCity) {
        this.death = new DeathData(died, diedCountry, 
              diedCountryCode, diedCity);
    }
    
    public void addPrize(String year, String category, String overallMotivation,
            String share, String motivation, String uniName, String city, String country) {
        this.prize = new PrizeData(year,  category,  overallMotivation,
             share,  motivation,  uniName, city, country);
    }
    
    public void addMisc(String id, String firstname, String surname, 
                 String gender) {
        this.misc = new MiscData(id,  firstname, surname, gender);   
    }

}
