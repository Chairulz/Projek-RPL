/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    public List<Transaction> getAllTransactions() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM transactions";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Transaction> transactions = new ArrayList<>();
        while (rs.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(rs.getInt("id"));
            transaction.setVehicleType(rs.getString("vehicle_type"));
            transaction.setLicensePlate(rs.getString("license_plate"));
            transaction.setEntryTime(rs.getTimestamp("entry_time"));
            transaction.setFee(rs.getInt("fee"));
            transactions.add(transaction);
        }
        return transactions;
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO transactions (vehicle_type, license_plate, entry_time, fee) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, transaction.getVehicleType());
        stmt.setString(2, transaction.getLicensePlate());
        stmt.setTimestamp(3, new java.sql.Timestamp(transaction.getEntryTime().getTime()));
        stmt.setInt(4, transaction.getFee());
        stmt.executeUpdate();
    }

    public void updateTransaction(Transaction transaction) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE transactions SET vehicle_type = ?, license_plate = ?, entry_time = ?, fee = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, transaction.getVehicleType());
        stmt.setString(2, transaction.getLicensePlate());
        stmt.setTimestamp(3, new java.sql.Timestamp(transaction.getEntryTime().getTime()));
        stmt.setInt(4, transaction.getFee());
        stmt.setInt(5, transaction.getId());
        stmt.executeUpdate();
    }

    public void deleteTransaction(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DELETE FROM transactions WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}

