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
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nico
 */
public class Boton {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    final String BDCategoria = "basededatoscontabilidad.categoria";
    final String BDGasto = "basededatoscontabilidad.gasto";
    final String BDDeuda = "basededatoscontabilidad.deuda";
    final String BDIngreso = "basededatoscontabilidad.ingreso";
    

    public void listar(JTable tabla,DefaultTableModel modelo, String sentencia){
        try {
            vaciarTabla(tabla,modelo);
            connection = Conectar.getConnection();
            preparedStatement = connection.prepareStatement(sentencia);
            resultSet = preparedStatement.executeQuery();
            int objnum = tabla.getColumnCount();
            boolean hayFecha =false;
            int j=-1;
            for (int i = 0; i< objnum; i++){
                    if (tabla.getColumnName(i)=="Fecha"){hayFecha = true; j= i;}
                }
            Object[] fila = new Object[objnum];//Creamos un Objeto con tantos parámetros como datos retorne cada fila de la consulta
            if(hayFecha){
               while(resultSet.next()){
                 for (int i = 0; i< objnum; i++){
                    if (i == j){fila[i] = fechaDeSql((String)resultSet.getObject(i + 1));}
                    else{fila[i] = resultSet.getObject(i + 1);}
                }
                modelo.addRow(fila); // Añade una fila al final del modelo de la tabla
            }
            }else{
            while(resultSet.next()){
                for (int i = 0; i< objnum; i++){
                    fila[i] = resultSet.getObject(i + 1);
                }
                modelo.addRow(fila); // Añade una fila al final del modelo de la tabla
            }}            
            resultSet.close();
            tabla.updateUI();//Actualiza la tabla
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
    }
    
    public void agregarATabla(JTable tabla,DefaultTableModel modelo, Object[] fila){
        int objnum = tabla.getColumnCount();
        fila = new Object[objnum];
        for (int i = 0; i< objnum; i++){
            fila[i] = "";
        }
        modelo.addRow(fila);
    }
    
    public void agregarCategoria(String nomcat){
        try {
              connection = Conectar.getConnection();
              preparedStatement = connection.prepareStatement("INSERT INTO "+BDCategoria+" VALUES (?,?)");
              preparedStatement.setString(1,ultimoCodigo());
              preparedStatement.setString(2, nomcat);
              preparedStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, nomcat+ " fue agregado a la base de datos con exito!");
          } catch (SQLException ex) {
              Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Se produjo un error, verifique si los campos tienen el formato requerido correcto");
          }
    }
    
    public void agregarGasto(String nomcat, String monto){
        try {
              int idCategoria=devolverIdCategoria(nomcat);
              connection = Conectar.getConnection();
              preparedStatement = connection.prepareStatement("INSERT INTO "+BDGasto+" VALUES (?,?,?)");
              preparedStatement.setInt(1,idCategoria);
              preparedStatement.setDouble(2,Double.parseDouble(monto));
              preparedStatement.setString(3, fechaDeHoy());
              preparedStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, "Su gasto en "+nomcat+ " ($"+ monto+") fue agregado a la base de datos con exito!");
          } catch (SQLException ex) {
              Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Se produjo un error, verifique si los campos tienen el formato requerido correcto");
          }          
      }
    
    public void agregarIngreso(String monto){
        try {
              connection = Conectar.getConnection();
              preparedStatement = connection.prepareStatement("INSERT INTO "+BDIngreso+" VALUES (?,?)");
              preparedStatement.setDouble(1, Double.parseDouble(monto));
              preparedStatement.setString(2, fechaDeHoy());
              preparedStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, "Su ingreso ($"+ monto+") fue agregado a la base de datos con exito!");
          } catch (SQLException ex) {
              Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Se produjo un error, verifique si los campos tienen el formato requerido correcto");
          }          
      }
    
    public void agregarDeuda(String monto, boolean valor, String acreedor){//si yo debo la deuda, el valor, es false, y si me deben es true
        try {
              connection = Conectar.getConnection();
              preparedStatement = connection.prepareStatement("INSERT INTO "+BDDeuda+" VALUES (?,?,?,?)");
              preparedStatement.setDouble(1, Double.parseDouble(monto));
              preparedStatement.setString(2, fechaDeHoy());
              preparedStatement.setBoolean(3, valor);//yo debo o me deben?      false || true
              preparedStatement.setString(4, acreedor);//a quien le debo o quien me debe
              preparedStatement.executeUpdate();
              if (valor==false){JOptionPane.showMessageDialog(null, "Su deuda ($"+ monto+") a nombre de "+acreedor+" fue agregada a la base de datos con exito!");}
                else{JOptionPane.showMessageDialog(null, "La deuda ($"+ monto+") de "+acreedor+" fue agregada a la base de datos con exito!");}
          } catch (SQLException ex) {
              Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Se produjo un error, verifique si los campos tienen el formato requerido correcto");
          }
    }

    
    private void vaciarTabla(JTable tabla,DefaultTableModel modelo){
        for (int i = 0; i < tabla.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
        }
    }
    
    public String fechaDeHoy(){
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH));
        String año = Integer.toString(c1.get(Calendar.YEAR));
        if ((c1.get(Calendar.DATE)) < 10) {dia = "0" + Integer.toString(c1.get(Calendar.DATE));}
        if ((c1.get(Calendar.MONTH)) < 10) {mes = "0" + Integer.toString(c1.get(Calendar.MONTH));}
        String fechaParaSql = año + mes + dia;
        return fechaParaSql;
    }
    
    public String fechaDeSql(Object fechaObj){
        //String s = formatter.format(date);
            String fechaDeSql=(String) fechaObj;
            String fecha = ""+fechaDeSql.charAt(5)+fechaDeSql.charAt(6)+"/"+fechaDeSql.charAt(8)+fechaDeSql.charAt(9)+"/"+fechaDeSql.charAt(0)+fechaDeSql.charAt(1)+fechaDeSql.charAt(2)+fechaDeSql.charAt(3);
            return fecha;
        }
    
  public int devolverIdCategoria(String categoria){
      int idCategoria=0;  
      try {
            String codSig= "SELECT idCategoria FROM "+ BDCategoria+" WHERE categoria = '"+categoria+"'";
            connection = Conectar.getConnection();
            preparedStatement = connection.prepareStatement(codSig);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            idCategoria = resultSet.getInt("idCategoria");
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Boton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCategoria;
  } 
  
  public String getSelectedButtonText(ButtonGroup buttonGroup) {
	for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		AbstractButton button = buttons.nextElement();
		if (button.isSelected()) {
			return button.getText();
		}
	}
	return null;
}
    
  public String ultimoCodigo() {
      //devuelve el ultimo codigo +1 de los que se tienen guardados en la db
      String codSig= "SELECT MAX(idCategoria)+1 FROM "+ BDCategoria;
      try{ 
            connection = Conectar.getConnection();
            preparedStatement = connection.prepareStatement(codSig);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            codSig = resultSet.getString(1);
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(Boton.class.getName()).log(Level.SEVERE, null, ex);
        }
      return codSig;
   }
  
   
    
   
    

    
    
   
}
