package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase que establece el medio de comunicaci�n con la base de datos hecha en
 * Oracle
 */
public class conexionMySql {

    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String portservice;
    private static ResourceBundle propertiesConexion;

    /**
     * M�todo que carga el driver, establece la conexi�n.
     *
     * @ return Connection
     *
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (propertiesConexion == null) {
            propertiesConexion = ResourceBundle.getBundle("mysql_properties");
            ipAddress = propertiesConexion.getString("ip_address");
            dbName = propertiesConexion.getString("db_name");
            user = propertiesConexion.getString("user");
            password = propertiesConexion.getString("password");
            portservice = propertiesConexion.getString("port_service");
        }




        return DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + portservice + "/" + dbName, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            System.out.println("Conexion Exitosa" + "  " + "Driver:" + "" + con);
            con.close();
        } catch (SQLException e) {
            System.out.println("El error es: " + e);
        }
    }
}
