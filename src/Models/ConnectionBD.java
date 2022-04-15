/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abarc
 */
public class ConnectionBD {
    Connection conectar = null;
    final String  USER="root",PASWORD = "";
    final String URL = "jdbc:mysql://localhost:33065/copiabcr";
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection(URL,USER,PASWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showInputDialog(null,"Error al establecer la conexion\n"+ex.getLocalizedMessage());
        }
        return conectar;
   
        
        
    }
}
