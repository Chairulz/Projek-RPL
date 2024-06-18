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

public class ParkingSlotDAO {
    public List<ParkingSlot> getAllSlots() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM parking_slots";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<ParkingSlot> slots = new ArrayList<>();
        while (rs.next()) {
            ParkingSlot slot = new ParkingSlot();
            slot.setSlotNumber(rs.getInt("slot_number"));
            slot.setOccupied(rs.getBoolean("is_occupied"));
            slots.add(slot);
        }
        return slots;
    }

    public void updateSlot(ParkingSlot slot) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE parking_slots SET is_occupied = ? WHERE slot_number = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setBoolean(1, slot.isOccupied());
        stmt.setInt(2, slot.getSlotNumber());
        stmt.executeUpdate();
    }
}


