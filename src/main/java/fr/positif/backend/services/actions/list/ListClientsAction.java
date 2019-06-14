/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions.list;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Client;
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
public class ListClientsAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"Employee"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) 
    {       
        PaginationValues paginationValues = getPaginationValuesFromRequest(request);
        
        List<Client> clients = Services.getClients(paginationValues.getPageNumber(), paginationValues.getPageSize());
        request.setAttribute("clients", clients);
        
        return true;
    }
    
}