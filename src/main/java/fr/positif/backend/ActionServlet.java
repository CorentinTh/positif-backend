package fr.positif.backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.positif.backend.services.actions.GetClientAction;
import fr.positif.backend.services.actions.GetMediumAction;
import fr.positif.backend.services.actions.auth.GetCurrentUserAction;
import fr.positif.backend.services.actions.list.ListClientsAction;
import fr.positif.backend.services.serializers.list.ListClientsSerializer;
import fr.positif.backend.services.serializers.auth.RegisterSerializer;
import fr.positif.backend.services.serializers.auth.LogoutSerializer;
import fr.positif.backend.services.actions.auth.LogoutAction;
import fr.positif.backend.services.actions.auth.RegisterAction;
import fr.positif.backend.services.actions.auth.LoginAction;
import fr.positif.backend.services.serializers.auth.LoginSerializer;
import fr.positif.backend.services.actions.list.ListMediumsAction;
import fr.positif.backend.services.serializers.GetClientSerializer;
import fr.positif.backend.services.serializers.GetMediumSerializer;
import fr.positif.backend.services.serializers.auth.GetCurrentUserSerializer;
import fr.positif.backend.services.serializers.list.ListMediumsSerializer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.positif.dao.JpaUtil;

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
                action = new GetCurrentUserAction();
                serializer = new GetCurrentUserSerializer();
                break;

            case "listMediums":
                action = new ListMediumsAction();
                serializer = new ListMediumsSerializer();
                break;

            case "getMedium": // Attribute : id
                action = new GetMediumAction();
                serializer = new GetMediumSerializer();
                break;

            case "listClients":
                action = new ListClientsAction();
                serializer = new ListClientsSerializer();
                break;

            case "getClient":  // Attribute : id
                action = new GetClientAction();
                serializer = new GetClientSerializer();
                break;
                
            case "listConsultations":  // Attribute : id person
                action = new GetClientAction();
                serializer = new GetClientSerializer();
                break;
                
            case "listCurrentConsultations":
                action = new GetClientAction();
                serializer = new GetClientSerializer();
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
            response.sendError(401, "Unauthorized " + session.getAttribute("userPermission").toString());
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
