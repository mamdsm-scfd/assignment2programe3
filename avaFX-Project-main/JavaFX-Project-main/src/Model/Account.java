/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Account {
    private int id;
    private int userId;
    private int accountNumber;
    private String username;
    private String currency;
    private double balance;
    private Date creationDate;

    public Account(int userId, int accountNumber, String username, String currency, double balance, Date creationDate) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
    public int saveAccount() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "INSERT INTO USERS (ID,user_id,account_number,username,currency,balance,creation_date) VALUES (?, ?, ?, ?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2,this.getUserId());
        ps.setInt(3, this.getAccountNumber());
        ps.setString(4, this.getUsername());
        ps.setString(5, this.getCurrency());
        ps.setDouble(6, this.getBalance());
        ps.setDate(6, (java.sql.Date) this.getCreationDate());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUsername()
                    +" User was added successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
    
    
    
    //get all users from users table
     public static ArrayList<Account> getAllAccounts throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            Account account = new Account(rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7));
            account.setId(rs.getInt(1));
            accounts.add(account);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return accounts;
    }
     
     
     
     //update an existing user in users table 
    public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE Accounts SET UserId=?, AccountNumber=?, Username=? , Currency=?,Balance=?,CreationDate=?, WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setInt(1,this.getUserId());
        ps.setInt(2, this.getAccountNumber());
        ps.setString(3, this.getUsername());
        ps.setString(4, this.getCurrency());
        ps.setDouble(5, this.getBalance());
        ps.setDate(6, (java.sql.Date) this.getCreationDate());
        ps.setInt(6, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
    //delete an user from users table 
    public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM Accounts WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The account with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
     
    
     
}
