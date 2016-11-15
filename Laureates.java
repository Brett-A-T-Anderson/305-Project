/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;

import java.util.ArrayList;


/**
 *
 * @author mark
 */
public class Laureates {
    
    private ArrayList<Laureate> winners = new ArrayList<>();
    
    public void addTo(String raw_in) {
        if(raw_in.contains("api.nobelprize.org/") || 
           raw_in.contains("id,firstname,surname,born,died")
           || raw_in.isEmpty()) { return; }
        
        raw_in = reformat(raw_in);
        String[] raw = raw_in.split(",");
        raw = fillBlanks(raw);
        raw = clean(raw);
        seperate(raw);

        

    }
    //id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,
    //category,overallMotivation,share,motivation,name,city,country
    private String reformat(String raw_in) {
        char[] formatting = raw_in.toCharArray();
        int length = formatting.length;
        boolean flag = false;
        String formatted = "";
        for(int i = 0; i < length; i++) {
            
            
            if((formatting[i] == '"') && (!flag)) { flag = true; continue;}
            if((formatting[i] == '"') && (flag)) { flag = false; continue;}   
            
            if(flag && (formatting[i] == ',')) {
                formatting[i] = ' ';
            }
            formatted = formatted + formatting[i];
            
            
        }

        return formatted;
    }


    
    private String[] fillBlanks(String[] raw){
        String current;
        for(int i = 0; i < raw.length; i++) {
            current = raw[i];
            if(current.compareTo("") == 0) {
                raw[i] = "Not available";
            }
        }
        
        
        return raw;
    }
    
    private String[] clean(String[] raw) {
        
        for(int i = 0; i < raw.length; i++) {
            raw[i] = raw[i].replaceAll("\"","");
        }
        return raw;
    }
    
    private void seperate(String[] raw) {

        String born = "", death = "", prize = "" , misc = "";
        
        for(int i = 0; i < raw.length; i++) {
            
            if( (i < 3) || (i == 11)){ 
                misc = misc + "," + raw[i]; 
            }
            else if(  (i == 3) || ((i > 4) && (i < 8))  ) {
                born = born + "," + raw[i] ;
            }
            else if(i > 11) {
                prize = prize + "," + raw[i];
            }
            else{
                death = death + "," + raw[i];
            }
        }
        
        assign(born, death, prize, misc);

        
        System.out.println("Born: " + born.replaceFirst(",", ""));
        System.out.println("Death: " + death.replaceFirst(",", ""));
        System.out.println("Prize: " + prize.replaceFirst(",", ""));
        System.out.println("Misc: " + misc.replaceFirst(",", ""));
        System.out.println(); 
       
        
       
    }
    private void assign(String born, String death, String prize, String misc) {
        Laureate Winner = new Laureate();
        birthData(Winner, born);
        deathData(Winner, death);
        prizeData(Winner, prize);
        miscData(Winner, misc);
        winners.add(Winner);         
    }
  
    private void birthData(Laureate Winner, String data) {
        String[] process = data.split(",");
        
        Winner.addBirth(process[0], process[1],process[2],process[3]);
    }
    
    private void deathData(Laureate Winner, String data) {
        String[] process = data.split(",");
        
        Winner.addDeath(process[0], process[1],process[2],process[3]);
    }
    
    private void prizeData(Laureate Winner, String data) {
        String[] process = data.split(",");
        String replaceA, replaceB;
        int length = process.length;
        if(length == 7) {
            replaceA = process[5];
            replaceB = process[6];
        }
        else {
            replaceA = "Not Available";
            replaceB = "Not Available";
        }
        Winner.addPrize(process[0], process[1],process[2],process[3],process[4], replaceA, replaceB);
    }
    
    private void miscData(Laureate Winner, String data) {
        String[] process = data.split(",");
        Winner.addMisc(process[0], process[1],process[2],process[1] + process[2], process[3]);
    }
    

}
