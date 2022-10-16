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
    public static String execQuery(String query) {

        String output = "";

        try (Connection connection = newConnection();
             PreparedStatement stm = connection.prepareStatement(query);
             ResultSet rs = stm.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    output += "  " + rs.getString(i);
                    if (i == metaData.getColumnCount()) {
                        output += "\n";
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR! CONSULTA INCORRECTA");
        }

        return output;
    }
    public static String obtenerEscuderia(String id) {
        String query = "SELECT Nombre FROM Escuderia WHERE ID='" + id + "';";
        return execQuery(query);
    }
    public static String obtenerNombrePilotos() {
        String query = "SELECT Nombre from Piloto;";
        return execQuery(query);
    }
}
