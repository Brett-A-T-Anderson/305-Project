package project;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Url_test {
	public static void main(String[] args) throws Exception {
		Scanner fileIn = new Scanner(System.in);
		String laurURL = "http://api.nobelprize.org/v1/laureate.csv?";
		System.out.println("What ID would you like to look for");
		String id = fileIn.nextLine();
		System.out.println(id);
		System.out.println("What Country was the laureate born in");
		String bornCountry = fileIn.nextLine();
		System.out.println("What is the country code of the place they were born in");
		String bornCountryCode = fileIn.nextLine();
		System.out.println("What City were they born in?");
		String bornCity = fileIn.nextLine();
		System.out.println("What city did they die in?");
		String diedCountry = fileIn.nextLine();
		System.out.println("Country code for death location?");
		String diedCountryCode = fileIn.nextLine();
		System.out.println("What city did they die in");
		String diedCity = fileIn.nextLine();
		System.out.println("What date were they born, either YYYY or YYYYMMDD");
		String bornDate = fileIn.nextLine();
		System.out.println("What year would you like to look from for born date?");
		String bornDateTo = fileIn.nextLine();
		System.out.println("What year did they die?");
		String diedDate = fileIn.nextLine();
		System.out.println("What year did they die to?");
		String diedDateTo = fileIn.nextLine();
		System.out.println("Gender?");
		String gender = fileIn.nextLine();
		
		if (!id.equals("")){
			String laurID = "&id=" + id;
			laurURL = laurURL + laurID;
		}
		if (!bornCountry.equals("")){
			String laurBornCountry = "&bornCountry=" + bornCountry;
			laurURL = laurURL + laurBornCountry;
		}
		if (!bornCountryCode.equals("")){
			String laurBornCountryCode = "&bornCountryCode=" + bornCountryCode;
			laurURL = laurURL + laurBornCountryCode;
		}
		if (!bornCity.equals("")){
			String laurBornCity = "&bornCity=" + bornCity ;
			laurURL = laurURL + laurBornCity;
		}
		if (!diedCountry.equals("")){
			String laurDiedCountry = "&diedCountry=" + diedCountry;
			laurURL = laurURL + laurDiedCountry;
		}
		if (!diedCountryCode.equals("")){
			String laurDiedCountryCode = "&diedCountryCode=" + diedCountryCode;
			laurURL = laurURL + laurDiedCountryCode;
		}
		if (!diedCity .equals("")){
			String laurDiedCity = "&diedCity=" + diedCity;
			laurURL = laurURL + laurDiedCity;
		}
		if (!bornDate.equals("")){
			String laurBornDate = "&bornCity=" + bornDate;
			laurURL = laurURL + laurBornDate;
		}
		if (!bornDateTo.equals("")){
			String laurBornDateTo = "&bornDateTo=" + bornDateTo;
			laurURL = laurURL + laurBornDateTo;
		}
		if (!diedDate.equals("")){
			String laurDiedDate = "&diedDate=" + diedDate;
			laurURL = laurURL + laurDiedDate;
		}
		if (!diedDateTo.equals("")){
			String laurDiedDateTo = "&diedDateTo=" + diedDateTo;
			laurURL = laurURL + laurDiedDateTo;
		}
		if (!gender.equals("")){
			String laurGender = "&gender=" + gender;
			laurURL = laurURL + laurGender;
		}
		
		System.out.println(laurURL);
		
		URL csv = new URL(laurURL);
		BufferedReader in = new BufferedReader(new InputStreamReader(csv.openStream()));
		String inputLine;
		while((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}
 