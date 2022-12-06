/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Control.AccionesUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class guardarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            /* Generar la sesion del usuario*/
            
            HttpSession sesionUsr = request.getSession( true);   // se obtuvo la sesion

            
            String idsesion = sesionUsr.getId();            
            
            long fechacreacion = sesionUsr.getCreationTime();           //saber la fecha de creacion de esta sesion
            
            long fechaultimoacceso = sesionUsr.getLastAccessedTime();      // saber el ultimo acceso a la sesion
            
            // Generar la creacion de la "cookie" de la sesion
            
            Integer cuenta = (Integer) sesionUsr.getAttribute("cuenta.ss");  //donde se va a guardar la sesion
            
            if(cuenta == null){
                   cuenta = new Integer(1);
            }else {
                   cuenta = new Integer(cuenta.intValue()+1);
            
            }
            
            sesionUsr.setAttribute("cuenta.ss", cuenta);
            
            // imprimir los valores de la sesion
            
            System.out.println("Id Sesion: "+ idsesion);
            System.out.println("Fecha en la que fue creada: "+ new Date(fechacreacion).toString());  //toString para convertir en cadena
            System.out.println("Fecha de ultimo ingreso: "+ new Date(fechaultimoacceso).toString());
            
            // visializar los parametros hasmap
            
            Enumeration parametrosSesion = sesionUsr.getAttributeNames();
            
            while(parametrosSesion.hasMoreElements()){
                
                String parametros =(String)parametrosSesion.nextElement();
                Object valor = sesionUsr.getAttribute(parametros);
                System.out.println("El parametro es: "+parametros   //parametro de la sesion
                                                      + "Su valor es: "+valor.toString());  //valor de la sesion
        
        }                           
                                 
                                               
            //obtener los parametros que vienen de formulario registro Usuario
            
            String nom,ape,doc,email,cont,confcont;
            
                   nom=request.getParameter("nombres");
                   ape=request.getParameter("apellidos");
                   doc=request.getParameter("d_identidad");
                   email=request.getParameter("email");
                   cont=request.getParameter("contrasena");
                   confcont=request.getParameter("confirmar_contrasena");
                            
                   //instanciar el Usuario
                   
                   Usuario usr = new Usuario();
                   
                   //enviar los paramentros
                   
                   usr.setNombres(nom);
                   usr.setApellidos(ape);
                   usr.setD_identidad(doc);
                   usr.setEmail(email);
                   usr.setContrasena(cont);
                   usr.setConfirmar_contrasena(confcont);
                   
                   int estatus = 
                   AccionesUsuario.registarUsuario(usr);
                   if(estatus > 0){
                       response.sendRedirect("registroUsuarios.jsp");
                   
                   }else{
                   response.sendRedirect("error.jsp");
                   
                   }
     
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
