/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.positif.backend.AbstractSerializer;
import fr.positif.entities.Employee;
import fr.positif.entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bfrolin
 */
public class LoginSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
        
        jsonContainer.addProperty("logged", (Boolean) request.getAttribute("logged"));
        
        Person user = (Person) request.getAttribute("user");
        if (user != null)
        {
            JsonObject jsonUser = new JsonObject();
            
            jsonUser.addProperty("id", user.getId());
            jsonUser.addProperty("firstname", user.getFirstname());
            jsonUser.addProperty("lastname", user.getLastname());
            jsonUser.addProperty("gender", user.getGender());
            jsonUser.addProperty("email", user.getEmail());
            jsonUser.addProperty("birthDate", user.getBirthDate().toString());
            jsonUser.addProperty("role", (user instanceof Employee) ? "Employee" : "Client");
            
            jsonContainer.add("user", jsonUser);          
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userPermission", (user instanceof Employee) ? "Employee" : "Client");
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
    
}
