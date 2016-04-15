/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class DBRentaCar {

      Connection con;
Statement st;
ResultSet rs;
String mensaje="";
public String userName="root";
public String password="";
public void abrirConexion() {
    
try {

String url="jdbc:mysql://localhost/BDRentaCar";
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection(url, userName, password);
 
//JOptionPane.showMessageDialog(null,"conexion a al base datos bd_renta_car_el_bory");
}
catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error en conexión ");
}
}
//Para cerrar la conexión una vez terminadas las consultas
public void cerrarConexion() {
try {
con.close();
JOptionPane.showMessageDialog(null,"Conexión cerrada");
}
catch (SQLException e) {
JOptionPane.showMessageDialog(null,"Error al cerrar conexión");
}}
}

