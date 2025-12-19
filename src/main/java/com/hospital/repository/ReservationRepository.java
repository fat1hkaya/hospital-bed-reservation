package com.hospital.repository;

import com.hospital.model.Reservation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    public void save(Reservation res) {
        String sql = "INSERT INTO reservations(bed_id, patient_id, start_date, end_date) VALUES(?,?,?,?)";

        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, res.getBed().getId());
            pstmt.setInt(2, res.getPatient().getId());
            pstmt.setString(3, res.getStartDate().toString());
            pstmt.setString(4, res.getEndDate().toString());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Reservation> findAll() {
        return new ArrayList<>();
    }

}