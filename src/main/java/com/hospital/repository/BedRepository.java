package com.hospital.repository;

import com.hospital.model.Bed;
import com.hospital.model.BedStatus;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BedRepository {

    public void updateStatus(int bedId, BedStatus status) {
        String sql = "UPDATE beds SET status = ? WHERE id = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status.name());
            pstmt.setInt(2, bedId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Bed bed) {
        String sql = "INSERT INTO beds(room_no, bed_no, status) VALUES(?,?,?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bed.getRoomNo());
            pstmt.setString(2, bed.getBedNo());
            pstmt.setString(3, bed.getStatus().name());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Bed> findEmptyBeds() {
        List<Bed> beds = new ArrayList<>();
        String sql = "SELECT * FROM beds WHERE status = 'EMPTY'";

        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                beds.add(new Bed(
                        rs.getInt("id"),
                        rs.getString("room_no"),
                        rs.getString("bed_no"),
                        BedStatus.valueOf(rs.getString("status"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beds;
    }

    public List<Bed> findAll() {
        List<Bed> beds = new ArrayList<>();
        String sql = "SELECT * FROM beds";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                beds.add(new Bed(
                        rs.getInt("id"),
                        rs.getString("room_no"),
                        rs.getString("bed_no"),
                        BedStatus.valueOf(rs.getString("status").toUpperCase())
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beds;
    }
}