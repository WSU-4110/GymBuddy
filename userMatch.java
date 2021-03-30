
public class Gym {

private String firstName;
   private String lastName;
   private int age;
   private String phoneNo;
   private String email;
   private String location;

   // public instance initialized when loading the class
   public static final Gym instance = new Gym();

   private Gym() {
   }

//getInstance method returns the instance static final variable which will be created at the time of loading class.

   public static Gym getInstance() {
       return instance;
   }

   
   public String getFirstName() {
       return firstName;
   }

   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   public String getLastName() {
       return lastName;
   }

   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   public int getAge() {
       return age;
   }

   public void setAge(int age) {
       this.age = age;
   }

   public String getPhoneNo() {
       return phoneNo;
   }

   public void setPhoneNo(String phoneNo) {
       this.phoneNo = phoneNo;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getLocation() {
       return location;
   }

   public void setLocation(String location) {
       this.location = location;
   }
}



public class GymTest {

   public static void main(String[] args) {
  
       ArrayList<Gym> account = new ArrayList<>(); 
       Scanner inp = new Scanner(System.in);
       while (true) {
           System.out.println("1-To Add Account");
           System.out.println("2-To Remove Account");
           System.out.println("3-To Display");
           System.out.println("4-To Exit");
           int choice = inp.nextInt();
           if (choice == 1) {
               System.out.println("Enter First Name");
               String firstName = inp.next();
               System.out.println("Enter Last Name");
               String lastName = inp.next();
               System.out.println("Enter Age");
               int age = inp.nextInt();
               System.out.println("Enter Phone No");
               String phoneNo = inp.next();
               System.out.println("Enter Email");
               String email = inp.next();
               System.out.println("Enter Location");
               String location = inp.next();
               boolean accExists = false;
               for (Gym acc : account) {

                   if (acc.getFirstName().equals(firstName) && acc.getLastName().equals(lastName)) {
                       
                       accExists = true;
                       break;

                   }
               }
               if (accExists) {
                   continue;
               } else {
                   Gym acc = Gym.getInstance();
                   acc.setFirstName(firstName);
                   acc.setLastName(lastName);
                   acc.setAge(age);
                   acc.setEmail(email);
                   acc.setLocation(location);
                   acc.setPhoneNo(phoneNo);
                   account.add(acc); // add a new account;

               }

           } else if (choice == 2) {
               System.out.println("Enter First Name ");
               String firstName = inp.next();
               System.out.println("Enter Last Name ");
               String lastName = inp.next();
               Gym accToDelete = null;
               for (Gym acc : account) {
                   if (acc.getFirstName().equals(firstName) && acc.getLastName().equals(lastName)) {
                       // if first name last name matches then remove it;
                       accToDelete = acc;
                       break;

                   }
               }
               account.remove(accToDelete);
           } else if (choice == 3) {
               for (Gym acc : account) {
                   System.out.println("First Name: " + acc.getFirstName());
                   System.out.println("Last Name: " + acc.getLastName());
               }
           } else if (choice == 4) {
               break;
           }

       }

   }

}