package main;
import java.util.StringTokenizer;
/**
 *
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
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
   
   public Date(Date d)
   {
      day = d.day;
      month = d.month;
      year = d.year;
   }      
   
   public boolean isValid()
   {
      switch(month) {
         case Month.JAN: case Month.MAR: case Month.MAY: case Month.JUL: case Month.AUG: case Month.OCT: case Month.DEC:
            return day >= 1 && day <= Month.DAYS_ODD;
         case Month.APR: case Month.JUN: case Month.SEP: case Month.NOV:
            return day >= 1 && day <= Month.DAYS_EVEN;
         case Month.FEB:
            boolean leapYear = year % Month.QUADRENNIAL == 0 && year % Month.CENTENNIAL != 0 && year % Month.QUARTERCENTENNIAL == 0;
            return (day <= Month.DAYS_FEB + 1 && leapYear) || (day <= Month.DAYS_FEB && !leapYear);
         default:
            return false;
      }
   }
   
   @Override
   public String toString()
   {
      return month + "/" + day + "/" + year;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date)) {
         return false;
      }
      Date dateObj = (Date)obj;
      return day == dateObj.day && month == dateObj.month && year == dateObj.year;
   }

   public static void main(String[] args) {
      // TODO testbed
   }
}


