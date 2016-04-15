/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.VehiculoMantenimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan
 */
public class VehiculoMantenimientoBD {
    
    DBRentaCar cb=new DBRentaCar();
    
    public void Insertarmantenimiento(String codmant, String fecha,String estatus, String descripcion,String codvehiculo){
VehiculoMantenimiento vm=new VehiculoMantenimiento();

    cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into mantenimiento values (?,?,?,?,?) ");
ps.setString(1, vm.getCodigomantenimiento());
ps.setString(2, fecha);
ps.setString(3, estatus);
ps.setString(4, descripcion);
ps.setString(5, codvehiculo);




ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(Codigomantenimiento) from mantenimiento");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            vm.setCodigomantenimiento(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    

    
    }
}
    public static VehiculoMantenimiento BuscarMantenimiento(String cod) throws SQLException {
        return BuscarMantenimiento(cod, null);
    }
  
  
    public static VehiculoMantenimiento BuscarMantenimiento(String cod,VehiculoMantenimiento vm) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
       
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from mantenimiento where Codigomantenimiento=?");
        ps.setString(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (vm == null) {
                vm= new VehiculoMantenimiento(){};
            }
            vm.setCodigomantenimiento(cod);
            vm.setCodigoVeh(rs.getInt("vehiculo_CdigoVehiculo"));
            vm.setFecha(rs.getString("FechaInicio"));
            vm.setDescripcion(rs.getString("Comentarios"));
            vm.setEstatusmantenimiento(rs.getString("Status"));
            
            /* CdigoVehiculo
            Codigomantenimiento
FechaInicio
Status
Comentarios
vehiculo_CdigoVehiculo
 PlacaVehiculo
 ColorVehiculo
 FechaIngreso
 SerialCarroceria
 SerialMotor
 KmVehiculo
 Litros
 CodigoStatusVehiculo
 modelovehiculo_CodigoModeloVehiculo
 poliza_CodigoPoliza*/
            
        }
        cb.con.close();
        ps.close();
        return vm;
    }
    
     public static boolean  ActualizarMantenimiento(VehiculoMantenimiento v) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        VehiculoMantenimiento vm=new VehiculoMantenimiento();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE mantenimiento SET status=?,  comentarios=?, vehiculo_CdigoVehiculo=? WHERE Codigomantenimiento=" + v.getCodigomantenimiento());
        ps.setString(1, v.getEstatusmantenimiento());
        ps.setString(2,v.getDescripcion());
        ps.setInt(3,v.getCodigoVeh());
       
        int rowsUpdated = ps.executeUpdate();
        cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
      public ArrayList<VehiculoMantenimiento> mostrarmantenimiento() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<VehiculoMantenimiento> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM mantenimiento ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            
            VehiculoMantenimiento vm=new VehiculoMantenimiento();
            
            vm.setCodigomantenimiento(cb.rs.getString("Codigomantenimiento")); 
            vm.setCodigoVeh(cb.rs.getInt("vehiculo_CdigoVehiculo"));
            vm.setFecha(cb.rs.getString("FechaInicio"));
            vm.setEstatusmantenimiento(cb.rs.getString("Status"));
            vm.setDescripcion(cb.rs.getString("Comentarios"));
            
            lista.add(vm);
            
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
       public ArrayList<VehiculoMantenimiento> mostrarmantenimiento(String cod) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<VehiculoMantenimiento> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM mantenimiento where Codigomantenimiento='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            
            VehiculoMantenimiento vm=new VehiculoMantenimiento();
            
            vm.setCodigomantenimiento(cb.rs.getString("Codigomantenimiento")); 
            vm.setCodigoVeh(cb.rs.getInt("vehiculo_CdigoVehiculo"));
            vm.setFecha(cb.rs.getString("FechaInicio"));
            vm.setEstatusmantenimiento(cb.rs.getString("Status"));
            vm.setDescripcion(cb.rs.getString("Comentarios"));
            
            lista.add(vm);
            
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    } 
}
