/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Account;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CreatAccountController implements Initializable {

    @FXML
    private Button showUsersManagmentPageBt;
    @FXML
    private Button showAccountsPageBt;
    @FXML
    private Button showOpretionsPageBt;
    @FXML
    private Button saveNewAccountBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userIdTF;
    @FXML
    private TextField AccountNumberTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField currencyTF;
    @FXML
    private TextField balanceTF;
    @FXML
    private TextField creationDateTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOpretionsPage(ActionEvent event) {
    }

    @FXML
    private void saveNewAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        // get data from all text fields
        
        int userId = Integer.parseInt(userIdTF.getText());
        int accountNumber = Integer.parseInt(AccountNumberTF.getText());
        String username = usernameTF.getText();
        String currency = currencyTF.getText();
        double balance = Double.parseDouble(balanceTF.getText());
        Date creationDate = Date.valueOf(creationDateTF.getText());
        // make an user object having this data
        Account account = new Account(userId,accountNumber,username,currency,balance,creationDate);
        // save the user in database by save method
        account.saveAccount();
        
        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelAccountCreation(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }
    
}
