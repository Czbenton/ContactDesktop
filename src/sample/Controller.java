package sample;

import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField name;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField email;
    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

    public void addContact() throws IOException {
        if (name.getText().trim().equals("") || phoneNumber.getText().trim().equals("") || email.getText().trim().equals("")) {
            //Eat it
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("OMG IT'S AN ERROR!");
            alert.setHeaderText("See below for error details");
            alert.setContentText("Please enter valid information into all fields. Thank you!");

            alert.showAndWait();

        } else {
            contacts.add(new Contact(name.getText(), phoneNumber.getText(), email.getText()));
            name.setText("");
            phoneNumber.setText("");
            email.setText("");
            JsonMethods.writeJson("contacts.json",contacts);

        }
    }

    public void removeContact() {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
    }
    public void onKeyPressed(KeyEvent event) throws IOException {      //boiler plate
        if (event.getCode() == KeyCode.ENTER) {
            addContact();
        }
    }




}
