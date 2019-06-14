/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Medium;
import fr.positif.services.Services;
import static fr.positif.utils.RequestUtils.getIdFromRequest;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class GetMediumAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Client", "Employee"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {    
        Long id = getIdFromRequest(request);
        if (id == null)
            return false;
                
        Medium medium = Services.getMedium(id);
        request.setAttribute("medium", medium);

        return true;
    }
}
