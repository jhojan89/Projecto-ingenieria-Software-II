/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class ClienteBD {
    Cliente c=new Cliente();
    DBRentaCar cb=new DBRentaCar();
    public void insertarCliente(String cod,String nom,String ap,String ced,String dir,String em,String sex,String tipo,String fecha,String codestatus){
    Cliente c1=new Cliente();
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into cliente values (?,?,?,?,?,?,?,?,?,?) ");
ps.setString(1, c1.getCodigoCliente());
ps.setString(2, nom);
ps.setString(3,ap);
ps.setString(4, ced);
ps.setString(5, dir);
ps.setString(6, em);
ps.setString(7, sex);
ps.setString(8, tipo);
ps.setString(9, fecha);
ps.setString(10, codestatus);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(codigocliente) from cliente");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            c1.setCodigoCliente(lastID);
        }

JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
    }
}
public void InsertarEstatus(String CodEstatus,String Estatus){
       DBRentaCar cb=new DBRentaCar();
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into estatuscliente values (?,?) ");
ps.setString(1, CodEstatus);
ps.setString(2, Estatus);




//En este caso, el método executeUpdate devuelve la cantidad de
//elementos insertados.
JOptionPane.showMessageDialog(null,"Datos Insertados ");
if (ps.executeUpdate()!=1)
throw new Exception("Error en la Inserción ");
//cb.cerrarConexion();
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
    
    }


}
public void IsertarTelefonos(String CodTel,String numTel,String Des,String codCliente){
     
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into telefonoscliente values (?,?,?,?) ");
ps.setString(1, c.getCodigoTelefono());
ps.setString(2, numTel);
ps.setString(3, Des);
ps.setString(4, codCliente);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(codigousuario) from usuario");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            c.setCodigoTelefono(lastID);
        }

JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    }


}
public ArrayList<Cliente> mostrarCliente() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Cliente> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM cliente ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Cliente c=new Cliente();
            c.setCodigoCliente(cb.rs.getString("codigoCliente"));
            c.setNombre(cb.rs.getString("nombrecliente"));
            c.setApellido(cb.rs.getString("apellidocliente"));
            c.setCedula(cb.rs.getString("cedulacliente"));
            c.setDireccion(cb.rs.getString("direccioncliente"));
            c.setEmail(cb.rs.getString("Emailcliente"));
            c.setSexo(cb.rs.getString("sexocliente"));
            c.setTipoCliente(cb.rs.getString("tipocliente"));
            c.setFechaIncreso(cb.rs.getString("fechaingreso"));
            c.setStatus(cb.rs.getString("estatuscliente_CodigoEstatusCliente"));
            lista.add(c);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
public ArrayList<Cliente> mostrarClientecod( String cod) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Cliente> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM cliente where codigocliente='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Cliente c=new Cliente();
            c.setCodigoCliente(cb.rs.getString("codigoCliente"));
            c.setNombre(cb.rs.getString("nombrecliente"));
            c.setApellido(cb.rs.getString("apellidocliente"));
            c.setCedula(cb.rs.getString("cedulacliente"));
            c.setDireccion(cb.rs.getString("direccioncliente"));
            c.setEmail(cb.rs.getString("Emailcliente"));
            c.setSexo(cb.rs.getString("sexocliente"));
            c.setTipoCliente(cb.rs.getString("tipocliente"));
            c.setFechaIncreso(cb.rs.getString("fechaingreso"));
            c.setStatus(cb.rs.getString("estatuscliente_CodigoEstatusCliente"));
            lista.add(c);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
public ArrayList<Cliente> mostrarClientecedula( String cedula) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Cliente> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM cliente where cedulacliente='"+cedula+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Cliente c=new Cliente();
            c.setCodigoCliente(cb.rs.getString("codigoCliente"));
            c.setNombre(cb.rs.getString("nombrecliente"));
            c.setApellido(cb.rs.getString("apellidocliente"));
            c.setCedula(cb.rs.getString("cedulacliente"));
            c.setDireccion(cb.rs.getString("direccioncliente"));
            c.setEmail(cb.rs.getString("Emailcliente"));
            c.setSexo(cb.rs.getString("sexocliente"));
            c.setTipoCliente(cb.rs.getString("tipocliente"));
            c.setFechaIncreso(cb.rs.getString("fechaingreso"));
            c.setStatus(cb.rs.getString("estatuscliente_CodigoEstatusCliente"));
            lista.add(c);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
public static Cliente buscarCliente(String cod) throws SQLException {
        return buscarCliente(cod, null);
    }
  
  
    public static Cliente buscarCliente(String codcliente,Cliente cc) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from cliente where codigocliente=?");
        ps.setString(1, codcliente);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (cc == null) {
                cc = new Cliente() {};
            }
             cc.setCodigoCliente(codcliente);
            cc.setNombre(rs.getString("nombrecliente"));
            cc.setApellido(rs.getString("apellidocliente"));
            cc.setCedula(rs.getString("cedulacliente"));
            cc.setDireccion(rs.getString("direccioncliente"));
            cc.setEmail(rs.getString("Emailcliente"));
            cc.setSexo(rs.getString("sexocliente"));
            cc.setTipoCliente(rs.getString("tipocliente"));
            cc.setFechaIncreso(rs.getString("fechaingreso"));
            cc.setStatus(rs.getString("estatuscliente_CodigoEstatusCliente"));
            //p.setTel(rs.getString("telefono"));
            
        }
        cb.con.close();
        ps.close();
        return cc;
    }
     public static boolean actualizarCliente(Cliente c) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE cliente SET nombrecliente=?, apellidocliente=?, cedulacliente=?, direccioncliente=?, sexocliente=? WHERE codigocliente=" + c.getCodigoCliente());
        ps.setString(1, c.getNombre());
        ps.setString(2,c.getApellido());
        ps.setString(3,c.getCedula());
        ps.setString(4,c.getDireccion());
        ps.setString(5,c.getSexo());
        
        int rowsUpdated = ps.executeUpdate();
        cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
}



 