package main;
import java.util.StringTokenizer;

/**
 * The date class contains a series of methods involved around creating and using Date objects.
 * Also included is a main method to be used only for testing purposes.
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */

public class Date 
{
   private int  day;
   private int  month;
   private int  year;

   /**
    * Constructor that creates a new date object based on the given string.
    * @param d String representing the date.  Formatted month/day/year.
    */
   public Date(String d)
   {
      StringTokenizer st = new StringTokenizer(d, "/");
      int i = 1;
      while(st.hasMoreTokens()) {
         switch(i) {
            case 1:
               month = Integer.parseInt(st.nextToken());
               break;
            case 2:
               day = Integer.parseInt(st.nextToken());
               break;
            case 3:
               year = Integer.parseInt(st.nextToken());
               break;
            default:
               break;
         }
         i++;
      }
   }

   /**
    * Constructor that creates a deep copy of a date object for security reasons.
    * @param d Date object.
    */
   public Date(Date d)
   {
      day = d.day;
      month = d.month;
      year = d.year;
   }

   /**
    * Checks to see if the called Date object is valid.
    * @return True if valid, false if not.
    */
   public boolean isValid()
   {
      switch(month) {
         case Month.JAN: case Month.MAR: case Month.MAY: case Month.JUL: case Month.AUG: case Month.OCT: case Month.DEC:
            return day >= 1 && day <= Month.DAYS_ODD;
         case Month.APR: case Month.JUN: case Month.SEP: case Month.NOV:
            return day >= 1 && day <= Month.DAYS_EVEN;
         case Month.FEB:
            boolean leapYear = ((year % Month.QUADRENNIAL == 0 && year % Month.CENTENNIAL == 0 && year % Month.QUARTERCENTENNIAL == 0)
                    || (year % Month.QUADRENNIAL == 0 && year % Month.CENTENNIAL != 0));
            return (day <= Month.DAYS_FEB + 1 && leapYear) || (day <= Month.DAYS_FEB && !leapYear);
         default:
            return false;
      }
   }

   /**
    * Turn the called date object into a String.
    * @return Date obj as String, formatted month/day/year.
    */
   @Override
   public String toString()
   {
      return month + "/" + day + "/" + year;
   }

   /**
    * Equals method for Date obj comparison
    * @param obj Date object
    * @return True if dates are equal, false if not.
    */
   @Override
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date)) {
         return false;
      }
      Date dateObj = (Date)obj;
      return day == dateObj.day && month == dateObj.month && year == dateObj.year;
   }

   /**
    * Testbed main for Date, which tests the various methods for success.
    */
   public static void main(String[] args) {
      //Testing constructor
      Date thisDate = new Date("2/17/2020");
      System.out.println(thisDate);

      //Testing deep copy
      Date thisDateCopy = new Date(thisDate);
      thisDate = null;
      System.out.println(thisDateCopy);

      //Testing isValid
      Date invalidDate = new Date("2/35/2020");
      System.out.println("Is 2/35/2020 a valid date?: " + invalidDate.isValid());

      //Testing toString
      System.out.println(invalidDate);

      //Testing equals method
      System.out.println("Are 2/17/2020 and 2/35/2020 the same date?: " + thisDateCopy.equals(invalidDate));
   }
}


