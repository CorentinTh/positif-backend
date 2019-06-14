/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers.list;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.positif.backend.AbstractSerializer;
import fr.positif.backend.services.serializers.entities.ConsultationSerializer;
import fr.positif.backend.services.serializers.entities.MediumSerializer;
import fr.positif.entities.Consultation;
import fr.positif.entities.Medium;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class ListConsultationsSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();
        
        List<Consultation> consultations = (List<Consultation>) request.getAttribute("consultations");
        if (consultations != null)
        {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Consultation.class, new ConsultationSerializer());
            Gson consultationGson = gsonBuilder.create();

            JsonArray jsonConsultations = new JsonArray(consultations.size());
            
            for (Consultation consultation : consultations)
                jsonConsultations.add(consultationGson.toJsonTree(consultation));
            
            jsonContainer.add("consultations", jsonConsultations);
        }
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
    
}
