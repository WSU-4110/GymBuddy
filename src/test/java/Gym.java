

import java.util.Scanner;


import org.junit.Test;

import static org.junit.Assert.*;

public class Gym {

// instance variables

   private String userName;
   private String location;
   private String routine;
   private int age;
   private boolean availability;
   private String gymName;
   private boolean discipline;
//class constructor 
 public Gym(String userName, String location, String routine, int age, boolean availability, String gymName,
           boolean discipline) {
       this.location = location;
       this.routine = routine;
       this.age = age;
       this.availability = availability;
       this.gymName = gymName;
       this.discipline = discipline;
       this.userName = userName;
   }

  //return location of gym
   
   public String getLocation() {
       return location;
   }

  //return routine  
   public String getRoutine() {
       return routine;
   }

   public int getAge() {
       return age;
   }
 // return availability 
 
   public boolean isAvailability() {
       return availability;
   }
 // return gym name
 
   public String getGymName() {
       return gymName;
   }

 //return discipline
   
   public boolean isDiscipline() {
       return discipline;
   }

 //param location
 
   public void setLocation(String location) {
       this.location = location;
   }

 //param routine
 
   public void setRoutine(String routine) {
       this.routine = routine;
   }

// param age
  
   public void setAge(int age) {
       this.age = age;
   }

 // param availability
   
   public void setAvailability(boolean availability) {
       this.availability = availability;
   }
 // param gymName
  
   public void setGymName(String gymName) {
       this.gymName = gymName;
   }

   // param discipline 
   
   public void setDiscipline(boolean discipline) {
       this.discipline = discipline;
   }

  // return user name
   public String getUserName() {
       return userName;
   }

  // param userName
  
   public void setUserName(String userName) {
       this.userName = userName;
   }

   @Override
   public String toString() {
       return "Gym [userName=" + userName + ", location=" + location + ", routine=" + routine + ", age=" + age
               + ", availability=" + availability + ", gymName=" + gymName + ", discipline=" + discipline + "]";
   }

/*
MAHER

Allows the user to swipe right or left on another user's profile
 */

   public void Swiping(Gym user){
            System.out.print("Do you want to be friends with " + user.userName + "?: ");
            Scanner sc = new Scanner(System.in);
            boolean choice = sc.nextBoolean();
            if (choice == true) {
                System.out.println("You swiped right on: " + user.userName + ".");
            } else if (choice == false) {
                System.out.println("You swiped left on: " + user.userName + ".");
            }
            sc.close(); //close sanner object

        }

    public class testSwiping {
        @Test
        public void test_Swiping_Method(){
Gym user1 = new Gym("maher","dearborn","Push/Pull/Legs",21,
        true,"Crunch", true);
Swiping(user1);
assertEquals("dearborn", user1.location,"You are in the same location");
        }
    }
}




