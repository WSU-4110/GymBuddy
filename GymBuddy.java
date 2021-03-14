import java.util.ArrayList;
import java.util.Scanner;

public class GymBuddy {

        public static void main(String[] args) {
                
                Scanner sc = new Scanner(System.in);
                
                ArrayList<User> members = new ArrayList<>();
                
                while(true) {
                        
                        System.out.println("Welcome to Gym Buddy Application");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Select one option : \n");
                        System.out.println("1. Add new user\n2. Find gym partner\n3. Exit");
                        int option = sc.nextInt();
                        
                        if(option == 1) {
                                System.out.print("Enter user name : ");
                                String uname = sc.next();
                                System.out.print("Enter location : ");
                                String location = sc.next();
                                System.out.print("Enter routine : ");
                                String routine = sc.next();
                                System.out.print("Enter age : ");
                                int age = sc.nextInt();
                                System.out.print("Is available ? (true/false) : ");
                                boolean available = sc.nextBoolean();
                                System.out.print("Enter gym name : ");
                                String gymName = sc.next();
                                System.out.print("Is disciplined ? (true/false) : ");
                                boolean discipline = sc.nextBoolean();
                                members.add(new User(uname, location, routine, age, available, gymName, discipline));
                        } else if(option == 2) {
                                System.out.print("Enter user name : ");
                                String uname = sc.next();
                                for(User user : members) {
                                        if(user.userName.equals(uname)) {
                                                System.out.println("Match found : " + user);
                                        } else {
                                                System.out.println("Match not found");
                                        }
                                }
                        } else if(option == 3) {
                                break;
                        }
                        System.out.println();
                }               
                
                
                
                sc.close();
                
        }

}

class User  {
        public String userName; 
        public String location;
        public String routine;
        public int age;
        public boolean availability;
        public String gymName;
        public boolean discipline;
        public User(String userName, String location, String routine, int age, boolean availability, String gymName,
                        boolean discipline) {
                super();
                this.userName = userName;
                this.location = location;
                this.routine = routine;
                this.age = age;
                this.availability = availability;
                this.gymName = gymName;
                this.discipline = discipline;
        }
        @Override
        public String toString() {
                return "Gym [userName=" + userName + ", location=" + location + ", routine=" + routine + ", age=" + age
                                + ", availability=" + availability + ", gymName=" + gymName + ", discipline=" + discipline + "]";
        }
}