
package mediamarkt;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MediaMarkt {

    public static void cargaDatos () {
        try {
            // 1. Cargar el driver.
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Creo la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/mediamarkt","adelina","mysql");
            // 3. Crear el Statement
            Statement s = conexion.createStatement();
            // 4. Trabajo con las consultas.
            ResultSet rs=s.executeQuery("SELECT * FROM productos");
            while (rs.next()==true) {
                System.out.println(rs.getInt("id")+" - "+(rs.getString("nombre")+" - "+(rs.getFloat("precio"))));
            }
            // 5. Cierro la conexión.
            rs.close();
            s.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error al cargar la base de datos.");
            //Muestre la información del error.
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        cargaDatos();
        
    }
    
}
