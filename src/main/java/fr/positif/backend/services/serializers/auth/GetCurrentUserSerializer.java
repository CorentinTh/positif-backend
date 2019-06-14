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
import fr.positif.backend.services.serializers.entities.ClientSerializer;
import fr.positif.backend.services.serializers.entities.EmployeeSerializer;
import fr.positif.entities.Client;
import fr.positif.entities.Employee;
import fr.positif.entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class GetCurrentUserSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
                
        Person user = (Person) request.getAttribute("user");
        if (user != null)
        {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Client.class, new ClientSerializer());
            gsonBuilder.registerTypeAdapter(Employee.class, new EmployeeSerializer());

            Gson userGson = gsonBuilder.create(); 
            jsonContainer.add("user", userGson.toJsonTree(user));
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
    
}
