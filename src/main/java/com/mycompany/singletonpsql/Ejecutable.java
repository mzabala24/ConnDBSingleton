/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.singletonpsql;

import java.sql.SQLException;

/**
 *
 * @author martin
 */
public class Ejecutable {
    
   
    
    public static void main(String[] args){
        
        DataBaseConnection conn = DataBaseConnection.getInstance();
        
        try {
            conn.testDatos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
