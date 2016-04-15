/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;
import Paquete_Clase.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class UsuarioBD {
    String mensaje;
    DBRentaCar cb=new DBRentaCar();
    Usuario u=new Usuario();
  public void insertarEmpleado(String dni,String n, String a,String ced, String tel,String us ,String t, String pass) {
    
  DBRentaCar cb=new DBRentaCar();
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into usuario values (?,?,?,?,?,?,?,?) ");
ps.setString(1, u.getCodigousuario());
ps.setString(2, n);
ps.setString(3, a);
ps.setString(4, ced);
ps.setString(5, tel);
ps.setString(6, us);
ps.setString(7, t);
ps.setString(8, pass);
ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(codigousuario) from usuario");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            u.setCodigousuario(lastID);
        }

JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
//cb.cerrarConexion();
}


    }

 public ArrayList<Usuario> mostrarUsuario() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Usuario> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM Usuario ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Usuario pp=new Usuario();
            pp.setCodigousuario(cb.rs.getString("codigousuario"));
            pp.setNombre(cb.rs.getString("nombreusuario"));
            pp.setApellido(cb.rs.getString("apellidousuario"));
            pp.setCedula(cb.rs.getString("cedulausuario"));
            pp.setTelefono(cb.rs.getString("telefonousuario"));
            pp.setTipoUsuario(cb.rs.getString("tipousuario"));
            pp.setUsuario(cb.rs.getString("usuario"));
            
            pp.setPasswork(cb.rs.getString("ContraseñaUsuario"));
            lista.add(pp);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
 public  ArrayList<Usuario> porcodigo(String cod) throws SQLException{
 
 cb.abrirConexion(); 
        ArrayList<Usuario> listacod = new ArrayList<>();
        PreparedStatement ps = null;
        
      

        
            ps = cb.con.prepareStatement("SELECT * FROM Usuario where codigousuario='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Usuario pp=new Usuario();
            pp.setCodigousuario(cb.rs.getString("codigousuario"));
            pp.setNombre(cb.rs.getString("nombreusuario"));
            pp.setApellido(cb.rs.getString("apellidousuario"));
            pp.setCedula(cb.rs.getString("cedulausuario"));
            pp.setTelefono(cb.rs.getString("telefonousuario"));
            pp.setTipoUsuario(cb.rs.getString("tipousuario"));
            pp.setUsuario(cb.rs.getString("usuario"));
            pp.setPasswork(cb.rs.getString("ContraseñaUsuario"));
             //JOptionPane.showMessageDialog(null, pp.getNombre());
          listacod.add(pp);
        }
        
      
    
    cb.con.close();
   ps.close();

return listacod;
 
 
 }

 public static Usuario BuscarUsuario(String cod) throws SQLException {
        return BuscarUsuario(cod, null);
    }
  
  
    public static Usuario BuscarUsuario(String codusuario,Usuario u) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from Usuario where codigousuario=?");
        ps.setString(1, codusuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario(){};
            }
            u.setCodigousuario(codusuario);
            u.setNombre(rs.getString("nombreusuario"));
            u.setApellido(rs.getString("apellidousuario"));
            u.setCedula(rs.getString("cedulausuario"));
            u.setTelefono(rs.getString("telefonousuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setTipoUsuario(rs.getString("tipousuario"));
            u.setPasswork(rs.getString("contraseñausuario"));
            
            //p.setTel(rs.getString("telefono"));
            
        }
        cb.con.close();
        ps.close();
        return u;
    }

 public static boolean  ActualizarUsuario(Usuario u) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE usuario SET nombreusuario=?, apellidousuario=?, cedulausuario=?, telefonousuario=?, usuario=?, contraseñausuario=?, tipousuario=? WHERE codigousuario=" + u.getCodigousuario());
        ps.setString(1, u.getNombre());
        ps.setString(2,u.getApellido());
        ps.setString(3,u.getCedula());
        ps.setString(4,u.getTelefono());
        ps.setString(5,u.getUsuario());
        ps.setString(6,u.getPasswork());
        ps.setString(7, u.getTipoUsuario());
        int rowsUpdated = ps.executeUpdate();
        cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
 
 public static Usuario obtenerUsuario(String cod) throws SQLException {
        return obtenerUsuario(cod, null);
    }
  
  
    public static Usuario obtenerUsuario(String user,Usuario u) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from Usuario where usuario=?");
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario(){};
            }
            u.setCodigousuario("codigousuario");
            u.setNombre(rs.getString("nombreusuario"));
            u.setApellido(rs.getString("apellidousuario"));
            u.setCedula(rs.getString("cedulausuario"));
            u.setTelefono(rs.getString("telefonousuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setTipoUsuario(rs.getString("tipousuario"));
            u.setPasswork(rs.getString("contraseñausuario"));
            
            //p.setTel(rs.getString("telefono"));
            
        }
        cb.con.close();
        ps.close();
        return u;
    }

 
 
 }


