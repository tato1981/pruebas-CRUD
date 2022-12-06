/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.SQLException;

/**
 *
 * @author duber
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
      Conexion.getConnection();
      System.out.println("Conexion Exitosa");   
}
}