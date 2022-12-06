<%-- 
    Document   : exitoso
    Created on : 30/11/2022, 10:10:23 p. m.
    Author     : duber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>registro exitoso</h1>
        <br>
        
        <%
        
           HttpSession sesionUsuario = request.getSession();
           
           /*
           si yo tubiera que consultar de la DB
           Verificar Usyario(String user, String pass)
           un objeto usuario
                      
           */                     
                                     //parametro  //usr.nombre()
           sesionUsuario.setAttribute("Usuario", "Duberney");
        
        %>
        <a href="index.jsp">Regresar al menu principal</a>
        <br>
        Bienvenido: <%out.println(sesionUsuario.getAttribute("Usuario"));%>
    </body>
</html>
