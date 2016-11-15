/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;
//id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,
//600,Henri,Bergson,1859-10-18,1941-01-04,France,FR,Paris,France,FR,Paris,male,1927,


//category,overallMotivation,share,motivation,name,city,country
//literature,               ,1,"""in recognition of his rich and vitalizing ideas and the brilliant skill with which they have been presented""",  ,  ,
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
            String share, String motivation, String city, String country) {
        this.prize = new PrizeData(year,  category,  overallMotivation,
             share,  motivation,  city, country);
    }
    
    public void addMisc(String id, String firstname, String surname, 
                String name, String gender) {
        this.misc = new MiscData(id,  firstname, surname, name, gender);   
    }

}
