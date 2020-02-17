package main;
/**
 * This class performs various operations in a given Team Member.
 * Also included is a main method to be used only for testing purposes.
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;

   /**
    * Initializes a TeamMember object with a name and a Date object.
    * @param nm The name of the team member.
    * @param date The date that the team member was added to the team.
    */
   public TeamMember(String nm, Date date)
   {
       name = nm;
       startDate = date;
   }

   /**
    * Simple getter method for the read only Date object that represents the team member's
    * start date.
    * @return A deep copy of the team member's start date.
    */
   public Date getStartDate()
   {
      return new Date(startDate);
   }

   /**
    * Checks for equality between two TeamMembers by comparing the return values of their toString methods.
    * @param obj A TeamMember object to be compared to the current instance of this TeamMember object.
    * @return The result of calling a string comparison on this object's toString and obj's toString.
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof TeamMember)) {
         return false;
      }
      TeamMember check = (TeamMember)obj;
      return this.toString().equals(check.toString());
   }

   /**
    * Produces a string displaying the name and startDate of the TeamMember instance.
    * @return A formatted string of this instance's name and the toString of startDate.
    */
   public String toString()
   {
       return name + " " + startDate;
   }

   /**
    * Testbed main for TeamMember, which tests the various methods for success.
    */
   public static void main(String [] args)
   {
      //Testing constructor
      TeamMember tom = new TeamMember("Thomas Brewer", new Date("2/3/2020"));

      //Testing toString
      System.out.println("Team Member: " + tom);

      //Testing get date
      System.out.println("Date started: " + tom.getStartDate());
      
      //Testing equals method
      TeamMember cloneOfTom = new TeamMember("Thomas Brewer", new Date("2/3/2020"));
      TeamMember mike = new TeamMember("Michael McLaughlin", new Date("2/1/2020"));

      System.out.println("Does Tom equal his clone: " + tom.equals(cloneOfTom));
      System.out.println("Does Tom equal his friend mike: " + tom.equals(mike));
   }
}