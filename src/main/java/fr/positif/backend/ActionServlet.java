package fr.positif.backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.positif.backend.services.actions.AcceptConsultationAction;
import fr.positif.backend.services.actions.AskForConsultationAction;
import fr.positif.backend.services.actions.CloseConsultationAction;
import fr.positif.backend.services.actions.GeneratePredictionsAction;
import fr.positif.backend.services.actions.GetClientAction;
import fr.positif.backend.services.actions.GetClientsCountByEmployeeAction;
import fr.positif.backend.services.actions.GetConsultationAction;
import fr.positif.backend.services.actions.GetConsultationsCountPerDayAction;
import fr.positif.backend.services.actions.GetConsultationsCountPerStatusAction;
import fr.positif.backend.services.actions.GetCurrentConsultationAction;
import fr.positif.backend.services.actions.GetMediumAction;
import fr.positif.backend.services.actions.auth.GetCurrentUserAction;
import fr.positif.backend.services.actions.list.ListClientsAction;
import fr.positif.backend.services.serializers.list.ListClientsSerializer;
import fr.positif.backend.services.serializers.auth.LogoutSerializer;
import fr.positif.backend.services.actions.auth.LogoutAction;
import fr.positif.backend.services.actions.auth.RegisterAction;
import fr.positif.backend.services.actions.auth.LoginAction;
import fr.positif.backend.services.actions.list.ListConsultationsAction;
import fr.positif.backend.services.actions.list.ListCurrentUserConsultationsAction;
import fr.positif.backend.services.serializers.auth.LoginSerializer;
import fr.positif.backend.services.actions.list.ListMediumsAction;
import fr.positif.backend.services.serializers.GeneratePredictionsSerializer;
import fr.positif.backend.services.serializers.GetClientSerializer;
import fr.positif.backend.services.serializers.GetConsultationsCountPerDaySerializer;
import fr.positif.backend.services.serializers.GetConsultationSerializer;
import fr.positif.backend.services.serializers.GetMediumSerializer;
import fr.positif.backend.services.serializers.GetClientsCountByEmployeeSerializer;
import fr.positif.backend.services.serializers.GetConsultationsCountPerStatusSerializer;
import fr.positif.backend.services.serializers.SimpleStatusSerializer;
import fr.positif.backend.services.serializers.auth.GetCurrentUserSerializer;
import fr.positif.backend.services.serializers.list.ListConsultationsSerializer;
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

        AbstractSerializer serializer;
        AbstractAction action;
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
                serializer = new SimpleStatusSerializer();
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
                action = new ListConsultationsAction();
                serializer = new ListConsultationsSerializer();
                break;
                
            case "listCurrentUserConsultations":
                action = new ListCurrentUserConsultationsAction();
                serializer = new ListConsultationsSerializer();
                break;
            
            case "getConsultation":
                action = new GetConsultationAction();
                serializer = new GetConsultationSerializer();
                break;
                
            case "listCurrentConsultations":
                action = new GetClientAction();
                serializer = new GetClientSerializer();
                break;
                
            case "askForConsultation":
                action = new AskForConsultationAction();
                serializer = new SimpleStatusSerializer();
                break;

            case "getCurrentConsultation":
                action = new GetCurrentConsultationAction();
                serializer = new GetConsultationSerializer();
                break;
                
            case "acceptConsultation":
                action = new AcceptConsultationAction();
                serializer = new SimpleStatusSerializer();
                break;
                
            case "generatePredictions":
                action = new GeneratePredictionsAction();
                serializer = new GeneratePredictionsSerializer();
                break;
                
            case "closeConsultation":
                action = new CloseConsultationAction();
                serializer = new SimpleStatusSerializer();
                break;
                
            case "getClientsCountByEmployee":
                action = new GetClientsCountByEmployeeAction();
                serializer = new GetClientsCountByEmployeeSerializer();
                break;
                
            case "getConsultationsCountPerDay":
                action = new GetConsultationsCountPerDayAction();
                serializer = new GetConsultationsCountPerDaySerializer();
                break;
                
            case "getConsultationsCountByStatus":
                action = new GetConsultationsCountPerStatusAction();
                serializer = new GetConsultationsCountPerStatusSerializer();
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
