/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Client;
import fr.positif.entities.Consultation;
import fr.positif.entities.ConsultationStateType;
import fr.positif.entities.Medium;
import fr.positif.entities.Prediction;
import fr.positif.services.Services;
import static fr.positif.utils.RequestUtils.getIdFromRequest;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class CloseConsultationAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Employee"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {    
        Long consultationId = getIdFromRequest(request);
        if (consultationId == null)
            return false;
        
        String comment = request.getParameter("comment");
        String closedAtString = request.getParameter("closedAt");
        Date closedAt;
        
        if (closedAtString != null)
        {
            try {
                closedAt = Date.from(Instant.parse(closedAtString));            
            }
            catch (DateTimeException e) {
                e.printStackTrace();
                return false;
            }
        }
        else closedAt = Date.from(Instant.now());         
        
        Consultation consultation = (Consultation) Services.getConsultation(consultationId);
        if (consultation.getState() != ConsultationStateType.PENDING)
            return false;
        
        List<Prediction> predictions = (List<Prediction>) request.getSession().getAttribute("lastPredictions");
        if (predictions != null)
            Services.setPredictionsForConsultation(consultation, predictions);
        
        Services.closeConsultation(consultation, comment, closedAt);
        
        request.setAttribute("status", true);

        return true;
    }
}
