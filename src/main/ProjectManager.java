package main;
import java.util.Scanner;
/**
 *
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
 
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213;

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
   
   private void print()
   {
      if(cs213.isEmpty())
         System.out.println("We have 0 team members!");
      else {
         System.out.println("We have the following team members:");
         cs213.print();
      }
   }   
} //ProjectManager
