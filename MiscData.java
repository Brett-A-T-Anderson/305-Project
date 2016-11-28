public class MiscData {
    private final String id;
    private final String firstname;
    private final String surname;
    private final String gender;

    MiscData(String id, String firstname, String surname,
             String gender) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.gender = gender;
    }

    public String getID() { return id; }

    public String getFName() { return firstname; }

    public String getLName() { return surname; }

    public String getGender() { return gender; }
}