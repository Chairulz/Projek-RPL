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

/**
 *
 * @author LENOVO
 */
public class LaporanDAO {
    public List<Laporan> getAllLaporan() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM laporan";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Laporan> laporan = new ArrayList<>();
        while (rs.next()) {
            Laporan lapor = new Laporan();
            lapor.setNama(rs.getString("Nama"));
            lapor.setNIP(rs.getString("NIP"));
            lapor.setDivisi(rs.getString("Divisi"));
            lapor.setFile(rs.getString("File"));
            laporan.add(lapor);
        }
        return laporan;
    }

    public void addLaporan(Laporan lapor) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO laporan (Nama, NIP, Divisi, File) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, lapor.getNama());
        stmt.setString(2, lapor.getNIP());
        stmt.setString(3, lapor.getDivisi());
        stmt.setString(4, lapor.getFile());
        stmt.executeUpdate();
    }
}
