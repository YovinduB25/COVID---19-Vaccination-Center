package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class generateReceipt {

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Label5;

    @FXML
    private Label Label6;

    @FXML
    private Label Label7;

    @FXML
    private Label dAndT;

    @FXML
    public void firstname(String Fname){
        Label1.setText(Fname);
    }
    @FXML
    public void surname(String Sname){
        Label2.setText(Sname);
    }
    @FXML
    public void age(String Age){
        Label3.setText(Age);
    }
    @FXML
    public void city(String City){
        Label4.setText(City);
    }
    @FXML
    public void nicPassport(String Nic){
        Label5.setText(Nic);
    }
    @FXML
    public void numBooth(String boothNum){
        Label7.setText(boothNum);
    }
    @FXML
    public void initialize(){
        String timeStamp = new SimpleDateFormat("HH:mm (dd/mm/yyyy)").format(Calendar.getInstance().getTime());
        dAndT.setText(timeStamp);
    }

    public void displayRece(String choiceVaccine) {
        Label6.setText(choiceVaccine);
    }
}
