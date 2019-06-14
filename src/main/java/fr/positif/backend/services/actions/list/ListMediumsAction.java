/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions.list;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Medium;
import fr.positif.services.Services;
import fr.positif.utils.PaginationValues;
import static fr.positif.utils.RequestUtils.getPaginationValuesFromRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class ListMediumsAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Client", "Employee"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {       
        PaginationValues paginationValues = getPaginationValuesFromRequest(request);

        List<Medium> mediums = Services.getMediums(paginationValues.getPageNumber(), paginationValues.getPageSize());
        request.setAttribute("mediums", mediums);
        
        return true;
    }
    
}