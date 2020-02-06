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
       // TODO this. ;)
   }
   
   @Override
   public String toString()
   {
       //use the format "month/day/year"
      return month + "/" + day + "/" + year;
   }
   
   @Override
   public boolean equals(Object obj)
   {
       return day == obj.day || month == obj.month || year == obj.year;
   }  
}


