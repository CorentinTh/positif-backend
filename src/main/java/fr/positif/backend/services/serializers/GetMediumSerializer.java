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
import fr.positif.backend.services.serializers.entities.MediumSerializer;
import fr.positif.entities.Medium;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class GetMediumSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
                
        Medium medium = (Medium) request.getAttribute("medium");
        if (medium != null)
        {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Medium.class, new MediumSerializer());

            Gson mediumGson = gsonBuilder.create(); 
            jsonContainer.add("medium", mediumGson.toJsonTree(medium));
        }
        else
        {
            jsonContainer.addProperty("error", "no medium found");
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
}
