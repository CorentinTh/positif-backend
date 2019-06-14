/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.positif.backend.AbstractSerializer;
import fr.positif.backend.services.serializers.entities.PersonSerializer;
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
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Person.class, new PersonSerializer());
            Gson userGson = gsonBuilder.create();

            jsonContainer.add("user", userGson.toJsonTree(user, Person.class));
        
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userPermission", (user instanceof Employee) ? "Employee" : "Client");
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
    
}
