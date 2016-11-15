/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg305_project;

/**
 *
 * @author mark
 */
public class MiscData {
    private String id;
    private String firstname;
    private String surname;
    private String name;
    private String gender;
    
    MiscData(String id, String firstname, String surname, 
                String name, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;       
        this.name = name;
        this.gender = gender;
    }
    
    public String getID() { return id; }
    
    public String getFName() { return firstname; }
    
    public String getLName() { return surname; }
    
    public String getName() { return name; }
    
    public String getGender() { return gender; }
}
