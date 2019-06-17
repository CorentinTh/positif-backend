/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions.list;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Client;
import fr.positif.entities.Consultation;
import fr.positif.entities.Employee;
import fr.positif.entities.Person;
import fr.positif.services.Services;
import fr.positif.utils.PaginationValues;
import static fr.positif.utils.RequestUtils.getIdFromRequest;
import static fr.positif.utils.RequestUtils.getPaginationValuesFromRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class ListCurrentUserConsultationsAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Employee", "Client"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {       
        PaginationValues paginationValues = getPaginationValuesFromRequest(request);
        Person person = (Person) request.getSession().getAttribute("user");
        if (person == null)
            return false;
        
        List<Consultation> consultations;
        if (person instanceof Employee)
            consultations = Services.getConsultations(paginationValues.getPageNumber(), paginationValues.getPageSize(), (Employee) person);
        else
            consultations = Services.getConsultations(paginationValues.getPageNumber(), paginationValues.getPageSize(), (Client) person);
        
        request.setAttribute("consultations", consultations);
        
        return true;
    }
    
}