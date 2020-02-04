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
   
   public Team()
   {
      team = new TeamMember[GROW_SIZE];
      numMembers = 0;
   }
   
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
   
   private void grow()
   {
      TeamMember[] temp = new TeamMember[team.length + GROW_SIZE];
      for(int i = 0; i < team.length; i++) {
         temp[i] = team[i];
      }
      team = temp;
   }
   
   public boolean isEmpty()
   {
       return numMembers == 0;
   }
   
   public void add(TeamMember m)
   {
      // TODO make storage more efficient by filling in null gaps created by object removal
      if(numMembers == team.length)
         grow();
      team[numMembers] = m;
      numMembers++;
   }
   
   public boolean remove(TeamMember m)
   {
      int removalIndex = find(m);
      if(removalIndex == NOT_FOUND) {
         return false;
      }
      team[removalIndex] = null;
      return true;
   } 
   
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
   
   public void print()
   {
      for(TeamMember member : team) {
         try {
            System.out.println(member);
         }
         catch(NullPointerException e) {
            continue;
         }
      }
   } 
}
