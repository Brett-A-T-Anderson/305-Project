
package pkg305_project;

import java.util.ArrayList;
import java.net.*;
import java.io.*;

/**
 *
 *  Jack, there are 2 method calls for this class. 1. build 2. makeQuery. Send
 *          your query class as argument for makeQuery. Sends a Laureate every iteration.
 */
public class Laureates {
    

    private  int lastString;
    private  final ArrayList<String[]> lines = new ArrayList<>();
    private  String[] compare;
    
    
    public  void build() throws Exception {
                
	URL csv = new URL("http://api.nobelprize.org/v1/laureate.csv?");
	BufferedReader in = new BufferedReader(new InputStreamReader(csv.openStream()));
	String inputLine;
        String[] currentArray;
        
	while((inputLine = in.readLine()) != null){
            
            if(inputLine.contains("api.nobelprize.org/") || 
                inputLine.contains("id,firstname,surname,born,died")
                || inputLine.isEmpty()) { continue; }
            
            inputLine = reformat(inputLine);
            if(checkForNums(inputLine.charAt(0))) {
                
                currentArray = inputLine.split(",");
                int length = currentArray.length;
                currentArray = fillBlanks(currentArray, length);
                currentArray = clean(currentArray);
                finalCheck(currentArray);
            }
            else if(!lines.isEmpty()) { 
                    String[] previous = lines.get(lines.size() - 1);
                    previous[lastString] = previous[lastString] + " " + inputLine; 
                    lastString = 0;    
            }
        }
    }

  
    private String[] clean(String[] raw) {
        
        for(int i = 0; i < raw.length; i++) {
            raw[i] = raw[i].replaceAll("\"","");
        }
        return raw;
    }
    
    private void finalCheck(String[] currentArray) {
        
        if(compare != null &&
           currentArray[0].equals(compare[0]) &&
           currentArray[12].equals(compare[12]) &&
           currentArray[13].equals(compare[13])) 
        {
            return;
        }       
        lines.add(currentArray);
    }

  
    private boolean checkForNums(char start) {
        char[] checker = { '1', '2', '3', '4', '5', '6', '7', '8', '9' ,'0'};
        for(int i = 0; i < 10; i++) {
            if(checker[i] == start) { return true; }
        }
        return false;
    }
     
    
    private String reformat(String raw_in) {
        
        
        char[] formatting = raw_in.toCharArray();
        int length = formatting.length;
        boolean flag = false;
        boolean add = true;
        String formatted = "";
        
        for(int i = 0; i < length; i++) {
            
            
            if((formatting[i] == '"') && (!flag)) { flag = true; continue;}
            if((formatting[i] == '"') && (flag)) { flag = false; continue;}   
            
            if(flag && (formatting[i] == ',')) {
                add = false;
            }
            if(formatting[i] == '\n') {
                formatting[i] = ' ';
            }
            if(add) { formatted = formatted + formatting[i]; }
            else { add = true; }  
        }
        return formatted;
    }    
    
 
    
    private String[] fillBlanks(String[] raw, int length){

        String [] full = new String[20];
        
        for(int i = 0; i < 20; i++) {

            if((i < length)) {
                if(raw[i].compareTo("") == 0){
                    full[i] = "Not Available";
                }
                else {
                    full[i] = raw[i];
                    lastString = i;
                }
            }
            else {
                full[i] = "Not Available";
            }
        }   
        return full;
    }     
    
    
    
    private Laureate seperate(String[] raw) {

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
        misc = misc.replaceFirst(",", "");
        born = born.replaceFirst(",", "");
        prize = prize.replaceFirst(",", "");
        death = death.replaceFirst(",", "");

        //assign(born, death, prize, misc); 
        Laureate Winner = new Laureate();
        birthData(Winner, born);
        deathData(Winner, death);
        prizeData(Winner, prize);
        miscData(Winner, misc);
        return Winner;        
    }
    
    
    
    
    private Laureate assign(String born, String death, String prize, String misc) {
        Laureate Winner = new Laureate();
        birthData(Winner, born);
        deathData(Winner, death);
        prizeData(Winner, prize);
        miscData(Winner, misc);
        return Winner;
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
        Winner.addPrize(process[0], process[1],process[2],process[3],
                        process[4], process[5], process[6], process[7]);
    }
    
    
    private void miscData(Laureate Winner, String data) {
        String[] process = data.split(",");
        Winner.addMisc(process[0], process[1],process[2], process[3]);
    }
    
    
    
    //send query class as argument.
    public void makeQuery() {
        String[] current;
        for(int i = 0; i < lines.size(); i++) {
            current = lines.get(i);
            Laureate Winner = seperate(current);
            // add to data structure here.
            
            
            //debug printing.
            //for(int j = 0; j < current.length; j++) {
             //   System.out.print(current[j] + ",");
            //}
            //System.out.println("\n");
        }
    }
}
