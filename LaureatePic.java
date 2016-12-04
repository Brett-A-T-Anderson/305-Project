/**
 * Created by: Jordan Hewko
 * This class will take a Laureate class from the UI, and fetch a picture for
 * the user, the pictures are taken from the Nobel Prize website.
 * */
package application;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class LaureatePic {

    private Image image;
    private String urlImage;

    public LaureatePic(Laureate winner) throws Exception {

        String first = winner.getFirstName().toLowerCase();
        String last = winner.getLastName().toLowerCase();
        String prize = winner.getCategory().toLowerCase();
        String year = Integer.toString(winner.getYear());

        String clean;
        String url;

        //Strip the name of any special characters
        first = stripSpecials(first);
        last = stripSpecials(last);
        first = removeTitle(first);

        //clean the name and find the pic with the cleaned name
        clean = cleanName(first, last);

        //build the URL to retrieve the picture
        url = buildURL(prize, year, clean);
        //System.out.println(url);
        //This will set the image for MOST Laureates
        setImage(url);

        //If the first way doesn't work, it is a duplicate, so try again
        if (this.image == null) {

            clean = cleanNameDuplicate(first, last);
            url = buildURL(prize, year, clean);
            //If they are duplicates with different names
            setImage(url);
            //System.out.println(url);

        }

        //This is a duplicate, and they share the same name, as far as I know
        //there is only 1 case of this in the entire database, and the code is 
        //not very good.
        if (this.image == null) {

            clean = cleanAgain(first, last);
            url = buildURL(prize, year, clean);

            setImage(url);
        }

        //IF you get here, there is an error in the search parameters, or the
        //winner is a committee, which I have not accounted for, becuase there is
        //no rhyme or reason to how they build the URL for the image.
        if (this.image == null) {
            this.image = new Image("/img/doge.jpeg");
        }

    }

    //Setters
    private void setImage(String url) throws Exception {

        BufferedImage raw = null;

        try {

            //create the image
            URL oracle = new URL(url);
            raw = ImageIO.read(oracle);

        } catch (IIOException | MalformedURLException ex) {

            //set the image, if raw retrieved an image, this will convert it to an 
            //image and post it
        }
        if (raw != null) {
            this.image = SwingFXUtils.toFXImage(raw, null);
        }
    }
    public void setUrlImage(String url) {
        this.urlImage = url;
    }

    /**
     * Some of the pictures use URL protocol http and some use https, so this
     * will check to see which protocol it uses, and fetches the url accordingly
     *
     * Code for this pulled from:
     * https://www.mkyong.com/java/java-httpurlconnection-follow-redirect-example/
     * 
     * @param url - String of the url,
     * @return url with the proper protocol
     */
    private String getProtocol(String url) {
        try {
            URL obj = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            int status = conn.getResponseCode();

            if (status == HttpURLConnection.HTTP_MOVED_PERM) url = "http://www.nobelprize.org" + obj.getPath();
                       
            //close the connection
            conn.disconnect();
            
        } catch (Exception ex) {

            System.out.println("Error " + ex);
        }
        return url;

    }

    //Getters
    public Image getImage() {
        return this.image;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    /**
     * After the URL is created, this method will create the URL with the name,
     * year and name. It is not concerned with what the name is, since the
     * cleaning methods handle that part.
     *
     */
    private String buildURL(String prize, String year, String name) {

        StringBuilder prizeURL = new StringBuilder();
        prizeURL.append("https://www.nobelprize.org/nobel_prizes/");
        prizeURL.append(prize);
        prizeURL.append("/laureates/");
        prizeURL.append(year);
        prizeURL.append("/");
        prizeURL.append(name);
        prizeURL.append("_postcard.jpg");

        setUrlImage(prizeURL.toString());

        return getProtocol(prizeURL.toString());

    }

    /**
     * This method strips special characters from the name of the Laureate,
     * because a website URL does not allow for special characters, also removes
     * titles, it wreaks havok in my urls :(
     *
     */
    private String stripSpecials(String fixMe) {

        fixMe = Normalizer.normalize(fixMe, Normalizer.Form.NFD);
        fixMe = fixMe.replaceAll("[^\\p{ASCII}]", "");

        //if the name ends with jr, split the name by jr, take the first half
        if (fixMe.endsWith("jr.")) {
            String[] name = fixMe.split(" jr.");
            fixMe = name[0];

        }
        return fixMe;
    }

    /**
     * Some of the Laureates have titles, and they don't work well for URLs, so
     * I removed them.
     *
     * @param name
     * @return name, without the title.
     */
    private String removeTitle(String name) {

        final ArrayList<String> titles = new ArrayList(Arrays.asList("sir", "lord", "lady", "baron", "baroness", "mother", "count"));
        StringBuilder cleaned = new StringBuilder();

        String[] stripped = name.split(" ");

        //Check every letter in the list
        for (String word : stripped) {

            //if the word isn't a title, append it to the string
            if (!titles.contains(word)) {
                cleaned.append(word);
                cleaned.append(" ");

            }

        }

        //remove the last " "
        cleaned.deleteCharAt(cleaned.length() - 1);
        return cleaned.toString();
    }

    /**
     * This method cleans the name of the Laureates, this will work 80% of the
     * time because some of the URLs are build strangely, for example, if there
     * are Laureates with the same last names.
     *
     */
    private String cleanName(String first, String last) {

        String cleaned = "";

        //if there is no last name, treat the first name like it is the last
        if (last.compareTo("\n") == 0) {
            System.out.println("No last name");
            last = first;
        }

        cleaned = last;

        //If the laureate is a woman with a maiden name:
        if (last.split(" ").length > 1) {
            String[] lastNames = last.split(" nee ");
            cleaned = lastNames[0];
        }

        //Strip any brackets off of the name
        if (last.startsWith("(") && last.endsWith(")")) {

            cleaned = last.substring(1, last.length() - 1);

        }

        //check for a ' in the name
        if (cleaned.contains("\'") == true) {

            //if it starts with ', combine the word to the second
            if (cleaned.startsWith("'") == true) {
                cleaned = cleaned.replaceAll(" ", "");
            }

            //remove the apostrophe
            cleaned = cleaned.replaceAll("\'", "");

        }

        //if the last name is more than one word, remove the others
        if (cleaned.split(" ").length > 1) {

            String[] split = cleaned.split(" ");
            cleaned = split[split.length - 1];

        }

        return cleaned;
    }

    /**
     * This method cleans the name of the Laureate following a different
     * algorithm, it will take the first and last names, and they will hyphenate
     * them together to build the URL
     *
     */
    private String cleanNameDuplicate(String first, String last) {

        String cleaned;

        //If the laureate is a woman with a maiden name:
        if (last.split(" ").length > 1) {
            String[] lastNames = last.split(" nee ");
            last = lastNames[0];
        }

        //Since the names are duplicates, strip the names and hyphenate them.
        String[] firstNames = first.split(" ");
        String[] lastNames = last.split(" ");

        cleaned = firstNames[firstNames.length - 1] + "-" + lastNames[lastNames.length - 1];
        return cleaned;

    }

    /**
     * This method cleans the name of the Laureate following a different
     * algorithm, this will take the first initial of their first name, combine
     * them, and hyphenate them with the last name to build a URL. THis is the
     * last ditch effort to grab a URL, if it doesn't work, no picture will be
     * fetched
     *
     */
    private String cleanAgain(String first, String last) {

        //IF the laureate is a woman with a maiden name:
        if (last.split(" ").length > 1) {
            String[] lastNames = last.split(",");
            last = lastNames[0];
        }
        //These guys have the same name, so you need to take their initials
        StringBuilder cleaned = new StringBuilder();

        //if they have a title it needs to be removed
        String[] firstNames = first.split(" ");

        //check every name in the first names
        for (String name : firstNames) {

            //add the initial to clean
            cleaned.append(name.charAt(0));
        }

        //append the last name, output the result.
        cleaned.append("-");
        cleaned.append(last);

        return cleaned.toString();

    }

}
