/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.actions.auth;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Person;
import fr.positif.services.Services;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class LoginAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"none"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email == null || password == null)
            return false;
        
        Person user = Services.checkCredentials(email, password);
        
        request.setAttribute("logged", (user != null));
        request.setAttribute("user", user);

        return true;
    }
}
