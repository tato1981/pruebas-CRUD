
package Modelo;

//modelo usuario 

public class Usuario {
    
    //variables globales del modelo usuario
    private int id;
     
    private String nombres,apellidos,d_identidad,email,contrasena,confirmar_contrasena;

    
    //constructor modelo usuario
    
    public Usuario() {
    }

    
    //getter and setter del modelo usuario
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getD_identidad() {
        return d_identidad;
    }

    public void setD_identidad(String d_identidad) {
        this.d_identidad = d_identidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmar_contrasena() {
        return confirmar_contrasena;
    }

    public void setConfirmar_contrasena(String confirmar_contrasena) {
        this.confirmar_contrasena = confirmar_contrasena;
    }

}