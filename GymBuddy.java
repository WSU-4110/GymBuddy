

import java.util.ArrayList;
import java.util.Scanner;

public class GymBuddy {
   static Scanner scan = new Scanner(System.in);
   static ArrayList<Gym> gymUserList = new ArrayList<>();

   public static void main(String[] args) {
       while(true) {
    // print menu       
       System.out.println(
               "\nWelcome to Gym Buddy Application\n------------------------------------------------\nSelect one option: \n");
       System.out.println("1. Add new user\n2. Find gym partner\n3. Exit");
  // get user input
       int option = scan.nextInt();
 // switch user input
       switch (option) {
       case 1:
    // call add user
           addUser();
           break;
       case 2:
   // call find partner
           findPartner();
           break;
       case 3:
    // exit execution
           System.exit(0);
           break;
       default:
           System.out.println("Enter a valid option number.");
           break;
       }
       }
   }

   private static void findPartner() {
   // get name of user need partner    
       System.out.print("Enter user name : ");
   // get user input
       String name = scan.next();
       int matchCount = 0;
     // check if list is not empty  
       if (gymUserList.size() != 0) {
     / loop through list      
           for (Gym g : gymUserList) {
       // if a user with the given name found
                 
               if (g.getUserName().equals(name)) {
      // loop through the list and check how many parameters matches              
                   for (Gym gym : gymUserList) {
                       if(!gym.getUserName().equals(name)) {
                       if (g.getLocation().equals(gym.getLocation()))
                           matchCount++;
                       if (g.getRoutine().equals(gym.getRoutine()))
                           matchCount++;
                       if (g.getAge() / 10 - 1 > gym.getAge() && g.getAge() / 10 + 1 < gym.getAge())
                           matchCount++;
                       if (g.isAvailability() == gym.isAvailability())
                           matchCount++;
                       if (g.getGymName().equals(gym.getGymName()))
                           matchCount++;
                       if (g.isDiscipline() == gym.isDiscipline())
                           matchCount++;

                       // check if at least 4 parameter matches
                       if (matchCount >= 4) {
                           System.out.println("Match found : " + gym);
                           break;
                       }
                       }
                   }
                   break;
               }
           }
       } else {
           System.out.println("No users in the list");
       }
       if(matchCount <4) {
           System.out.println("No match found! Please wait...");
       }
   }

   private static void addUser() {
// ask user for input details
       System.out.print("Enter user name : ");
       String name = scan.next();
       System.out.print("Enter location : ");
       String location = scan.next();
       System.out.print("Enter routine : ");
       String routine = scan.next();
       System.out.print("Enter age : ");
       int age = scan.nextInt();
       System.out.print("Is available ? (true/false) : ");
       boolean availability = scan.nextBoolean();
       System.out.print("Enter gym name : ");
       String gymName = scan.next();
       System.out.print("Is disciplined ? (true/false) : ");
       boolean discipline = scan.nextBoolean();
// create a gym object and add to gymUser list
       gymUserList.add(new Gym(name, location, routine, age, availability, gymName, discipline));

   }

}
