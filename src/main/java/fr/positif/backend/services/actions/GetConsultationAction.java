/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Consultation;
import fr.positif.entities.Person;
import fr.positif.services.Services;
import static fr.positif.utils.RequestUtils.getIdFromRequest;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class GetConsultationAction extends AbstractAction {

    //TODO: Secure check id client
    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Employee", "Client"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {    
        Long id = getIdFromRequest(request);
        if (id == null)
            return false;
        
        Consultation consultation = Services.getConsultation(id);
        if (consultation == null)
            return false;
        
        request.setAttribute("consultation", consultation);

        return true;
    }
}
