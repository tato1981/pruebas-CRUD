<%-- 
    Document   : consultarUsuarios
    Created on : 4/12/2022, 2:33:04 p. m.
    Author     : duber
--%>


<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Control.AccionesUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabl de todos los Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h3>Todos los Usuarios</h3>
            <!--<a class="btn btn-success" href="registro_pacientes_admin.jsp">Agregar Nuevo</a>-->
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">DOCUMENTO</th>
                        <th class="text-center">EMAIL</th>                        
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                 <%
                  
                    List<Usuario> lista = AccionesUsuario.buscarAllUsuarios();
                    
                    for(Usuario usr : lista){                   
                    
                    
                %>
                <tbody>
                    
                   
                    
                        <td style="visibility:collapse; display:none" class="text-center"><%=usr.getId()%></td>
                        <td class="text-center"><%=usr.getNombres()%></td>
                        <td class="text-center"><%=usr.getApellidos()%></td>
                        <td class="text-center"><%=usr.getD_identidad()%></td>
                        <td class="text-center"><%=usr.getEmail()%></td>                        
                        <td style="visibility:collapse; display:none" class="text-center"><%=usr.getContrasena()%></td>
                        <td style="visibility:collapse; display:none" class="text-center"><%=usr.getConfirmar_contrasena()%>  </td>
                         
                        <td class="text-center">
                            <a href="editarUsuario.jsp?id=<%=usr.getId()%>" class="card-link">Editar</a>                                                     
                            <a href="borrarUsuario?id=<%=usr.getId()%>" class="card-link">Eliminar</a>
                        </td>
                    
                    <%}%>
                </tbody>
            </table>
       
        </div> 
                
                <br>
        <a href="index.jsp">Regresar al menu principal</a>
    </body>
</html>
