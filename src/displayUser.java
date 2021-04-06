public class displayUser extends user{
    //Create the object
    public static displayUser instance = new displayUser();

    //Make constructor
    private displayUser(){}

    public static displayUser getInstance(){
        return instance;
    }


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
}
