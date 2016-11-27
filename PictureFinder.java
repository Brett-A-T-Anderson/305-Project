/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;


public class PictureFinder extends Application{
    
    //static ArrayList<Image> pics = new ArrayList<>();

    String title;
    static Laureate win;
    
    
    public static void main(String[] args) {
        
        
        //Laureates pool = new Laureates();
        //win = pool.makeDatabase(6);
        
        launch(args);       
    }
    
    
    @Override
    public void start(Stage Alice) {
        Image clean;

        try {
            clean = getPic(win.misc.getLName().toLowerCase(), win.prize.getYear(), win.prize.getCategory());
        }
        catch(Exception ex) {
            title = "Not Found.";
            clean = new Image("harambe.jpeg");            
        }
                
        
        FlowPane Node = new FlowPane();
        
        Node.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(Node, 400, 400);
        
        Alice.setScene(myScene);
        Alice.setTitle(title);
        
        
        ImageView James = new ImageView(clean);
        
        Node.getChildren().add(James);
        
        Alice.show();
        
    }
    

    
    
    // Lname is the one that can be several versions of fubar.
    private Image getPic(String Lname, String year, String cat) throws Exception {
        
        BufferedImage raw = null;
        Image clean = null;
        try{
            String prizeURl = "http://www.nobelprize.org/nobel_prizes/" 
            + cat + "/laureates/" + year + "/" + Lname + "_postcard.jpg";
            URL oracle = new URL(prizeURl);
            raw = ImageIO.read(oracle);
        }
        catch(IIOException | MalformedURLException ex) {}
        try {
            
            clean = SwingFXUtils.toFXImage(raw, null);
            title = win.misc.getFName() + " " + win.misc.getLName();
        }
        catch(NullPointerException ex) { throw ex; }
        
        return clean;
    }
    
}