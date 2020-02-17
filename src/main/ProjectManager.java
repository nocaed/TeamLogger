package main;

import java.util.Scanner;

/**
 * This class performs various team building operations, including communications with the user.
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
 
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213;

   /**
    * Begins the team building process.  Creates a new Team, and runs I/O to the user as necessary.
    */
   public void run()
   {
      cs213 = new Team();
      boolean done = false;

      while (!done)
      {
         String command = stdin.nextLine();
         switch (command.charAt(0))
         {   
            case 'A':
              add(command);
		      break; 
            case 'R':
               remove(command);
               break;
            case 'P':
               print();
               break;
            case 'Q':
               print();
               done = true;
               break;
            default:
               System.out.println("Command '" + command.charAt(0) + "' not supported!");
               break;
         }  
      }
      System.out.println("The team is ready to go!");
   } //run()

   /**
    * Adds a new member to the team.
    * @param memberToAdd String representing the person to add with the following format: "command name date"
    */
   private void add(String memberToAdd)
   {
      String[] memberInfo = memberToAdd.split(" ");

      //must check if the date is valid
      Date date = new Date(memberInfo[2]);
      if (!date.isValid()) {
         System.out.println(memberInfo[2] + " is not a valid date!");
         return;
      }

      TeamMember newMember = new TeamMember(memberInfo[1], date);

      //must call the contains() method to check if a given
      //team member is in the team already
      if (cs213.contains(newMember)) {
         System.out.println(newMember + " is already in the team.");
         return;
      }

      System.out.println(newMember + " has joined the team.");
      cs213.add(newMember);
   }

   /**
    * Removes a member from the team.
    * @param memberToRemove String representing the person to remove with the following format: "command name date"
    */
   private void remove(String memberToRemove)
   {
      String[] memberInfo = memberToRemove.split(" ");

      //must check if the date is valid
      Date date = new Date(memberInfo[2]);
      if (!date.isValid()) {
         System.out.println(memberInfo[2] + " is not a valid date!");
         return;
      }

      TeamMember member = new TeamMember(memberInfo[1], date);

      if (!cs213.contains(member)) {
         System.out.println(member + " is not a team member.");
         return;
      }

      System.out.println(member + " has left the team.");
      cs213.remove(member);
   }

   /**
    * Prints out the current team members to the user.
    */
   private void print()
   {
      if(cs213.isEmpty())
         System.out.println("We have 0 team members!");
      else {
         System.out.println("We have the following team members:");
         cs213.print();
         System.out.println("-- end of the list --");
      }
   }   
} //ProjectManager
