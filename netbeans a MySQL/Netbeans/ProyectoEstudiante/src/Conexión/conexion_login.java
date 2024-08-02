package Conexión;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
public class conexion_login{
    
    public static void main (String[] args) {
    Java_MySQL db = new Java_MySQL();
    db.getConnecxtion();
    }
}
*/


public class conexion_login {
    public static boolean verificarLogin(String usuario, String contraseña) {
        Connection conn = Java_MySQL.getConnection();

        // verificar el login.
        if (conn != null) {
            try {
                // consultatabla la tabla "usuarios" donde el campo "usuario" coincide con el parámetro "usuario" y el campo "contraseña" coincide con el parámetro "contraseña".
                String query = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);

                // parámetros de la consulta SQL.
                pstmt.setString(1, usuario); // parámetro "usuario".
                pstmt.setString(2, contraseña); // parámetro "contraseña".

                // obtenemos los resultados.
                ResultSet rs = pstmt.executeQuery();

                // si el ResultSet contiene al menos un registro, el login es válido.
                if (rs.next()) {
                    return true; // devuelve true si el login es válido.
                }
            } catch (SQLException e) {
                // si ocurre una excepción SQL, salta un mensaje de error en la consola.
                System.out.println("Error al verificar login: " + e.getMessage());
            } finally {
                try {
                    // cierra la conexión a la base de datos.
                    conn.close();
                } catch (SQLException e) {
                    // si ocurre una excepción al cerrar la conexion, salta un mensaje de error en la consola.
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return false;
    }
}