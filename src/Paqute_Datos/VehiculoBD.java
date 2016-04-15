/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqute_Datos;

import Paquete_Clase.Aseguradora;
import Paquete_Clase.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhojan89
 */
public class VehiculoBD {
    Vehiculo vh=new Vehiculo();
   
    DBRentaCar cb=new DBRentaCar();
    Aseguradora as=new Aseguradora();
    public void InsertarVehiculos(int cod,String plaveh,String colveh,int año,String fechveh,String serialcarveh,String serialmotveh,
            int kmveh,float litveh,String cogstatuveh,String codmodeloveh,String codpolizaveh,String img){
       
   cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into vehiculo values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
ps.setInt(1, vh.getCodigoVeh());
ps.setString(2, plaveh);
ps.setString(3,colveh);
ps.setInt(4, año);
ps.setString(5, fechveh);
ps.setString(6, serialcarveh);
ps.setString(7, serialmotveh);
ps.setInt(8, kmveh);
ps.setFloat(9, litveh);
ps.setString(10, cogstatuveh);
ps.setString(11, codmodeloveh);
ps.setString(12, codpolizaveh);
ps.setString(13, img);


ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CdigoVehiculo) from vehiculo");
        cb.rs = ps.executeQuery();
        if (cb.rs.next()) {
            int lastID = cb.rs.getInt(1);
            vh.setCodigoVeh(lastID);
        }
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
    
    
    }
}
    
  public void insertarMarca(String codmarca, String marca){     
           cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into marcavehiculo values (?,?) ");
ps.setString(1, vh.getMarca());
ps.setString(2, marca);



ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigomarcaVehiculo) from marcaVehiculo");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            vh.setCodigoMarca(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
}
    
}
    
  public void insertarclase(String codclase,String des, double costodiario, double costoprot){
  
             cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into clasevehiculo values (?,?,?,?) ");
ps.setString(1, vh.getCodigoClase());
ps.setString(2, des);
ps.setDouble(3, costodiario);
ps.setDouble(4, costoprot);

ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigoClaseVehiculo) from claseVehiculo");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            vh.setCodigoClase(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
}
  
  
  
  }
  public void Insertarmodelo(String codmodelo, String modelo, String codmarca,String codclase){
  
  
     cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into modelovehiculo values (?,?,?,?) ");
ps.setString(1, vh.getCodigoModelo());
ps.setString(2, modelo);
ps.setString(3,codmarca);
ps.setString(4, codclase);




ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigomodeloVehiculo) from modeloVehiculo");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            vh.setCodigoModelo(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
}
}
public void InsertarEstatusVehiculo(String codEstatus,String Estatus){


    cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into statusvehiculo values (?,?) ");
ps.setString(1, codEstatus);
ps.setString(2, Estatus);





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

 
  public void InsertarObservaciones(String codobserbacion,String fecha,String micas, String tracapalanca,String radio,String placa
    ,String gato,String cono,String triangulo,String espejos, String faros ,String cerradura,String vateria, String observaciones, String codvehiculo){
    
       cb.abrirConexion();   
try {
    
   
   //Connection cn = null;
PreparedStatement ps = cb.con.prepareStatement(
"insert into controlvehiculo values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
ps.setString(1, vh.getCodigoobservaciones());
ps.setString(2, fecha);
ps.setString(3, micas);
ps.setString(4, tracapalanca);
ps.setString(5, radio);
ps.setString(6, placa);
ps.setString(7, gato);
ps.setString(8, cono);
ps.setString(9, triangulo);
ps.setString(10, espejos);
ps.setString(11, faros);
ps.setString(12, cerradura);
ps.setString(13, vateria);
ps.setString(14, observaciones);
ps.setString(15, codvehiculo);
ps.executeUpdate();
        ps = cb.con.prepareStatement("select max(CodigocontrolVehiculo) from controlVehiculo");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            vh.setCodigoobservaciones(lastID);}
 JOptionPane.showMessageDialog(null,"Datos Insertados ");
}catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error al Insertar Datos ");
    
}

      
}
  public ArrayList<Vehiculo> mostrarVehiculo() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM vehiculo ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo v=new Vehiculo();
            
            //VehiculoModelo vm=new VehiculoModelo();
            v.setCodigoVeh(cb.rs.getInt("CodigoVehiculo"));
            v.setPlacaVeh(cb.rs.getString("placavehiculo"));
            v.setColorVeh(cb.rs.getString("colorvehiculo"));
            v.setAño(cb.rs.getInt("añovehiculo"));
            v.setFechaIngresoVeh(cb.rs.getString("FechaIngreso"));
            v.setSerialCarroseriaVeh(cb.rs.getString("SerialCarroceria"));
            v.setSerialmotorVeh(cb.rs.getString("SerialMotor"));
            v.setKilometrajeVeh(cb.rs.getInt("KmVehiculo"));
            v.setLitrosVeh(cb.rs.getFloat("Litros"));
            v.setCodigoEstatus(cb.rs.getString("CodigoStatusVehiculo"));
            v.setCodigoModelo(cb.rs.getString("modelovehiculo_CodigoModeloVehiculo"));
            v.setCodigoPoliza(cb.rs.getString("poliza_CodigoPoliza"));
            lista.add(v);
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
  public ArrayList<Vehiculo> mostrarVehiculoMatricula(String placa) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM vehiculo where PlacaVehiculo='"+placa+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo v=new Vehiculo();
            Aseguradora a=new Aseguradora();
           Vehiculo vm=new Vehiculo();
            v.setCodigoVeh(cb.rs.getInt("CodigoVehiculo"));
            v.setPlacaVeh(cb.rs.getString("placavehiculo"));
            v.setColorVeh(cb.rs.getString("colorvehiculo"));
            v.setAño(cb.rs.getInt("añovehiculo"));
            v.setFechaIngresoVeh(cb.rs.getString("FechaIngreso"));
            v.setSerialCarroseriaVeh(cb.rs.getString("SerialCarroceria"));
            v.setSerialmotorVeh(cb.rs.getString("SerialMotor"));
            v.setKilometrajeVeh(cb.rs.getInt("KmVehiculo"));
            v.setLitrosVeh(cb.rs.getFloat("Litros"));
            v.setCodigoEstatus(cb.rs.getString("CodigoStatusVehiculo"));
            vm.setCodigoModelo(cb.rs.getString("modelovehiculo_CodigoModeloVehiculo"));
            a.setCodigoPoliza(cb.rs.getString("poliza_CodigoPoliza"));
            lista.add(v);
            
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
   public ArrayList<Vehiculo> mostrarVehiculocod(String chasis) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM vehiculo where SerialCarroceria='"+chasis+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo v=new Vehiculo();
            Aseguradora a=new Aseguradora();
            v.setCodigoVeh(cb.rs.getInt("CodigoVehiculo"));
            v.setPlacaVeh(cb.rs.getString("placavehiculo"));
            v.setColorVeh(cb.rs.getString("colorvehiculo"));
            v.setAño(cb.rs.getInt("añovehiculo"));
            v.setFechaIngresoVeh(cb.rs.getString("FechaIngreso"));
            v.setSerialCarroseriaVeh(cb.rs.getString("SerialCarroceria"));
            v.setSerialmotorVeh(cb.rs.getString("SerialMotor"));
            v.setKilometrajeVeh(cb.rs.getInt("KmVehiculo"));
            v.setLitrosVeh(cb.rs.getFloat("Litros"));
            v.setCodigoEstatus(cb.rs.getString("CodigoStatusVehiculo"));
            v.setCodigoModelo(cb.rs.getString("modelovehiculo_CodigoModeloVehiculo"));
            a.setCodigoPoliza(cb.rs.getString("poliza_CodigoPoliza"));
            lista.add(v);
            
        }
        
      
    
    cb.con.close();
   ps.close();
   return lista; 
    }
    public static Vehiculo BuscarVehiculo(int cod) throws SQLException {
        return BuscarVehiculo(cod, null);
    }
  
  
    public static Vehiculo BuscarVehiculo(int codvehiculo,Vehiculo v) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
       Vehiculo vm=new Vehiculo();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from Vehiculo where CodigoVehiculo=?");
        ps.setInt(1, codvehiculo);
        
        
        
        
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (v == null) {
                v= new Vehiculo(){};
            }
            Aseguradora a=new Aseguradora();
            v.setCodigoVeh(codvehiculo);
            v.setPlacaVeh(rs.getString("PlacaVehiculo"));
            v.setSerialCarroseriaVeh(rs.getString("SerialCarroceria"));
            v.setSerialmotorVeh(rs.getString("SerialMotor"));
            v.setColorVeh(rs.getString("ColorVehiculo"));
            v.setAño(rs.getInt("añovehiculo"));
            v.setCodmodelo(rs.getString("modelovehiculo_CodigoModeloVehiculo"));
            v.setKilometrajeVeh(rs.getInt("KmVehiculo"));
            v.setLitrosVeh(rs.getInt("Litros"));
            v.setCodigoPoliza(rs.getString("poliza_CodigoPoliza"));
            v.setCodigoEstatus(rs.getString("CodigoStatusVehiculo"));
            v.setFechaIngresoVeh(rs.getString("FechaIngreso"));
            v.setImagen(rs.getString("imagen"));
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
        return v;
    }

    public static boolean  ActualizarVehiculo(Vehiculo v) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        Vehiculo vm=new Vehiculo();
        Aseguradora a=new Aseguradora();
        //Cliente c=new Cliente();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE Vehiculo SET PlacaVehiculo=?,  SerialCarroceria=?, SerialMotor=?, ColorVehiculo=?, añovehiculo=?, modelovehiculo_CodigoModeloVehiculo=?, poliza_CodigoPoliza=?, KmVehiculo=?, Litros=?, FechaIngreso=?, CodigoStatusVehiculo=?   WHERE CdigoVehiculo=" + v.getCodigoVeh());
        ps.setString(1, v.getPlacaVeh());
        ps.setString(2,v.getSerialCarroseriaVeh());
        ps.setString(3,v.getSerialmotorVeh());
        ps.setString(4,v.getColorVeh());
        ps.setInt(5, v.getAño());
        ps.setString(6,vm.getCodigoModelo());
        ps.setString(7,v.getCodigoPoliza());
        ps.setString(8, String.valueOf(v.getKilometrajeVeh()));
        ps.setString(9, String.valueOf(v.getLitrosVeh()));
        ps.setString(10, v.getFechaIngresoVeh());
        ps.setString(11, v.getCodigoEstatus());
        ps.setString(12, v.getImagen());
        int rowsUpdated = ps.executeUpdate();
        cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static Vehiculo BuscarVehiculoEstatus(String cod) throws SQLException {
        return BuscarVehiculoEstatus(cod, null);
    }
  
  
    public static Vehiculo BuscarVehiculoEstatus(String cod,Vehiculo v) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
       Vehiculo vm=new Vehiculo();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from statusvehiculo where CodigoStatusVehiculo=?");
        ps.setString(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (v == null) {
                v= new Vehiculo(){};
            }
            v.setCodigoEstatus(cod);
            v.setEstatus(rs.getString("StatusVehiculo"));
            
            /* CdigoVehiculo
            CodigoStatusVehiculo
StatusVehiculo
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
        return v;
    }
    public static Vehiculo BuscarModeloVehiculo(String cod) throws SQLException {
        return BuscarModeloVehiculo(cod, null);
    }
  
  
    public static Vehiculo BuscarModeloVehiculo(String cod, Vehiculo vc) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("SELECT * FROM ModeloVehiculo where CodigoModeloVehiculo=?");
        ps.setString(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (vc == null) {
                vc = new Vehiculo(){};
            }
            vc.setCodigoModelo(cod);
            vc.setCodigoMarca(rs.getString("marcavehiculo_CodigoMarcaVehiculo"));
            vc.setCodigoClase(rs.getString("clasevehiculo_CodigoClaseVehiculo"));
            vc.setModelo(rs.getString("ModeloVehiculo"));
           
           
            /*CodigoClaseVehic
Descripcion
CostoDiario
CostoProteccion*/
            
        }
        cb.con.close();
        ps.close();
        return vc;
    }
     public ArrayList<Vehiculo> mostrarVehiculoModelo() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM ModeloVehiculo ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo v=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            v.setCodigoModelo(cb.rs.getString("CodigoModeloVehiculo"));
            v.setCodigoMarca(cb.rs.getString("marcavehiculo_CodigoMarcaVehiculo"));
            v.setCodigoClase(cb.rs.getString("clasevehiculo_CodigoClaseVehiculo"));
            v.setModelo(cb.rs.getString("ModeloVehiculo"));
            
            lista.add(v);
        }
        
       



    
    cb.con.close();
   ps.close();
   return lista; 
     }
      public ArrayList<Vehiculo> mostrarVehiculoModelo_codigo(String cod) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM ModeloVehiculo where CodigoModeloVehiculo='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo v=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            v.setCodigoModelo(cb.rs.getString("CodigoModeloVehiculo"));
            v.setCodigoMarca(cb.rs.getString("marcavehiculo_CodigoMarcaVehiculo"));
            v.setCodigoClase(cb.rs.getString("clasevehiculo_CodigoClaseVehiculo"));
            v.setModelo(cb.rs.getString("ModeloVehiculo"));
            
            lista.add(v);
        }
         
    cb.con.close();
   ps.close();
   return lista;}
     public static boolean actualizarVehiculoModelo( Vehiculo vm) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE modelovehiculo SET ModeloVehiculo=?, marcavehiculo_CodigoMarcaVehiculo=?, clasevehiculo_CodigoClaseVehiculo=? WHERE CodigoModeloVehiculo=" + vm.getCodigoModelo());
        ps.setString(1, vm.getModelo());
        ps.setString(2,vm.getCodigoMarca());
        ps.setString(3,vm.getCodigoClase());
        int rowsUpdated = ps.executeUpdate();
       cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Vehiculo BuscarMarca(String cod) throws SQLException {
        return BuscarMarca(cod, null);
    }
  
  
    public static Vehiculo BuscarMarca(String codmarca,Vehiculo vm) throws SQLException {
       DBRentaCar cb=new DBRentaCar();
      
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select *from marcavehiculo where codigomarcavehiculo =?");
        ps.setString(1, codmarca);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (vm == null) {
                vm= new Vehiculo(){};
            }
            vm.setCodigoMarca(codmarca);
            vm.setMarca(rs.getString("NombreMarcaVehiculocol"));
            
       
            
        }
        cb.con.close();
        ps.close();
        return vm;
    }   
     public ArrayList<Vehiculo> mostrarVehiculoMarca() throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM marcavehiculo ");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo m=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            
            m.setCodigoMarca(cb.rs.getString("CodigoMarcaVehiculo"));
            m.setMarca(cb.rs.getString("NombreMarcaVehiculocol"));
            
            lista.add(m);
        }
        
       



    
    cb.con.close();
   ps.close();
   return lista; 
     } 
     public ArrayList<Vehiculo> mostrarVehiculoMarcaCodigo(String cod) throws SQLException{
        
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("select * from marcavehiculo where codigomarcavehiculo ='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo m=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            
            m.setCodigoMarca(cb.rs.getString("CodigoMarcaVehiculo"));
            m.setMarca(cb.rs.getString("NombreMarcaVehiculocol"));
            
            lista.add(m);
        }
        
    
    cb.con.close();
   ps.close();
   return lista; 
     } 
     public static boolean actualizarmarca( Vehiculo vma) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE marcavehiculo SET NombreMarcaVehiculocol=? WHERE CodigoMarcaVehiculo=" + vma.getCodigoMarca());
        ps.setString(1, vma.getMarca());
        int rowsUpdated = ps.executeUpdate();
       cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
     
      public static Vehiculo BuscarClaseVehiculo(String cod) throws SQLException {
        return BuscarClaseVehiculo(cod, null);
    }
  
  
    public static Vehiculo BuscarClaseVehiculo(String codClase, Vehiculo vc) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;
        ps = cb.con.prepareStatement("select * from clasevehiculo where CodigoClaseVehiculo=?");
        ps.setString(1, codClase);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (vc == null) {
                vc = new Vehiculo(){};
            }
            vc.setCodigoClase(codClase);
            vc.setCodigoClase(rs.getString("Descripcion"));
            vc.setCostoDiario(rs.getDouble(String.valueOf("CostoDiario")));
            vc.setCostoProteccion(rs.getDouble(String.valueOf("CostoProteccion")));
            /*CodigoClaseVehic
Descripcion
CostoDiario
CostoProteccion*/
            
        }
        cb.con.close();
        ps.close();
        return vc;
    }
    public static boolean actualizarVehiculoClase( Vehiculo vc2) throws SQLException {
        DBRentaCar cb=new DBRentaCar();
        cb.abrirConexion();
        PreparedStatement ps = null;

        ps = cb.con.prepareStatement("UPDATE clasevehiculo SET Descripcion=?, CostoDiario=?, CostoProteccion=? WHERE CodigoClaseVehiculo=" + vc2.getCodigoClase());
        ps.setString(1, vc2.getCodigoClase());
        ps.setString(2,String.valueOf(vc2.getCostoDiario()));
        ps.setString(3,String.valueOf(vc2.getCostoProteccion()));
        int rowsUpdated = ps.executeUpdate();
       cb.con.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
     public ArrayList<Vehiculo> mostrarVehiculoClase() throws SQLException{
        DBRentaCar cb=new DBRentaCar();
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("SELECT * FROM Clasevehiculo ");
        
            
        
        cb.rs = ps.executeQuery();
        //ResultSet rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo vc4=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            
            vc4.setCodigoClase(cb.rs.getString("CodigoClaseVehiculo"));
            
            vc4.setCodigoClase(cb.rs.getString("Descripcion"));
            vc4.setCostoDiario(cb.rs.getDouble(String.valueOf("CostoDiario")));
            vc4.setCostoProteccion(cb.rs.getDouble(String.valueOf("CostoProteccion")));
            lista.add(vc4);
        }
        
       



    
    cb.con.close();
   ps.close();
   return lista; 
     } 
      public ArrayList<Vehiculo> mostrarVehiculoClaseCodigo(String cod) throws SQLException{
        DBRentaCar cb=new DBRentaCar();
       cb.abrirConexion(); 
       
        PreparedStatement ps = null;
        
        ArrayList<Vehiculo> lista = new ArrayList<>();

        
            ps = cb.con.prepareStatement("select * from clasevehiculo where CodigoClaseVehiculo='"+cod+"'");
        
            
        
        cb.rs = ps.executeQuery();
        //ResultSet rs = ps.executeQuery();
        while (cb.rs.next()) {
            Vehiculo vc5=new Vehiculo();
            //VehiculoModelo vm=new VehiculoModelo();
            
            vc5.setCodigoClase(cb.rs.getString("CodigoClaseVehiculo"));
            
            vc5.setCodigoClase(cb.rs.getString("Descripcion"));
            vc5.setCostoDiario(cb.rs.getDouble(String.valueOf("CostoDiario")));
            vc5.setCostoProteccion(cb.rs.getDouble(String.valueOf("CostoProteccion")));
            lista.add(vc5);
        }
        
       



    
    cb.con.close();
   ps.close();
   return lista; 
     } 
}

    
    

