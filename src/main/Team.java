package main;
/**
 *
 * @author Thomas Brewer
 * @author Michael McLaughlin
 */
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;

   /**
    * Default constructor for Team. Starts the array with a size of 4; the growth size, and starts the number of
    * members at 0.
    */
   public Team()
   {
      team = new TeamMember[GROW_SIZE];
      numMembers = 0;
   }

   /**
    * Finds a specific TeamMember in team.
    * @param m The target TeamMember that is being searched for in the array.
    * @return The index of the target TeamMember. Returns -1 if m is not found.
    */
   private int find(TeamMember m)
   {
       for(int i = 0; i < team.length; i++) {
          try{
             if(team[i].equals(m))
                return i;
          }
          catch(NullPointerException e){
             continue;
          }
       }

       return NOT_FOUND;
   }

   /**
    * Grows the array by GROW_SIZE.
    */
   private void grow()
   {
      TeamMember[] temp = new TeamMember[team.length + GROW_SIZE];
      System.arraycopy(team, 0, temp, 0, team.length);
      team = temp;
   }

   /**
    * Checks if the array is empty
    * @return The evaluation of numMembers being equal to 0.
    */
   public boolean isEmpty()
   {
       return numMembers == 0;
   }

   /**
    * Adds a TeamMember to the team array.
    * @param m The TeamMember to add to team.
    */
   public void add(TeamMember m)
   {
      if(numMembers == team.length)
         grow();

      team[numMembers] = m;
      numMembers++;
   }


   /**
    * Remove a target TeamMember from the array.
    * @param m The TeamMember to remove.
    * @return True if the TeamMember was in the array, false if it wasn't.
    */
   public boolean remove(TeamMember m)
   {
      int removalIndex = find(m);
      if(removalIndex == NOT_FOUND) {
         return false;
      }
      team[removalIndex] = team[numMembers];
      team[numMembers] = null;
      numMembers--;
      return true;
   }

   /**
    * Checks if team contains a target TeamMember.
    * @param m The TeamMember being searched for.
    * @return If team contains m or not.
    */
   public boolean contains(TeamMember m)
   {
      for(TeamMember member : team) {
         try {
            if(member.equals(m))
               return true;
         }
         catch(NullPointerException e) {
            continue;
         }
      }
      return false;
   }

   /**
    * Prints each TeamMember in team.
    */
   public void print()
   {
      for(TeamMember member : team) {
         try {
            if (member == null)
               continue;
            System.out.println(member);
         }
         catch(NullPointerException e) {
            continue;
         }
      }
   } 
}
