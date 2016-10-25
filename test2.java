/**
 * Created by stapl on 10/25/2016.
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://api.nobelprize.org/v1/prize.csv?category=medicine&year=1990&yearto=1994");
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

