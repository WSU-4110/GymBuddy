package gymtest;

import java.util.ArrayList;
import java.util.Scanner;


public class GymTest {

  
    public static void main(String[] args) {
        // TODO code application logic here
       ArrayList<Gym> account = new ArrayList<>(); // creating array list to store GYM Accounts;
       Scanner inp = new Scanner(System.in);
        while(true)
        {
            System.out.println("1-To Add Account");
            System.out.println("2-To Remove Account");
            System.out.println("3-To Display");
            System.out.println("4-To Exit");
            int choice = inp.nextInt();
            if(choice==1)
            {
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
                for(Gym acc:account)
                {
                    if(acc.getFirstName().equals(firstName) && acc.getLastName().equals(lastName))
                    {
                        // if account with first name and last name exists then do not insert
                        accExists = true;
                        break;
                        
                    }
                }
                if(accExists)
                {
                    continue;
                }
                else
                {
                    Gym acc = new Gym(firstName,lastName,age,phoneNo,email,location);
                    account.add(acc); // add a new account;
                    
                }
                
            }
            else if(choice==2)
            {
                System.out.println("Enter First Name ");
                String firstName = inp.next();
                System.out.println("Enter Last Name ");
                String lastName = inp.next();
                Gym accToDelete=null;
                for(Gym acc:account)
                {
                    if(acc.getFirstName().equals(firstName) && acc.getLastName().equals(lastName))
                    {
                         //if first name last name matches then  remove it;
                        accToDelete = acc;
                        break;
                        
                    }
                }
                account.remove(accToDelete);
            }
            else if(choice==3)
            {
               for(Gym acc:account)
               {
                   System.out.println("First Name: "+acc.getFirstName());
                   System.out.println("Last Name: "+acc.getLastName());
               }
            }
            else if(choice==4)
            {
                break;
            }
            
        }
        
        
    }
    
}
