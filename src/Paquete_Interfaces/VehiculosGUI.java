/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete_Interfaces;

import Otros.metodos;
import Otros.mipanel;
import Paquete_Clase.Aseguradora;
import Paqute_Datos.VehiculoBD;
import Paquete_Clase.Vehiculo;

import Paquete_Clase.VehiculoMantenimiento;


import Paqute_Datos.VehiculoMantenimientoBD;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhojan89
 */
public class VehiculosGUI extends javax.swing.JFrame {
    Vehiculo vehm=new Vehiculo();
     Vehiculo marca=new Vehiculo();
     Vehiculo veh=new Vehiculo();
    Vehiculo vehc=new Vehiculo();
    VehiculoBD vehbd=new VehiculoBD();
    Aseguradora a=new Aseguradora();
    int cod;
    /**
     * Creates new form Registrar_Vehiculos
     */
    public VehiculosGUI() {
        initComponents();
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        Status.setVisible(false);
        jPanel5.setVisible(false);
      
        
    }
    
    public void BuscarVehiculo(){
   Vehiculo v = null;     
try {
   
            v= VehiculoBD.BuscarVehiculo(cod=Integer.parseInt(jTecodveh.getText()));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (v != null) {try{
            jTecodveh.setText(String.valueOf(v.getCodigoVeh()));
            jTexplaca.setText(v.getPlacaVeh());
            jTexcarroseria.setText(v.getSerialCarroseriaVeh());
            jTexserialmotor.setText(v.getSerialmotorVeh());
            jTexcolor.setText(v.getColorVeh());
            jTexcodmodelo.setText(v.getCodmodelo());
            jTekm.setText(String.valueOf(v.getKilometrajeVeh()));
            jTelitro.setText(String.valueOf(v.getLitrosVeh()));
            jTecodpoliza.setText(v.getCodigoPoliza());
            jTecodestatus.setText(v.getCodigoEstatus());
            jTefechaingreso.setText(v.getFechaIngresoVeh());
           URL url = new URL(v.getImagen());
                m.setObtener(url);
                m.Mostrar(jPanelimg);
        jButtactualizarv.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        }catch (MalformedURLException ex) {
                Logger.getLogger(VehiculosGUI.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        }else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtactualizarv.setEnabled(false);
            jTecodveh.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodveh.setEditable(true);
            }}
    public void BuscarVehiculomodelo(){
        
try {
  
            vehm= VehiculoBD.BuscarModeloVehiculo(jTecodmodelo.getText());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (vehm != null) {
            jTecodmodelo.setText(String.valueOf(vehm.getCodigoModelo()));
            jTemodelo.setText(vehm.getModelo());
            jTexcodmarca.setText(vehm.getCodigoMarca());
            jTexcodclase.setText(vehm.getCodigoClase());
           
        jButtactualizarv.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        
        
        }

        else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtactualizarv.setEnabled(false);
            jTecodveh.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodveh.setEditable(true);
            }}
    public void BuscarMarca(){
       
    try {
  
            marca= VehiculoBD.BuscarMarca(jTcodMarca.getText());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (marca != null) {
            jTcodMarca.setText(String.valueOf(marca.getCodigoMarca()));
            jTfemarca.setText(marca.getMarca());
            
           
        jButtactualizarv.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        
        
        }

        else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtactualizarv.setEnabled(false);
            jTecodveh.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodveh.setEditable(true);
        }
    
    }
public void BuscarVehiculoClase(){
    Vehiculo vc1=new Vehiculo();
try {
            vc1= VehiculoBD.BuscarClaseVehiculo(jTecodclase.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (vc1 != null) {
            jTecodclase.setText(String.valueOf(vc1.getCodigoClase()));
            jTexdescipclase.setText(vc1.getCodigoClase());
            jTexcostodiario.setText(String.valueOf(vc1.getCostoDiario()));
            jTexcostoproteccion.setText(String.valueOf(vc1.getCostoProteccion()));
            
           
        jButtonactualizarc.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        
        
        }

        else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtonactualizarc.setEnabled(false);
            jTecodclase.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodclase.setEditable(true);
            }
        
}
public void BuscarEstatus(){
 Vehiculo v=new Vehiculo();
 
 
try {
            v= VehiculoBD.BuscarVehiculoEstatus(jTexcodestatus.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (v != null) {
            jTexcodestatus.setText(String.valueOf(v.getCodigoEstatus()));
            Status.setText(v.getEstatus());
            if (Status.getText().equals("Activo")) {
                jRainactivoveh.setEnabled(false);
                jRaActivoveh.setEnabled(true);
               jRaActivoveh.setSelected(true);
               
            } 
            else {
                jRaActivoveh.setEnabled(false);
                jRainactivoveh.setEnabled(true);
                jRainactivoveh.setSelected(true);
            }
            
           
        jButtonactualizarc.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        
        
        }

        else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtonactualizarc.setEnabled(false);
            jTecodclase.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodclase.setEditable(true);
        }
}
public void BuscarMantenimiento(){
       VehiculoMantenimiento vma =new VehiculoMantenimiento();
    try {
  
           vma= VehiculoMantenimientoBD.BuscarMantenimiento(jTexcodmantenimiento.getText());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (vma != null) {
            jTexcodmantenimiento.setText(String.valueOf(vma.getCodigomantenimiento()));
            jTexfecha.setText(vma.getFecha());
            jTexdescripmantenimiento.setText(vma.getDescripcion());
            jTexcodvehiculo.setText(String.valueOf(vma.getCodigoVeh()));
            jTextFieldestaus.setText(vma.getEstatusmantenimiento());
            if(jTextFieldestaus.getText().equals("Activo")){
            
            jRadioActivo.setSelected(true);
            
            }
            else{
            jRadioInactivo.setSelected(true);
            
            }
           
        jButtactualizarv.setEnabled(true);
            jButtcancelarv.setEnabled(true);
        
        
        
        }

        else {
            JOptionPane.showMessageDialog(null, "No exite");
           jButtactualizarv.setEnabled(false);
            jTecodveh.setText("");
            jButtcancelarv.setEnabled(false);
            jTecodveh.setEditable(true);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbmant = new javax.swing.JTabbedPane();
        jPanelmarca = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTcodMarca = new javax.swing.JTextField();
        jButtguardarm = new javax.swing.JButton();
        jButtonuevom = new javax.swing.JButton();
        jButtactualizarm = new javax.swing.JButton();
        jButtcancelarm = new javax.swing.JButton();
        jButtonconsultam = new javax.swing.JButton();
        jButbuscarmarca = new javax.swing.JButton();
        jTfemarca = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablemarcas = new javax.swing.JTable();
        jButtocerrartabla = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jButtBuscarmarca = new javax.swing.JButton();
        jPanelclase = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTecodclase = new javax.swing.JTextField();
        jTexdescipclase = new javax.swing.JTextField();
        jTexcostodiario = new javax.swing.JTextField();
        jButtonguardarc = new javax.swing.JButton();
        jTexcostoproteccion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButtonnevo = new javax.swing.JButton();
        jButtonactualizarc = new javax.swing.JButton();
        jButtoncancelarc = new javax.swing.JButton();
        jButtonconsulta = new javax.swing.JButton();
        jButtonbuscarc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jButtBusclase1 = new javax.swing.JButton();
        jButtocerrartabla3 = new javax.swing.JButton();
        jPanelmodelo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jbuttGuardar = new javax.swing.JButton();
        jTecodmodelo = new javax.swing.JTextField();
        jTemodelo = new javax.swing.JTextField();
        jTexcodmarca = new javax.swing.JTextField();
        jTexcodclase = new javax.swing.JTextField();
        jButtnuevomodel = new javax.swing.JButton();
        ActualizarModelo = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Consultarmodelo = new javax.swing.JButton();
        jButtonbuscarmodelo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buscarmodelo1 = new javax.swing.JButton();
        jtexbusqueda = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButtcerrartabla3 = new javax.swing.JButton();
        jPanelestatus = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRaActivoveh = new javax.swing.JRadioButton();
        jRainactivoveh = new javax.swing.JRadioButton();
        jTexcodestatus = new javax.swing.JTextField();
        jButtogardarestatus = new javax.swing.JButton();
        jButtonNuevoestatus = new javax.swing.JButton();
        jButtonactualizarestatus = new javax.swing.JButton();
        jButtocancelarestatus = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButtonBuscarestatus = new javax.swing.JButton();
        Status = new javax.swing.JTextField();
        jPanelmant = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTexcodmantenimiento = new javax.swing.JTextField();
        jTexfecha = new javax.swing.JTextField();
        jTexdescripmantenimiento = new javax.swing.JTextField();
        jTexcodvehiculo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jRadioActivo = new javax.swing.JRadioButton();
        jRadioInactivo = new javax.swing.JRadioButton();
        jButtguardarmant = new javax.swing.JButton();
        jButtnuevomant = new javax.swing.JButton();
        jButtoActualizarmantenimienti = new javax.swing.JButton();
        jButtcancelarmant = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        Buscaramntenimiento = new javax.swing.JButton();
        Buscarvehiculo = new javax.swing.JButton();
        jTextFieldestaus = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablemantenimiento = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jtexbusquedamantenimiento = new javax.swing.JTextField();
        buscarmntenimiento = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanelveh = new javax.swing.JPanel();
        jTexplaca = new javax.swing.JTextField();
        jTexcarroseria = new javax.swing.JTextField();
        jTexserialmotor = new javax.swing.JTextField();
        jTexcolor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTecodveh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTefechaingreso = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTelitro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTecodpoliza = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTekm = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTecodestatus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtguardarv = new javax.swing.JButton();
        jButtcancelarv = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTexcodmodelo = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButtconsultar = new javax.swing.JButton();
        jButtnuevo = new javax.swing.JButton();
        jButtactualizarv = new javax.swing.JButton();
        jButtbuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanelimg = new javax.swing.JPanel();
        jButtimgv = new javax.swing.JButton();
        jTextAño = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));
        setForeground(new java.awt.Color(51, 0, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Registrar Vehiculos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(484, 484, 484))
        );

        jLabel10.setText("Codigo");

        jLabel16.setText("Marca");

        jButtguardarm.setText("Guardar");
        jButtguardarm.setEnabled(false);
        jButtguardarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtguardarmActionPerformed(evt);
            }
        });

        jButtonuevom.setText("Nuevo");
        jButtonuevom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonuevomActionPerformed(evt);
            }
        });

        jButtactualizarm.setText("Actualizar");
        jButtactualizarm.setEnabled(false);
        jButtactualizarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtactualizarmActionPerformed(evt);
            }
        });

        jButtcancelarm.setText("Cancelar");
        jButtcancelarm.setEnabled(false);
        jButtcancelarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtcancelarmActionPerformed(evt);
            }
        });

        jButtonconsultam.setText("Consultar");
        jButtonconsultam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonconsultamActionPerformed(evt);
            }
        });

        jButbuscarmarca.setText("Buscar");
        jButbuscarmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButbuscarmarcaActionPerformed(evt);
            }
        });

        jTablemarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablemarcas);

        jButtocerrartabla.setText("cerrar tabla");
        jButtocerrartabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtocerrartablaActionPerformed(evt);
            }
        });

        jLabel31.setText("Buscar Por");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "Codigo" }));

        jButtBuscarmarca.setText("Buscar");
        jButtBuscarmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtBuscarmarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtocerrartabla, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtBuscarmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtBuscarmarca))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButtocerrartabla)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelmarcaLayout = new javax.swing.GroupLayout(jPanelmarca);
        jPanelmarca.setLayout(jPanelmarcaLayout);
        jPanelmarcaLayout.setHorizontalGroup(
            jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmarcaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 631, Short.MAX_VALUE))
            .addGroup(jPanelmarcaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelmarcaLayout.createSequentialGroup()
                        .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelmarcaLayout.createSequentialGroup()
                                .addComponent(jTcodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButbuscarmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTfemarca)))
                    .addGroup(jPanelmarcaLayout.createSequentialGroup()
                        .addComponent(jButtonuevom, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtactualizarm, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtguardarm, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtcancelarm, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonconsultam, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelmarcaLayout.setVerticalGroup(
            jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmarcaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTcodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButbuscarmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTfemarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelmarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonuevom)
                    .addComponent(jButtactualizarm)
                    .addComponent(jButtonconsultam)
                    .addComponent(jButtguardarm)
                    .addComponent(jButtcancelarm))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jTabbmant.addTab("Marca", jPanelmarca);

        jLabel17.setText("Codigo");

        jLabel18.setText("Descripcion");

        jLabel19.setText("Costo Diario");

        jButtonguardarc.setText("Guardar");
        jButtonguardarc.setEnabled(false);
        jButtonguardarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonguardarcActionPerformed(evt);
            }
        });

        jLabel20.setText("Costo Proteccion");

        jButtonnevo.setText("Nuevo");
        jButtonnevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonnevoActionPerformed(evt);
            }
        });

        jButtonactualizarc.setText("Actualizar");
        jButtonactualizarc.setEnabled(false);
        jButtonactualizarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonactualizarcActionPerformed(evt);
            }
        });

        jButtoncancelarc.setText("Cancelar");
        jButtoncancelarc.setEnabled(false);
        jButtoncancelarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncancelarcActionPerformed(evt);
            }
        });

        jButtonconsulta.setText("Consultar");
        jButtonconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonconsultaActionPerformed(evt);
            }
        });

        jButtonbuscarc.setText("jButton1");
        jButtonbuscarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbuscarcActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Costo Diario", "Costo Proteccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel32.setText("Buscar Por");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "Codigo" }));

        jButtBusclase1.setText("Buscar");
        jButtBusclase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtBusclase1ActionPerformed(evt);
            }
        });

        jButtocerrartabla3.setText("cerrar tabla");
        jButtocerrartabla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtocerrartabla3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButtocerrartabla3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(15, 15, 15)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtBusclase1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtBusclase1))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtocerrartabla3))
                .addContainerGap(279, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelclaseLayout = new javax.swing.GroupLayout(jPanelclase);
        jPanelclase.setLayout(jPanelclaseLayout);
        jPanelclaseLayout.setHorizontalGroup(
            jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelclaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelclaseLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(22, 22, 22)
                        .addComponent(jTexdescipclase, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelclaseLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jTecodclase, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonbuscarc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelclaseLayout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(18, 18, 18)
                            .addComponent(jTexcostoproteccion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelclaseLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(18, 18, 18)
                            .addComponent(jTexcostodiario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelclaseLayout.createSequentialGroup()
                        .addComponent(jButtonnevo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonguardarc)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonactualizarc)
                        .addGap(12, 12, 12)
                        .addComponent(jButtoncancelarc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelclaseLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 454, Short.MAX_VALUE))
        );
        jPanelclaseLayout.setVerticalGroup(
            jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelclaseLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTecodclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonbuscarc))
                .addGap(18, 18, 18)
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTexdescipclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTexcostodiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTexcostoproteccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelclaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonnevo)
                    .addComponent(jButtoncancelarc)
                    .addComponent(jButtonconsulta)
                    .addComponent(jButtonguardarc)
                    .addComponent(jButtonactualizarc))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbmant.addTab("Clase Vehiculo", jPanelclase);

        jLabel21.setText("Codigo");

        jLabel22.setText("Modelo");

        jLabel23.setText("codigo marca");

        jLabel24.setText("Codigo Clase");

        jbuttGuardar.setText("Gardar");
        jbuttGuardar.setEnabled(false);
        jbuttGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttGuardarActionPerformed(evt);
            }
        });

        jTexcodclase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexcodclaseActionPerformed(evt);
            }
        });

        jButtnuevomodel.setText("Nuevo");
        jButtnuevomodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtnuevomodelActionPerformed(evt);
            }
        });

        ActualizarModelo.setText("Actualizar");
        ActualizarModelo.setEnabled(false);
        ActualizarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarModeloActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.setEnabled(false);
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Consultarmodelo.setText("Consultar");
        Consultarmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarmodeloActionPerformed(evt);
            }
        });

        jButtonbuscarmodelo.setText("buscar");
        jButtonbuscarmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbuscarmodeloActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Modelo", "Codigo Marca", "Codigo Clase"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buscarmodelo1.setText("Buscar");
        buscarmodelo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarmodelo1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Buscar Por");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Todo" }));

        jButtcerrartabla3.setText("Cerrar ventana");
        jButtcerrartabla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtcerrartabla3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtcerrartabla3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtexbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarmodelo1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarmodelo1)
                    .addComponent(jtexbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtcerrartabla3))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout jPanelmodeloLayout = new javax.swing.GroupLayout(jPanelmodelo);
        jPanelmodelo.setLayout(jPanelmodeloLayout);
        jPanelmodeloLayout.setHorizontalGroup(
            jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmodeloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelmodeloLayout.createSequentialGroup()
                        .addComponent(jButtnuevomodel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ActualizarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbuttGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Consultarmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelmodeloLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTecodmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonbuscarmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelmodeloLayout.createSequentialGroup()
                        .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTemodelo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jTexcodmarca)
                            .addComponent(jTexcodclase))))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanelmodeloLayout.setVerticalGroup(
            jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmodeloLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonbuscarmodelo)
                    .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jTecodmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTemodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTexcodmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTexcodclase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanelmodeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtnuevomodel)
                    .addComponent(ActualizarModelo)
                    .addComponent(jbuttGuardar)
                    .addComponent(Cancelar)
                    .addComponent(Consultarmodelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbmant.addTab("Modelo", jPanelmodelo);

        jLabel6.setText("Codigo Estatus");

        jLabel9.setText("Estatus");

        buttonGroup1.add(jRaActivoveh);
        jRaActivoveh.setText("Activo");
        jRaActivoveh.setEnabled(false);

        buttonGroup1.add(jRainactivoveh);
        jRainactivoveh.setText("Inactivo");
        jRainactivoveh.setEnabled(false);

        jButtogardarestatus.setText("Guardar");
        jButtogardarestatus.setEnabled(false);
        jButtogardarestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtogardarestatusActionPerformed(evt);
            }
        });

        jButtonNuevoestatus.setText("Nuevo");
        jButtonNuevoestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoestatusActionPerformed(evt);
            }
        });

        jButtonactualizarestatus.setText("Actualizar");
        jButtonactualizarestatus.setEnabled(false);

        jButtocancelarestatus.setText("Cancelar");
        jButtocancelarestatus.setEnabled(false);
        jButtocancelarestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtocancelarestatusActionPerformed(evt);
            }
        });

        jButton36.setText("Consultar");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButtonBuscarestatus.setText("Buscar");
        jButtonBuscarestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarestatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelestatusLayout = new javax.swing.GroupLayout(jPanelestatus);
        jPanelestatus.setLayout(jPanelestatusLayout);
        jPanelestatusLayout.setHorizontalGroup(
            jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelestatusLayout.createSequentialGroup()
                .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelestatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelestatusLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTexcodestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscarestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelestatusLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(61, 61, 61)
                                .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRainactivoveh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelestatusLayout.createSequentialGroup()
                                        .addComponent(jRaActivoveh)
                                        .addGap(18, 18, 18)
                                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanelestatusLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButtonNuevoestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtogardarestatus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonactualizarestatus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtocancelarestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(527, Short.MAX_VALUE))
        );
        jPanelestatusLayout.setVerticalGroup(
            jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelestatusLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTexcodestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscarestatus)))
                .addGap(18, 18, 18)
                .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jRaActivoveh)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRainactivoveh)
                .addGap(18, 18, 18)
                .addGroup(jPanelestatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonactualizarestatus)
                    .addComponent(jButtonNuevoestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtogardarestatus)
                    .addComponent(jButtocancelarestatus)
                    .addComponent(jButton36))
                .addContainerGap(498, Short.MAX_VALUE))
        );

        jTabbmant.addTab("Estatus Vehiculo", jPanelestatus);

        jLabel25.setText("Codigo");

        jLabel26.setText("Fecha");

        jLabel27.setText("Estatus");

        jLabel28.setText("Descripcion");

        jLabel29.setText("Codigo Vehiculo");

        buttonGroup1.add(jRadioActivo);
        jRadioActivo.setText("Activo");

        buttonGroup1.add(jRadioInactivo);
        jRadioInactivo.setText("Inactivo");

        jButtguardarmant.setText("Guardar");
        jButtguardarmant.setEnabled(false);
        jButtguardarmant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtguardarmantActionPerformed(evt);
            }
        });

        jButtnuevomant.setText("Nuevo");
        jButtnuevomant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtnuevomantActionPerformed(evt);
            }
        });

        jButtoActualizarmantenimienti.setText("Actualizar");
        jButtoActualizarmantenimienti.setEnabled(false);
        jButtoActualizarmantenimienti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoActualizarmantenimientiActionPerformed(evt);
            }
        });

        jButtcancelarmant.setText("Cancelar");
        jButtcancelarmant.setEnabled(false);
        jButtcancelarmant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtcancelarmantActionPerformed(evt);
            }
        });

        jButton32.setText("Consultar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        Buscaramntenimiento.setText("Buscar");
        Buscaramntenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaramntenimientoActionPerformed(evt);
            }
        });

        Buscarvehiculo.setText("Buscar");

        jTablemantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Estatus", "Descripcion", "Codigo Vehiculo"
            }
        ));
        jScrollPane4.setViewportView(jTablemantenimiento);

        jLabel34.setText("Buscar Por");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Todo" }));

        buscarmntenimiento.setText("Buscar");
        buscarmntenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarmntenimientoActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtexbusquedamantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarmntenimiento)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarmntenimiento)
                    .addComponent(jtexbusquedamantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
        );

        javax.swing.GroupLayout jPanelmantLayout = new javax.swing.GroupLayout(jPanelmant);
        jPanelmant.setLayout(jPanelmantLayout);
        jPanelmantLayout.setHorizontalGroup(
            jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelmantLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelmantLayout.createSequentialGroup()
                                .addComponent(jTexfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 873, Short.MAX_VALUE))
                            .addGroup(jPanelmantLayout.createSequentialGroup()
                                .addComponent(jRadioActivo)
                                .addGap(5, 5, 5)
                                .addComponent(jRadioInactivo)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldestaus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelmantLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(jTexcodvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Buscarvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelmantLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(jTexdescripmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanelmantLayout.createSequentialGroup()
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addComponent(jButtnuevomant)
                        .addGap(18, 18, 18)
                        .addComponent(jButtguardarmant)
                        .addGap(18, 18, 18)
                        .addComponent(jButtoActualizarmantenimienti)
                        .addGap(18, 18, 18)
                        .addComponent(jButtcancelarmant)
                        .addGap(18, 18, 18)
                        .addComponent(jButton32))
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTexcodmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscaramntenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelmantLayout.setVerticalGroup(
            jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelmantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexcodmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscaramntenimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTexfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jRadioActivo)
                    .addComponent(jTextFieldestaus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioInactivo))
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelmantLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTexdescripmantenimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTexcodvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscarvehiculo))
                .addGap(18, 18, 18)
                .addGroup(jPanelmantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtguardarmant)
                    .addComponent(jButtnuevomant)
                    .addComponent(jButtcancelarmant)
                    .addComponent(jButton32)
                    .addComponent(jButtoActualizarmantenimienti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbmant.addTab("Mantenimiento", jPanelmant);

        jLabel2.setText("PLACA");

        jLabel3.setText("SERIAL CARROSERIA");

        jLabel4.setText("SERIAL MOTOR");

        jLabel5.setText("COLOR");

        jLabel7.setText("Codigo Modelo");

        jLabel11.setText("Codigo");

        jLabel12.setText("FechaIngreso");

        jLabel13.setText("Litros");

        jLabel14.setText("Kilometraje");

        jLabel15.setText("Codigo Poliza");

        jLabel8.setText("Codigo Status Vehiculo");

        jButtguardarv.setText("GUARDAR");
        jButtguardarv.setEnabled(false);
        jButtguardarv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtguardarvActionPerformed(evt);
            }
        });

        jButtcancelarv.setText("Cancelar");
        jButtcancelarv.setEnabled(false);
        jButtcancelarv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtcancelarvActionPerformed(evt);
            }
        });

        jButton9.setText("buscar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setText("buscar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("buscar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButtconsultar.setText("Consultar");
        jButtconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtconsultarActionPerformed(evt);
            }
        });

        jButtnuevo.setText("Nuevo");
        jButtnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtnuevoActionPerformed(evt);
            }
        });

        jButtactualizarv.setText("Actualizar");
        jButtactualizarv.setEnabled(false);
        jButtactualizarv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtactualizarvActionPerformed(evt);
            }
        });

        jButtbuscar.setText("buscar");
        jButtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtbuscarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelimgLayout = new javax.swing.GroupLayout(jPanelimg);
        jPanelimg.setLayout(jPanelimgLayout);
        jPanelimgLayout.setHorizontalGroup(
            jPanelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanelimgLayout.setVerticalGroup(
            jPanelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelimg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanelimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtimgv.setText("Buscar Imagen");
        jButtimgv.setEnabled(false);
        jButtimgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtimgvActionPerformed(evt);
            }
        });

        jLabel33.setText("Año");

        javax.swing.GroupLayout jPanelvehLayout = new javax.swing.GroupLayout(jPanelveh);
        jPanelveh.setLayout(jPanelvehLayout);
        jPanelvehLayout.setHorizontalGroup(
            jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvehLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelvehLayout.createSequentialGroup()
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTexplaca))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jTecodveh, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTexserialmotor, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTexcarroseria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelvehLayout.createSequentialGroup()
                                    .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelvehLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(jLabel14)
                                            .addGap(71, 71, 71))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelvehLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTelitro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTekm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanelvehLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15)
                                    .addGap(62, 62, 62)
                                    .addComponent(jTecodpoliza, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelvehLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(67, 67, 67)
                                        .addComponent(jTefechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelvehLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTecodestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanelvehLayout.createSequentialGroup()
                        .addComponent(jButtnuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtguardarv)
                        .addGap(18, 18, 18)
                        .addComponent(jButtactualizarv)
                        .addGap(18, 18, 18)
                        .addComponent(jButtcancelarv)
                        .addGap(18, 18, 18)
                        .addComponent(jButtimgv)
                        .addGap(18, 18, 18)
                        .addComponent(jButtconsultar))
                    .addGroup(jPanelvehLayout.createSequentialGroup()
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jTexcodmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTexcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextAño, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );
        jPanelvehLayout.setVerticalGroup(
            jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvehLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelvehLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelvehLayout.createSequentialGroup()
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTecodveh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButtbuscar))
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTexplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTexcarroseria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTekm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jTelitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTexserialmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel15)
                                    .addComponent(jTecodpoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelvehLayout.createSequentialGroup()
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jTexcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jTexcodmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12)))
                                    .addGroup(jPanelvehLayout.createSequentialGroup()
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(jTecodestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTefechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelvehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtnuevo)
                                    .addComponent(jButtguardarv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtactualizarv)
                                    .addComponent(jButtcancelarv)
                                    .addComponent(jButtconsultar)
                                    .addComponent(jButtimgv)))
                            .addGroup(jPanelvehLayout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jTabbmant.addTab("Vehiculo", jPanelveh);

        jPanel14.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbmant)
                .addGap(76, 76, 76)
                .addComponent(jButton3))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbmant, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
AseguradoraGUI as=new AseguradoraGUI();
as.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButtguardarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtguardarmActionPerformed
     
    vehm.setMarca(jTfemarca.getText());
        vehbd.insertarMarca(jTcodMarca.getText(),vehm.getMarca());
        


// TODO add your handling code here:
    }//GEN-LAST:event_jButtguardarmActionPerformed

    private void jButtonguardarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonguardarcActionPerformed
        vehc.setCodigoClase(jTecodclase.getText());
        vehc.setCodigoClase(jTexdescipclase.getText());
        vehc.setCostoDiario(Double.parseDouble(jTexcostodiario.getText()));
        vehc.setCostoProteccion(Double.parseDouble(jTexcostoproteccion.getText()));
        vehbd.insertarclase(vehc.getCodigoClase(), vehc.getCodigoClase(), vehc.getCostoDiario(), vehc.getCostoProteccion());        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonguardarcActionPerformed

    private void jbuttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttGuardarActionPerformed
vehm.setCodigoModelo(jTecodmodelo.getText());  
vehm.setModelo(jTemodelo.getText());
vehbd.Insertarmodelo(vehm.getCodigoModelo(), vehm.getModelo(), jTexcodmarca.getText(), jTexcodclase.getText());


// TODO add your handling code here:
    }//GEN-LAST:event_jbuttGuardarActionPerformed

    private void jButtogardarestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtogardarestatusActionPerformed
veh.setCodigoEstatus(jTexcodestatus.getText()); 
if(jRaActivoveh.isSelected()){
veh.setEstatus("Activo");

}
else if(jRainactivoveh.isSelected()){

veh.setEstatus("Inactivo");

}
vehbd.InsertarEstatusVehiculo(veh.getCodigoEstatus(), veh.getEstatus());
// TODO add your handling code here:
    }//GEN-LAST:event_jButtogardarestatusActionPerformed

    metodos m = new metodos() {};
    String ImagenURL;
    public void Mostrar(JPanel p) {
        try {
            //se asigna a "url" el archivo de imagen seleccionado
            URL url = m.getObtener();
            //se lo coloca en memoria
            m.cargar_imagen(url);
            //se aÃ±ade al contenedor
            p.add(new mipanel(m.Obtener_imagen_de_Buffer(), p.getSize()) {});
            p.setVisible(true);
            p.repaint();
        } catch (Exception ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    private void jButtguardarvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtguardarvActionPerformed
//veh.setCodigoVeh(Integer.parseInt(jTecodveh.getText())); 
 Vehiculo v=new Vehiculo(); 
  VehiculoBD vv=new VehiculoBD();
v.setPlacaVeh(jTexplaca.getText());
v.setColorVeh(jTexcolor.getText());
v.setAño(Integer.parseInt(jTextAño.getText()));
v.setFechaIngresoVeh(jTefechaingreso.getText());
v.setSerialCarroseriaVeh(jTexcarroseria.getText());
v.setSerialmotorVeh(jTexserialmotor.getText());
v.setKilometrajeVeh(Integer.parseInt(jTekm.getText()));
v.setLitrosVeh(Float.parseFloat(jTelitro.getText()));
v.setCodigoEstatus(jTecodestatus.getText());
v.setCodigoModelo(jTexcodmodelo.getText());
v.setImagen(ImagenURL);
vv.InsertarVehiculos(v.getCodigoVeh(),v.getPlacaVeh(), v.getColorVeh(),v.getAño(), v.getFechaIngresoVeh(), v.getSerialCarroseriaVeh(),
        v.getSerialmotorVeh(),v.getKilometrajeVeh(), v.getLitrosVeh(), v.getCodigoEstatus(),v.getCodigoModelo(),jTecodpoliza.getText(),v.getImagen());

// TODO add your handling code here:
    }//GEN-LAST:event_jButtguardarvActionPerformed

    private void jButtguardarmantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtguardarmantActionPerformed
        VehiculoMantenimientoBD vm=new VehiculoMantenimientoBD();
        String mant="";
        if(jRadioActivo.isSelected()){
        
        mant="Activo";
        
        }
        else if(jRadioInactivo.isSelected()){
        
        mant="Inactivo";
        
        }
        
        vm.Insertarmantenimiento(jTexcodmantenimiento.getText(), jTexfecha.getText(), mant, jTexdescripmantenimiento.getText(),
       jTexcodvehiculo.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_jButtguardarmantActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
jPanelmodelo.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButtconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtconsultarActionPerformed
Consultar_Vehiculos conv=new Consultar_Vehiculos(); 
conv.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButtconsultarActionPerformed

    private void jButtcancelarvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtcancelarvActionPerformed
limpiar();
jButtbuscar.setEnabled(true);
jTecodveh.setEditable(true);
jButtguardarv.setEnabled(false);
jButtnuevo.setEnabled(true);
jButtcancelarv.setEnabled(false);
jButtimgv.setEnabled(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jButtcancelarvActionPerformed
public void borrarcamposmodelo(){
jTecodmodelo.setText("");
jTemodelo.setText("");
jTexcodmarca.setText("");
jTexcodclase.setText("");


}
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
borrarcamposmodelo();
jTecodmodelo.setEnabled(true);
jButtonbuscarmodelo.setEnabled(true);
jTecodmodelo.setEditable(true);
jbuttGuardar.setEnabled(false);
jButtnuevomodel.setEnabled(true);
Cancelar.setEnabled(false);


// TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void ConsultarmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarmodeloActionPerformed
jPanel2.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarmodeloActionPerformed
public void borracamposc(){
jTecodclase.setText("");
jTexdescipclase.setText("");
jTexcostodiario.setText("");
jTexcostoproteccion.setText("");
}
    private void jButtoncancelarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncancelarcActionPerformed
           borracamposc();
        jTecodclase.setEnabled(true);
        jTecodclase.setEditable(true);
        jButtonactualizarc.setEnabled(false);
        jButtoncancelarc.setEnabled(false);
        jButtonbuscarc.setEnabled(true);
        jButtonnevo.setEnabled(true);
        jTecodclase.setEditable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButtoncancelarcActionPerformed

    private void jButtonconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonconsultaActionPerformed
jPanel4.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonconsultaActionPerformed

    private void jButtcancelarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtcancelarmActionPerformed
borrarcamposmarca();
jButtonuevom.setEnabled(true);
jButtguardarm.setEnabled(false);
jButtcancelarm.setEnabled(false);
jTcodMarca.setEditable(true);
jTcodMarca.setEnabled(true);
jButtactualizarm.setEnabled(false);
jButbuscarmarca.setEnabled(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButtcancelarmActionPerformed

    private void jButtonconsultamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonconsultamActionPerformed
jPanel3.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonconsultamActionPerformed

    private void jButtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtbuscarActionPerformed
if (jTecodveh.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar al Vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarVehiculo();
                jButtactualizarv.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                
                
                jButtactualizarv.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Vehiculo a Buscar");
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtbuscarActionPerformed

    private void jButtactualizarvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtactualizarvActionPerformed
        
        try {
            veh = VehiculoBD.BuscarVehiculo(cod=Integer.parseInt(jTecodveh.getText()));
            veh.setPlacaVeh(jTexplaca.getText());
            veh.setSerialCarroseriaVeh(jTexcarroseria.getText());
            veh.setSerialmotorVeh(jTexserialmotor.getText());
            veh.setColorVeh(jTexcolor.getText());
            vehm.setCodigoModelo(jTexcodmodelo.getText());
            a.setCodigoPoliza(jTecodpoliza.getText());
            veh.setKilometrajeVeh(Integer.parseInt(jTekm.getText()));
            veh.setLitrosVeh(Float.valueOf(jTelitro.getText()));
            veh.setCodigoEstatus(jTecodestatus.getText());
            veh.setFechaIngresoVeh(jTefechaingreso.getText());
           
            VehiculoBD.ActualizarVehiculo(veh);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButtactualizarvActionPerformed

    private void jButtnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtnuevoActionPerformed
limpiar();
jButtbuscar.setEnabled(false);
jTecodveh.setEditable(false);
jButtguardarv.setEnabled(true);
jButtnuevo.setEnabled(false);
jButtcancelarv.setEnabled(true);
jButtimgv.setEnabled(true);
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButtnuevoActionPerformed
public void borrarcamposmarca(){
jTfemarca.setText("");
jTcodMarca.setText("");

}
    private void jButtonuevomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonuevomActionPerformed
    borrarcamposmarca();
    jButtonuevom.setEnabled(false);
    jButtguardarm.setEnabled(true);
    jButtcancelarm.setEnabled(true);
    jButbuscarmarca.setEnabled(false);
    jTcodMarca.setEnabled(false);
    jButtactualizarm.setEnabled(false);
    
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonuevomActionPerformed

    private void jButtonnevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonnevoActionPerformed

        borracamposc();
        jTecodclase.setEditable(false);
       jTecodclase.setEnabled(false);
        jButtonactualizarc.setEnabled(false);
        jButtoncancelarc.setEnabled(true);
        jButtonbuscarc.setEnabled(false);
        jButtonnevo.setEnabled(false);  
        jButtonguardarc.setEnabled(true);



// TODO add your handling code here:
    }//GEN-LAST:event_jButtonnevoActionPerformed

    private void jButtnuevomantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtnuevomantActionPerformed
        borrarcamposmant();
        jTexcodmantenimiento.setEditable(false);
        jButtoActualizarmantenimienti.setEnabled(false);
        jButtcancelarmant.setEnabled(true);
        Buscaramntenimiento.setEnabled(false);
        jButtnuevomant.setEnabled(false); 
        jButtguardarmant.setEnabled(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButtnuevomantActionPerformed
public void borrarcamposmant(){

jTexcodmantenimiento.setText("");
jTexfecha.setText("");
jTexdescripmantenimiento.setText("");
jTextFieldestaus.setText("");
jTexcodvehiculo.setText("");

}
    private void jButtcancelarmantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtcancelarmantActionPerformed
       borrarcamposmant();
        jButtguardarmant.setEnabled(false);
        jTexcodmantenimiento.setEditable(true);
        jButtoActualizarmantenimienti.setEnabled(false);
        jButtcancelarmant.setEnabled(false);
        Buscaramntenimiento.setEnabled(true);
        jButtnuevomant.setEnabled(true); 
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButtcancelarmantActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
jPanel5.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButtonNuevoestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoestatusActionPerformed
    jButtogardarestatus.setEnabled(true); 
    jButtonBuscarestatus.setEnabled(false);
    jButtocancelarestatus.setEnabled(true);
    jButtonNuevoestatus.setEnabled(false);
    
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonNuevoestatusActionPerformed

    private void jButtocancelarestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtocancelarestatusActionPerformed
         jButtogardarestatus.setEnabled(false); 
    jButtonBuscarestatus.setEnabled(true);
    jButtocancelarestatus.setEnabled(false);
    jButtonNuevoestatus.setEnabled(true);
    
    // TODO add your handling code here:
    }//GEN-LAST:event_jButtocancelarestatusActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButtonbuscarmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbuscarmodeloActionPerformed
if (jTecodmodelo.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar el Modelo vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarVehiculomodelo();
                ActualizarModelo.setEnabled(true);
                Cancelar.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                
                
                ActualizarModelo.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Modelo Vehiculo a Buscar");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonbuscarmodeloActionPerformed

    private void jButtcerrartabla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtcerrartabla3ActionPerformed
jPanel2.setVisible(false);
Clear_Table1();// TODO add your handling code here:
    }//GEN-LAST:event_jButtcerrartabla3ActionPerformed
private void Clear_Table1(){
    DefaultTableModel t =(DefaultTableModel)jTable1.getModel();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            t.removeRow(i);
            i-=1;
        }
    }

    private void buscarmodelo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarmodelo1ActionPerformed
     VehiculoBD vm=new VehiculoBD();
     
     DefaultTableModel t =(DefaultTableModel)jTable1.getModel();
            
     if(jtexbusqueda.getText().compareTo("") == 0 && jComboBox1.getSelectedItem().equals("Codigo")){
            JOptionPane.showMessageDialog(null, "Campos vasio");}
     
     else if (jComboBox1.getSelectedItem().equals("Codigo") ){

            
            jTable1.setModel(t);
            Clear_Table1();
                    try {
                        
                for(Vehiculo vv : vm.mostrarVehiculoModelo_codigo(jtexbusqueda.getText())){
                    String Datos[]={vv.getCodigoModelo(), vv.getModelo(),vv.getCodigoMarca(), vv.getCodigoClase()};
                    //t.addRow(new Object[0]);
                    t.addRow(Datos);
                    //t.addRow(new Object[0]);
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
     }
     else if (jComboBox1.getSelectedItem().equals("Todo") ){

                   // DefaultTableModel t =(DefaultTableModel)jTable1.getModel();
                     //t.addRow(new Object[WIDTH]);
                    jTable1.setModel(t);
                    //t.addRow(new Object[0]);
Clear_Table1();
                    try {
                        
                for(Vehiculo vv : vm.mostrarVehiculoModelo()){
                    String Datos[]={vv.getCodigoModelo(), vv.getModelo(),vv.getCodigoMarca(), vv.getCodigoClase()};
                    t.addRow(Datos);
                   
                    //t.addRow(new Object[0]);
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
          
                    } 
      





// TODO add your handling code here:
    }//GEN-LAST:event_buscarmodelo1ActionPerformed

    
    private void jTexcodclaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexcodclaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexcodclaseActionPerformed

    private void ActualizarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarModeloActionPerformed
Vehiculo u;
        try {
            u = VehiculoBD.BuscarModeloVehiculo(jTecodmodelo.getText());
            u.setModelo(jTemodelo.getText());
            u.setCodigoMarca(jTexcodmarca.getText());
            u.setCodigoClase(jTexcodclase.getText());
            
            VehiculoBD.actualizarVehiculoModelo(u);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarModeloActionPerformed

    private void jButbuscarmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButbuscarmarcaActionPerformed
if (jTcodMarca.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar una marca de vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarMarca();
                jButtactualizarm.setEnabled(true);
                jButtcancelarm.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                
                
                jButtactualizarm.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Modelo Vehiculo a Buscar");
        }         // TODO add your handling code here:
                                              // TODO add your handling code here:
    }//GEN-LAST:event_jButbuscarmarcaActionPerformed

    private void jButtBuscarmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtBuscarmarcaActionPerformed
VehiculoBD vm=new VehiculoBD();
     
     DefaultTableModel t2 =(DefaultTableModel)jTablemarcas.getModel();
            
     if(jTextField1.getText().compareTo("") == 0 && jComboBox2.getSelectedItem().equals("Codigo")){
            JOptionPane.showMessageDialog(null, "Campos vasio");}
     
     else if (jComboBox2.getSelectedItem().equals("Codigo") ){

            
            jTablemarcas.setModel(t2);

                    try {
                        
                for(Vehiculo m : vm.mostrarVehiculoMarcaCodigo(jTextField1.getText())){
                    String Datos[]={m.getCodigoMarca(), m.getMarca()};
                    //t2.addRow(new Object[0]);
                    t2.addRow(Datos);
                    
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
     }
     if (jComboBox2.getSelectedItem().equals("Todo") ){

                   
                    try {
                        
                for(Vehiculo mt : vm.mostrarVehiculoMarca()){
                    String Datos[]={mt.getCodigoMarca(), mt.getMarca()};
                    t2.addRow(Datos);
                    t2.addRow(new Object[0]);
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
          
                    } 
              // TODO add your handling code here:
    }//GEN-LAST:event_jButtBuscarmarcaActionPerformed

    private void jButtonbuscarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbuscarcActionPerformed
if (jTecodclase.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar la Clase de vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarVehiculoClase();
               jButtonactualizarc.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                BuscarVehiculoClase();
                //btnEliminarC.setEnabled(true);
                jButtonactualizarc.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo de la clase de vehiculo a Buscar");
        }        // TODO add your ha        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonbuscarcActionPerformed

    private void jButtonactualizarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonactualizarcActionPerformed
 Vehiculo vc3;
        try {
            vc3 = VehiculoBD.BuscarClaseVehiculo(jTecodclase.getText());
            vc3.setCodigoClase(jTexdescipclase.getText());
            vc3.setCostoDiario(Double.parseDouble(jTexcostodiario.getText()));
            vc3.setCostoProteccion(Double.parseDouble(jTexcostoproteccion.getText()));
            
            VehiculoBD.actualizarVehiculoClase(vc3);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonactualizarcActionPerformed

    private void jButtBusclase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtBusclase1ActionPerformed
VehiculoBD vc5=new VehiculoBD();
     String costo="", costoprot="";
     
     
     DefaultTableModel t3 =(DefaultTableModel)jTable3.getModel();
            
     if(jTextField2.getText().compareTo("") == 0 && jComboBox3.getSelectedItem().equals("Codigo")){
            JOptionPane.showMessageDialog(null, "Campos vasio");}
     
     else if (jComboBox3.getSelectedItem().equals("Codigo") ){

            
            jTable3.setModel(t3);

    try {
        for(Vehiculo vc : vc5.mostrarVehiculoClaseCodigo(jTextField2.getText())){
            String Datos[]={vc.getCodigoClase(), vc.getCodigoClase(),costo.valueOf(vc.getCostoDiario()), costoprot.valueOf(vc.getCostoDiario())};
            //t2.addRow(new Object[0]);
            t3.addRow(Datos);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(VehiculosGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
     
     }
     if (jComboBox3.getSelectedItem().equals("Todo") ){

                   
    try {
        for(Vehiculo vc : vc5.mostrarVehiculoClase()){
            String Datos[]={vc.getCodigoClase(), vc.getCodigoClase(),costo.valueOf(vc.getCostoDiario()), costoprot.valueOf(vc.getCostoDiario())};
            t3.addRow(Datos);
            t3.addRow(new Object[0]);
        }
    } catch (SQLException ex) {
        Logger.getLogger(VehiculosGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
          
                    }         // TODO add your handling code here:
    }//GEN-LAST:event_jButtBusclase1ActionPerformed

    private void jButtocerrartabla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtocerrartabla3ActionPerformed
jPanel4.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtocerrartabla3ActionPerformed

    private void jButtocerrartablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtocerrartablaActionPerformed
       jPanel3.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_jButtocerrartablaActionPerformed

    private void jButtactualizarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtactualizarmActionPerformed
Vehiculo ma;
        try {
            ma = VehiculoBD.BuscarMarca(jTcodMarca.getText());
            ma.setModelo(jTfemarca.getText());
            
            
            VehiculoBD.actualizarmarca(ma);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtactualizarmActionPerformed

    private void jButtonBuscarestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarestatusActionPerformed
if (jTexcodestatus.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar Estatus de vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarEstatus();
               jButtonactualizarestatus.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                BuscarVehiculoClase();
                //btnEliminarC.setEnabled(true);
                jButtonactualizarestatus.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Estatus de vehiculo a Buscar");
        }              
        







// TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarestatusActionPerformed

    private void BuscaramntenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaramntenimientoActionPerformed
      
        if (jTexcodmantenimiento.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar un mantenimiento de vehiculo para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BuscarMantenimiento();
                jButtoActualizarmantenimienti.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                
                
                jButtoActualizarmantenimienti.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Mantenimiento Vehiculo a Buscar");
        }         


// TODO add your handling code here:
    }//GEN-LAST:event_BuscaramntenimientoActionPerformed

    private void jButtoActualizarmantenimientiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoActualizarmantenimientiActionPerformed
VehiculoMantenimiento vm;
        try {
            vm = VehiculoMantenimientoBD.BuscarMantenimiento(jTexcodmantenimiento.getText());
        
            vm.setDescripcion(jTexdescripmantenimiento.getText());
            vm.setCodigoVeh(cod=Integer.parseInt(jTexcodvehiculo.getText()));
            vm.setEstatusmantenimiento(jTextFieldestaus.getText());
            VehiculoMantenimientoBD.ActualizarMantenimiento(vm);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }        // TODO add your handling code her        // TODO add your handling code here:
    }//GEN-LAST:event_jButtoActualizarmantenimientiActionPerformed

    private void buscarmntenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarmntenimientoActionPerformed
        
        VehiculoMantenimientoBD vm=new VehiculoMantenimientoBD();
        DefaultTableModel t =(DefaultTableModel)jTablemantenimiento.getModel();
            
     if(jtexbusquedamantenimiento.getText().compareTo("") == 0 && jComboBox4.getSelectedItem().equals("Codigo")){
            JOptionPane.showMessageDialog(null, "Campos vasio");}
     
     else if (jComboBox4.getSelectedItem().equals("Codigo") ){

            
            jTablemantenimiento.setModel(t);

                    try {
                        
                for(VehiculoMantenimiento vv : vm.mostrarmantenimiento(jtexbusquedamantenimiento.getText())){
                    String Datos[]={vv.getCodigomantenimiento(), vv.getFecha(),vv.getEstatusmantenimiento(), vv.getDescripcion(),String.valueOf(vv.getCodigoVeh())};
                    //t.addRow(new Object[0]);
                    t.addRow(Datos);
                    //t.addRow(new Object[0]);
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
     }
     else if (jComboBox4.getSelectedItem().equals("Todo") ){

                   // DefaultTableModel t =(DefaultTableModel)jTable1.getModel();
                     //t.addRow(new Object[WIDTH]);
                    jTablemantenimiento.setModel(t);
                    //t.addRow(new Object[0]);

                    try {
                        
                for(VehiculoMantenimiento vv : vm.mostrarmantenimiento()){
                    String Datos[]={vv.getCodigomantenimiento(), vv.getFecha(),vv.getEstatusmantenimiento(), vv.getDescripcion(),String.valueOf(vv.getCodigoVeh())};
                    //t.addRow(new Object[0]);
                    t.addRow(Datos);
                    //t.addRow(new Object[0]);
                        }   } catch (SQLException ex) {
                            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
                        
          
                    } 
      






// TODO add your handling code here:
    }//GEN-LAST:event_buscarmntenimientoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jPanel5.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtnuevomodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtnuevomodelActionPerformed
        borrarcamposmodelo();
        jTecodmodelo.setEditable(false);
        ActualizarModelo.setEnabled(false);
        jbuttGuardar.setEnabled(true);
        Cancelar.setEnabled(true);
        jButtnuevomodel.setEnabled(false);
        jButtonbuscarmodelo.setEnabled(false);
        jTecodmodelo.setEnabled(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButtnuevomodelActionPerformed

    private void jButtimgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtimgvActionPerformed
jPanelimg.removeAll();
        m.Abrir_Dialogo(jPanelimg );
        ImagenURL = m.ObtenerUrl();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtimgvActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
public void nuevo(){


}

public void limpiar(){
jTecodveh.setText("");
jTecodestatus.setText("");
jTexplaca.setText("");
jTexserialmotor.setText("");
jTexcolor.setText("");
jTexcodmodelo.setText("");
jTekm.setText("");
jTelitro.setText("");
jTecodpoliza.setText("");
jTecodestatus.setText("");
jTefechaingreso.setText("");
jTexcarroseria.setText("");
jPanelimg.removeAll();
jPanelimg.repaint();

}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VehiculosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehiculosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehiculosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehiculosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehiculosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarModelo;
    private javax.swing.JButton Buscaramntenimiento;
    private javax.swing.JButton Buscarvehiculo;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Consultarmodelo;
    private javax.swing.JTextField Status;
    private javax.swing.JButton buscarmntenimiento;
    private javax.swing.JButton buscarmodelo1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButbuscarmarca;
    private javax.swing.JButton jButtBuscarmarca;
    private javax.swing.JButton jButtBusclase1;
    private javax.swing.JButton jButtactualizarm;
    private javax.swing.JButton jButtactualizarv;
    private javax.swing.JButton jButtbuscar;
    private javax.swing.JButton jButtcancelarm;
    private javax.swing.JButton jButtcancelarmant;
    private javax.swing.JButton jButtcancelarv;
    private javax.swing.JButton jButtcerrartabla3;
    private javax.swing.JButton jButtconsultar;
    private javax.swing.JButton jButtguardarm;
    private javax.swing.JButton jButtguardarmant;
    private javax.swing.JButton jButtguardarv;
    private javax.swing.JButton jButtimgv;
    private javax.swing.JButton jButtnuevo;
    private javax.swing.JButton jButtnuevomant;
    private javax.swing.JButton jButtnuevomodel;
    private javax.swing.JButton jButtoActualizarmantenimienti;
    private javax.swing.JButton jButtocancelarestatus;
    private javax.swing.JButton jButtocerrartabla;
    private javax.swing.JButton jButtocerrartabla3;
    private javax.swing.JButton jButtogardarestatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonBuscarestatus;
    private javax.swing.JButton jButtonNuevoestatus;
    private javax.swing.JButton jButtonactualizarc;
    private javax.swing.JButton jButtonactualizarestatus;
    private javax.swing.JButton jButtonbuscarc;
    private javax.swing.JButton jButtonbuscarmodelo;
    private javax.swing.JButton jButtoncancelarc;
    private javax.swing.JButton jButtonconsulta;
    private javax.swing.JButton jButtonconsultam;
    private javax.swing.JButton jButtonguardarc;
    private javax.swing.JButton jButtonnevo;
    private javax.swing.JButton jButtonuevom;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelclase;
    private javax.swing.JPanel jPanelestatus;
    private javax.swing.JPanel jPanelimg;
    private javax.swing.JPanel jPanelmant;
    private javax.swing.JPanel jPanelmarca;
    private javax.swing.JPanel jPanelmodelo;
    private javax.swing.JPanel jPanelveh;
    private javax.swing.JRadioButton jRaActivoveh;
    private javax.swing.JRadioButton jRadioActivo;
    private javax.swing.JRadioButton jRadioInactivo;
    private javax.swing.JRadioButton jRainactivoveh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbmant;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTablemantenimiento;
    private javax.swing.JTable jTablemarcas;
    private javax.swing.JTextField jTcodMarca;
    private javax.swing.JTextField jTecodclase;
    private javax.swing.JTextField jTecodestatus;
    private javax.swing.JTextField jTecodmodelo;
    private javax.swing.JTextField jTecodpoliza;
    private javax.swing.JTextField jTecodveh;
    private javax.swing.JTextField jTefechaingreso;
    private javax.swing.JTextField jTekm;
    private javax.swing.JTextField jTelitro;
    private javax.swing.JTextField jTemodelo;
    private javax.swing.JTextField jTexcarroseria;
    private javax.swing.JTextField jTexcodclase;
    private javax.swing.JTextField jTexcodestatus;
    private javax.swing.JTextField jTexcodmantenimiento;
    private javax.swing.JTextField jTexcodmarca;
    private javax.swing.JTextField jTexcodmodelo;
    private javax.swing.JTextField jTexcodvehiculo;
    private javax.swing.JTextField jTexcolor;
    private javax.swing.JTextField jTexcostodiario;
    private javax.swing.JTextField jTexcostoproteccion;
    private javax.swing.JTextField jTexdescipclase;
    private javax.swing.JTextField jTexdescripmantenimiento;
    private javax.swing.JTextField jTexfecha;
    private javax.swing.JTextField jTexplaca;
    private javax.swing.JTextField jTexserialmotor;
    private javax.swing.JTextField jTextAño;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldestaus;
    private javax.swing.JTextField jTfemarca;
    private javax.swing.JButton jbuttGuardar;
    private javax.swing.JTextField jtexbusqueda;
    private javax.swing.JTextField jtexbusquedamantenimiento;
    // End of variables declaration//GEN-END:variables
}
