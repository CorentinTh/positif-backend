package fr.positif.backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.positif.dao.JpaUtil;
import fr.positif.services.ServicesInit;
import services.login.LoginAction;
import services.login.LoginSerializer;
import services.logout.LogoutAction;
import services.logout.LogoutSerializer;
import services.register.RegisterAction;
import services.register.RegisterSerializer;

/**
 *
 * @author bfrolin
 */
@WebServlet(urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        
        JpaUtil.init();

        ServicesInit.insertEmployees();
        ServicesInit.insertMediums();
    }

    @Override
    public void destroy() {
        super.destroy();
        
        JpaUtil.destroy();
    }
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
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("userPermission") == null) {
            session.setAttribute("userPermission", "none");
        }

        request.setCharacterEncoding("UTF-8");
        String doParam = request.getParameter("do");

        AbstractSerializer serializer = null;
        AbstractAction action = null;
        switch (doParam) {
            case "login":
                action = new LoginAction();
                serializer = new LoginSerializer();
                break;
                
            case "logout": 
                action = new LogoutAction();
                serializer = new LogoutSerializer();
                break;
                
            case "register":
                action = new RegisterAction();
                serializer = new RegisterSerializer();
                break;

            case "getCurrentUser": // user in session
                action = new RegisterAction();
                serializer = new RegisterSerializer();
                break;

            case "listMediums":
                break;

            case "getMedium": // Attribute : id
                break;

            case "listClients":
                break;

            case "getClient":
                break;

            default:
                response.sendError(404, "Request Not Found");
                return;
        }

        if (action == null || serializer == null) {
            response.sendError(500, "no action or serializer found.");
            return;
        }

        if (!action.isAuthorized(session.getAttribute("userPermission").toString())) {
            System.out.println(session.getAttribute("userPermission").toString());
            response.sendError(401, "Unauthorized" + session.getAttribute("userPermission").toString());
            return;
        }

        if (!action.execute(request)) {
            response.sendError(500, "action execution failed.");
            return;
        }

        serializer.serialize(request, response);
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
