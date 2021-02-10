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
        firstName = userFirstName;
        lastName = userLastName;
        phoneNumber = userPhoneNumber;
        email = userEmail;
        gender = userGender;
        birthdayYear = userBirthdayYear;
        birthdayMonth = userBirthdayMonth;
        birthdayDay = userBirthdayDay;
    }


/*    May need later
public String location = "";
public String gym = "";
public String discipline = "";
public String availability = "";
public String objectives = "";
public String routine = "";
 */

/*
SET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS

 */



/*
GET FUNCTIONS FOR ALL THE NOT COMMENTED FIELDS


 */


//METHOD TO DISPLAY THE USER INFORMATION WHICH WILL CALL ALL THE GETS FUNCTION




//METHOD TO DELETE THE USER'S PROFILE (OBJECT)



    //METHOD CALLED "MODIFY PROFILE" WHICH WILL CALL ALL THE SETS FUNCTIONS



    
}

