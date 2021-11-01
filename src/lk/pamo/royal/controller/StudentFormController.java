package lk.pamo.royal.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.pamo.royal.entity.Student;
import lk.pamo.royal.util.HibernateStudentController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    @FXML
    private RadioButton rabMale;

    @FXML
    private RadioButton rabFemale;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtBirth;

    @FXML
    private TableView<Student> tblStudent;

    @FXML
    private Button btnStudentSave;

    @FXML
    private Button btnStudentUpdate;

    @FXML
    private Button btnStudentDelete;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtStudentID;

    @FXML
    private Label gender;

    @FXML
    private DatePicker dpDob;

    @FXML
    private void saveStudent(ActionEvent event) {

        LocalDate localDate = dpDob.getValue();
        String d = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(localDate);
        Date date = null;
        try {
            date = new SimpleDateFormat("YYYY-MM-dd").parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sid = txtStudentID.getText();
        String sname = txtStudentName.getText();
        String saddress = txtAddress.getText();
        String contact = txtContact.getText();
        Date dob = date;
        String gender1 = "";
        if (rabMale.isSelected()) {
            gender1 = "Male";
        } else {
            gender1 = "Female";
        }

        Student s = new Student(sid, sname, saddress, contact, dob, gender1);
        new HibernateStudentController().saveStudent(s);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rabMale.setToggleGroup(toggleGroup);
        rabFemale.setToggleGroup(toggleGroup);


        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("address"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("contact"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("dob"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory("gender"));

        loadStudents();

    }

    private void loadStudents() {
        List<Student> students = new HibernateStudentController().getAllStudents();
        tblStudent.setItems(FXCollections.observableArrayList(students));

    }
}
