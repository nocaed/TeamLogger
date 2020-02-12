package main;
import java.util.Scanner;
/**
 *
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
 
public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {
      cs213 = new Team();
      boolean done = false;
      while (!done)
      {
         String command = stdin.next();
         switch (command.charAt(0))
         {   
            case 'A':
              add();
		      break; 
            case 'R':
               remove();
               break;
            case 'P':
               print();
               break;
            case 'Q':
               // same as P but you end the program afterwards
               break;
            default:
               //deal with bad command here
               break;
         }  
      }
      //write java code before you terminate the program
   } //run()
   
   private void add()
   {
      	//must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
   }
   
   private void remove()
   {
      //must check if the date is valid
	   
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
