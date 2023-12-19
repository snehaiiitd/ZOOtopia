import java.util.*;
public class ap_assignment_2 {
    private static int ticount;
    private static HashMap<String,Integer> popatt = new HashMap<>();
    private static int revenue;
    public static void main(String[] args) { //hardcoded some items initially
        System.out.println("Welcome to Zootopia");
        Attractions.getAttuid().add("101");
        Attractions.getAtt().put("Jungle Safari", "Go on an adventure in the wild.");
        Attractions.getAttuid().add("102");
        Attractions.getAtt().put("Botanical Garden", "Go on a plantation adventure.");
        Attractions.getAttuid().add("103");
        Attractions.getAtt().put("Dinosaur Show", "Go have fun with the dinosaurs.");
        Discounts.getDiscount().put("MINOR10",10);
        Discounts.getDiscount().put("SENIOR20",20);
        Events.getEvent().put("Jungle Safari", 10);
        Events.getEvent().put("Botanical Garden", 15);
        Events.getEvent().put("Dinosaur Show", 12);
        Events.getEventclo().put("Jungle Safari", "open");
        Events.getEventclo().put("Botanical Garden", "open");
        Events.getEventclo().put("Dinosaur Show", "open");
        Animals.getAnimal().put("Elephant", "Mammal");
        Animals.getAnimal().put("Cat", "Mammal");
        Animals.getAnimal().put("Snake", "Reptile");
        Animals.getAnimal().put("Crocodile", "Reptile");
        Animals.getAnimal().put("Frog", "Amphibian");
        Animals.getAnimal().put("Salamander", "Amphibian");
        Animals.getAnimaldes().put("Elephant", "They are large, intelligent herbivorous mammals");
        Animals.getAnimaldes().put("Cat", "They are small little creatures known for their agility");
        Animals.getAnimaldes().put("Snake", "They are legless reptiles that use venom to subdue prey");
        Animals.getAnimaldes().put("Crocodile", "They are large, aquatic reptiles with powerful jaws");
        Animals.getAnimaldes().put("Frog", "They are small, jumping amphibians with smooth, moist skin.");
        Animals.getAnimaldes().put("Salamander", "They are small, amphibious creatures with long tails");
        Animals.getAnimalsound().put("Elephant", "Trumpet");
        Animals.getAnimalsound().put("Cat", "Meow");
        Animals.getAnimalsound().put("Snake", "Hiss");
        Animals.getAnimalsound().put("Crocodile", "Bellow");
        Animals.getAnimalsound().put("Frog", "Croak");
        Animals.getAnimalsound().put("Salamander", "Squeak");
        Deals.getDeal().put(2,15);
        Deals.getDeal().put(3,30);

        Start s = new Start();
    }
    public static int getTicount() {
        return ticount;
    }

    public static void setTicount(int ticount) {
        ap_assignment_2.ticount = ticount;
    }

    public static HashMap<String, Integer> getPopatt() {
        return popatt;
    }

    public static void setPopatt(HashMap<String, Integer> popatt) {
        ap_assignment_2.popatt = popatt;
    }

    public static int getRevenue() {
        return revenue;
    }

    public static void setRevenue(int revenue) {
        ap_assignment_2.revenue = revenue;
    }
}

class Start{
    private String email;
    private String password;
    public Start(){ // will show the option to enter as visitor or admin
        System.out.println("1. Enter as admin");
        System.out.println("2. Enter as a visitor");
        String email = "admin1";
        String password = "admin123"; // admin email is "admin1" and password is "admin123"
        System.out.println("Enter your choice (1 or 2)");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1){
            AdminLogin al = new AdminLogin(email, password);
        }else if (choice == 2){
            VisitorLogin vl = new VisitorLogin();
        }
        else{
            System.out.println("Invalid choice. Try again.");
        }
    }
    public String getPassword() {
        return password;
    }
    public void setPassword() {
        this.password = "admin123";
    }
    public String getEmail() {
        return email;
    }
    public void setEmail() {
        this.email = "admin1";
    }
}
class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
class AdminLogin extends User{ // used inheritance while the admin logins in the system
    private static HashMap <String, String> adminl = new HashMap<>();
    Scanner sal = new Scanner(System.in);
    public AdminLogin(String email, String password) {
        super(email, password);
        adminl.put(email, password);
        System.out.println("Enter Admin Email: ");
        String amail = sal.nextLine();
        System.out.println("Enter Admin Password: ");
        String apass = sal.nextLine();
        if (adminl.containsKey(amail)) {
            if (Objects.equals(adminl.get(amail), apass)) {
                Admin ad = new Admin();
            } else {
                System.out.println("Login Unsuccessful. Try Again.");
                AdminLogin al = new AdminLogin(email, password);
            }

        } else {
            System.out.println("Login Unsuccessful. Try Again.");
            AdminLogin al = new AdminLogin(email, password);
        }
    }
    public static HashMap<String, String> getAdminl() {
        return adminl;
    }

    public static void setAdminl(HashMap<String, String> adminl) {
        AdminLogin.adminl = adminl;
    }
}
class Admin{
    Scanner sa = new Scanner(System.in); //admin will get to choose from a variety of options
    public Admin() {
        System.out.println("Enter a choice: ");
        System.out.println("""
                        1. Manage Attractions
                        2. Manage Animals
                        3. Schedule Events
                        4. Set Discounts
                        5. Set Special Deal
                        6. View Visitor Stats
                        7. View Feedback
                        8. Exit
                        """);
        int ch = sa.nextInt();
        sa.nextLine();
        if (ch == 1){
            Attractions a = new Attractions();
        }
        else if (ch == 2){
            Animals a = new Animals();
        }
        else if (ch == 3){
            Events e = new Events();
        }
        else if(ch == 4){
            Discounts d = new Discounts();
        }
        else if(ch == 5){
            Deals d = new Deals();
        }
        else if(ch == 6){
            Statistics s = new Statistics();
        }
        else if(ch == 7){
            ViewFeedback f = new ViewFeedback();
        }
        else if(ch == 8){
            Start s = new Start();
        }else{
            System.out.println("Invalid Choice.Try Again");
        }
    }
}

class Interaction{
    private String vemail;
    private String vpass;
    Scanner i = new Scanner(System.in);
    public Interaction() {
        System.out.println("Enter Visitor Email: "); //parent class for registration and login of visitor
        String vemail = i.nextLine();
        System.out.println("Enter Visitor Password: ");
        String vpass = i.nextLine();
        this.vemail = vemail;
        this.vpass = vpass;
    }
    public String getVemail() {
        return vemail;
    }

    public void setVemail() {
        System.out.println("Enter Visitor Email: ");
        String vemail = i.nextLine();
        this.vemail = vemail;
    }

    public String getVpass() {
        return vpass;
    }

    public void setVpass() {
        System.out.println("Enter Visitor Password: ");
        String vpass = i.nextLine();
        this.vpass = vpass;
    }
}
class Register extends Interaction{
    private String vname;
    private int vage;
    private String vphonenumber;
    private int vbal;
    Scanner r = new Scanner(System.in);
    public Register(){
        super();
        System.out.println("Enter Visitor Name: ");  //visitor registers in this class
        String vname = r.nextLine();
        System.out.println("Enter Visitor Age: ");
        int vage = r.nextInt();
        r.nextLine();
        System.out.println("Enter Visitor Phone number: ");
        String vphone = r.nextLine();
        System.out.println("Enter Visitor Balance: ");
        int vbal = r.nextInt();
        r.nextLine();
        this.vname = vname;
        this.vage = vage;
        this.vphonenumber = vphone;
        this.vbal = vbal;
        VisitorLogin.getVisitorl().put(getVemail(),getVpass());
        VisitorLogin.getVisitorlbal().put(getVemail(),vbal);
        VisitorLogin.getVisitorlage().put(getVemail(),vage);
        VisitorLogin.setUser(getVemail());
        Visitor v = new Visitor(VisitorLogin.getUser());
    }
    public String getVname() {
        return vname;
    }

    public void setVname() {
        System.out.println("Enter Visitor Name: ");
        String vname = r.nextLine();
        this.vname = vname;
    }

    public int getVage() {
        return vage;
    }

    public void setVage() {
        System.out.println("Enter Visitor Age: ");
        int vage = r.nextInt();
        r.nextLine();
        this.vage = vage;
    }

    public String getVphonenumber() {
        return vphonenumber;
    }

    public void setVphonenumber() {
        System.out.println("Enter Visitor Phone number: ");
        String vphone = r.nextLine();
        this.vphonenumber = vphone;
    }

    public int getVbal() {
        return vbal;
    }

    public void setVbal() {
        System.out.println("Enter Visitor Balance: ");
        int vbal = r.nextInt();
        r.nextLine();
        this.vbal = vbal;
    }
}

class Login extends Interaction{  //visitor login in this class, inheritance is used
    Scanner l = new Scanner(System.in);
    public Login(){
        if (VisitorLogin.getVisitorl().containsKey(getVemail())){
            if (Objects.equals(VisitorLogin.getVisitorl().get(getVemail()), getVpass())){
                System.out.println("Login Successful");
                VisitorLogin.setUser(getVemail());
                Visitor v = new Visitor(VisitorLogin.getUser());
            }
            else{
                System.out.println("Login Unsuccessful. Try Again");
                VisitorLogin vl = new VisitorLogin();
            }
        } else {
            System.out.println("Login Unsuccessful. Try Again");
            VisitorLogin vl = new VisitorLogin();
        }
    }
}
class VisitorLogin{
    private static HashMap <String, String> visitorl = new HashMap<>();
    private static HashMap <String, Integer> visitorlbal = new HashMap<>();
    private static HashMap <String, Integer> visitorlage = new HashMap<>();
    Scanner svl = new Scanner(System.in);
    private static String user = "";

    public VisitorLogin(){
        System.out.println("Enter a choice: ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = svl.nextInt();
        svl.nextLine();
        if (choice == 1){
            Register r = new Register();
        }
        else if(choice == 2){
            Login l = new Login();
        }
    }
    public static HashMap<String, String> getVisitorl() {
        return visitorl;
    }

    public static void setVisitorl(HashMap<String, String> visitorl) {
        VisitorLogin.visitorl = visitorl;
    }

    public static HashMap<String, Integer> getVisitorlbal() {
        return visitorlbal;
    }

    public static void setVisitorlbal(HashMap<String, Integer> visitorlbal) {
        VisitorLogin.visitorlbal = visitorlbal;
    }
    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        VisitorLogin.user = user;
    }
    public static HashMap<String, Integer> getVisitorlage() {
        return visitorlage;
    }

    public static void setVisitorlage(HashMap<String, Integer> visitorlage) {
        VisitorLogin.visitorlage = visitorlage;
    }
}
class Visitor{
    Scanner sv = new Scanner(System.in); //visitor is given an option to choose from the menu
    public Visitor(String user){
        System.out.println("""
                Visitor Menu:
                1. Explore the Zoo
                2. Buy Membership
                3. Buy Tickets
                4. View Discounts
                5. View Special Deals
                6. Visit Animals
                7. Visit Attractions
                8. Leave Feedback
                9. Log Out
                """);
        int c = sv.nextInt();
        sv.nextLine();
        if (c == 1){
            Zoo z = new Zoo();
        }else if (c==2){
            Membership m = new Membership(user);
        }else if (c==3){
            Tickets t = new Tickets(user);
        }else if (c==4){
            ViewDiscounts vd = new ViewDiscounts();
        }else if (c==5){
            ViewDeals d = new ViewDeals();
        }else if (c==6){
            VisitAnimal a = new VisitAnimal();
        }else if (c==7){
            VisitAtt a = new VisitAtt(user);
        }else if (c==8){
            LeaveFeedback l = new LeaveFeedback();
        }else if(c==9){
            Start s = new Start();
        }else{
            System.out.println("Invalid Choice.Try Again");
        }
    }
}
interface Activities{  //interfaces are used
    void viewActivities();
    void addActivities();
    void modifyActivities();
    void removeActivities();
}

class Attractions implements Activities{
    private static HashMap<String,String> att = new HashMap<>();
    private static ArrayList<String> attuid = new ArrayList<>();
    Scanner sb = new Scanner(System.in);
    public Attractions(){
        System.out.println("Enter a choice: ");
        System.out.println("""
                1. Add Attraction
                2. View Attractions
                3. Modify Attraction
                4. Remove Attraction
                5. Exit
                """);
        int ch = sb.nextInt();
        sb.nextLine();
        if (ch == 1){
            addActivities();
        }
        else if (ch == 2){
            viewActivities();
        }
        else if (ch == 3){
            modifyActivities();
        }
        else if(ch == 4){
            removeActivities();
        }
        else if (ch == 5){
            Admin a = new Admin();
        }
        else{
            System.out.println("Invalid Choice. Try Again");
        }
    }
    public static HashMap<String, String> getAtt() {
        return att;
    }

    public static void setAtt(HashMap<String, String> att) {
        Attractions.att = att;
    }
    public static ArrayList<String> getAttuid() {
        return attuid;
    }

    public static void setAttuid(ArrayList<String> attuid) {
        Attractions.attuid = attuid;
    }
    @Override
    public void addActivities(){
        System.out.println("Enter Attraction UID: ");  //attraction is added, first the uniqueness of attraction uid is checked
        String aid = sb.nextLine();
        if (attuid.contains(aid)) {
            System.out.println("This UID already exists. Please enter a unique UID");
            addActivities();
        }
        System.out.println("Enter Attraction Name: ");
        String aname = sb.nextLine();
        System.out.println("Enter Attraction Description: ");
        String ades = sb.nextLine();
        att.put(aname,ades);
        System.out.println("Attraction added successfully");
        Attractions at = new Attractions();
    }
    @Override
    public void viewActivities(){          //used to view the attractions
        System.out.println("The attractions available are: ");
        for (Map.Entry<String, String> entry : att.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        Attractions at = new Attractions();
    }
    @Override
    public void modifyActivities(){       //used to modify the existing attractions
        System.out.println("Modify Attraction Name: ");
        String aname = sb.nextLine();
        System.out.println("Modify Attraction Description: ");
        String ades = sb.nextLine();
        if (att.containsKey(aname)){
            att.put(aname,ades);
            System.out.println("Attraction is modified successfully.");
        }else {
            System.out.println("The attraction does not exist. You can add a new one.");
        }
        Attractions at = new Attractions();
    }
    @Override
    public void removeActivities(){     //used to remove the attraction
        System.out.println("Remove the attraction: ");
        String aname = sb.nextLine();
        if (att.containsKey(aname)){
            att.remove(aname);
            System.out.println("Attraction is removed successfully.");
        }else {
            System.out.println("The attraction already does not exist.");
        }
        Attractions at = new Attractions();
    }
}
abstract class Creatures {   //abstraction is used for classes animals and discounts
    Scanner c = new Scanner(System.in);
    public Creatures() {
        welcome();
    }

    public void welcome(){
        System.out.println("Welcome to the admins section:");
    }
    public abstract void addCreatures();

    public abstract void modifyCreatures();

    public abstract void removeCreatures();

    public abstract void viewCreatures();
}
class Discounts extends Creatures{
    private static HashMap<String,Integer> discount = new HashMap<>();
    Scanner sb = new Scanner(System.in);
    public Discounts(){
        System.out.println("Enter a choice: ");
        System.out.println("""
                1. Add Discount
                2. Modify Discount
                3. Remove Discount
                4. View Discounts
                5. Exit
                """);
        int ch = sb.nextInt();
        sb.nextLine();
        if (ch == 1){
            addCreatures();
        }
        else if (ch == 2){
            modifyCreatures();
        }
        else if (ch == 3){
            removeCreatures();
        }
        else if (ch == 5){
            Admin a = new Admin();
        }
        else if (ch == 4){
            viewCreatures();
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    public static HashMap<String, Integer> getDiscount() {
        return discount;
    }

    public static void setDiscount(HashMap<String, Integer> discount) {
        Discounts.discount = discount;
    }
    @Override
    public void welcome(){
        System.out.println("Set discounts");
    }
    @Override
    public void addCreatures(){
        System.out.println("Enter Discount Category: ");  //new discount is added
        String dname = sb.nextLine();
        System.out.println("Enter Discount Percentage: ");
        int dtype = sb.nextInt();
        sb.nextLine();
        discount.put(dname,dtype);
        System.out.println("Discount is added successfully");
        Discounts d = new Discounts();
    }
    @Override
    public void modifyCreatures(){
        System.out.println("Modify discount category: "); //existing discount is modified
        String dname = sb.nextLine();
        System.out.println("Modify discount percentage: ");
        int dtype = sb.nextInt();
        sb.nextLine();
        if (discount.containsKey(dname)){
            discount.put(dname,dtype);
            System.out.println("Discount is modified successfully.");
        }else {
            System.out.println("The discount does not exist. You can add a new one.");
        }
        Discounts d = new Discounts();
    }
    @Override
    public void removeCreatures(){
        System.out.println("Remove the discount: "); //discount is removed
        String dname = sb.nextLine();
        if (discount.containsKey(dname)){
            discount.remove(dname);
            System.out.println("Discount is removed successfully.");
        }else {
            System.out.println("The discount already does not exist.");
        }
        Discounts d = new Discounts();
    }
    @Override
    public void viewCreatures(){   //all discounts can be viewed here
        System.out.println("The discounts available are: ");
        for (Map.Entry<String, Integer> entry : discount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        Discounts d = new Discounts();
    }
}

class Animals extends Creatures{
    private static HashMap<String,String> animal = new HashMap<>();
    private static HashMap<String,String> animaldes = new HashMap<>();
    private static HashMap<String,String> animalsound = new HashMap<>();
    Scanner sb = new Scanner(System.in);
    public Animals(){
        String m = "Mammal";
        String r = "Reptile";
        String a = "Amphibian";

        int countMammal = 0;     //the code proceeds only when atleast two mammals, two reptiles and two amphibians are there
        int countReptile = 0;
        int countAmphibian = 0;

        for (String value : animal.values()) {
            if (Objects.equals(value, m)) {
                countMammal++;
            } else if (Objects.equals(value, r)) {
                countReptile++;
            }else if(Objects.equals(value, a)){
                countAmphibian++;
            }
        }

        if (countMammal >= 2 && countAmphibian >= 2 && countReptile >= 2) {
            System.out.println("Enter a choice: ");
            System.out.println("""
                1. Add Animal
                2. Update Animal Details
                3. Remove Animal
                4. View Animal details
                5. Exit
                """);
            int ch = sb.nextInt();
            sb.nextLine();
            if (ch == 1){
                addCreatures();
            }
            else if (ch == 2){
                modifyCreatures();
            }
            else if (ch == 3){
                removeCreatures();
            }
            else if (ch == 5){
                Admin ad =new Admin();
            }
            else if(ch == 4){
                viewCreatures();
            }
            else{
                System.out.println("Invalid choice");
            }
        } else {
            System.out.println("There should be atleast two mammals, two amphibians, and two reptiles to proceed.");
            System.out.println("Add more animals.");
            addCreatures();
        }
    }
    public static HashMap<String, String> getAnimal() {
        return animal;
    }

    public static void setAnimal(HashMap<String, String> animal) {
        Animals.animal = animal;
    }

    public static HashMap<String, String> getAnimaldes() {
        return animaldes;
    }

    public static void setAnimaldes(HashMap<String, String> animaldes) {
        Animals.animaldes = animaldes;
    }

    public static HashMap<String, String> getAnimalsound() {
        return animalsound;
    }

    public static void setAnimalsound(HashMap<String, String> animalsound) {
        Animals.animalsound = animalsound;
    }

    @Override
    public void welcome(){
        System.out.println("Set animals: ");
    }
    @Override
    public void addCreatures(){          //animal is added, type can be from the three given types only
        System.out.println("Enter Animal Name: ");
        String aniname = sb.nextLine();
        System.out.println("Enter Animal Type: ");
        String anitype = sb.nextLine();
        if (Objects.equals(anitype, "Mammal") || Objects.equals(anitype, "Reptile") || Objects.equals(anitype, "Amphibian")){
            animal.put(aniname,anitype);
        }
        else{
            System.out.println("Invalid type of animal");
            addCreatures();
        }
        System.out.println("Enter Animal Description: ");
        String anides = sb.nextLine();
        System.out.println("Enter Animal Sound: ");
        String anisound = sb.nextLine();
        animaldes.put(aniname,anides);
        animalsound.put(aniname,anisound);
        System.out.println("Animal is added successfully");
        Animals an = new Animals();
    }
    @Override
    public void modifyCreatures(){     //animals can be modified
        System.out.println("Modify Animal Name: ");
        String aniname = sb.nextLine();
        System.out.println("Modify Animal Type: ");
        String anitype = sb.nextLine();
        System.out.println("Modify Animal Description: ");
        String anides = sb.nextLine();
        System.out.println("Modify Animal Sound: ");
        String anisound = sb.nextLine();
        if (animal.containsKey(aniname)){
            animal.put(aniname,anitype);
            animaldes.put(aniname,anides);
            animalsound.put(aniname,anisound);
            System.out.println("Animal is modified successfully.");
        }else {
            System.out.println("The animal does not exist. You can add a new one.");
        }
        Animals an = new Animals();

    }
    @Override
    public void removeCreatures() {     //animals can be removed
        System.out.println("Remove the animal: ");
        String aniname = sb.nextLine();
        if (animal.containsKey(aniname)){
            animal.remove(aniname);
            animaldes.remove(aniname);
            animalsound.remove(aniname);
            System.out.println("Animal is removed successfully.");
        }else {
            System.out.println("The animal already does not exist.");
        }
        Animals an = new Animals();
    }
    @Override
    public void viewCreatures(){      //all the animals can be viewed
        System.out.println("The animals available are: ");
        for (Map.Entry<String, String> entry : animal.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        Animals an = new Animals();
    }
}

class Statistics{  //statistics are shown
    public Statistics(){
        System.out.println("- Total Visitors: " + ap_assignment_2.getTicount());
        System.out.println("- Total Revenue: Rs " + ap_assignment_2.getRevenue());
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : ap_assignment_2.getPopatt().entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }

        if (maxKey != null) {
            System.out.println("Most Popular Attraction: " + maxKey);
        } else {
            System.out.println("There is no popular attraction.");
        }
        Admin am = new Admin();
    }
}

class Events{
    private static HashMap <String, Integer> event = new HashMap<>();
    private static HashMap <String, String> eventclo = new HashMap<>();
    static Scanner e = new Scanner(System.in);
    public Events(){
        System.out.println("""
                1. Decide if the event is closed or open
                2. Update the prices of attractions
                3. View the count of ticketed visitors
                4. View the prices of events
                5. View the availability of events
                6. Exit
                """);
        int ev = e.nextInt();
        e.nextLine();
        if (ev == 1){
            eventclosed();
        }
        else if (ev == 2){
            addPrice();
        }
        else if(ev == 3){
            System.out.println("The number of ticketed visitors are: "+ ap_assignment_2.getTicount());
            Events eve = new Events();
        }
        else if(ev == 6){
            Admin a = new Admin();
        }
        else if(ev == 4){
            vieweventprice();

        }else if(ev == 5){
            vieweventavail();
        }
        else{
            System.out.println("Invalid Input. Try Again");
        }
    }
    public static HashMap<String, Integer> getEvent() {
        return event;
    }

    public static void setEvent(HashMap<String, Integer> event) {
        Events.event = event;
    }

    public static HashMap<String, String> getEventclo() {
        return eventclo;
    }

    public static void setEventclo(HashMap<String, String> eventclo) {
        Events.eventclo = eventclo;
    }

    public void addPrice(){         //decides the price of an event
        System.out.println("Enter the name of the attraction: ");
        String ename = e.nextLine();
        System.out.println("Enter the price of the attraction: ");
        int price = e.nextInt();
        e.nextLine();
        event.put(ename,price);
        System.out.println("Attraction price is added successfully");
        Events ev = new Events();
    }
    public void eventclosed(){ //decides if the event is closed or open. If an event is set to closed, visitor cannot buy its ticket
        System.out.println("Enter the name of the attraction: ");
        String ename = e.nextLine();
        System.out.println("Enter if the attraction is closed or open: ");
        String availability = e.nextLine();
        if (Objects.equals(eventclo.get(ename), "closed") && Objects.equals(availability, "open")){
            Attractions.getAtt().put(ename,"Attraction");
        }
        if (Objects.equals(eventclo.get(ename), "open") && Objects.equals(availability, "closed")){
            Attractions.getAtt().remove(ename);
        }
        eventclo.put(ename,availability);
        System.out.println("Attraction availability is added successfully");
        Events ev = new Events();
    }

    public void vieweventprice() {
        System.out.println("The event price available are: ");
        for (Map.Entry<String, Integer> entry : event.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        Events ev = new Events();
    }

    public void vieweventavail(){
        System.out.println("The event availability available are: ");
        for (Map.Entry<String, String> entry : eventclo.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        Events ev = new Events();
    }
}

class Deals{
    private static HashMap <Integer, Integer> deal = new HashMap<>();
    Scanner d = new Scanner(System.in);
    public Deals(){
        System.out.println("Enter a choice: ");
        System.out.println("""
                1. Add Deal
                2. Modify Deal
                3. Remove Deal
                4. Exit
                """);
        int ch = d.nextInt();
        d.nextLine();
        if (ch == 1){
            adddeals();
        }
        else if (ch == 2){
            modifydeals();
        }
        else if (ch == 3){
            removedeal();
        }
        else if (ch == 4){
            Admin a = new Admin();
        }
        else{
            System.out.println("Invalid Choice. Try Again");
        }
    }
    public static HashMap<Integer, Integer> getDeal() {
        return deal;
    }

    public static void setDeal(HashMap<Integer, Integer> deal) {
        Deals.deal = deal;
    }

    public void adddeals(){   //we can add special deals here
        System.out.println("Set Special Deal:");
        System.out.println("The number of ticket purchases after which the discount should avail:");
        int dt = d.nextInt();
        d.nextLine();
        System.out.println("The percentage of discount given: ");
        int dp = d.nextInt();
        d.nextLine();
        deal.put(dt,dp);
        System.out.println("Special deal is added successfully");

        Deals de = new Deals();
    }

    public void modifydeals(){ //we can modify existing deals here
        System.out.println("Modify Special Deal:");
        System.out.println("The number of ticket purchases after which the discount should avail:");
        int dt = d.nextInt();
        d.nextLine();
        System.out.println("The percentage of discount given: ");
        int dp = d.nextInt();
        d.nextLine();
        if (deal.containsKey(dt)){
            deal.put(dt,dp);
            System.out.println("Deal is modified successfully.");
        }else {
            System.out.println("The deal does not exist. You can add a new one.");
        }
        Deals de = new Deals();
    }
    public void removedeal(){   //we can remove a deal here
        System.out.println("Remove the deal: ");
        Integer dt = d.nextInt();
        d.nextLine();
        if (deal.containsKey(dt)){
            deal.remove(dt);
            System.out.println("Deal is removed successfully.");
        }else {
            System.out.println("The deal already does not exist.");
        }
        Deals de = new Deals();
    }
}

class Zoo{
    Scanner z = new Scanner(System.in);
    public Zoo(){
        System.out.println("Enter your choice (1,2 or 3)");
        System.out.println("""
                1. View Attractions
                2. View Animals
                3. Exit
                """);
        int cz = z.nextInt();
        z.nextLine();
        if (cz==1) {
            System.out.println("Attractions in the zoo are: \n");  //existing attractions can be explored by the visitor
            for (String key : Attractions.getAtt().keySet()) {
                System.out.println(key);
            }
            System.out.println("Enter your choice: (name of the attraction) ");
            String a = z.nextLine();
            if (Attractions.getAtt().containsKey(a)){
                String value = Attractions.getAtt().get(a);
                System.out.println(value + " Buy your tickets now!");
            } else {
                System.out.println("The attraction " + a + " is not present.");
            }
            Zoo zo = new Zoo();

        }else if (cz == 2){   //existing animals can be explored by the visitor
            System.out.println("Animals in the zoo: \n");
            for (String key : Animals.getAnimal().keySet()) {
                System.out.println(key);
            }
            System.out.println("Enter your choice: (name of the animal) ");
            String a = z.nextLine();
            if (Animals.getAnimal().containsKey(a)) {
                String value = Animals.getAnimal().get(a);
                System.out.println(a + " is a " + value + ". Buy your tickets now!");
            } else {
                System.out.println("The animal " + a + " is not present.");
            }
            Zoo zo = new Zoo();
        }
        else{
            Visitor v = new Visitor(VisitorLogin.getUser());
        }
    }

}

class Membership{
    private static HashMap <String, String> member = new HashMap<>();
    Scanner m = new Scanner(System.in);
    public Membership(String user){
        System.out.println("Enter a choice: (1 or 2)");
        System.out.println("""
                1. Basic Membership (Rs 20)
                2. Premium Membership (Rs 50)
                3. Exit
                """);
        int cm = m.nextInt();
        m.nextLine();
        if (cm==1) {
            member.put(user,"Basic");
            System.out.println("Apply discount code: \n");  //while applying discount, age eligibility is also checked
            String a = m.nextLine();
            if (Discounts.getDiscount().containsKey(a)) {
                if (((VisitorLogin.getVisitorlage().get(user) <= 18) && Objects.equals(a, "MINOR10")) || (VisitorLogin.getVisitorlage().get(user) >= 60) && Objects.equals(a, "SENIOR20")) {
                    int perc = Discounts.getDiscount().get(a);
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    int rev = (20 - 20 * perc / 100);
                    bal = bal - rev;
                    int revfinal = ap_assignment_2.getRevenue() + rev; //balance of visitor is deducted after buying the membership
                    ap_assignment_2.setRevenue(revfinal);
                    VisitorLogin.getVisitorlbal().put(user, bal);
                    System.out.println("Basic membership enabled. The balance is " + bal);

                } else if (!Objects.equals(a, "MINOR10") && !Objects.equals(a, "SENIOR20")) {
                    int perc = Discounts.getDiscount().get(a);
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    int rev = (20 - 20 * perc / 100);
                    bal = bal - rev;
                    int revfinal = ap_assignment_2.getRevenue() + rev;
                    ap_assignment_2.setRevenue(revfinal);
                    VisitorLogin.getVisitorlbal().put(user, bal);
                    System.out.println("Basic membership enabled. The balance is " + bal);
                }
                else{
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    bal = bal - 20;
                    ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + 20);
                    VisitorLogin.getVisitorlbal().put(user,bal);
                    System.out.println("Basic membership enabled. The balance is " + bal);
                }

            }else{
                int bal = VisitorLogin.getVisitorlbal().get(user);
                bal = bal - 20;
                ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + 20);
                VisitorLogin.getVisitorlbal().put(user,bal);
                System.out.println("Basic membership enabled. The balance is " + bal);
            }
            Visitor v = new Visitor(user);


        }else if (cm == 2) {
            member.put(user,"Premium");  //same applies for premium membership
            System.out.println("Apply discount code: \n");
            String a = m.nextLine();
            if (Discounts.getDiscount().containsKey(a)){
                if (((VisitorLogin.getVisitorlage().get(user) <= 18) && Objects.equals(a, "MINOR10")) || (VisitorLogin.getVisitorlage().get(user) >= 60) && Objects.equals(a, "SENIOR20")) {
                    int perc = Discounts.getDiscount().get(a);
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    int rev = (50 - 50 * perc / 100);
                    bal = bal - rev;
                    ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + rev);
                    VisitorLogin.getVisitorlbal().put(user, bal);
                    System.out.println("Premium membership enabled. The balance is " + bal);

                }else if(!Objects.equals(a, "MINOR10") && !Objects.equals(a, "SENIOR20")){
                    int perc = Discounts.getDiscount().get(a);
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    int rev = (50 - 50 * perc / 100);
                    bal = bal - rev;
                    int revfinal = ap_assignment_2.getRevenue() + rev;
                    ap_assignment_2.setRevenue(revfinal);
                    VisitorLogin.getVisitorlbal().put(user, bal);
                    System.out.println("Premium membership enabled. The balance is " + bal);
                }
                else{
                    int bal = VisitorLogin.getVisitorlbal().get(user);
                    bal = bal - 50;
                    ap_assignment_2.setRevenue(ap_assignment_2.getRevenue()+50);
                    VisitorLogin.getVisitorlbal().put(user,bal);
                    System.out.println("Premium membership enabled. The balance is " + bal);
                }

            } else {
                int bal = VisitorLogin.getVisitorlbal().get(user);
                bal = bal - 50;
                ap_assignment_2.setRevenue(ap_assignment_2.getRevenue()+50);
                VisitorLogin.getVisitorlbal().put(user,bal);
                System.out.println("Premium membership enabled. The balance is " + bal);
            }
            Visitor v = new Visitor(user);

        }else{
            Visitor v = new Visitor(user);
        }
    }
    public static HashMap<String, String> getMember() {
        return member;
    }

    public static void setMember(HashMap<String, String> member) {
        Membership.member = member;
    }

}

class Tickets{
    Scanner t = new Scanner(System.in);
    private static ArrayList<String> attvisit = new ArrayList<>();
    public Tickets(String user){
        System.out.println("Enter a choice (1 or 2)");
        System.out.println("1. Buy tickets");
        System.out.println("2. Exit");
        int choice = t.nextInt();
        t.nextLine();
        if (choice == 1){
            int initBal = VisitorLogin.getVisitorlbal().get(user); //asks how many tickets are to be bought and revises the balance accordingly. It also applies special deals and discounts here if eligible
            System.out.println("Enter how many tickets do you want to buy: ");
            int ti = t.nextInt();
            t.nextLine();
            if (Objects.equals(Membership.getMember().get(user), "Basic")) {
                int wh = ti;
                while (wh != 0){
                    System.out.println("Select an attraction to buy a ticket:");
                    for (String key : Attractions.getAtt().keySet()) {
                        System.out.println(key);
                    }
                    System.out.println("Enter your choice: (name of the attraction) ");
                    String a = t.nextLine();
                    attvisit.add(a);
                    if (ap_assignment_2.getPopatt().containsKey(a)) {
                        int val = ap_assignment_2.getPopatt().get(a);
                        val++;
                        ap_assignment_2.getPopatt().put(a, val);
                    } else {
                        ap_assignment_2.getPopatt().put(a, 1);
                    }
                    int value = Events.getEvent().get(a);
                    ap_assignment_2.setTicount(ap_assignment_2.getTicount() + 1);
                    System.out.println("Apply discount code:");
                    String dis = t.nextLine();
                    if (Discounts.getDiscount().containsKey(dis)){
                        if (((VisitorLogin.getVisitorlage().get(user) <= 18) && Objects.equals(a, "MINOR10")) || (VisitorLogin.getVisitorlage().get(user) >= 60) && Objects.equals(a, "SENIOR20")) {
                            int perc = Discounts.getDiscount().get(dis);
                            int bal = VisitorLogin.getVisitorlbal().get(user);
                            int rev = (value - value * perc / 100);
                            bal = bal - rev;
                            ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + rev);
                            VisitorLogin.getVisitorlbal().put(user, bal);
                            System.out.println("The ticket for " + a + " was purchased successfully. Your balance is now ₹" + bal);

                        }else if(!Objects.equals(dis, "MINOR10") && !Objects.equals(dis, "SENIOR20")) {
                            int perc = Discounts.getDiscount().get(dis);
                            int bal = VisitorLogin.getVisitorlbal().get(user);
                            int rev = (value - value * perc / 100);
                            bal = bal - rev;
                            ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + rev);
                            VisitorLogin.getVisitorlbal().put(user, bal);
                            System.out.println("The ticket for " + a + " was purchased successfully. Your balance is now ₹" + bal);
                        }
                        else{
                            int bal = VisitorLogin.getVisitorlbal().get(user);
                            bal = bal - value;
                            ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + value);
                            VisitorLogin.getVisitorlbal().put(user, bal);
                            System.out.println("The ticket for " + a + " was purchased successfully. Your balance is now ₹" + bal);
                        }
                    } else {
                        int bal = VisitorLogin.getVisitorlbal().get(user);
                        bal = bal - value;
                        ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() + value);
                        VisitorLogin.getVisitorlbal().put(user, bal);
                        System.out.println("The ticket for " + a + " was purchased successfully. Your balance is now ₹" + bal);
                    }
                    wh--;
                }
                if (Deals.getDeal().containsKey(ti)){
                    System.out.println("As you have bought " + ti + " tickets, you have unlocked a special deal of additional " + Deals.getDeal().get(ti) + "% discount on your total sum of tickets" );
                    int finBal = VisitorLogin.getVisitorlbal().get(user);
                    int totPrice = initBal - finBal;
                    int redPrice = totPrice * (Deals.getDeal().get(ti)/100);
                    finBal -= redPrice;
                    ap_assignment_2.setRevenue(ap_assignment_2.getRevenue() - redPrice);
                    VisitorLogin.getVisitorlbal().put(user, finBal);
                }
                Tickets t = new Tickets(user);
            }else{
                ap_assignment_2.setTicount(ap_assignment_2.getTicount() + ti);
                System.out.println("You are premium member. You don't need to buy tickets.");
                Tickets t = new Tickets(user);
            }
        }else if(choice == 2){
            Visitor v = new Visitor(user);
        }else{
            System.out.println("Invalid Choice. Try Again.");
            Tickets t = new Tickets(user);
        }
    }
    public static ArrayList<String> getAttvisit() {
        return attvisit;
    }

    public static void setAttvisit(ArrayList<String> attvisit) {
        Tickets.attvisit = attvisit;
    }

}

class ViewDiscounts{
    public ViewDiscounts(){  //discounts can be checked here
        System.out.println("The discounts available are: ");
        for (Map.Entry<String, Integer> entry : Discounts.getDiscount().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + "%");
        }
        Visitor v = new Visitor(VisitorLogin.getUser());
    }

}
class VisitAtt{      //attraction can be visited here. if premium no tickets are required. In basic, we need to have a ticket to visit an attraction
    Scanner va = new Scanner(System.in);
    public VisitAtt(String user){
        System.out.println("Select an attraction to visit: (name of the attraction)");
        for (String key : Attractions.getAtt().keySet()) {
            System.out.println(key);
        }
        String vq = va.nextLine();
        if (Objects.equals(Membership.getMember().get(user), "Premium")){
            System.out.println("Thank you for visiting " + vq + ". Hope you enjoyed the attraction.");
        }else{
            if (Tickets.getAttvisit().contains(vq)) {
                System.out.println("1 Ticket used. Thank you for visiting " + vq + ". Hope you enjoyed the attraction.");
                Tickets.getAttvisit().remove(vq);
            }else{
                System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
            }
        }
        Visitor v = new Visitor(user);

    }
}
class LeaveFeedback{  //visitor can leave a feedback here
    Scanner l = new Scanner(System.in);
    private static ArrayList<String> leavefeed = new ArrayList<>();
    public LeaveFeedback(){
        System.out.println("Enter your feedback (max 200 characters): ");
        String lf = l.nextLine();
        System.out.println("Thank you for your feedback. ");
        leavefeed.add(lf);
        Visitor v = new Visitor(VisitorLogin.getUser());
    }
    public static ArrayList<String> getLeavefeed() {
        return leavefeed;
    }

    public static void setLeavefeed(ArrayList<String> leavefeed) {
        LeaveFeedback.leavefeed = leavefeed;
    }
}
class ViewFeedback{
    public ViewFeedback(){   //admin can view the feedback
        System.out.println("The feedback left by the visitors are:");
        for (String feed : LeaveFeedback.getLeavefeed()) {
            System.out.println(feed);
        }
        Admin ad = new Admin();
    }
}

class ViewDeals{ //visitor can check special deals here
    public ViewDeals(){
        System.out.println("The deals available are: ");
        for (Map.Entry<Integer, Integer> entry : Deals.getDeal().entrySet()) {
            System.out.println("Buy " + entry.getKey() + " tickets and get " + entry.getValue() + "% discount.");
        }
        Visitor v = new Visitor(VisitorLogin.getUser());
    }
}

class VisitAnimal{
    Scanner av = new Scanner(System.in);
    public VisitAnimal() {     //visitor can visit an animal here
        System.out.println("Enter a choice (1 or 2)");
        System.out.println("(1). Select an animal to visit:");
        System.out.println("(2). Exit ");
        int c = av.nextInt();
        av.nextLine();
        if (c == 1) {
            for (String key : Animals.getAnimal().keySet()) {
                System.out.println(key);
            }
            String choice = av.nextLine();
            System.out.println("Enter a choice (1 or 2)");
            System.out.println("(1). Feed the animal ");
            System.out.println("(2). Read about the animal ");
            int ch = av.nextInt();
            av.nextLine();
            if (ch == 1) {
                String value = Animals.getAnimalsound().get(choice);
                System.out.println(value);
                VisitAnimal va = new VisitAnimal();

            } else if (ch == 2) {
                String value = Animals.getAnimaldes().get(choice);
                System.out.println(value);
                VisitAnimal va = new VisitAnimal();

            } else {
                System.out.println("Invalid choice");
            }
        } else if (c == 2) {
            Visitor v = new Visitor(VisitorLogin.getUser());
        } else {
            System.out.println("Invalid Choice.");
        }
    }
}