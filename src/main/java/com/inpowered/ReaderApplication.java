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
 * @version 1.2.1
 */
public class ReaderApplication {

  static final int NAME_POSITION = 0;
  static final int GENDER_POSITION = 1;
  static final int BIRTHDAY_POSITION = 2;
  static final String DATE_PATTERN_FORMAT = "dd/MM/yy";
  static final String FILE_SPLIT_REGEX = ",";

  //TODO: change that into different classes. Let's do the logic in one place first
  public static void main(String[] args) throws IOException, ParseException {

    //Steps:
    //Read File -> Analyze oldest person -> Days older

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
      String[] personIntel = st.split(FILE_SPLIT_REGEX);

      SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN_FORMAT);
      Date personIntelBirthday = formatter.parse(personIntel[BIRTHDAY_POSITION].strip());

      //TODO: remove time from date after
      if (personIntelBirthday.compareTo(oldest) < 0) {
        oldest = personIntelBirthday;
        oldestName = personIntel[NAME_POSITION].strip();
      }

      //"String".equals avoids NullPointerException
      //Ex.: "Male".equals(null) -> False
      // null.equals("Male") -> NullPointerException
      if ("Male".equals(personIntel[GENDER_POSITION].strip())) {
        malesCount++;
      }

      if (personIntel[0].contains("Bill")) {
        billsBirthday = formatter.parse(personIntel[BIRTHDAY_POSITION].strip());
      } else if (personIntel[0].contains("Paul")) {
        paulsBirthday = formatter.parse(personIntel[BIRTHDAY_POSITION].strip());
      }
    }

    long diff = calculateDateDifferenceInDays(paulsBirthday, billsBirthday);
    displayResults(malesCount, oldestName, oldest, diff);

  }

  /**
   * Calculate difference between to given dates.
   * Given two java.util.Date parameters, this method will calculate the absolute difference in days
   * about the two dates.
   *
   * @param firstDate  first date to compare
   * @param secondDate second date to compare
   * @return the absolute difference between the two dates (no negative difference)
   */
  private static long calculateDateDifferenceInDays(final Date firstDate, final Date secondDate) {
    long diffInMilliseconds = Math.abs(firstDate.getTime() - secondDate.getTime());
    return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
  }

  /**
   * Display results on terminal/console.
   * This method will display the results on user's console: Males Count, person Name/Birthday and
   * Bill's & Paul's days difference
   *
   * @param malesCount number of males records in the address book
   * @param oldestName oldest person's name in the address book
   * @param oldestDate oldest person's birthday in the address book
   * @param diff       difference between birthdays
   */
  private static void displayResults(final int malesCount,
                                     final String oldestName,
                                     final Date oldestDate, final long diff) {
    System.out.println("There are " + malesCount + " males in the address book");
    System.out.println(
        "The oldest person in the address book is " + oldestName + ", who was born in " +
            oldestDate);
    System.out.println("Bill is " + diff + " days older than Paul");
  }
}
