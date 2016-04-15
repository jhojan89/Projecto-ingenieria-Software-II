/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.Chofer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class ChoferBD {

   
    DBRentaCar cb=new DBRentaCar();
    Chofer ch=new Chofer();
    public void AgregarChofer(String codChof,String cedChof,String nomChof,String apellChof,int edadChof ,String licChof,int catlicChof,
            String dirChof,String telChof,String emailChof){
    
    
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into conductor values (?,?,?,?,?,?,?,?,?,?) ");
ps.setString(1, ch.getCodigoChofer());
ps.setString(2, cedChof);
ps.setString(3, nomChof);
ps.setString(4,apellChof);
ps.setInt(5, edadChof);
ps.setString(6, licChof);
ps.setInt(7, catlicChof);
ps.setString(8,dirChof );
ps.setString(9, telChof);
ps.setString(10, emailChof);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigoConductor) from conductor");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            ch.setCodigoChofer(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}
catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
  
    
    
    }
    
    }
public ArrayList<Chofer> mostrarChofer() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Chofer> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM conductor ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
       
            ch.setCodigoChofer(cb.rs.getString("codigoconductor"));
            ch.setNombreChofer(cb.rs.getString("nombreconductor"));
            ch.setApellidoChofer(cb.rs.getString("apellidoconductor"));
            ch.setCedulaChofer(cb.rs.getString("cedulaconductor"));
            ch.setTelefonoChofer(cb.rs.getString("telefonoconductor"));
            ch.setEdadChofer(cb.rs.getInt("edad"));
            ch.setLicenciaCoonducirChofer(cb.rs.getString("licenciaconductor"));
            ch.setCategorialicenciaChofer(cb.rs.getInt("Categorialicencia"));
            ch.setDireccionChofer(cb.rs.getString("direccionconductor"));
            ch.setTelefonoChofer(cb.rs.getString("TelefonoConductor"));
            ch.setEmailChofer(cb.rs.getString("emailconductor"));
            
           
            lista.add(ch);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
public  ArrayList<Chofer> MostrarChofercod(String cod) throws SQLException{
 Chofer chf=new Chofer();
  cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Chofer> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("select *from conductor where codigoconductor='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
     
            chf.setCodigoChofer(cb.rs.getString("codigoconductor"));
            chf.setNombreChofer(cb.rs.getString("nombreconductor"));
            chf.setApellidoChofer(cb.rs.getString("apellidoconductor"));
            chf.setCedulaChofer(cb.rs.getString("cedulaconductor"));
            chf.setTelefonoChofer(cb.rs.getString("telefonoconductor"));
            chf.setEdadChofer(cb.rs.getInt("edad"));
            chf.setLicenciaCoonducirChofer(cb.rs.getString("licenciaconductor"));
            chf.setCategorialicenciaChofer(cb.rs.getInt("Categorialicencia"));
            chf.setDireccionChofer(cb.rs.getString("direccionconductor"));
            chf.setTelefonoChofer(cb.rs.getString("TelefonoConductor"));
            chf.setEmailChofer(cb.rs.getString("emailconductor"));
            
           
            lista.add(chf);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
 public  ArrayList<Chofer> MostrarChofercedula(String ced) throws SQLException{
 Chofer chf1=new Chofer();
  cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Chofer> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("select *from conductor where cedulaconductor='"+ced +"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
        
            chf1.setCodigoChofer(cb.rs.getString("codigoconductor"));
            chf1.setNombreChofer(cb.rs.getString("nombreconductor"));
            chf1.setApellidoChofer(cb.rs.getString("apellidoconductor"));
            chf1.setCedulaChofer(cb.rs.getString("cedulaconductor"));
            chf1.setTelefonoChofer(cb.rs.getString("telefonoconductor"));
            chf1.setEdadChofer(cb.rs.getInt("edad"));
           chf1.setLicenciaCoonducirChofer(cb.rs.getString("licenciaconductor"));
           chf1.setCategorialicenciaChofer(cb.rs.getInt("Categorialicencia"));
           chf1.setDireccionChofer(cb.rs.getString("direccionconductor"));
           chf1.setTelefonoChofer(cb.rs.getString("TelefonoConductor"));
            chf1.setEmailChofer(cb.rs.getString("emailconductor"));
            
           
            lista.add(chf1);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
 public static Chofer BuscarChofer(String cod) throws SQLException {
        return BuscarChofer(cod, null);
    }
 

   public static Chofer BuscarChofer(String codusuario,Chofer u) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from conductor where codigoconductor=?");
        ps.setString(1, codusuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Chofer(){};
            }
             u.setCodigoChofer(rs.getString("codigoconductor"));
            u.setNombreChofer(rs.getString("nombreconductor"));
            u.setApellidoChofer(rs.getString("apellidoconductor"));
            u.setCedulaChofer(rs.getString("cedulaconductor"));
            u.setTelefonoChofer(rs.getString("telefonoconductor"));
            u.setEdadChofer(rs.getInt("edad"));
           u.setLicenciaCoonducirChofer(rs.getString("licenciaconductor"));
           u.setCategorialicenciaChofer(rs.getInt("Categorialicencia"));
           u.setDireccionChofer(rs.getString("direccionconductor"));
           u.setTelefonoChofer(rs.getString("TelefonoConductor"));
            u.setEmailChofer(rs.getString("emailconductor"));
            
            //p.setTel(rs.getString("telefono"));
            
        }
        cb.con.close();
        ps.close();
        return u; //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean ActualizarChofer(Chofer ch)throws SQLException { //To change body of generated methods, choose Tools | Templates.
    DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE conductor SET nombreconductor=?, apellidoconductor=?, cedulaconductor=?, telefonoconductor=?,"
                + " licenciaconductor=?, Categorialicencia=?, telefonoconductor=?, direccionconductor=?, emailconductor=? WHERE codigoconductor=" + ch.getCodigoChofer());
        ps.setString(1, ch.getNombreChofer());
        ps.setString(2,ch.getApellidoChofer());
        ps.setString(3,ch.getCedulaChofer());
        ps.setString(4,ch.getTelefonoChofer());
        ps.setString(5,ch.getLicenciaCoonducirChofer());
        ps.setString(6,String.valueOf(ch.getCategorialicenciaChofer()));
        ps.setString(7, String.valueOf(ch.getEdadChofer()));
        ps.setString(8, ch.getDireccionChofer());
        ps.setString(9, ch.getEmailChofer());
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



