package com.hospital.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {

    private static final String URL = "jdbc:sqlite:hospital.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            throw new RuntimeException("SQLite Bağlantı Hatası", e);
        }
    }
}
