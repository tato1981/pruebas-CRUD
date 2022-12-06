/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Control.AccionesUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duber
 */
public class actualizarUsuario1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           //optener los parametros
            
            String nom,ape,doc,email,cont,confcont;
            
                   int id = Integer.parseInt(request.getParameter("id2"));
            
                   nom=request.getParameter("nombres2");
                   ape=request.getParameter("apellidos2");
                   doc=request.getParameter("d_identidad2");
                   email=request.getParameter("email2");
                   cont=request.getParameter("contrasena2");
                   confcont=request.getParameter("confirmar_contrasena2");
            
                 //instancia Usuario
                 
                   Usuario usr = new Usuario();
                   
                   usr.setId(id);
                   usr.setNombres(nom);
                   usr.setApellidos(ape);
                   usr.setD_identidad(doc);
                   usr.setEmail(email);
                   usr.setContrasena(cont);
                   usr.setConfirmar_contrasena(confcont);
            
                   int estatus = AccionesUsuario.actualizarUsuario(usr);
                  
                   if(estatus > 0){
                      response.sendRedirect("consultarUsuarios.jsp");
                   
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
