/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacontabilidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flor
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        VistaAgregarTransaccion.setLocationRelativeTo(null);
        VistaAgregarTransaccion.setFocusable(true);
        VistaMenu.setLocationRelativeTo(null);
        VistaMenu.setFocusable(true);
        VistaListaGastos.setLocationRelativeTo(null);
        VistaListaGastos.setFocusable(true);
        llenarCBCategorias();
        agregarRadioButtonsAGrupo();
        modeloTransaccion.addColumn("Categoria");
        modeloTransaccion.addColumn("Monto");
        modeloTransaccion.addColumn("Deudor");
        modeloTransaccion.addColumn("Fecha");
    }
    Boton button =new Boton();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ButtonGroup radioBTGroup = new ButtonGroup();
    
    DefaultTableModel modeloGasto = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false; //Con esto conseguimos que la tabla no se pueda editar
                }
    };
    DefaultTableModel modeloDeuda = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false; //Con esto conseguimos que la tabla no se pueda editar
                }
    };
    DefaultTableModel modeloIngreso = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false; //Con esto conseguimos que la tabla no se pueda editar
                }
    };
    DefaultTableModel modeloTransaccion = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false; //Con esto conseguimos que la tabla no se pueda editar
                }
    };
    
    
    
   // final String BDCategoria = "categoria";
    final String BDGasto = "gasto";
    final String BDDeuda = "deuda";
    final String BDIngreso = "ingreso";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VistaAgregarTransaccion = new javax.swing.JFrame();
        BTVTAgregarATabla = new javax.swing.JButton();
        VTCBCategoria = new javax.swing.JComboBox<>();
        VTTFDinero = new javax.swing.JTextField();
        VTTFQuienMeDebe = new javax.swing.JTextField();
        VTTFFechaGasto = new javax.swing.JTextField();
        VTRBCatIngreso = new javax.swing.JRadioButton();
        VTRBCatDebo = new javax.swing.JRadioButton();
        VTRBCatDeben = new javax.swing.JRadioButton();
        VTRBCatComboBox = new javax.swing.JRadioButton();
        VTBTAceptar = new javax.swing.JButton();
        VTBTCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVTAgregarTransaccion = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        VistaMenu = new javax.swing.JFrame();
        BTMenuVerGastos = new javax.swing.JButton();
        BTMenuAddTransaccion = new javax.swing.JButton();
        BTMenuVerDeudas = new javax.swing.JButton();
        BTMenuVerIngresos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        VistaListaGastos = new javax.swing.JFrame();
        BTVListGastBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaGastos = new javax.swing.JTable();
        TFVListGastosFecha = new javax.swing.JTextField();
        TFVListGastosMonto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabelImagenListaGastos = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        TFPrincipalUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTIngresarUsuario = new javax.swing.JButton();
        TFPrincipalContraseña = new javax.swing.JPasswordField();
        jLabelFondo = new javax.swing.JLabel();

        VistaAgregarTransaccion.setPreferredSize(new java.awt.Dimension(744, 626));
        VistaAgregarTransaccion.setResizable(false);
        VistaAgregarTransaccion.setSize(new java.awt.Dimension(744, 626));
        VistaAgregarTransaccion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTVTAgregarATabla.setText("Agregar");
        BTVTAgregarATabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTVTAgregarATablaActionPerformed(evt);
            }
        });
        VistaAgregarTransaccion.getContentPane().add(BTVTAgregarATabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        VTCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VistaAgregarTransaccion.getContentPane().add(VTCBCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 90, -1));
        VistaAgregarTransaccion.getContentPane().add(VTTFDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, -1));

        VTTFQuienMeDebe.setText("¿Quien me debe?");
        VTTFQuienMeDebe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                VTTFQuienMeDebeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                VTTFQuienMeDebeFocusLost(evt);
            }
        });
        VistaAgregarTransaccion.getContentPane().add(VTTFQuienMeDebe, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 120, -1));

        VTTFFechaGasto.setText("dd/mm/aaaa");
        VistaAgregarTransaccion.getContentPane().add(VTTFFechaGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, -1));

        VTRBCatIngreso.setText("Ingreso");
        VistaAgregarTransaccion.getContentPane().add(VTRBCatIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        VTRBCatDebo.setText("Debo");
        VistaAgregarTransaccion.getContentPane().add(VTRBCatDebo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        VTRBCatDeben.setText("Me deben");
        VTRBCatDeben.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                VTRBCatDebenItemStateChanged(evt);
            }
        });
        VTRBCatDeben.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                VTRBCatDebenFocusGained(evt);
            }
        });
        VistaAgregarTransaccion.getContentPane().add(VTRBCatDeben, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));
        VistaAgregarTransaccion.getContentPane().add(VTRBCatComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        VTBTAceptar.setText("Aceptar");
        VistaAgregarTransaccion.getContentPane().add(VTBTAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        VTBTCancelar.setText("Cancelar");
        VistaAgregarTransaccion.getContentPane().add(VTBTCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, -1, -1));

        jTableVTAgregarTransaccion.setModel(modeloTransaccion);
        jScrollPane2.setViewportView(jTableVTAgregarTransaccion);

        VistaAgregarTransaccion.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 620, 170));

        jLabel3.setText("Dinero");
        VistaAgregarTransaccion.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        jLabel4.setText("$");
        VistaAgregarTransaccion.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaAgregarTransaccion.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 440, 330));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaAgregarTransaccion.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 360));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaAgregarTransaccion.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 640, 290));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaAgregarTransaccion.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 410, 400));

        VistaMenu.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        VistaMenu.setMinimumSize(new java.awt.Dimension(490, 320));
        VistaMenu.setResizable(false);
        VistaMenu.setSize(new java.awt.Dimension(490, 320));
        VistaMenu.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTMenuVerGastos.setText("Ver Gastos");
        BTMenuVerGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMenuVerGastosActionPerformed(evt);
            }
        });
        VistaMenu.getContentPane().add(BTMenuVerGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        BTMenuAddTransaccion.setText("Agregar Transaccion");
        BTMenuAddTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMenuAddTransaccionActionPerformed(evt);
            }
        });
        VistaMenu.getContentPane().add(BTMenuAddTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        BTMenuVerDeudas.setText("Ver Deudas");
        VistaMenu.getContentPane().add(BTMenuVerDeudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        BTMenuVerIngresos.setText("Ver Ingresos");
        VistaMenu.getContentPane().add(BTMenuVerIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaMenu.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        VistaListaGastos.setSize(new java.awt.Dimension(669, 312));
        VistaListaGastos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTVListGastBuscar.setText("Buscar");
        VistaListaGastos.getContentPane().add(BTVListGastBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        jTableListaGastos.setModel(modeloGasto);
        jScrollPane1.setViewportView(jTableListaGastos);

        VistaListaGastos.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 159, 372, 123));

        TFVListGastosFecha.setText("dd/mm/aaaa");
        VistaListaGastos.getContentPane().add(TFVListGastosFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 97, 79, -1));

        TFVListGastosMonto.setText("$0");
        VistaListaGastos.getContentPane().add(TFVListGastosMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 97, 52, -1));

        jLabel9.setText("Fecha");
        VistaListaGastos.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 51, -1, -1));

        jLabel7.setText("Monto");
        VistaListaGastos.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 51, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VistaListaGastos.getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 71, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VistaListaGastos.getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 71, -1, -1));

        jLabelImagenListaGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/colores calidos.jpg"))); // NOI18N
        VistaListaGastos.getContentPane().add(jLabelImagenListaGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 139, -1, -1));

        TFPrincipalUsuario.setText("Flor");
        getContentPane().add(TFPrincipalUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 159, 80, -1));

        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 216, -1, -1));

        BTIngresarUsuario.setText("Ingresar");
        BTIngresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTIngresarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BTIngresarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));
        getContentPane().add(TFPrincipalContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 236, 97, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flores.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 540, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTIngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTIngresarUsuarioActionPerformed
        //if (validarUser()){
        if(true){//aca se debe validar el usuario 
        VistaMenu.setVisible(true);
         this.setVisible(false);   
        } else {JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta!");}     
    }//GEN-LAST:event_BTIngresarUsuarioActionPerformed

    private void BTMenuAddTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMenuAddTransaccionActionPerformed
        VistaAgregarTransaccion.setVisible(true);
        button.getSelectedButtonText(radioBTGroup);
        VTTFQuienMeDebe.setEnabled(false);
    }//GEN-LAST:event_BTMenuAddTransaccionActionPerformed

    private void BTMenuVerGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMenuVerGastosActionPerformed
        VistaListaGastos.setVisible(true);
        //button.listar(jTableListaGastos, modeloGasto, button.sentencia(BDGasto));
    }//GEN-LAST:event_BTMenuVerGastosActionPerformed

    private void BTVTAgregarATablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTVTAgregarATablaActionPerformed
        String seleccionado =button.getSelectedButtonText(radioBTGroup);
        String[] datoAux={"Error","Error","Error","Error"};
        Object [] fila=new Object[4];
//modeloTransaccion.addRow(fila);
        switch (seleccionado){
            case "":{String[] dato= {devolverDatoComboBox(),VTTFDinero.getText(),"-",VTTFFechaGasto.getText()};datoAux=dato;break;}
            case "Ingreso":{String[] dato={seleccionado.toLowerCase(),VTTFDinero.getText(),"-",button.fechaDeSql(button.fechaDeHoy())};datoAux=dato;break;}
            case "Debo":{String[] dato={seleccionado.toLowerCase(),VTTFDinero.getText(), "Yo debo",button.fechaDeSql(button.fechaDeHoy())};datoAux=dato;break;}//si yo debo la deuda, el valor, es false, y si me deben es true
            case "Me deben":{String[] dato={seleccionado.toLowerCase(),VTTFDinero.getText(), VTTFQuienMeDebe.getText(),button.fechaDeSql(button.fechaDeHoy())};datoAux=dato;break;}
        }
        agregarDatosAFila(datoAux);
        System.out.println(datoAux);
        
        
        /*switch (seleccionado){
            case "":{button.agregarGasto(devolverDatoComboBox(), VTTFDinero.getText());}
            case "Ingreso":{button.agregarIngreso(VTTFDinero.getText());}
            case "Debo":{button.agregarDeuda(VTTFDinero.getText(), false, "Yo");}//si yo debo la deuda, el valor, es false, y si me deben es true
            case "Me deben":{button.agregarDeuda(VTTFDinero.getText(), true, VTTFQuienMeDebe.getText());}
        }*/
        
    }//GEN-LAST:event_BTVTAgregarATablaActionPerformed

    private void VTTFQuienMeDebeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VTTFQuienMeDebeFocusLost
        if(VTTFQuienMeDebe.getText()==""){VTTFQuienMeDebe.setText("¿Quien me debe?");}
    }//GEN-LAST:event_VTTFQuienMeDebeFocusLost

    private void VTTFQuienMeDebeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VTTFQuienMeDebeFocusGained
        VTTFQuienMeDebe.setText("");
    }//GEN-LAST:event_VTTFQuienMeDebeFocusGained

    private void VTRBCatDebenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VTRBCatDebenFocusGained
        VTTFQuienMeDebe.setEnabled(true);
    }//GEN-LAST:event_VTRBCatDebenFocusGained

    private void VTRBCatDebenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_VTRBCatDebenItemStateChanged
        if(!(VTRBCatDeben.isSelected())){VTTFQuienMeDebe.setEnabled(false);}
    }//GEN-LAST:event_VTRBCatDebenItemStateChanged

    
    private boolean validarUser(){
        String pass = String.valueOf(TFPrincipalContraseña.getPassword());
        String user = TFPrincipalUsuario.getText();
        boolean valor;
        if ((user.contains("Flor"))&(pass.contains("1234"))){valor= true;} 
        else {valor= false;}
        if ((user.contains("Vale"))&(pass.contains("4321"))){valor= true;}
        return valor;
    }
    private String devolverDatoComboBox(){
        String categoria= (String)VTCBCategoria.getSelectedItem();
        return categoria;
    }
    
  /*  private void keyPressedListar(java.awt.event.KeyEvent evt, String nomLista, JTable vista){
        if(evt.getKeyCode() == evt.VK_ENTER) {
            switch(nomLista){
                case BDGasto:{button.listar(vista, modeloGasto, button.sentencia("Productos"));}
                case BDDeuda:{button.listar(vista, modeloDeuda, button.sentencia("Proveedores"));}
                case BDIngreso:{button.listar(vista, modeloIngreso, button.sentencia("Clientes"));}
            }            
        }
        if(evt.getKeyCode() == evt.VK_ESCAPE) {
            vista.setVisible(false);
        }
    }*/
    
    private void agregarRadioButtonsAGrupo(){
        radioBTGroup.add(VTRBCatIngreso);
        radioBTGroup.add(VTRBCatDeben);
        radioBTGroup.add(VTRBCatDebo);
        radioBTGroup.add(VTRBCatComboBox);
    }
    
    private Object agregarDatosAFila(String[] dato){
        int objnum = jTableVTAgregarTransaccion.getColumnCount();
        Object[] fila = new Object[objnum];
        for (int i = 0; i< objnum; i++){
            fila[i] = dato[i];
        }
        return fila;
    }
 
    private void llenarCBCategorias(){
        connection = Conectar.getConnection();
        int itemCount = VTCBCategoria.getItemCount();
        for(int i=0;i<itemCount;i++){
            VTCBCategoria.removeItemAt(0);
        }
        try {
            preparedStatement = connection.prepareStatement("SELECT categoria FROM basededatoscontabilidad.categoria");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                VTCBCategoria.addItem(resultSet.getString("categoria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    /*  String sentencia(String nombreBD){
        String codigo;
        boolean op = false;
        switch(nombreBD){
            case BDGasto:{
                codigo = "SELECT idCategoria, monto, fecha FROM "+ BDGasto +" WHERE ";
                //si hay algo en el text field de codigo, lo agrega al codigo
                if (!(TFVListGastosFecha.getText().isEmpty())) {codigo += "Codigo = "+ TFLCodigoProducto.getText(); op = true;}
                //si hay algo en el text field de nombre y antes se habia escrito algo, lo agrega al codigo con un and, si no se habia escrito nada solo lo agrega
                if ((!(TFVListGastosMonto.getText().isEmpty())) & (op == true)) {codigo += " and monto ="+ ponerComillas(TFVListGastosMonto.getText()+"%");} 
                else if (!(TFVListGastosMonto.getText().isEmpty())){codigo += "monto = "+ ponerComillas(TFVListGastosMonto.getText()+"%"); op = true;}
                //idem ant
                if ((!(TFLFechaAñoProducto1.getText().isEmpty())&(!(TFLFechaMesProducto1.getText().isEmpty()))&(!(TFLFechaDiaProducto1.getText().isEmpty()))) & (op == true)) {codigo += " and FechaModificacion = "+ ponerComillas(unirFecha("Producto"));} 
                        else if ((!(TFLFechaAñoProducto1.getText().isEmpty()))&(!(TFLFechaMesProducto1.getText().isEmpty()))&(!(TFLFechaDiaProducto1.getText().isEmpty()))){codigo += "FechaModificacion = "+ ponerComillas(unirFecha("Producto")); op = true;}
                //si en ninguno se escribio nada, se cambia el codigo para que no quede el "WHERE " solo y produja un error
                if (op == false) {codigo = "SELECT idCategoria, monto, fecha FROM "+ BDGasto;} //codigo base
                break;                
            }
            
            case BDDeuda:{
                codigo = "SELECT idCategoria, monto, fecha FROM "+ BDDeuda +" WHERE ";
                //si hay algo en el text field de codigo, lo agrega al codigo
                if (!(TFLCodProveedor.getText().isEmpty())) {codigo += "CodProveedor = "+ TFLCodProveedor.getText(); op = true;}
                //si hay algo en el text field de nombre y antes se habia escrito algo, lo agrega al codigo con un and, si no se habia escrito nada solo lo agrega
                if ((!(TFLCuitProveedor.getText().isEmpty())) & (op == true)) {codigo += " and Cuit = "+ ponerComillas(TFLCuitProveedor.getText());} 
                        else if (!(TFLCuitProveedor.getText().isEmpty())){codigo += "Cuit = "+ ponerComillas(TFLCuitProveedor.getText()); op = true;}
                //si en ninguno se escribio nada, se cambia el codigo para que no quede el "WHERE " solo y produja un error
                if (op == false) {codigo = "SELECT idCategoria, monto, fecha FROM "+ BDDeuda;} //codigo base
                break;
            }
            
            case BDIngreso:{
                codigo = "SELECT idCategoria, monto, fecha FROM "+ BDIngreso +" WHERE ";
                //si hay algo en el text field de codigo, lo agrega al codigo
                if (!(TFLCodCliente.getText().isEmpty())) {codigo += "CodProveedor = "+ TFLCodCliente.getText(); op = true;}
                //si hay algo en el text field de nombre y antes se habia escrito algo, lo agrega al codigo con un and, si no se habia escrito nada solo lo agrega
                if ((!(TFLSaldoCliente.getText().isEmpty())) & (op == true)) {codigo += " and Saldo = "+ ponerComillas(TFLSaldoCliente.getText());} 
                        else if (!(TFLSaldoCliente.getText().isEmpty())){codigo += "Saldo = "+ ponerComillas(TFLSaldoCliente.getText()); op = true;}
                //si en ninguno se escribio nada, se cambia el codigo para que no quede el "WHERE " solo y produja un error
                if (op == false) {codigo = "SELECT idCategoria, monto, fecha FROM "+ BDIngreso;} //codigo base
                break;
            }
            default: codigo ="";
    }
       return codigo; 
    }*/
    
        private String ponerComillas(String palabra){
        String palabraConComillas ="'" + palabra + "'";
        return palabraConComillas;
    }
    
    
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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTIngresarUsuario;
    private javax.swing.JButton BTMenuAddTransaccion;
    private javax.swing.JButton BTMenuVerDeudas;
    private javax.swing.JButton BTMenuVerGastos;
    private javax.swing.JButton BTMenuVerIngresos;
    private javax.swing.JButton BTVListGastBuscar;
    private javax.swing.JButton BTVTAgregarATabla;
    private javax.swing.JPasswordField TFPrincipalContraseña;
    private javax.swing.JTextField TFPrincipalUsuario;
    private javax.swing.JTextField TFVListGastosFecha;
    private javax.swing.JTextField TFVListGastosMonto;
    private javax.swing.JButton VTBTAceptar;
    private javax.swing.JButton VTBTCancelar;
    private javax.swing.JComboBox<String> VTCBCategoria;
    private javax.swing.JRadioButton VTRBCatComboBox;
    private javax.swing.JRadioButton VTRBCatDeben;
    private javax.swing.JRadioButton VTRBCatDebo;
    private javax.swing.JRadioButton VTRBCatIngreso;
    private javax.swing.JTextField VTTFDinero;
    private javax.swing.JTextField VTTFFechaGasto;
    private javax.swing.JTextField VTTFQuienMeDebe;
    private javax.swing.JFrame VistaAgregarTransaccion;
    private javax.swing.JFrame VistaListaGastos;
    private javax.swing.JFrame VistaMenu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelImagenListaGastos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaGastos;
    private javax.swing.JTable jTableVTAgregarTransaccion;
    // End of variables declaration//GEN-END:variables
}