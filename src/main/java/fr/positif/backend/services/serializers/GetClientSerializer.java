/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.positif.backend.AbstractSerializer;
import fr.positif.backend.services.serializers.entities.ClientSerializer;
import fr.positif.backend.services.serializers.entities.MediumSerializer;
import fr.positif.entities.Client;
import fr.positif.entities.Medium;
import fr.positif.entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class GetClientSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
                
        Person person = (Person) request.getAttribute("client");
        if (person != null)
        {
            if (person instanceof Client) 
            {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Client.class, new ClientSerializer());

                Gson clientGson = gsonBuilder.create(); 
                jsonContainer.add("client", clientGson.toJsonTree(person));   
            }
            else
            {
                jsonContainer.addProperty("error", "found an employee not a client");
            }
        }
        else
        {
            jsonContainer.addProperty("error", "no client found");
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
}
