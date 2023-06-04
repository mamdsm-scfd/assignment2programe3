/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Account;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdateAccountPageController implements Initializable {
    private Account oldAccount;

    @FXML
    private Label userIdTF;
    @FXML
    private Button updateAccountBtn;
    @FXML
    private Button cancelBtn;
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
    private void updateAccount(ActionEvent event) throws SQLException, ClassNotFoundException {
        int userId = Integer.parseInt(userIdTF.getText());
        int accountNumber = Integer.parseInt(AccountNumberTF.getText());
        String username = usernameTF.getText();
        String currency = currencyTF.getText();
        double balance = Double.parseDouble(balanceTF.getText());
        Date creationDate = Date.valueOf(creationDateTF.getText());
        
        Account newAccount = new Account(userId,accountNumber,username,currency,balance,creationDate);
        
        newAccount.setId(oldAccount.getId());
        
        newAccount.update();
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
        Controller.Admin.AccountsManagmentController.updateStage.close();
    }
    
}
