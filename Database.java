import java.util.*;

/**
 * Created by stapl on 11/15/2016.
 */
public class Database {
    private Map<String, ArrayList<Integer>> firstName;
    private Map<String, ArrayList<Integer>> lastName;
    private Map<Integer, ArrayList<Integer>> years;
    private Map<String, ArrayList<Integer>> category;
    private Map<String, ArrayList<Integer>> country;
    private Map<String, ArrayList<Integer>> gender;
    private Map<Integer, Laureate> id;

    public Database(){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        years = new HashMap<Integer, ArrayList<Integer>>();
        category = new HashMap<String, ArrayList<Integer>>();
        country = new HashMap<String, ArrayList<Integer>>();
        gender =  new HashMap<String, ArrayList<Integer>>();
        id = new HashMap<Integer, Laureate>();
    }

    public Database(ArrayList<Laureate> laurs){
        firstName = new HashMap<String, ArrayList<Integer>>();
        lastName = new HashMap<String, ArrayList<Integer>>();
        years = new HashMap<Integer, ArrayList<Integer>>();
        category = new HashMap<String, ArrayList<Integer>>();
        country = new HashMap<String, ArrayList<Integer>>();
        gender =  new HashMap<String, ArrayList<Integer>>();
        id = new HashMap<Integer, Laureate>();

        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }
    public ArrayList<Laureate> runQuery(Query search){
        ArrayList<Integer> fName = null;
        ArrayList<Integer> lName = null;
        ArrayList<Integer> year = new ArrayList<Integer>();
        ArrayList<Integer> cat = null;
        ArrayList<Integer> count = null;
        ArrayList<Integer> gen = null;
        Set<Integer> all = new HashSet<Integer>();
        ArrayList<Laureate> empty = new ArrayList<Laureate>();
        ArrayList<Laureate> temp = new ArrayList<Laureate>();
        boolean used = false;
        if (!search.getFirstName().matches("")){
            fName = nameSearch(search.getFirstName());
            if(fName != null) {
                used = true;
                all.addAll(fName);
            }
            else{
                return empty;
            }
        }
        if (!search.getLastName().matches("")){

            lName = lastName.get(search.getLastName());
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
        if (!search.getCategory().matches("") && cat != null){
            all.retainAll(cat);
        }
        if (!search.getCountry().matches("") && count != null){
           all.retainAll(count);
        }
        if (!search.getGender().matches("") && gen != null){
            all.retainAll(gen);
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
        String fName[] = laur.getFirstName().split(" ");
        if (fName[0].matches("[A-Z]\\.") || fName[0].matches("sir")){
            this.addFirstName(fName[1].toLowerCase(), id);
        }
        else {
            this.addFirstName(fName[0].toLowerCase(), id);
        }
        this.addLastName(laur.getLastName().toLowerCase(), id);
        this.addToYear(laur.getYear(), id);
        this.addToCategory(laur.getCategory().toLowerCase(), id);
        this.addCountry(laur.getCountry().toLowerCase(), id);
        this.addGender(laur.getGender().toLowerCase(), id);
        this.addID(id, laur);
    }

    public void addMultipleLaureates(ArrayList<Laureate> laurs){
        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }

    public void addFirstName(String name, Integer id){
        if (!firstName.containsKey(name)){
            firstName.put(name.toLowerCase(), new ArrayList<Integer>());
        }
        firstName.get(name.toLowerCase()).add(id);
    }

    public void addLastName(String name, Integer id){
        if (!lastName.containsKey(name)){
            lastName.put(name.toLowerCase(), new ArrayList<Integer>());
        }
        lastName.get(name.toLowerCase()).add(id);
    }

    public void addToYear(Integer year, Integer id){
        if (!years.containsKey(year)){
            years.put(year, new ArrayList<Integer>());
        }
        years.get(year).add(id);
    }

    public void addToCategory(String cat, Integer id){
        if (!category.containsKey(cat)){
            category.put(cat, new ArrayList<Integer>());
        }
        category.get(cat).add(id);
    }

    public void addCountry(String countryName, Integer id){
        if (!country.containsKey(countryName)){
            country.put(countryName, new ArrayList<Integer>());
        }
        country.get(countryName).add(id);
    }

    public void addGender(String genderType, Integer id){
        if (!gender.containsKey(genderType)){
            gender.put(genderType, new ArrayList<Integer>());
        }
        gender.get(genderType).add(id);
    }

    public void addID(Integer idVal, Laureate laur){
        id.put(idVal, laur);
    }
    public ArrayList<Integer> nameSearch(String name){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        String[] names = firstName.keySet().toArray(new String[0]);
        for (int i = 0; i < names.length; i++){
            if (names[i].matches(".*" + name + ".*")){
                temp.addAll(firstName.get(names[i]));
            }
        }
        return temp;
    }
}
