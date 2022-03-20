package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField Fname;

    @FXML
    private TextField Sname;

    @FXML
    private Button genRec;

    @FXML
    private ChoiceBox<String> vaccineReq;
    private String[] choiceVaccine = {"AstraZeneca","Sinopharm","Pfizer"};

    @FXML
    private TextField Age;

    @FXML
    private TextField City;

    @FXML
    private TextField Nic;

    @FXML
    private TextField boothNum;

    @FXML
    public void click() {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("generateReceipt.fxml"));
            Parent root = loader.load();

            generateReceipt displayReceipt = loader.getController();
            displayReceipt.firstname(Fname.getText());
            displayReceipt.surname(Sname.getText());
            displayReceipt.age(Age.getText().toString());
            displayReceipt.city(City.getText());
            displayReceipt.nicPassport(Nic.getText().toString());
            displayReceipt.numBooth(boothNum.getText().toString());
            displayReceipt.displayRece(vaccineReq.getValue());

            Stage stage = (Stage) genRec.getScene().getWindow();
            stage.close();
            Stage stageOne = new Stage();
            stageOne.setScene(new Scene(root));
            stageOne.setTitle("COVID-19 VACCINATION CENTER PROGRAM");
            stageOne.show();
        }catch (IOException e){
            System.err.println(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      vaccineReq.getItems().addAll(choiceVaccine);
    }
}
