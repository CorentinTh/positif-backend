/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bfrolin
 */
public class RequestUtils {
    
    public static PaginationValues getPaginationValuesFromRequest(final HttpServletRequest request)
    {
        Integer pageNumber;
        Integer pageSize;
        
        try 
        {
            pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            pageSize = Integer.valueOf(request.getParameter("pageSize"));
        }
        catch (NumberFormatException e)
        {
            pageNumber = 1;
            pageSize = 100;
        }

        return new PaginationValues(pageNumber, pageSize);
    }
    
    public static Long getIdFromRequest(final HttpServletRequest request)
    {
        Long id;
        
        try 
        {
            id = Long.parseLong(request.getParameter("id"));
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return null;
        }
        
        return id;
    }
    
    public static Integer getIntFromRequest(final HttpServletRequest request, final String name)
    {
        Integer id;
        
        try 
        {
            id = Integer.parseInt(request.getParameter(name));
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return null;
        }
        
        return id;
    }
}
