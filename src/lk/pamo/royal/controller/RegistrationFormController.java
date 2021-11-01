package lk.pamo.royal.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.pamo.royal.util.HibernateRegController;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class RegistrationFormController implements Initializable {

    @FXML
    private TextField txtregDate;

    @FXML
    private TextField txtregFee;

    @FXML
    private TableView<?> tblReg;

    @FXML
    private Button btnRegSave;

    @FXML
    private ComboBox<?> cmbStuID;

    @FXML
    private ComboBox<?> cmbCourseID;

    @FXML
    private Label lblStudentName;

    @FXML
    private Label lblCourseName;

    @FXML
    private TextField txtregID;

    @FXML
    void saveRegistrations(ActionEvent event){

//        new HibernateRegController().registretion(r,course);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCid();
        loadSid();
    }

    private void loadCid() {

        List list = new HibernateRegController().loadCid();

        ObservableList<String> a = FXCollections.observableArrayList();
        a.addAll(list);
        cmbCourseID.getItems().addAll();

    }

    private void loadSid() {

        List list = new HibernateRegController().loadCid();

        ObservableList<String> a = FXCollections.observableArrayList();
        a.addAll(list);
        cmbStuID.getItems().addAll();

    }
}
