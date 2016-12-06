import java.util.*;

/**
 * Created by Jack Staples on 11/15/2016.
 *
 * This is our database that will contain all the laureautes and
 * create maps to search through them quickly.
 */
public class Database {
    private Map<String, ArrayList<Integer>> firstName;
    private Map<String, ArrayList<Integer>> lastName;
    private Map<Integer, ArrayList<Integer>> wonYears;
    private Map<Integer, ArrayList<Integer>> birthYear;
    private Map<Integer, ArrayList<Integer>> deathYear;
    private Map<String, ArrayList<Integer>> category;
    private Map<String, ArrayList<Integer>> country;
    private Map<String, ArrayList<Integer>> gender;
    private Map<String, ArrayList<Integer>> deathCountry;
    private Map<String, ArrayList<Integer>> city;
    private Map<String, ArrayList<Integer>> deathCity;
    private Map<Integer, Laureate> id;

    /* database constructor */
    public Database(){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        wonYears = new HashMap<Integer, ArrayList<Integer>>();
        category = new HashMap<String, ArrayList<Integer>>();
        country = new HashMap<String, ArrayList<Integer>>();
        gender =  new HashMap<String, ArrayList<Integer>>();
        deathYear = new HashMap<Integer, ArrayList<Integer>>();
        birthYear = new HashMap<Integer, ArrayList<Integer>>();
        deathCountry =  new HashMap<String, ArrayList<Integer>>();
        city =  new HashMap<String, ArrayList<Integer>>();
        deathCity =  new HashMap<String, ArrayList<Integer>>();
        id = new HashMap<Integer, Laureate>();
    }
/* this constructor is not used, but you could create a database from an array of laureate objects if needed */
    public Database(ArrayList<Laureate> laurs){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        wonYears = new HashMap<Integer, ArrayList<Integer>>();
        category = new HashMap<String, ArrayList<Integer>>();
        country = new HashMap<String, ArrayList<Integer>>();
        gender =  new HashMap<String, ArrayList<Integer>>();
        deathYear = new HashMap<Integer, ArrayList<Integer>>();
        birthYear = new HashMap<Integer, ArrayList<Integer>>();
        deathCountry =  new HashMap<String, ArrayList<Integer>>();
        city =  new HashMap<String, ArrayList<Integer>>();
        deathCity =  new HashMap<String, ArrayList<Integer>>();
        id = new HashMap<Integer, Laureate>();

        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }
    /* this is the search method, runs a query object */
    public List<Laureate> runQuery(Query search){
        List<Integer> fName = null;
        List<Integer> lName = null;
        List<Integer> yearsWon = new ArrayList<Integer>();
        List<Integer> yearsDeath = null;
        List<Integer> yearsBorn = null;
        List<Integer> bCity = null;
        List<Integer> dCity = null;
        List<Integer> dCountry = null;
        List<Integer> cat = null;
        List<Integer> count = null;
        List<Integer> gen = null;
        Set<Integer> all = new HashSet<Integer>();
        List<Laureate> empty = new ArrayList<Laureate>();
        List<Laureate> temp = new ArrayList<Laureate>();
        boolean used = false;

        /* these if looks check if a field is set and then
        fill the needed array with all the laureates that
        match the information in the query. nameSearch is used for
        a n length regex search, while a simple map check is used for
        others as it is faster
         */
        if (!search.getFirstName().matches("")){
            fName = nameSearch(search.getFirstName(), firstName);
            if(fName != null) {
                used = true;
                all.addAll(fName);
            }
            else{
                return empty;
            }
        }
        if (!search.getLastName().matches("")){
            lName = nameSearch(search.getLastName(), lastName);
            if (lName != null) {
                used = true;
                all.addAll(lName);
            }
            else{
                return empty;
            }
        }
        if (!search.getCategory().matches("")){
            cat = category.get(search.getCategory());
            if(cat != null) {
                used = true;
                all.addAll(cat);
            }
            else{
                return empty;
            }
        }
        if (!search.getDeathCity().matches("")){
            dCity = nameSearch(search.getDeathCity(), deathCity);
            if (dCity != null){
                used = true;
                all.addAll(dCity);
            }
            else{
                return empty;
            }
        }
        if (!search.getCity().matches("")){
            bCity = nameSearch(search.getCity(), city);
            if (bCity != null){
                used = true;
                all.addAll(bCity);
            }
            else {
                return empty;
            }
        }
        if (!search.getDeathCountry().matches("")){
            dCountry = deathCountry.get(search.getDeathCountry());
            if (dCountry != null){
                used = true;
                all.addAll(dCountry);
            }
            else{
                return empty;
            }
        }
        if (!search.getCountry().matches("")){
            count = country.get(search.getCountry());
            if (count != null) {
                used = true;
                all.addAll(count);
            }
            else{
                return empty;
            }
        }
        if (!search.getGender().matches("")){
            gen = gender.get(search.getGender());
            if (gen != null) {
                used = true;
                all.addAll(gen);
            }
            else{
                return empty;
            }
        }
        if (search.getStartYear() != null) {
            used = true;
            yearsWon = yearSearch(wonYears, search.getStartYear(), search.getLoops());
            all.addAll(yearsWon);
        }
        if (search.getDeathYear() != null) {
            used = true;
            yearsDeath = yearSearch(deathYear, search.getDeathYear(), search.getDeathLoops());
            all.addAll(yearsDeath);
        }
        if (search.getBirthYear() != null) {
            used = true;
            yearsBorn = yearSearch(birthYear, search.getBirthYear(), search.getBirthLoops());
            all.addAll(yearsBorn);
        }

        /* these if statements see which arrays have been filled and then filter out all
        the laureates who do not match ALL the search categories
         */
        if (!search.getFirstName().matches("") && fName != null){
                all.retainAll(fName);
        }
        if (!search.getLastName().matches("") && lName != null){
            all.retainAll(lName);
        }
        if (!search.getCity().matches("") && bCity != null){
            all.retainAll(bCity);
        }
        if (!search.getDeathCountry().matches("") && dCountry != null){
            all.retainAll(dCountry);
        }
        if (!search.getCategory().matches("") && cat != null){
            all.retainAll(cat);
        }
        if (!search.getDeathCity().matches("") && dCity != null){
            all.retainAll(dCity);
        }
        if (!search.getCountry().matches("") && count != null){
           all.retainAll(count);
        }
        if (!search.getGender().matches("") && gen != null){
            all.retainAll(gen);
        }
        if (search.getBirthYear() != null && yearsBorn != null){
            all.retainAll(yearsBorn);
        }
        if (search.getDeathYear() != null && yearsDeath != null){
            all.retainAll(yearsDeath);
        }
        if (search.getStartYear() != null && yearsWon != null){
            all.retainAll(yearsWon);
        }
        if (!used){
            String[] total = firstName.keySet().toArray(new String[0]);
            for (int i = 0; i < total.length; i++){
                all.addAll(firstName.get(total[i]));
            }
        }
        /* this runs through and adds the matched id's to an array of laureate objects */
        Integer[] iterator = all.toArray(new Integer[0]);
        for (int i = 0; i < iterator.length; i++){
            temp.add(id.get(iterator[i]));
        }
        return temp;
    }
    /* inputs a single laureate into the database using the addField and addIntField methods */
    public void addSingleLaureate(Laureate laur){
        Integer id = laur.getID();
        this.addField(firstName, laur.getFirstName().toLowerCase(), id);
        this.addField(lastName, laur.getLastName().toLowerCase(), id);
        this.addIntField(wonYears, laur.getYear(), id);
        this.addField(category, laur.getCategory().toLowerCase(), id);
        this.addField(country, laur.getCountry().toLowerCase(), id);
        this.addField(gender, laur.getGender().toLowerCase(), id);
        this.addField(city, laur.getCity().toLowerCase(), id);
        this.addField(deathCity, laur.getDeathCity().toLowerCase(), id);
        this.addField(deathCountry, laur.getDeathCountry().toLowerCase(), id);
        this.addIntField(deathYear, laur.getDeathYear(), id);
        this.addIntField(birthYear, laur.getBirthYear(), id);
        this.addID(id, laur);
    }
    /* not used, but if you wanted to add multiple laureautes you can */
    public void addMultipleLaureates(ArrayList<Laureate> laurs){
        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }
    /* add a string field to the database */
    public void addField(Map<String, ArrayList<Integer>> toAdd, String addName, Integer id){
        if (!toAdd.containsKey(addName)){
            toAdd.put(addName, new ArrayList<Integer>());
        }
        toAdd.get(addName).add(id);
    }
    /* add an integer field to the database */
    public void addIntField(Map<Integer, ArrayList<Integer>> toAdd, Integer addInt, Integer id){
        if (!toAdd.containsKey(addInt)){
            toAdd.put(addInt, new ArrayList<Integer>());
        }
        toAdd.get(addInt).add(id);
    }
    /* add an ID to the ID Map */
    public void addID(Integer idVal, Laureate laur){
        id.put(idVal, laur);
    }
    /* this is a n length search that uses a regex pattern to find matching laureates */
    public List<Integer> nameSearch(String name, Map<String, ArrayList<Integer>> mapIn){
        List<Integer> temp = new ArrayList<Integer>();
        String[] names = mapIn.keySet().toArray(new String[0]);
        for (int i = 0; i < names.length; i++){
            if (names[i].matches(".*" + name + ".*")){
                temp.addAll(mapIn.get(names[i]));
            }
        }
        return temp;
    }
    /* returns all the laureates in a range of years */
    public List<Integer> yearSearch(Map<Integer, ArrayList<Integer>> years, Integer startYear, Integer loops){
        List<Integer> temp = new ArrayList<Integer>();
        for (Integer i = startYear; i < (startYear + loops); i++) {
            if (years.containsKey(i)) {
                temp.addAll(years.get(i));
            }
        }
        return temp;
    }
}
