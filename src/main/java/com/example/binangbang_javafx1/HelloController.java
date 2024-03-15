package com.example.binangbang_javafx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HelloController {

    @FXML
    private VBox pnLogin;

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnSignIn;

    @FXML
    private TextField fieldPassword;

    @FXML
    private TextField fieldUsername;

    @FXML
    private Text messageText;

    @FXML
    private ColorPicker cpPicker;
    @FXML
    private AnchorPane paneDashBoard;

    @FXML
    private AnchorPane mainPane;

    HashMap<String, String> userInfo = new HashMap<>();
    static String username = "", password = "";

    @FXML
    void userLogin(MouseEvent event) throws IOException {
        userInfo.put("test", "test");
        userInfo.put("test2", "test2");
        userInfo.put("test3", "test3");

        username = fieldUsername.getText();
        password = fieldPassword.getText();
        System.out.println(fieldUsername.getText() + " " + fieldPassword.getText());
        AnchorPane p = (AnchorPane) pnLogin.getParent();
        if (userInfo.get(username) != null && userInfo.get(username).equals(password)) {


            if (username.equals("test")) {
                Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
                p.getScene().getStylesheets().clear();
                p.getScene().getStylesheets().add(getClass().getResource("user1.css").toExternalForm());
                p.getChildren().clear();
                p.getChildren().add(scene);
            } else if (username.equals("test2")) {
                Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
                p.getScene().getStylesheets().clear();
                p.getScene().getStylesheets().add(getClass().getResource("user2.css").toExternalForm());
                p.getChildren().clear();
                p.getChildren().add(scene);
            } else {

                Parent scene = FXMLLoader.load(getClass().getResource("home-view.fxml"));
                p.getScene().getStylesheets().clear();
                p.getScene().getStylesheets().add(getClass().getResource("user3.css").toExternalForm());
                p.getChildren().clear();
                p.getChildren().add(scene);
            }

        } else {
            messageText.setText("you have inputted the wrong username or password");
        }

    }

    @FXML
    void userLogout(MouseEvent event) throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        AnchorPane p = (AnchorPane) paneDashBoard.getParent();

        p.getChildren().clear();
        p.getChildren().add(scene);
        String color = cpPicker.getValue().toString().substring(2, cpPicker.getValue().toString().length() - 2);
        System.out.println(cpPicker.getValue());

        String temp = ".button{\n" +
                "-fx-background-color: #" + color + ";\n" +
                "\n" +
                "}";
        String path = "";
        if (username.equals("test")) {
            path = "user1.css";
        } else if (username.equals("test2")) {
            path = "user2.css";
        } else {
            path = "user3.css";
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource(path).getPath(), true));
            bw.append(temp);
            bw.close();

        } catch (IOException e) {

        }
    }


    public void btnLogout(ActionEvent actionEvent) {
    }
}
