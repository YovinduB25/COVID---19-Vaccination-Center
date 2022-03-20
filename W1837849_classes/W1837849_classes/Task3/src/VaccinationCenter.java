import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class VaccinationCenter {
    private static  int vaccinationStock = 150;
    private static final Scanner input=new Scanner(System.in);
    static Booth [] booths = new Booth[6];
    static Patient patient = new Patient("",0, "", 0, "");  //Created empty object
    static String[] ptList = new String[3];
    static int k;


    public static void main(String[] args) {
        String selected = "";

        initialise(booths);
        k = 0;
        while(true){
            if (!((selected.equalsIgnoreCase("EXT")) || (selected.equals("999")))){
                selected = displayMenu();
                try {
                    menu(selected, booths);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Thank you.");
                break;
            }
        }
    }
    public static void initialise( Booth [] booths ) {

        booths[0] = new Booth(patient,1);
        booths[1] = new Booth(patient,2);
        booths[2] = new Booth(patient,3);
        booths[3] = new Booth(patient,4);
        booths[4] = new Booth(patient,5);
        booths[5] = new Booth(patient,6);

        System.out.println( "initialise ");
    }


    public static String displayMenu(){

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
    public static void menu(String selected, Booth[] booths) throws IOException {
        if(selected.equals("100") || selected.toUpperCase().equals("VVB")) {
            viewBooths(booths);
        } else if(selected.equals("101") || selected.toUpperCase().equals("VEB")) {
            viewEmpty(booths);
        } else if(selected.equals("102") || selected.toUpperCase().equals("APB")) {
            addPatient();
        } else if(selected.equals("103") || selected.toUpperCase().equals("RPB")) {
            removePatient();
       } else if(selected.equals("104") || selected.toUpperCase().equals("VPS")) {
            sortPatient(ptList);
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
    public static void viewBooths(Booth[] booths){
        for (int x=0; x<booths.length; x++){
            if (booths[x].getPatientDetails().getName().equals("")){
                System.out.println("Booth " + (x + 1) + " is empty");
            }else {
                System.out.println("Booth " + (x + 1) + " is occupied by " + booths[x].getPatientDetails().getName() + " who got " + booths[x].getPatientDetails().getVaccination_name() );
            }
        }
    }
    //View all empty Booths "101" or "VEB"
    public static void viewEmpty(Booth[] booths){
        for (int x=0; x< booths.length; x++){
            if (booths[x].getPatientDetails().getName().equals("")){
                System.out.println("Booth " + (x + 1) +" is empty");
            }
        }
    }
    //Add Patient to a Booth "102" or "APB"
    public static void addPatient(){
        vaccinationStock -= 1;
        if(vaccinationStock <= 20) {
            System.out.println("Stock is running low");
        }
        String name;
        String surname;
        String fullname;
        int Age;
        String city;
        long nic_pass_num;
        int numBooth = 0;
        String vaccination_name;



        System.out.println("Enter patient's Vaccination type (AstraZeneca ='AZ', Sinopharm ='SP', Pfizer='PF')" );
        vaccination_name=input.next();
        if(vaccination_name.equalsIgnoreCase("AZ")){
            numBooth = (int)(Math.random()*0+1);
        }
        if(vaccination_name.equalsIgnoreCase("SP")){
            numBooth = (int)(Math.random()*2+3);
        }
        if(vaccination_name.equalsIgnoreCase("PF")){
            numBooth = (int)(Math.random()*4+5);
        }


        if (numBooth !=7){
            if(numBooth == booths[numBooth - 1].getBoothNumber()){
                if (booths[numBooth - 1].getPatientDetails().getName().equals("")){
                    System.out.println("Enter patient name for booth " + numBooth + " : " );
                    name=input.next();
                    System.out.println("Enter patient surname for booth " + numBooth + " : " );
                    surname=input.next();
                    System.out.println("Enter patient Age for booth " + numBooth + " : " );
                    Age=input.nextInt();
                    System.out.println("Enter patient city for booth " + numBooth + " : " );
                    city=input.next();
                    System.out.println("Enter patient nic_pass_num for booth " + numBooth + " : " );
                    nic_pass_num=input.nextLong();

                    fullname = name+" "+ surname;
                    booths[numBooth - 1].setPatientDetails(new Patient(fullname,Age, city, nic_pass_num, vaccination_name));
                    ptList[k] = name;
                    k++;
                }else {
                    System.out.println("The booth "+ numBooth + " is already occupied.");
                }
            }
        }
    }
    //Remove Patient from a Booth "103" or "RPB"
    public static void removePatient(){
        System.out.println("From which booth do you need to remove: ");
        int numBooth;
        numBooth = input.nextInt();
        if (!(booths[numBooth - 1].getPatientDetails().getName().equals(""))){
            booths[numBooth - 1].getPatientDetails().setName("");

            System.out.println("Patient removed  from booth "+ numBooth);
        }
        else
        {
            System.out.println("Booth "+numBooth+" is already empty");
        }

    }

    //View Patients Sorted in alphabetical order "104" or "VPS"
    public static void sortPatient(String [] pName){
        System.out.println("Unsorted Patient List : ");
        for(int b = 0;b< pName.length;b++) {
            System.out.println(pName[b]); //Display unsorted list before sorted list
        }
        for(int f = 0; f < pName.length; f++) {   //Method for sort list
            for (int s = f+1;s< pName.length;s++) {
                if(pName[f].compareTo(pName[s])>0) {
                    String tmp = pName[f];
                    pName[f] = pName[s];
                    pName[s] = tmp;
                }
            }
        }
        System.out.println("Sorted Patient List : ");   //Display sorted list
        for(int c = 0;c< pName.length;c++) {
            System.out.println(pName[c]);
        }
    }

    //Store Program Data from "105" or "SPD"
    public static void storeProgramData() throws IOException {
        BufferedWriter writer = new BufferedWriter((new FileWriter("BoothData.txt") ));
        for(int i=0;i< booths.length;i++)
        {
            String line =booths[i].getPatientDetails().getName();
            writer.write(line);
            writer.newLine();
            System.out.println(line);
        }
        try {
            FileWriter myFileWriter = new FileWriter("BoothData.txt");
            for (int i = 0; i < booths.length; i++) {
                String line = booths[i].getPatientDetails().getName();
                myFileWriter.write(line);

                System.out.println(line);
            }
            myFileWriter.close();
        }
        catch (IOException e){
            System.out.println("An error occurred = " + e);

        }
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

