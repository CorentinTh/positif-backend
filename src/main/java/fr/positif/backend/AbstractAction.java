package fr.positif.backend;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bfrolin
 */
public abstract class AbstractAction {    
    
    protected abstract ArrayList<String> permissionsRequired();
        
    public boolean isAuthorized(String userPermission) {
        return permissionsRequired().contains(userPermission);
    }
    
    public abstract boolean execute(HttpServletRequest request);
}
