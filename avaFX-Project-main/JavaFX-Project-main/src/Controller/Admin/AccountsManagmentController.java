/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Account;
import Model.User;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AccountsManagmentController implements Initializable {
    
    
    public static Account selectedAccountToUpdate;
    public static Stage updateStage;

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button createNewAccountrBtn;
    @FXML
    private Button showAllAccountsBtn;
    @FXML
    private TableView<Account> accountsTV;
    @FXML
    private TableColumn<Account, Integer> tcID;
    @FXML
    private TableColumn<Account, Integer> tcAccountNumber;
    @FXML
    private TableColumn<Account, String> tcUserName;
    @FXML
    private TableColumn<Account, String> tcCurrency;
    @FXML
    private TableColumn<Account, Double> tcBalance;
    @FXML
    private TableColumn<Account, Date> tcCreationDate;
    @FXML
    private Button updateSelectedAccountBtn;
    @FXML
    private Button deleteSelectedAccountBtn;
    @FXML
    private TextField accontSearchTF;
    @FXML
    private Button searchAccountBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcAccountNumber.setCellValueFactory(new PropertyValueFactory("account_number"));
        tcUserName.setCellValueFactory(new PropertyValueFactory("username"));
        tcCurrency.setCellValueFactory(new PropertyValueFactory("currency"));
        tcBalance.setCellValueFactory(new PropertyValueFactory("balance"));
        tcCreationDate.setCellValueFactory(new PropertyValueFactory("creation_date"));
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void showAccountCreationPage(ActionEvent event) {
        
    }

    @FXML
    private void showAllAccounts(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Account> accountsList =
      FXCollections.observableArrayList(Account.getAllAccounts);
      
      accountsTV.setItems(accountsList);
    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) {
    }

    @FXML
    private void deleteSelectedAccount(ActionEvent event) {
    }

    @FXML
    private void searchForAnAccount(ActionEvent event) {
    }
    
}
