package org.data;

import java.sql.*;

public class ConnectionManager {
    public static Connection newConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formula1?user=luis" +
                    "&password=030305");
        } catch (SQLException e) {
            System.out.println("ERROR! NO SE PUDO REALIZAR LA CONEXION");
        }

        return connection;
    }

    public static String execQuery(String query, Connection connection) {
        String output = null;

        try (PreparedStatement stm = connection.prepareStatement(query);
             ResultSet rs = stm.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                int index = 0;
                while (index < columnCount) {
                    output += rs.getString(index);
                    index++;
                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR! VERIFICA LA SINTAXIS");
        }

        return output;
    }
}
