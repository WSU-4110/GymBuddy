public class runner implements user {

    String doesCompete;
    String inOrOut;
    String distanceOrSprint;
    float distance;


    public String firstName ="NA", lastName = "NA";
    public String  phoneNumber = "000-000-0000"; //most convenient data type IMO if you're wondering
    public String email = "example@gmail.com";
    public String gender = "Male";
    public int birthdayYear = 0000, birthdayMonth =00, birthdayDay= 00;

    public String getDoesCompete() {
        return doesCompete;
    }

    public float getDistance() {
        return distance;
    }

    public String getDistanceOrSprint() {
        return distanceOrSprint;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setDoesCompete(String doesCompete) {
        this.doesCompete = doesCompete;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setDistanceOrSprint(String distanceOrSprint) {
        this.distanceOrSprint = distanceOrSprint;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthdayYear(){
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public int getBirthdayMonth(){
        return birthdayMonth;
    }

    public void setBirthdayMonth(int birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public int getBirthdayDay(){
        return birthdayDay;
    }

    public void setBirthdayDay(int birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public void userInfo(String userFirstName, String userLastName, String userPhoneNumber, String userEmail,
                   String userGender, int userBirthdayYear, int userBirthdayMonth, int userBirthdayDay){
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.phoneNumber = userPhoneNumber;
        this.email = userEmail;
        this.gender = userGender;
        this.birthdayYear = userBirthdayYear;
        this.birthdayMonth = userBirthdayMonth;
        this.birthdayDay = userBirthdayDay;
    }

    public void workoutRoutine(){
        System.out.println("I am ready to compete? " + doesCompete);
        System.out.println("Do I prefer to run indoors or outdoors? " + inOrOut);
        System.out.println("Do I run distance or sprints" + distanceOrSprint);
        System.out.println("How far do I run " + distance);
    }

    runner(){
        inOrOut = "";
        doesCompete = "";
        distance = 0;
        distanceOrSprint = "";
    }

    runner(String inOrOut, String doesCompete, String distanceOrSprint, float distance){
        this.doesCompete = doesCompete;
        this.inOrOut = inOrOut;
        this.distanceOrSprint = distanceOrSprint;
        this.distance = distance;

    }
}
