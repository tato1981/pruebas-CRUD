
package Control;


import Modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


//accciones del modelo usuario

public class AccionesUsuario {
    /*
    son todas las opeeraciones o requerimientos 
    funcionales con que el usuario operaro el sistema
    
    registrarUsuario --> Usuario usr
    actualizarUsuario --> Usuario usr
    eliminarUsuario --> int id
    buscarUsuario --> int id
    buscarTodoslosUsuarios -->
    verificarUsuario--> documento, contraseña    
    */
    
    public static int registarUsuario (Usuario usr){
    
          int estatus = 0;
          
          try{
              //conexion con la base de datps
              Connection con = Conexion.getConnection();
              //sentencia sql
              String sql = "INSERT INTO usuario (nombres, apellidos, d_identidad, email, contrasena, confirmar_contrasena) VALUES(?,?,?,?,?,?)";
              //prepara la consulta
             PreparedStatement ps = con.prepareStatement(sql);
              
              //getter and setter
              
            ps.setString(1, usr.getNombres());
            ps.setString(2, usr.getApellidos());
            ps.setString(3, usr.getD_identidad());
            ps.setString(4, usr.getEmail());
            ps.setString(5, usr.getContrasena());
            ps.setString(6, usr.getConfirmar_contrasena());
            
            estatus = ps.executeUpdate();
            System.out.print("Registro Exitoso de Usuario");
            con.close();            
              
          }catch(Exception e){
               System.out.print("Error al registrar al Usuario");
               System.out.print(e.getMessage());
          }
    
           return estatus;               
    }
    
    
    public static int actualizarUsuario (Usuario usr){
    
          int estatus = 0;
          
          try{
              //conexion con la base de datps
              Connection con = Conexion.getConnection();
              
              //sentencia sql
              String sql = "UPDATE usuario SET nombres = ?, apellidos = ?, d_identidad = ?, email = ?, contrasena = ?, confirmar_contrasena = ?  WHERE id = ?";
              
              //prepara la consulta
             PreparedStatement ps = con.prepareStatement(sql);
              
              //getter and setter
              
            ps.setString(1, usr.getNombres());
            ps.setString(2, usr.getApellidos());
            ps.setString(3, usr.getD_identidad());
            ps.setString(4, usr.getEmail());
            ps.setString(5, usr.getContrasena());
            ps.setString(6, usr.getConfirmar_contrasena());
            ps.setInt(7, usr.getId());
            
                        
            estatus = ps.executeUpdate();  // ejecutar la sentencia
            System.out.print("Actualizacion exitosa del usuario");
            con.close();            
              
          }catch(Exception e){
               System.out.print("Error al actualizar al usuario Usuario");
               System.out.print(e.getMessage());
          }
    
           return estatus;               
    }
    
    
    public static int borrarUsuario (int id){
    
          int estatus = 0;
          
          try{
              //conexion con la base de datps
              Connection con = Conexion.getConnection();
              
              //sentencia sql
              String sql = "DELETE FROM usuario WHERE id = ?";
              //prepara la consulta
             PreparedStatement ps = con.prepareStatement(sql);
              
              //getter and setter
              
            
            ps.setInt(1, id);
            
            estatus = ps.executeUpdate();
            System.out.print("Borrado exitoso del usuario");
            con.close();            
              
          }catch(Exception e){
               System.out.print("Error al borrar al usuario Usuario");
               System.out.print(e.getMessage());
          }
    
           return estatus;               
    }
    
    
    public static Usuario buscarUsuarioById (int id){
    
       Usuario usr = new Usuario();
          
          try{
              //conexion con la base de datps
              Connection con = Conexion.getConnection();
              
              //sentencia sql
              String sql = "SELECT *FROM usuario WHERE id=?";
              
              //prepara la consulta
             PreparedStatement ps = con.prepareStatement(sql);
              
              
              ps.setInt(1, id);
              
              ResultSet rs= ps.executeQuery();
              
              if(rs.next()){
              
              usr.setId(rs.getInt(1));
              usr.setNombres(rs.getString(2));
              usr.setApellidos(rs.getString(3));
              usr.setD_identidad(rs.getString(4));
              usr.setEmail(rs.getString(5));
              usr.setContrasena(rs.getString(6));
              usr.setConfirmar_contrasena(rs.getString(7));             
              
              }            
                            
            System.out.print("Empleado encontrado");
            con.close();            
              
          }catch(Exception e){
               System.out.print("Error al encontrar al Usuario");
               System.out.print(e.getMessage());
          }
    
           return usr;               
    }
    
    
    
    public static List<Usuario> buscarAllUsuarios (){
        List<Usuario> lista = new ArrayList<Usuario>();
        
       
          
          try{
              //conexion con la base de datps
              Connection con = Conexion.getConnection();
              
              //sentencia sql
              String sql = "SELECT * FROM usuario";
              
              //prepara la consulta
             PreparedStatement ps = con.prepareStatement(sql);
              
              //ejecucion de la consulta                           
              ResultSet rs= ps.executeQuery();
              
              while(rs.next()){
                  
              Usuario usr = new Usuario();
              
              usr.setId(rs.getInt(1));
              usr.setNombres(rs.getString(2));
              usr.setApellidos(rs.getString(3));
              usr.setD_identidad(rs.getString(4));
              usr.setEmail(rs.getString(5));
              usr.setContrasena(rs.getString(6));
              usr.setConfirmar_contrasena(rs.getString(7));
              lista.add(usr);
              
              }                          
              
            System.out.print("Empleado encontrado");
            con.close();            
              
          }catch(Exception e){
               System.out.print("Error al encontrar al Usuario");
               System.out.print(e.getMessage());
          }
    
           return lista;               
    }
}
