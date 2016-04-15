/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.Aseguradora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class AseguradoraBD {
    
    

    
    
    DBRentaCar cb=new DBRentaCar();
    
    public void InsertarAseguradora(String codAsegu,String nomAsegu,String dirAsegu,String telAsegu,String faxAsegu,String emailAsegu){
      Aseguradora as=new Aseguradora();  
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into aseguradora values (?,?,?,?,?,?) ");
ps.setString(1, as.getCodigoAseguradora());
ps.setString(2, nomAsegu);
ps.setString(3,dirAsegu);
ps.setString(4, telAsegu);
ps.setString(5, faxAsegu);
ps.setString(6, emailAsegu);
ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(codigoaseguradora) from aseguradora");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            as.setCodigoAseguradora(lastID);
        }

JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
    
}

    
    }
public void insertarPoliza(String codpoliza, String fechaemicion,String fechainicio, String fechafin,String Codaseguradora){
   cb.abrirConexion();  
   Aseguradora as1=new Aseguradora();
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into poliza values (?,?,?,?,?) ");
ps.setString(1, as1.getCodigoPoliza());
ps.setString(2, fechaemicion);
ps.setString(3, fechainicio);
ps.setString(4, fechafin);
ps.setString(5, Codaseguradora);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(codigoPoliza) from Poliza");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            as1.setCodigoPoliza(lastID);
        }

JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");  
    
}

}
public  ArrayList<Aseguradora> MostrarPoliza() throws SQLException{

 cb.abrirConexion(); 
        ArrayList<Aseguradora> listapoliza = new ArrayList<>();
        PreparedStatement ps = null;
        /*
       CodigoPoliza
 FechaEmision
 FechaInicio
 FechaFin
 aseguradora_CodigoAseguradora*/

        
            ps = cb.con.prepareStatement("SELECT * FROM poliza");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
             Aseguradora a=new Aseguradora();
            Aseguradora pp=new Aseguradora();
            a.setCodigoPoliza(cb.rs.getString("codigopoliza"));
            a.setCodigoAseguradora(cb.rs.getString("aseguradora_CodigoAseguradora"));
            a.setFechaEmicion(cb.rs.getString("FechaEmision"));
            a.setFechaInicio(cb.rs.getString("FechaInicio"));
            a.setFechaFin(cb.rs.getString("FechaFin"));
            
          listapoliza.add(a);
        }
        
      
    
    cb.con.close();
   ps.close();

return listapoliza;
 
 
 }
public static Aseguradora BuscarPoliza(String cod) throws SQLException {
        return BuscarPoliza(cod, null);
    }
  
  
    public static Aseguradora BuscarPoliza(String codigo,Aseguradora p) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from poliza where  Codigopoliza=?");
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p= new Aseguradora(){};
            }
            p.setCodigoPoliza(codigo);
            p.setCodigoAseguradora(rs.getString("aseguradora_CodigoAseguradora"));
            p.setFechaEmicion(rs.getString("FechaEmision"));
            p.setFechaInicio(rs.getString("FechaInicio"));
            p.setFechaFin(rs.getString("FechaFin"));
            
            
            
            /*
            
            CodigoAseguradora
NombreAseguradora
DireccionAseguradora
TelefonoAseguradora
FaxAseguradora
EmailAseguradora
            */
        }
        cb.con.close();
        ps.close();
        return p;
    }
public static boolean  ActualizarPoliza(Aseguradora p) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE poliza SET fechaemision=?, fechainicio=?, fechafin=?, aseguradora_CodigoAseguradora=? WHERE Codigopoliza=" + p.getCodigoPoliza());
        ps.setString(1, p.getFechaEmicion());
        ps.setString(2,p.getFechaInicio());
        ps.setString(3,p.getFechaFin());
        ps.setString(4,p.getCodigoAseguradora());
        
       
        int rowsUpdated = ps.executeUpdate();
        cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }


public  ArrayList<Aseguradora> MostrarAseguradoras() throws SQLException{

 cb.abrirConexion(); 
        ArrayList<Aseguradora> lista = new ArrayList<>();
        PreparedStatement ps = null;
        
      

        
            ps = cb.con.prepareStatement("SELECT * FROM Aseguradora");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
             Aseguradora a=new Aseguradora();
            Aseguradora pp=new Aseguradora();
            a.setCodigoAseguradora(cb.rs.getString("CodigoAseguradora"));
            a.setNombreAseguradora(cb.rs.getString("NombreAseguradora"));
            a.setDireccionAseguradora(cb.rs.getString("DireccionAseguradora"));
            a.setTelefonoAseguradora(cb.rs.getString("TelefonoAseguradora"));
            a.setFaxAseguradora(cb.rs.getString("FaxAseguradora"));
            a.setEmailseguradora(cb.rs.getString("EmailAseguradora"));
          lista.add(a);
        }
        
      
    
    cb.con.close();
   ps.close();

return lista;
 
 
 }
  public static Aseguradora BuscarAseguradora(String cod) throws SQLException {
        return BuscarAseguradora(cod, null);
    }
  
  
    public static Aseguradora BuscarAseguradora(String codigo,Aseguradora a) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from Aseguradora where  CodigoAseguradora=?");
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (a == null) {
                a= new Aseguradora(){};
            }
            a.setCodigoAseguradora(codigo);
            a.setNombreAseguradora(rs.getString("NombreAseguradora"));
            a.setDireccionAseguradora(rs.getString("DireccionAseguradora"));
            a.setTelefonoAseguradora(rs.getString("TelefonoAseguradora"));
            a.setFaxAseguradora(rs.getString("FaxAseguradora"));
            a.setEmailseguradora(rs.getString("EmailAseguradora"));
            
            
            /*
            
            CodigoAseguradora
NombreAseguradora
DireccionAseguradora
TelefonoAseguradora
FaxAseguradora
EmailAseguradora
            */
        }
        cb.con.close();
        ps.close();
        return a;
    }




public static boolean  ActualizarAseguradora(Aseguradora a) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE Aseguradora SET NombreAseguradora=?, DireccionAseguradora=?, TelefonoAseguradora=?, FaxAseguradora=?, EmailAseguradora=? WHERE CodigoAseguradora=" + a.getCodigoAseguradora());
        ps.setString(1, a.getNombreAseguradora());
        ps.setString(2,a.getDireccionAseguradora());
        ps.setString(3,a.getTelefonoAseguradora());
        ps.setString(4,a.getFaxAseguradora());
        ps.setString(5,a.getEmailseguradora());
       
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





