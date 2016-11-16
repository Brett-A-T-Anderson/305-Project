import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList<Laureate> temp = null;
        ArrayList<Integer> fName = null;
        ArrayList<Integer> lName = null;
        ArrayList<Integer> year = null;
        ArrayList<Integer> cat = null;
        ArrayList<Integer> count = null;
        ArrayList<Integer> gen = null;
        if (!search.getFirstName().matches("")){
            fName = firstName.get(search.getFirstName());
        }
        if (!search.getLastName().matches("")){
            lName = lastName.get(search.getFirstName());
        }
        if (!search.getCategory().matches("")){
            cat = category.get(search.getCategory());
        }
        if (!search.getCountry().matches("")){
            count = country.get(search.getCountry());
        }
        if (!search.getGender().matches("")){
            gen = gender.get(search.getGender());
        }
        return temp;
    }
    public void addSingleLaureate(Laureate laur){
        Integer id = laur.getID();
        this.addFirstName(laur.getFirstName(),id);
        this.addLastName(laur.getLastName(), id);
        this.addToYear(laur.getYear(), id);
        this.addToCategory(laur.getCategory(), id);
        this.addCountry(laur.getCountry(), id);
        this.addGender(laur.getGender(), id);
        this.addID(id, laur);
    }

    public void addMultipleLaureates(ArrayList<Laureate> laurs){
        for (int i = 0; i < laurs.size(); i++){
            this.addSingleLaureate(laurs.get(i));
        }
    }

    public void addFirstName(String name, Integer id){
        if (!firstName.containsKey(name)){
            firstName.put(name, new ArrayList<Integer>());
        }
        firstName.get(name).add(id);
    }

    public void addLastName(String name, Integer id){
        if (!lastName.containsKey(name)){
            lastName.put(name, new ArrayList<Integer>());
        }
        lastName.get(name).add(id);
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

}
