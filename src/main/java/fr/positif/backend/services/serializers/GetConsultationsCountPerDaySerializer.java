/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.positif.backend.AbstractSerializer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class GetConsultationsCountPerDaySerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
                
        Map<Integer, Long> map = (Map<Integer, Long>) request.getAttribute("map");
        if (map != null)
        {
            JsonArray jsonMap = new JsonArray();
            for (Entry<Integer, Long> entry : map.entrySet())
            {
                JsonObject jsonEntry = new JsonObject();
                
                jsonEntry.addProperty("day", entry.getKey());
                jsonEntry.addProperty("count", entry.getValue());     
                
                jsonMap.add(jsonEntry);
            }
            jsonContainer.add("map", jsonMap);
        }
        else
        {
            jsonContainer.addProperty("error", "no statistics found");
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
}
