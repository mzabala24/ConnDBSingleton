/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.singletonpsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author martin
 */
public class DataBaseConnection {
    
    static Connection conn;
    private static  DataBaseConnection INSTANCE;
    
    private DataBaseConnection(){
    }
    
    private static void crearInstancia(){
        if(INSTANCE==null){
            INSTANCE = new DataBaseConnection();
        }
    }
    
    public static DataBaseConnection getInstance(){
        if(INSTANCE==null){
            crearInstancia();
        }
        return INSTANCE;
    }
    
    public static void borrarInstancia(){
        INSTANCE=null;
        closeConnection();
    }
    
    public void performConnection(){
         String cadenaConexion ="jdbc:postgresql://nuevo.aretico.com:5432/software_2";
         String user="grupo5";
         String passwd="Verano2015";
         try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(cadenaConexion, user, passwd);
        } catch (Exception e) {
             System.out.println("Error estableciendo conexion");
        }
    }
    
    public int testDatos() throws SQLException{
        String consulta="SELECT \"ID\" FROM grupo5.\"TEST\"";
        int siResgistro=0;
        PreparedStatement ps= conn.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {        
            siResgistro = siResgistro+1;
            System.out.println("");
        }
        return siResgistro;
    }
    
    public static void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error cerrando la conexion");
        }
    }
    
}
