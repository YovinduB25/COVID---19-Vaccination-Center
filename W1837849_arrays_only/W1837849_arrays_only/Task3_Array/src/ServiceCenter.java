import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class ServiceCenter {
    static Scanner input = new Scanner(System.in);
    static String[] boothCenter = new String[6]; //Initialise global array with 6 elements
    static int vaccinationStock =150;   //set vaccine stock to 150
    public static void main(String[] args) throws IOException {
        String selected = "";
        String patientName;
        int boothNum =0;


        initialise(boothCenter);

        while(true){
            if (!((selected.equalsIgnoreCase("EXT")) || (selected.equals("999")))){ //Until user input "EXT" || "999" loop will run
                selected = displayMenu(); //calling menu method
                menu(selected, boothCenter);
            }else {
                System.out.println("Thank you.");
                break;
            }
        }
    }
    public static void initialise( String [] booths ) { //Initialise empty index array booth
        Arrays.fill(booths, "empty");
        System.out.println( "initialise ");
    }
    public static String displayMenu(){ //Initialise method displayMenu to print

        System.out.println("_____________________________________");
        System.out.println("Menu :");
        System.out.println("100 or VVB: View all Vaccination Booths");
        System.out.println("101 or VEB: View all Empty Booths");
        System.out.println("102 or APB: Add Patient to a Booth");
        System.out.println("103 or RPB: Remove Patient from a Booth");
        System.out.println("104 or VPS: View Patients Sorted in alphabetical order");
        System.out.println("105 or SPD: Store Program Data into file");
        System.out.println("106 or LPD: Load Program Data from file");
        System.out.println("107 or VRV: View Remaining Vaccinations");
        System.out.println("108 or AVS: Add Vaccinations to the Stock");
        System.out.println("999 or EXT: Exit the Program");
        System.out.println("_____________________________________");

        System.out.println("Input required");
        return input.next();
    }
    public static void menu(String selected, String[] booths) throws IOException { //Switch cases for menu.

        if(selected.equals("100") || selected.toUpperCase().equals("VVB")) {
            viewBooths(booths);
        } else if(selected.equals("101") || selected.toUpperCase().equals("VEB")) {
            viewEmpty(booths);
        } else if(selected.equals("102") || selected.toUpperCase().equals("APB")) {
            addPatient();
        } else if(selected.equals("103") || selected.toUpperCase().equals("RPB")) {
            removePatient();
        } else if(selected.equals("104") || selected.toUpperCase().equals("VPS")) {
            sortPatient();
        } else if(selected.equals("105") || selected.toUpperCase().equals("SPD")) {
            storeProgramData();
        } else if(selected.equals("106") || selected.toUpperCase().equals("LPD")) {
            loadProgramData();
        } else if(selected.equals("107") || selected.toUpperCase().equals("VRV")) {
            viewRemainingVaccine();
        } else if(selected.equals("108") || selected.toUpperCase().equals("AVS")) {
            addVaccine();
        } else {
            System.out.println("Invalid Input");
        }
    }


    //View all Booths "100" or "VVB"
    public static void viewBooths(String[] booths){
        for (int x=0; x<booths.length; x++){
            if (booths[x].equals("empty")){ //Checking booths empty
                System.out.println("Booth " + (x + 1) + " is empty");
            }else {
                System.out.println("Booth " + (x + 1) + " is occupied by " + booths[x] );
            }
        }
    }
    //View all empty Booths "101" or "VEB"
    public static void viewEmpty(String[] booths){
        for (int x=0; x< booths.length; x++){
            if (booths[x].equals("empty")){ //Checking booths empty
                System.out.println("Booth " + (x + 1) +" is empty");
            }
        }
    }
    //Add Patient to a Booth "102" or "APB"
    public static void addPatient(){
        String firstnamePatient;    //initialized variables
        String surnamePatient;
        int vaccineType = 100;

        System.out.println("Enter the required vaccine type.");
        System.out.println("Please Enter 1 for AstraZeneca.");
        System.out.println("Please Enter 2 for Sinopharm.");
        System.out.println("Please Enter 3 for Pfizer.");

        try {
            vaccineType = Integer.parseInt(input.next());   //Asking the value from user
        }
        catch (NumberFormatException ex)    //error handling
        {
            System.out.println("Please enter an integer value.");
        }
        if(vaccineType == 1) {  //If user input AstraZeneca as their vaccine type
            if(boothCenter[0].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();    //Taking first name
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();  //Taking surname
                String fullname = firstnamePatient+" "+surnamePatient;  //fulname as firstname + surname
                String saveText = "Requested Vaccine Type : AstraZeneca | " + "Name : "+fullname;
                boothCenter[0] = saveText;  //Saving for booth 0
                vaccinationStock = vaccinationStock - 1;    //reduce the stock value by 1
            }
            else if(boothCenter[1].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();
                String fullname = firstnamePatient+" "+surnamePatient;
                String saveText = "Requested Vaccine Type : AstraZeneca | " + "Name : "+fullname;
                boothCenter[1] = saveText;
                vaccinationStock = vaccinationStock - 1;
            } else {
                System.out.println("All AstraZeneca Vaccinating Booths Are Filled.");
            }
        }
        if(vaccineType == 2) {  //If user input Sinopharm as their vaccine type
            if(boothCenter[2].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();
                String fullname = firstnamePatient+" "+surnamePatient;
                String saveText = "Requested Vaccine Type : Sinopharm | " + "Name : "+fullname;
                boothCenter[2] = saveText;
                vaccinationStock = vaccinationStock - 1;

            } else if(boothCenter[3].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();
                String fullname = firstnamePatient+" "+surnamePatient;
                String saveText = "Requested Vaccine Type : Sinopharm | " + "Name : "+fullname;
                boothCenter[3] = saveText;
                vaccinationStock = vaccinationStock - 1;

            } else {
                System.out.println("All Sinopharm Vaccinating Booths Are Filled.");
            }
        }
        if(vaccineType == 3) {  //If user input Pfizer as their vaccine type
            if(boothCenter[4].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();
                String fullname = firstnamePatient+" "+surnamePatient;
                String saveText = "Requested Vaccine Type : Pfizer | " + "Name : "+fullname;
                boothCenter[4] = saveText;
                vaccinationStock = vaccinationStock - 1;

            } else if(boothCenter[5].equals("empty")) {
                System.out.println("Enter the patient firstname : ");
                firstnamePatient = input.next();
                System.out.println("Enter the patient surname : ");
                surnamePatient = input.next();
                String fullname = firstnamePatient+" "+surnamePatient;
                String saveText = "Requested Vaccine Type : Pfizer | " + "Name : "+fullname;
                boothCenter[5] = saveText;
                vaccinationStock = vaccinationStock - 1;

            } else {
                System.out.println("All Pfizer Vaccinating Booths Are Filled.");
            }
        }
    }
    //Remove Patient from a Booth "103" or "RPB"
    public static void removePatient(){
        System.out.println("From which booth do you need to remove : ");
        int numBooth;
        numBooth = input.nextInt();
        if (!(boothCenter[numBooth - 1].equals("empty"))){  // Can not reduce the value
            boothCenter[numBooth - 1] = "empty";
            System.out.println("Patient removed  from booth "+ numBooth);
        } else {
            System.out.println("Booth "+numBooth+" is already empty");
        }

    }
    //Remove Patient from a Booth "103" or "RPB"
    public static void sortPatient(){
        System.out.println("Unsorted Patient List : ");
        for(int b = 0;b< boothCenter.length;b++) {
            System.out.println(boothCenter[b]);
        }
        for(int f = 0; f < boothCenter.length; f++) {
            for (int s = f+1;s< boothCenter.length;s++) {
                if(boothCenter[f].compareTo(boothCenter[s])>0) {
                    String tmp = boothCenter[f];
                    boothCenter[f] = boothCenter[s];
                    boothCenter[s] = tmp;
                }
            }

        }
        System.out.println("Sorted Patient List : ");
        for(int c = 0;c< boothCenter.length;c++) {
            System.out.println(boothCenter[c]);
        }
    }
    //Store Program Data from "105" or "SPD"
    public static void storeProgramData() throws IOException {
        BufferedWriter writer = new BufferedWriter((new FileWriter("BoothData.txt") ));
        for(int k=0;k< boothCenter.length;k++) {
            writer.write(boothCenter[k]);
            writer.newLine();
            System.out.println(boothCenter[k]);
        }
        writer.close();
    }
    //Load Program Data from file "106" or "LPD"
    public static void loadProgramData() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("BoothData.txt"));//load the data from selected file
        StringBuffer sb = new StringBuffer(); // initialize a buffer variable to store all the read values till print
        String readingLine; //initialize a string variable to store the value of reading line
        while((readingLine = br.readLine())!= null ){
            sb.append(readingLine); // store all reading values to buffer
            sb.append("\n");// adding a new line between reading lines
        }
        br.close();// close buffer reader
        System.out.println(sb.toString());//print the read lines from the buffer

    }
    //View Remaining Vaccinations "107" or "VRV"
    public static void viewRemainingVaccine() {
        System.out.println("Remaining Vaccine Count : "+vaccinationStock);
    }
    //Add Vaccinations to the Stock "108" or "AVS"
    public static void addVaccine() {
        int newVaccineCount;
        System.out.println("Enter the new vaccine count : ");
        newVaccineCount = input.nextInt();
        int totalVaccine = newVaccineCount+vaccinationStock;
        if(totalVaccine>150) {
            System.out.println("Vaccine count is higher than the maximum stock.Please enter a lower value!");
        } else {
            vaccinationStock = totalVaccine;
            System.out.println("New Vaccine Stock : "+vaccinationStock);
        }
    }
}
