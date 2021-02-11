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
protected void setFirstName(String firstName){
    this.firstName = firstName;
}

protected void setLastName(String lastName){
    this.lastName = lastName;
}

protected void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
}

protected void setEmail(String email){
    this.email = email;
}

protected void setGender(String gender){
    this.gender = gender;
}

protected void setBirthdayYear(int birthdayYear){
    this.birthdayYear = birthdayYear;
}

protected void setBirthdayMonth(int birthdayMonth){
    this.birthdayMonth = birthdayMonth;
}

protected void setBirthdayDay(int birthdayDay){
    this.birthdayDay = birthdayDay;
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

    public void modifyProfile(user profile, String firstName, String lastName, String phoneNumber, String email, String gender,
                              int birthdayYear, int birthdayMonth, int birthdayDay){
    profile.setFirstName(firstName);
    profile.setLastName(lastName);
    profile.setPhoneNumber(phoneNumber);
    profile.setGender(gender);
    profile.setEmail(email);
    profile.setBirthdayYear(birthdayYear);
    profile.setBirthdayMonth(birthdayMonth);
    profile.setBirthdayDay(birthdayDay);

    }
    //this currently sets all of the users info whenever they want to change any detail about their profile. we may want to make it more modular later so
    //we use less processing power on changing data

}

