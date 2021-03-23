import java.sql.SQLOutput;
import java.util.Scanner;

public class user {

    public String firstName = "", lastName ="";
    //public int age;
    public String phoneNumber; //most convenient data type IMO if you're wondering
    public String email = "";
    public String gender = "";
    public int birthdayYear, birthdayMonth, birthdayDay;

    //default constructor
    protected user(){
        firstName ="NA";
        lastName = "NA";
        phoneNumber = "000-000-0000";
        email = "example@gmail.com";
        gender = "Male";
        birthdayYear = 0000;
        birthdayMonth =00;
        birthdayDay= 00;
    }

    protected user(String userFirstName, String userLastName, String userPhoneNumber, String userEmail,
                   String userGender, int userBirthdayYear, int userBirthdayMonth, int userBirthdayDay){
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.phoneNumber = userPhoneNumber;
        this.email = userEmail;
        this.gender = userGender;
        this.birthdayYear = userBirthdayYear;
        this.birthdayMonth = userBirthdayMonth;
        this.birthdayDay = userBirthdayDay;

        // * * *  * * *  * * *  * * *  * * *  * * *  * * *  * * *  * * *
        // shouldn't these all have a 'this.' to refer to this obj? -kevin
        // * * *  * * *  * * *  * * *  * * *  * * *  * * *  * * *  * * *
    }


// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//              Un-used functions
// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

/*    May need later
public String location = "";
public String gym = "";
public String discipline = "";
public String availability = "";
public String objectives = "";
public String routine = "";

public void setLocation(String local){
    this.location = local;
}

public void setGym(String gym){
    this.gym = gym;
}

public void setDiscipline(String discipline){
    this.discipline = discipline;
}

public void setAvailabilty(String avalable){
    this.Availabilty = avalable;
}
public void setGoals(String goals){
    this.goals = goals;
}

public void setRoutine(String routine){
    this.routine = routine;
}

*/


// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//              End of Un-used functions
// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

/*
SET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS

 */
protected void setFirstName(String firstName){
    if(firstName != null && firstName.length() >= 2) {
        this.firstName = firstName;
    }
    else{
        return;
    }
}

protected void setLastName(String lastName){
    if (lastName != null && lastName.length() >=2){
        this.lastName = lastName;
    }
    else{
        return;
    }

}

protected void setPhoneNumber(String phoneNumber){
    if (phoneNumber.matches("\\d{9}")){
        this.phoneNumber = phoneNumber;
    }
    else if (phoneNumber.matches("\\d{3}[-\\s]\\d{3}[-\\s]\\d{4}"))
    {
        this.phoneNumber = phoneNumber;
    }
    else
    {
        return;
    }
}

protected void setEmail(String email){

    this.email = email;
}

protected void setGender(String gender){
    if (gender == "male" || gender == "female") {
        this.gender = gender;
    }
    else{
        return;
    }
}

protected void setBirthdayYear(int birthdayYear){
    if (birthdayYear >= 1920 || birthdayYear <= 2004 ) {
        this.birthdayYear = birthdayYear;
    }
    else {
        return;
    }
}

protected void setBirthdayMonth(int birthdayMonth){
    if (birthdayMonth > 0 || birthdayMonth <= 12) {
        this.birthdayMonth = birthdayMonth;
    }
    else{
        return;
    }
}

protected void setBirthdayDay(int birthdayDay){
    if (birthdayDay > 0 || birthdayDay <= 31) {
        this.birthdayDay = birthdayDay;
    }
    else {
        return;
    }
}
/*
GET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS


 */
public String getFirstName(){
    return firstName;
}

public String getLastName(){
    return lastName;
}

public String getPhoneNumber(){
    return phoneNumber;
}
public String getEmail(){
    return email;
}
public String getGender(){
    return gender;
}
public int getBirthdayYear(){
    return birthdayYear;
}
public int getBirthdayMonth(){
    return birthdayMonth;
}
public int getBirthdayDay(){
    return birthdayDay;
}
//METHOD TO DISPLAY THE USER INFORMATION WHICH WILL CALL ALL THE GETS FUNCTION

// * * * * * *  * * *  * * *  * *  Kevin's work space * * * * * *  * * *  * * *  * * *  * * *  * * *

public void infoDump(){
    System.out.println("Name :" + this.firstName + " " + this.lastName);
    System.out.println("Sex: " + this.gender);
    System.out.println("Date of Birth: " + this.birthdayDay + "/" + this.birthdayMonth + "/" + this.birthdayYear);
    System.out.println("Phone number: " + this.phoneNumber);
    System.out.println("Email :" + this.email);
}

public void updateInfo(String firstName, String lastName, String phoneNumber, String email, String gender,
                       int birthdayYear, int birthdayMonth, int birthdayDay){
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setPhoneNumber(phoneNumber);
    this.setGender(gender);
    this.setEmail(email);
    this.setBirthdayYear(birthdayYear);
    this.setBirthdayMonth(birthdayMonth);
    this.setBirthdayDay(birthdayDay);
}

public void demoUser(){ updateInfo("kevin", "clause", "810-253-5757", "go8212@wayne.edu", "male", 2000, 9, 02);
}

// * * * * * *  * * *  * * *  * * *  End of Kevin's work space * * * * * *  * * *  * * *  * * *  * * *

public void displayUser(user profile){
    profile.getFirstName();
    profile.getLastName();
    profile.getPhoneNumber();
    profile.getEmail();
    profile.getGender();
    profile.getBirthdayYear();
    profile.getBirthdayMonth();
    profile.getBirthdayDay();
}


//METHOD TO DELETE THE USER'S PROFILE (OBJECT)

    public void removeUser(user profile){
    profile = new user();
    profile = null;
    }

    //METHOD CALLED "MODIFY PROFILE" WHICH WILL CALL ALL THE SETS FUNCTIONS
//Maher
    public void modifyProfile(user User1){

        displayUser(User1);

        int choice;
        System.out.println("Type 1 to modify your phone number. Type 2 to modify your email address. Type anything else to exit.");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        scan.close();

        switch (choice){
            case 1: //for phone
                Scanner sc1= new Scanner(System.in); //System.in is a standard input stream
                System.out.print("Enter the new phone number: ");
                String str1= sc1.nextLine();              //reads string
                User1.setPhoneNumber(str1);
                break;

            case 2: //for email
                Scanner sc2= new Scanner(System.in); //System.in is a standard input stream
                System.out.print("Enter the new email address: ");
                String str2= sc2.nextLine();              //reads string
                User1.setEmail(str2);
                break;

            default: //default case
                System.out.println("Exited modify profile.");
        }
    }


}

