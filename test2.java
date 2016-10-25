/**
 * Created by stapl on 10/25/2016.
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) throws Exception {
        Scanner fileIn = new Scanner(System.in);
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

        System.out.println(prizeURl);
        URL oracle = new URL(prizeURl);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        List<String> hold = new ArrayList<>();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            hold.add(inputLine);
        }
        in.close();
        for (int i = 0; i < hold.size(); i++){
            System.out.println(hold.get(i));
        }

    }

}

