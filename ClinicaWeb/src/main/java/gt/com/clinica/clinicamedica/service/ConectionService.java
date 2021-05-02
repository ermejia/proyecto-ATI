

package gt.com.clinica.clinicamedica.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionService {
    private static Connection dataSource;
    private static ConectionService instance;
    /**
     * Varibales de conexión
     */
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String database = "Clinica";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
    public String username = "root";
    public String password = "password";

    private ConectionService() {
    }

    /**
     *
     * @return Intancia de la conexión
     */
    public static ConectionService getInstance() {
        if (instance == null) {
            instance = new ConectionService();
        }
        return instance;
    }

    /**
     * Conecta con la base de datos
     * @return nueva conexion
     * @throws SQLException En caso de que la conexion falle
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            dataSource = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Error al conectar");
        }
        return dataSource;
    }
}