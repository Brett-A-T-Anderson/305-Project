import java.util.*;

/**
 * Created by stapl on 11/15/2016.
 */
public class Database {
    private Map<String, ArrayList<Integer>> firstName;
    private Map<String, ArrayList<Integer>> lastName;
    private Map<Integer, ArrayList<Integer>> years;
    private Map<Integer, ArrayList<Integer>> birthYear;
    private Map<Integer, ArrayList<Integer>> deathYear;
    private Map<String, ArrayList<Integer>> category;
    private Map<String, ArrayList<Integer>> country;
    private Map<String, ArrayList<Integer>> gender;
    private Map<String, ArrayList<Integer>> deathCountry;
    private Map<String, ArrayList<Integer>> city;
    private Map<String, ArrayList<Integer>> deathCity;
    private Map<Integer, Laureate> id;

    public Database(){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        years = new HashMap<Integer, ArrayList<Integer>>();
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

    public Database(ArrayList<Laureate> laurs){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        years = new HashMap<Integer, ArrayList<Integer>>();
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
    public List<Laureate> runQuery(Query search){
        List<Integer> fName = null;
        List<Integer> lName = null;
        List<Integer> year = new ArrayList<Integer>();
        List<Integer> dYear = null;
        List<Integer> bYear = null;
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
        if (search.getBirthYear() != null){
            bYear = birthYear.get(search.getBirthYear());
            if(bYear != null) {
                used = true;
                all.addAll(bYear);
            }
            else{
                return empty;
            }
        }
        if (search.getDeathYear() != null){
            dYear = deathYear.get(search.getDeathYear());
            if(dYear != null) {
                used = true;
                all.addAll(dYear);
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
        if (!search.getDeatbCity().matches("")){
            dCity = nameSearch(search.getDeatbCity(), deathCity);
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
            for (Integer i = search.getStartYear(); i < (search.getStartYear() + search.getLoops()); i++) {
                if (years.containsKey(i)) {
                    year.addAll(years.get(i));
                }
            }
            all.addAll(year);
        }
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
        if (!search.getDeatbCity().matches("") && dCity != null){
            all.retainAll(dCity);
        }
        if (!search.getCountry().matches("") && count != null){
           all.retainAll(count);
        }
        if (!search.getGender().matches("") && gen != null){
            all.retainAll(gen);
        }
        if (search.getBirthYear() != null && year != null){
            all.retainAll(bYear);
        }
        if (search.getDeathYear() != null && year != null){
            all.retainAll(dYear);
        }
        if (search.getStartYear() != null && year != null){
            all.retainAll(year);
        }
        if (!used){
            String[] total = firstName.keySet().toArray(new String[0]);
            for (int i = 0; i < total.length; i++){
                all.addAll(firstName.get(total[i]));
            }
        }
        Integer[] iterator = all.toArray(new Integer[0]);
        for (int i = 0; i < iterator.length; i++){
            temp.add(id.get(iterator[i]));
        }
        return temp;
    }
    public void addSingleLaureate(Laureate laur){
        Integer id = laur.getID();
        this.addField(firstName, laur.getFirstName().toLowerCase(), id);
        this.addField(lastName, laur.getLastName().toLowerCase(), id);
        this.addIntField(years, laur.getYear(), id);
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

    public void addMultipleLaureates(ArrayList<Laureate> laurs){
        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }

    public void addField(Map<String, ArrayList<Integer>> toAdd, String addName, Integer id){
        if (!toAdd.containsKey(addName)){
            toAdd.put(addName, new ArrayList<Integer>());
        }
        toAdd.get(addName).add(id);
    }
    public void addIntField(Map<Integer, ArrayList<Integer>> toAdd, Integer addInt, Integer id){
        if (!toAdd.containsKey(addInt)){
            toAdd.put(addInt, new ArrayList<Integer>());
        }
        toAdd.get(addInt).add(id);
    }
    public void addID(Integer idVal, Laureate laur){
        id.put(idVal, laur);
    }
    public ArrayList<Integer> nameSearch(String name, Map<String, ArrayList<Integer>> mapIn){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        String[] names = mapIn.keySet().toArray(new String[0]);
        for (int i = 0; i < names.length; i++){
            if (names[i].matches(".*" + name + ".*")){
                temp.addAll(mapIn.get(names[i]));
            }
        }
        return temp;
    }
}
