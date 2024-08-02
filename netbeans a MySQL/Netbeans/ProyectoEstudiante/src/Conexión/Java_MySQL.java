package Conexión;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Java_MySQL {
   
   /* PRIMER INTENTO DE CONECTAR LA BASE DE DATOS
    
    private static String DRIVER   ="com.mysql.cj.jdbc.Driver";
    private static String USUARIO  ="root";
    private static String PASSWORD ="bd3000";
    private static String URL      ="jdbc:mysql:localhost:3306/loginu";
    
    static{
        
        try{
            Class.forName(DRIVER);
        
    } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER: "+e);
    }
    }
    
    public Connection getConnecxtion(){
        Connection con = null;
        try {
            con= DriverManager.getConnection(URL, USUARIO, PASSWORD);
             JOptionPane.showMessageDialog(null, "GG");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR"+ e);
        }
        return con;
    }
    
    */
    
    //SEGUNDO INTENTO PARA CONECTAR LA BASE DE DATOS
    
    private static final String URL = "jdbc:mysql://localhost:3306/loginu";
    private static final String USER = "root";
    private static final String PASSWORD = "bd3000";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        
        //PARA SABER SI FUNCIONA
        try {
            Class.forName("DRIVER");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}