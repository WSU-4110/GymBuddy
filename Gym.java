public class Gym {

   private String userName;
   private String location;
   private String routine;
   private int age;
   private boolean availability;
   private String gymName;
   private boolean discipline;

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

   
   public String getLocation() {
       return location;
   }

   
   public String getRoutine() {
       return routine;
   }

   public int getAge() {
       return age;
   }

   public boolean isAvailability() {
       return availability;
   }

   public String getGymName() {
       return gymName;
   }

  
   public boolean isDiscipline() {
       return discipline;
   }

 
   public void setLocation(String location) {
       this.location = location;
   }

   
   public void setRoutine(String routine) {
       this.routine = routine;
   }

  
   public void setAge(int age) {
       this.age = age;
   }

   
   public void setAvailability(boolean availability) {
       this.availability = availability;
   }

  
   public void setGymName(String gymName) {
       this.gymName = gymName;
   }

   
   public void setDiscipline(boolean discipline) {
       this.discipline = discipline;
   }

  
   public String getUserName() {
       return userName;
   }

  
   public void setUserName(String userName) {
       this.userName = userName;
   }

   @Override
   public String toString() {
       return "Gym [userName=" + userName + ", location=" + location + ", routine=" + routine + ", age=" + age
               + ", availability=" + availability + ", gymName=" + gymName + ", discipline=" + discipline + "]";
   }

}


