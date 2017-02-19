/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.User;
import com.fpmislata.service.UserServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gerard
 */
@WebServlet(name = "ControllerUser",
        loadOnStartup = 1,
        urlPatterns = {"/ListarUser",
            "/AltaUser",
            "/EliminarUser",
            "/ModificarUser",
            "/ControllerUser"})
public class ControllerUser extends HttpServlet {

    @EJB
    private UserServiceLocal userService;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        if (userPath.equals("/ListarUser")) {
            listarUser(request, response);
        }
    }
    private void listarUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            // Ejecutamos el metodo y obtenemos la lista
            List lista = userService.listUsers();
            ArrayList<User> listaArray = new ArrayList<>(lista);
//             Asignamos al request el atributo lista
            request.getSession().setAttribute("users",listaArray);
//             Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rdi = request.getRequestDispatcher("/listarUsers.jsp");
//             Cargamos la pagina
            rdi.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
