/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.Alquiler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class AlquilerBD {
    
    Alquiler alq=new Alquiler();
    
    public void InsertarAlquiler(String codalquiler,String codcliente ,String fecha, String fecharetorno, String tipoproteccion,String acesorio,
            double costodiario,String esreserva, String codclasevehiculo,String codVehiculo,String codconductor){
    
     DBRentaCar cb=new DBRentaCar();
     
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into alquiler values (?,?,?,?,?,?,?,?,?,?,?) ");
ps.setString(1, alq.getCodigoalquiler());
ps.setString(2, codcliente);
ps.setString(3,fecha);
ps.setString(4, fecharetorno);
ps.setString(5, tipoproteccion);
ps.setString(6, acesorio);
ps.setDouble(7, costodiario);
ps.setString(8, esreserva);
ps.setString(9, codclasevehiculo);
ps.setString(10, codVehiculo);
ps.setString(11, codconductor);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigoAlquiler) from alquiler");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            alq.setCodigoalquiler(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
 cb.con.close();
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
  
    
    }
    
    
    
    
    
    
    }
    public void insertarFactura(int codfactura,double monto,String fecha,String Descripcion,String codAlquiler){
         DBRentaCar cb=new DBRentaCar();
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into facturas values (?,?,?,?,?) ");
ps.setInt(1, codfactura);
ps.setDouble(2, monto);
ps.setString(3,fecha);
ps.setString(4, Descripcion);
ps.setString(5, codAlquiler);



//En este caso, el método executeUpdate devuelve la cantidad de
//elementos insertados.
//JOptionPane.showMessageDialog(null,"Datos Insertados ");
if (ps.executeUpdate()!=1)
throw new Exception("Error en la Inserción ");
//cb.cerrarConexion();
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");

}
    
    }
    
    public ArrayList<Alquiler> mostrarAlquiler() throws SQLException{
        DBRentaCar cb=new DBRentaCar();
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Alquiler> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM Alquiler ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
          Alquiler  v=new Alquiler();
            //VehiculoModelo vm=new VehiculoModelo();
            v.setCodigoalquiler(cb.rs.getString("CodigoAlquiler"));
            v.setCodigocliente(cb.rs.getString("cliente_CodigoCliente"));
            v.setFecha(cb.rs.getString("FechaSalida"));
            v.setFecharetorno(cb.rs.getString("FechaRetorno"));
            v.setTipoproteccion(cb.rs.getString("TipoProteccion"));
            v.setAcesorio(cb.rs.getString("ProteccionRoboAcesorios"));
            v.setCostodiario(Double.valueOf(cb.rs.getString("CostoDiario")));
            v.setEsreserva(cb.rs.getString("EsReserva"));
            v.setCodigoClasevehiculo(cb.rs.getString("clasevehiculo_CodigoClaseVehiculo"));
            v.setCodigoVehiculo(cb.rs.getString("vehiculo_CdigoVehiculo"));
            v.setCodigoConductor(cb.rs.getString("conductor_CodigoConductor"));
          
            lista.add(v);
        }
        
      /*
 CodigoAlquiler
 cliente_CodigoCliente
 FechaSalida
 FechaRetorno
 TipoProteccion
 ProteccionRoboAcesorios
 CostoDiario
 EsReserva
 clasevehiculo_CodigoClaseVehiculo
 vehiculo_CdigoVehiculo
 conductor_CodigoConductor */
        
    
    cb.con.close();
   ps.close();
   return lista; 
    }
     public static Alquiler BuscarAlquiler(String cod) throws SQLException {
        return BuscarAlquiler(cod, null);
    }
  
  
    public static Alquiler BuscarAlquiler(String cod,Alquiler a) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
       //Alquiler a=new Alquiler();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from alquiler where CodigoAlquiler=?");
        ps.setString(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (a == null) {
                a= new Alquiler(){};
            }
            
            a.setCodigoalquiler(cod);
            a.setCodigocliente(rs.getString("cliente_CodigoCliente"));
            a.setFecha(rs.getString("FechaSalida"));
            a.setFecharetorno(rs.getString("FechaRetorno"));
            a.setTipoproteccion(rs.getString("TipoProteccion"));
            a.setAcesorio(rs.getString("ProteccionRoboAcesorios"));
            a.setCostodiario(Double.valueOf(rs.getString("CostoDiario")));
            a.setEsreserva(rs.getString("EsReserva"));
            a.setCodigoClasevehiculo(rs.getString("clasevehiculo_CodigoClaseVehiculo"));
            a.setCodigoVehiculo(rs.getString("vehiculo_CdigoVehiculo"));
            a.setCodigoConductor(rs.getString("conductor_CodigoConductor"));
            /* CdigoVehiculo
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
        return a;
    }
     public static boolean  ActualizarAlquiler(Alquiler ac) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
       
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;
        /*
        
         CodigoAlquiler
 cliente_CodigoCliente
 FechaSalida
 FechaRetorno
 TipoProteccion
 ProteccionRoboAcesorios
 CostoDiario
 EsReserva
 clasevehiculo_CodigoClaseVehiculo
 vehiculo_CdigoVehiculo
 conductor_CodigoConductor
        
        
        
        */

        ps = cb.con.prepareStatement("UPDATE alquiler SET cliente_CodigoCliente=?,  vehiculo_CdigoVehiculo=?, clasevehiculo_CodigoClaseVehiculo=?, conductor_CodigoConductor=?, FechaSalida=?, FechaRetorno=?, TipoProteccion=?, CostoDiario=?, ProteccionRoboAcesorios=?  WHERE CodigoAlquiler=" + ac.getCodigoalquiler());
        ps.setString(1,ac.getCodigocliente());
        ps.setString(2,ac.getCodigoVehiculo());
        ps.setString(3,ac.getCodigoClasevehiculo());
        ps.setString(4,ac.getCodigoConductor());
        ps.setString(5,ac.getFecha());
        ps.setString(6,ac.getFecharetorno());
        ps.setString(7,ac.getTipoproteccion());
        ps.setString(8,String.valueOf(ac.getCostodiario()));
        ps.setString(9,ac.getAcesorio());
       // ps.setString(10,ac.getEsreserva());
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
