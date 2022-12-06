<%-- 
    Document   : editarUsuario
    Created on : 4/12/2022, 3:07:49 p. m.
    Author     : duber
--%>

<%@page import="Control.AccionesUsuario"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Registro de Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
       <div class="container">
            <h1 class="form-title"> Actualizar Registro de Usuarios</h1>
            <form  method="post" name="actualizarDatos" action="actualizarUsuario1"   class="table table-bordered">

                <div class="main-user-info">
                    
                    <!--codigo java para obtener los datos que sean visializados en este formilario-->
                    
                    <%
                    
                      int id = Integer.parseInt(request.getParameter("id"));
                      Usuario usr = AccionesUsuario.buscarUsuarioById(id);
                    
                    %>
                    
                    
                    <div class="user-input-box">
                        <label class="nuevpassword">ID</label>
                        <input type="hidden"                             
                               name="id2"
                               value="<%=usr.getId()%>" >                               
                               
                    </div>
                                        
                    <div class="user-input-box">
                        <label class="nombres">Nombres</label>
                        <input type="text"
                               id="nombres"
                               placeholder="Nombre"
                               name="nombres2"
                               value="<%=usr.getNombres()%>">
                    </div>

                    <div class="user-input-box">
                        <label class="apellidos">Apellidos</label>
                        <input type="text"
                               id="apellidos"
                               placeholder="Apellidos"
                               name="apellidos2"
                               value="<%=usr.getApellidos()%>" >
                    </div>

                    <div class="user-input-box">
                        <label class="documento">Documento</label>
                        <input type="text"
                               id="documento"
                               placeholder="Documento"
                               name="d_identidad2"
                               value="<%=usr.getD_identidad()%>">            
                    </div>

                    <div class="user-input-box">
                        <label class="email">E-mail</label>
                        <input type="email"
                               id="email"
                               placeholder="Tu E-mail"
                               name="email2"
                               value="<%=usr.getEmail()%>">
                    </div>


                    <div class="user-input-box">
                        <label class="nuevpassword">Nueva contraseña</label>
                        <input type="password"
                               id="contrasena"
                               placeholder="Nueva contraseña"                             
                               name="contrasena2"
                               value="<%=usr.getContrasena()%>">
                    </div>

                    <div class="user-input-box">
                        <label class="confirmpasswod">Confirmar Contraseña</label>
                        <input type="password"
                               id="confirmar_contrasena"
                               placeholder="Confirmar contraseña"                              
                               name="confirmar_contrasena2"
                               value="<%=usr.getConfirmar_contrasena()%>">
                    </div>          

                    <div class="form-submit-btn">
                        
                        
                        <input  type="submit" value="Actualizar Usuario" >
                    </div>
                </div>
            </form> 
           
            <div class="consultarUsuarios">
                <a href="consultarUsuarios.jsp">Consultar a todos los Usuarios</a>
                
            </div>
        </div>   

    </body>
</html>
