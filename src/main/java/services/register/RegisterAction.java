/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.register;

import fr.positif.backend.AbstractAction;
import fr.positif.entities.Address;
import fr.positif.entities.Client;
import java.util.Date;
import fr.positif.services.Services;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class RegisterAction extends AbstractAction {

    @Override
    protected ArrayList<String> permissionsRequired() {
        String[] permissions = {"none"};
        return new ArrayList(Arrays.asList(permissions));
    }

    @Override
    public boolean execute(HttpServletRequest request) {
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String passwordConfirmed = request.getParameter("passwordConfirmed");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        
        if (address == null || email == null || phoneNumber == null || password == null || passwordConfirmed == null)
            return false;
        
        if (!passwordConfirmed.equals(password))
            return false;
        
        Client client = new Client(new Address(address), phoneNumber, email, lastname, firstname, password, gender, Date.from(Instant.parse(birthDate)));
        Boolean status = Services.registerClient(client);
        
        request.setAttribute("status", status);
        
        return true;
    }
    
}
