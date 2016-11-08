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
    
    private ArrayList<Laureate> winners;
    
    public void addTo(String raw_in) {
        if(raw_in.contains("api.nobelprize.org/") || 
           raw_in.contains("id,firstname,surname,born,died")) { return; }
        
        
        String[] raw = raw_in.split(",");
        raw = fillBlanks(raw);
        raw = clean(raw);
        seperate(raw);

        

    }
    //id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,
    //category,overallMotivation,share,motivation,name,city,country
    
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
        System.out.println("Born: " + born.replaceFirst(",", ""));
        System.out.println("Death: " + death.replaceFirst(",", ""));
        System.out.println("Prize: " + prize.replaceFirst(",", ""));
        System.out.println("Misc: " + misc.replaceFirst(",", ""));
        System.out.println();        
    }
}
