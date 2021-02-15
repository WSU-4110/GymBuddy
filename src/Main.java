import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("enter your choice");
        int choice = input.nextInt();

        switch(choice){
            case 1:
                System.out.println("user registration");
            case 2:
                System.out.println("Demo User");
                System.out.println("");
                testUser test = new testUser();
                test.user1.infoDump();
                // i don't like this method because it relies on knowing that in test there is a
                // container named 'user1' and you need prior knowledge of that by reading code
                // basically object in side an object


                // this is a different implementation that
                // accomplishes the same goal
                System.out.println("");

                user testSubject = new user();
                testSubject.demoUser();
                testSubject.infoDump();
        }
    }

    public void registration(){

    }
}
