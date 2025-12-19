package com.hospital.repository;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void init() {
        String bedTable = """
                CREATE TABLE IF NOT EXISTS beds (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                room_no TEXT,
                bed_no TEXT,
                status TEXT ); """;


        String patientTable = """
            CREATE TABLE IF NOT EXISTS patients (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                surname TEXT,
                tc_no TEXT UNIQUE ); """;

        String reservationTable = """
            CREATE TABLE IF NOT EXISTS reservations (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                bed_id INTEGER,
                patient_id INTEGER,
                start_date TEXT,
                end_date TEXT,
                FOREIGN KEY(bed_id) REFERENCES beds(id),
                FOREIGN KEY(patient_id) REFERENCES patients(id) ); """;

        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(bedTable);
            stmt.execute(patientTable);
            stmt.execute(reservationTable);

            System.out.println("Database Tablosu hazır");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
