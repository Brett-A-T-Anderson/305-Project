//id,firstname,surname,born,died,bornCountry,bornCountryCode,bornCity,diedCountry,diedCountryCode,diedCity,gender,year,
//600,Henri,Bergson,1859-10-18,1941-01-04,France,FR,Paris,France,FR,Paris,male,1927,


//category,overallMotivation,share,motivation,name,city,country
//literature,               ,1,"""in recognition of his rich and vitalizing ideas and the brilliant skill with which they have been presented""",  ,  ,
public class Laureate {

    public BirthData born;
    public DeathData death;
    public PrizeData prize;
    public MiscData  misc;



    public void addBirth(String born, String bornCountry,
                         String bornCountryCode, String bornCity) {
        this.born = new BirthData(born,bornCountry,bornCountryCode,bornCity);
    }

    public void addDeath(String died, String diedCountry,
                         String diedCountryCode, String diedCity) {
        this.death = new DeathData(died, diedCountry,
                diedCountryCode, diedCity);
    }

    public void addPrize(String year, String category, String overallMotivation,
                         String share, String motivation, String uniName, String city, String country) {
        this.prize = new PrizeData(year,  category,  overallMotivation,
                share,  motivation,  uniName, city, country);
    }

    public void addMisc(String id, String firstname, String surname,
                        String gender) {
        this.misc = new MiscData(id,  firstname, surname, gender);
    }

    public String getFirstName(){
        return misc.getFName();
    }
    public String getLastName(){
        return misc.getLName();
    }
    public Integer getID(){
        return Integer.parseInt(misc.getID());
    }
    public Integer getYear(){
        String temp = prize.getYear();
        if(temp.matches("[0-9]*")){
            return Integer.parseInt(temp);
        }
        else{
           return 0;
        }
    }
    public String getCategory(){
        return prize.getCategory();
    }
    public String getCountry(){
        return born.getBCountry();
    }
    public String getGender(){
        return misc.getGender();
    }
    public String getMotivation(){
        return prize.getMotivation();
    }
    public String getDeathCity(){
        return death.getDCity();
    }
    public String getCity(){
        return born.getBCity();
    }
    public String getDeathCountry(){
        return death.getDCountry();
    }
    public Integer getDeathYear(){
        String temp = death.getDeath();
        String[] tmp = temp.split("-");
        if(tmp[0].matches("[0-9]*")){
            return Integer.parseInt(tmp[0]);
        }
        else{
            return 0;
        }
    }
    public Integer getBirthYear(){
        String temp = born.getBorn();
        String[] tmp = temp.split("-");
        if(tmp[0].matches("[0-9]*")){
            return Integer.parseInt(tmp[0]);
        }
        else{
            return 0;
        }
    }
    public String getBirth(){return born.getBorn();}
}