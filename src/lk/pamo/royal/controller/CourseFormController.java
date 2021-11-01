package lk.pamo.royal.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.pamo.royal.entity.Course;
import lk.pamo.royal.util.HibernateCourseController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseFormController implements Initializable {

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCourseType;

    @FXML
    private TextField txtDuration;

    @FXML
    private Button btnCourseSave;

    @FXML
    private Button btnCourseUpdate;

    @FXML
    private Button btnCourrseDelete;

    @FXML
    private TextField txtCourseCode;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<Course> tblCourse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("code"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("courseName"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("courseType"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("duration"));

        loadCourses();
    }

    private void loadCourses() {
        List<Course> courses = new HibernateCourseController().getAllCourse();
        tblCourse.setItems(FXCollections.observableArrayList(courses));

    }

    public void AddCourse(ActionEvent event) {
        String cid = txtCourseCode.getText();
        String cname = txtCourseName.getText();
        String ctype = txtCourseType.getText();
        String cdu = txtDuration.getText();

        Course c = new Course(cid,cname,ctype,cdu);

        new HibernateCourseController().saveCourse(c);
        loadCourses();
    }
}
