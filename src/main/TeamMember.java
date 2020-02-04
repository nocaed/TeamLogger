package main;
/**
 *
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
      return this.toString().equals(obj.toString());
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
    * TODO test bed for this class.
    */
   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
   }
}