import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class ServiceCenter {
    static Scanner input = new Scanner(System.in);
    static String[] boothCenter = new String[6]; //Initialise global array with 6 elements
    static int vaccinationStock =150; //Initialise Vaccination stock as 150

    public static void main(String[] args) throws IOException {
        String selected = "";   //Initialise variables
        String patientName;
        int boothNum =0;


        initialise(boothCenter); //Initialise Array boothCenter

        while(true){ //Make running menu as a infinity loop
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
    public static void menu(String selected, String[] booths) throws IOException { //Select cases for menu.

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
            System.out.println("Invalid Input"); //Error handling
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
        String namePatient; //Initialise namePatient variable
        int numBooth =100;
        System.out.println("Enter booth number (1-6) or 7 to stop:(Please enter integer value only.) ");
        try {
            numBooth = Integer.parseInt(input.next());  //Error handling
        } catch (NumberFormatException ex) {
            System.out.println("Please enter an integer value!");
        }
        if (numBooth !=7){
            if (boothCenter[numBooth - 1].equals("empty")){
                System.out.println("Enter patient name for booth " + numBooth + " : " );
                namePatient=input.next();
                boothCenter[numBooth - 1]= namePatient;
                vaccinationStock -= 1; //Making stock reduce by one when patient add
                if(vaccinationStock <= 20) {
                    System.out.println("Stock is running low!"); //Display when stock <=20
                }
            }else {
                System.out.println("The booth "+ numBooth + " is already occupied.");
            }
        }
    }
    //Remove Patient from a Booth "103" or "RPB"
    public static void removePatient(){
        System.out.println("From which booth do you need to remove: ");
        int numBooth;
        numBooth = input.nextInt();
        if (!(boothCenter[numBooth - 1].equals("empty"))){  // Removing patient from booth
            boothCenter[numBooth - 1] = "empty";
            System.out.println("Patient removed  from booth "+ numBooth);
        } else {
            System.out.println("Booth "+numBooth+" is already empty");
        }
    }
    //View Patients Sorted in alphabetical order "104" or "VPS"
    public static void sortPatient(){
        System.out.println("Unsorted Patient List : ");
        for(int b = 0;b< boothCenter.length;b++) {
            System.out.println(boothCenter[b]); //Display unsorted list before sorted list
        }
        for(int f = 0; f < boothCenter.length; f++) {   //Method for sort list
            for (int s = f+1;s< boothCenter.length;s++) {
                if(boothCenter[f].compareTo(boothCenter[s])>0) {
                    String tmp = boothCenter[f];
                    boothCenter[f] = boothCenter[s];
                    boothCenter[s] = tmp;
                }
            }
        }
        System.out.println("Sorted Patient List : ");   //Display sorted list
        for(int c = 0;c< boothCenter.length;c++) {
            System.out.println(boothCenter[c]);
        }
    }
    //Store Program Data from "105" or "SPD"
    public static void storeProgramData() throws IOException {
        BufferedWriter writer = new BufferedWriter((new FileWriter("BoothData.txt") )); //Store array data to BoothData file
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
        System.out.println("Remaining Vaccine Count : "+vaccinationStock);  //Printing remaining Vaccine count
    }

    //Add Vaccinations to the Stock "108" or "AVS"
    public static void addVaccine() {
        int newVaccineCount;    //Initialise newVaccineCount
        System.out.println("Enter the new vaccine count : ");
        newVaccineCount = input.nextInt();
        int totalVaccine = newVaccineCount+vaccinationStock;    //Initialise totalVaccine
        if(totalVaccine>150) {  //Condition for that vaccine count cannot be more than 150
            System.out.println("Vaccine count is higher than the maximum stock.Please enter a lower value!");
        } else {
           vaccinationStock = totalVaccine;
           System.out.println("New Vaccine Stock : "+vaccinationStock);
        }
    }
}
