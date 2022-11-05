package main.java.com.inpowered;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class responsible for calling file reader and return properly intel.
 * This class will call a file reader; based on names, genders and birthdays
 * and return how many males are in the file, who's the oldest person in the file
 * and how many days older Bill is than Paul.
 *
 * @author Filipe Lima
 * @version 1.0.0
 */
public class ReaderApplication {

  //TODO: change that into different classes. Let's do the logic in one place first
  public static void main(String[] args) throws IOException, ParseException {

    //Steps:
    //Read File -> Analyze oldest person -> Days older

    //TODO: set specific variables for positions of intel in array

    //File Reader
    File file = new File("src/main/resources/AddressBook.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    //Default Date for comparison
    Date oldest = new Date();
    String oldestName = "";

    //Get Bill's and Paul's birthdays
    Date billsBirthday = new Date();
    Date paulsBirthday = new Date();

    String st;
    int malesCount = 0;
    while ((st = br.readLine()) != null) {
      String[] personIntel = st.split(",");

      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
      Date personIntelBirthday = formatter.parse(personIntel[2].strip());

      //TODO: remove time from date after
      if (personIntelBirthday.compareTo(oldest) < 0) {
        oldest = personIntelBirthday;
        oldestName = personIntel[0].strip();
      }

      //"String".equals avoids NullPointerException
      //Ex.: "Male".equals(null) -> False
      // null.equals("Male") -> NullPointerException
      if ("Male".equals(personIntel[1].strip())) {
        malesCount++;
      }

      if (personIntel[0].contains("Bill")) {
        billsBirthday = formatter.parse(personIntel[2].strip());
      } else if (personIntel[0].contains("Paul")) {
        paulsBirthday = formatter.parse(personIntel[2].strip());
      }
    }

    long diffInMillies = Math.abs(paulsBirthday.getTime() - billsBirthday.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

    System.out.println("There are " + malesCount + " males in the file");
    System.out.println(
        "The oldest person in the file is" + oldestName + ", who was born in " + oldest);
    System.out.println("Bill is " + diff + " days older than Paul");

  }
}
