/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.ConsultationStateType;
import fr.positif.entities.Employee;
import fr.positif.services.Services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class GetConsultationsCountPerStatusAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = { "Employee" };
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {   
        Map<ConsultationStateType, Long> map = Services.getConsultationCountByStatus();
        request.setAttribute("map", map);

        return true;
    }
}
