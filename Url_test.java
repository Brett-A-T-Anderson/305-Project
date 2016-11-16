

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

public class Url_test {

    public static void main(String[] args) throws Exception {

       /* Laureate laur1 = new Laureate();
        Laureate laur2 = new Laureate();
        Laureate laur3 = new Laureate();
        Laureate laur4 = new Laureate();
        Laureate laur5 = new Laureate();
        Laureate laur6 = new Laureate();

        laur1.addBirth("1956", "canada", "CA", "edmonton");
        laur1.addDeath("", "", "", "");
        laur1.addMisc("1", "don", "keedix", "don keedix", "male");
        laur1.addPrize("2000", "physics", "for contributions to stuff", "1", "he felt like it, fam", "toronto", "canada");

        laur2.addBirth("1974", "canada", "CA", "toronto");
        laur2.addDeath("", "", "", "");
        laur2.addMisc("2", "betty", "phuckter", "betty phuckter", "female");
        laur2.addPrize("2008", "peace", "for max package 2: the repackaging", "2", "she was just along for the ride", "chicago", "usa");

        laur3.addBirth("1982", "germany", "DE", "berlin");
        laur3.addDeath("2016", "brazil", "BR", "rio de janero");
        laur3.addMisc("3", "max", "package", "max package", "male");
        laur3.addPrize("2008", "peace", "for max package 2: the repackaging", "2", "to share his package with the world", "chicago", "usa");

        laur4.addBirth("1905", "england", "EN", "london");
        laur4.addDeath("1982", "france", "FR", "paris");
        laur4.addMisc("4", "hugh", "mungus", "hugh mungus", "male");
        laur4.addPrize("1983", "chemisty", "he had good chemisty", "1", "insert stupid joke here", "france", "paris");

        laur5.addBirth("1932", "canada", "CA", "edmonton");
        laur5.addDeath("1982", "france", "FR", "paris");
        laur5.addMisc("5", "max", "package", "max package","male");
        laur5.addPrize("1955", "physics", "for contributions to stuff", "1", "he felt like it, fam", "toronto", "canada");

        laur6.addBirth("1954", "england", "EN", "chelsea");
        laur6.addDeath("", "", "", "");
        laur6.addMisc("6", "dixxy", "normus", "dixxy normus", "female");
        laur6.addPrize("1994", "literature", "for contributions to stuff", "1", "she felt like it, fam", "chicago", "usa");

        ArrayList<Laureate> laurs = new ArrayList<Laureate>();
        laurs.add(laur1);
        laurs.add(laur2);
        laurs.add(laur3);
        laurs.add(laur4);
        laurs.add(laur5);
        laurs.add(laur6);

        Database data = new Database(laurs);
        Query test = new Query("max", "package","","","","","");
        ArrayList<Laureate> max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
           System.out.println(max.get(i).getName() +" "+ max.get(i).getYear() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================max package");
        test = new Query("", "","","","","male","");
        max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
            System.out.println(max.get(i).getName() +" "+ max.get(i).getGender() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================male");
        test = new Query("", "","2008","","","","");
        max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
            System.out.println(max.get(i).getName() +" "+ max.get(i).getYear() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================2008");
        test = new Query("", "","1905","2007","","","");
        max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
            System.out.println(max.get(i).getName() +" "+ max.get(i).getYear() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================1905-2007")
        test = new Query("", "","","","","","canada");
        max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
            System.out.println(max.get(i).getName() +" "+ max.get(i).getYear() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================canada");
        test = new Query("", "","","","physics","","");
        max = data.runQuery(test);
        for (int i = 0; i < max.size(); i++){
            System.out.println(max.get(i).getName() +" "+ max.get(i).getYear() +" "+ max.get(i).getCategory());
        }
        System.out.println("==================================================physics");


        System.out.println("Completed running, array len: " + laurs.size());*/

       // END OF QUERY TESTING


        /*Laureates Lauerates = new Laureates();
        Scanner fileIn = new Scanner(System.in);
        fileIn.close();

        URL csv = new URL("http://api.nobelprize.org/v1/laureate.csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(csv.openStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null) {
            Lauerates.addTo(inputLine);
        }
        in.close();*/
    }

    /*private static String laureates(Scanner fileIn) {

        //Scanner fileIn = new Scanner(System.in);
        String laurURL = "http://api.nobelprize.org/v1/laureate.csv?";
        System.out.println("What ID would you like to look for");
        String id = fileIn.nextLine();
        System.out.println("What Country was the laureate born in");
        String bornCountry = fileIn.nextLine();
        System.out.println("What is the country code of the place they were born in");
        String bornCountryCode = fileIn.nextLine();
        System.out.println("What City were they born in?");
        String bornCity = fileIn.nextLine();
        System.out.println("What city did they die in?");
        String diedCountry = fileIn.nextLine();
        System.out.println("Country code for death location?");
        String diedCountryCode = fileIn.nextLine();
        System.out.println("What city did they die in");
        String diedCity = fileIn.nextLine();
        System.out.println("What date were they born, either YYYY or YYYYMMDD");
        String bornDate = fileIn.nextLine();
        System.out.println("What year would you like to look from for born date?");
        String bornDateTo = fileIn.nextLine();
        System.out.println("What year did they die?");
        String diedDate = fileIn.nextLine();
        System.out.println("What year did they die to?");
        String diedDateTo = fileIn.nextLine();
        System.out.println("Gender?");
        String gender = fileIn.nextLine();

        if (!id.equals("")){
            String laurID = "&id=" + id;
            laurURL = laurURL + laurID;
        }
        if (!bornCountry.equals("")){
            String laurBornCountry = "&bornCountry=" + bornCountry;
            laurURL = laurURL + laurBornCountry;
        }
        if (!bornCountryCode.equals("")){
            String laurBornCountryCode = "&bornCountryCode=" + bornCountryCode;
            laurURL = laurURL + laurBornCountryCode;
        }
        if (!bornCity.equals("")){
            String laurBornCity = "&bornCity=" + bornCity ;
            laurURL = laurURL + laurBornCity;
        }
        if (!diedCountry.equals("")){
            String laurDiedCountry = "&diedCountry=" + diedCountry;
            laurURL = laurURL + laurDiedCountry;
        }
        if (!diedCountryCode.equals("")){
            String laurDiedCountryCode = "&diedCountryCode=" + diedCountryCode;
            laurURL = laurURL + laurDiedCountryCode;
        }
        if (!diedCity.equals("")){
            String laurDiedCity = "&diedCity=" + diedCity;
            laurURL = laurURL + laurDiedCity;
        }
        if (!bornDate.equals("")){
            String laurBornDate = "&bornCity=" + bornDate;
            laurURL = laurURL + laurBornDate;
        }
        if (!bornDateTo.equals("")){
            String laurBornDateTo = "&bornDateTo=" + bornDateTo;
            laurURL = laurURL + laurBornDateTo;
        }
        if (!diedDate.equals("")){
            String laurDiedDate = "&diedDate=" + diedDate;
            laurURL = laurURL + laurDiedDate;
        }
        if (!diedDateTo.equals("")){
            String laurDiedDateTo = "&diedDateTo=" + diedDateTo;
            laurURL = laurURL + laurDiedDateTo;
        }
        if (!gender.equals("")){
            String laurGender = "&gender=" + gender;
            laurURL = laurURL + laurGender;
        }
        //fileIn.close();
        System.out.println(laurURL);
        return laurURL;
    }






    private static String prizes(Scanner fileIn) {
        //Scanner fileIn = new Scanner(System.in);
        System.out.println("What category would you like to look for?");
        String category = fileIn.nextLine();
        System.out.println("From what year would you like to search?");
        String startYear = fileIn.nextLine();
        System.out.println("To what year would you like to look?");
        String endYear = fileIn.nextLine();
        System.out.println("What number of laureates?");
        String numberLaurs = fileIn.nextLine();
        String prizeURl = "http://api.nobelprize.org/v1/prize.csv?";
        if (!category.equals("")){
            String catCat = "&category=" + category;
            prizeURl = prizeURl + catCat;
        }
        if (!startYear.equals("")){
            String catStart = "&year=" + startYear;
            prizeURl = prizeURl + catStart;
        }
        if (!endYear.equals("")){
            String catEnd = "&yearTo=" + endYear;
            prizeURl = prizeURl + catEnd;
        }
        if (!numberLaurs.equals("")){
            String catNumLaurs = "&numberOfLaureates=" + numberLaurs;
            prizeURl = prizeURl + catNumLaurs;
        }
        //fileIn.close();
        System.out.println(prizeURl);
        return prizeURl;
    }*/
}