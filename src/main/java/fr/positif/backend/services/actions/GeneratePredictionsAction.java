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
import fr.positif.entities.Prediction;
import fr.positif.services.Services;
import static fr.positif.utils.RequestUtils.getIdFromRequest;
import static fr.positif.utils.RequestUtils.getIntFromRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class GeneratePredictionsAction extends AbstractAction {

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
        
        Integer loveLevel = getIntFromRequest(request, "loveLevel");
        Integer healthLevel = getIntFromRequest(request, "healthLevel");
        Integer workLevel = getIntFromRequest(request, "workLevel");
                
        if (loveLevel == null || healthLevel == null || workLevel == null)
            return false;
      
        Consultation consultation = (Consultation) Services.getConsultation(consultationId);
        if (consultation.getState() != ConsultationStateType.PENDING)
            return false;
        
        List<Prediction> predictions = Services.generatePredictions(consultation, loveLevel, healthLevel, workLevel);
        request.setAttribute("predictions", predictions);

        return true;
    }
}
