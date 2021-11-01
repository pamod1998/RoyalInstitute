package lk.pamo.royal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class DashBoardController {
    @FXML
    private BorderPane main;

    @FXML
    private AnchorPane display;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnRegistration;

    @FXML
    private Button btnCourse;


    @FXML
    void loadCourse(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/lk/pamo/royal/view/CourseForm.fxml"));
            main.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void loadRegistration(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/lk/pamo/royal/view/RegistrationForm.fxml"));
            main.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void loadStudent(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/lk/pamo/royal/view/StudentForm.fxml"));
            main.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
