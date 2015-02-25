/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.jmx.trace.TraceTags;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 *
 * @author martin
 */
public class TestConnectionDB {
    
    public TestConnectionDB() {
    }
    @Test
    public void pruebaConnectionPostgresql(){
    
        Connection conexion=null;
        try {
            String cadenaConexion ="jdbc:postgresql://nuevo.aretico.com:5432/software_2";
            String user="grupo5";
            String passwd="Verano2015";
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(cadenaConexion, user, passwd);
            Assert.assertNotNull(conexion);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }finally{
            if(conexion!=null)
                try {
                    conexion.close();
                } catch (SQLException e) {
                    //Logger.getLogger(TestConnectionDB.class.getName()).;
                }
        }
    }
    @Test
    public void pruebaConsultaPostgreSQL(){
        String consulta="SELECT \"ID\" FROM grupo5.\"TEST\"";
        Connection conexion=null;
        
        try {
            String cadenaConexion ="jdbc:postgresql://nuevo.aretico.com:5432/software_2";
            String user="grupo5";
            String passwd="Verano2015";
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(cadenaConexion, user, passwd);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Assert.assertNotNull(rs.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }finally{
            if(conexion!=null)
                try {
                    conexion.close();
                } catch (SQLException e) {
                    //Logger.getLogger(TestConnectionDB.class.getName()).;
                }
        }
    }
    
}
