/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import fr.positif.entities.Client;
import fr.positif.entities.Consultation;
import fr.positif.entities.Employee;
import fr.positif.entities.Medium;
import fr.positif.entities.Prediction;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
/**
 *
 * @author bfrolin
 */
public class ConsultationSerializer implements JsonSerializer<Consultation> {

    @Override
    public JsonElement serialize(Consultation consultation, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonConsultation = new JsonObject();
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Employee.class, new EmployeeSerializer());
        gsonBuilder.registerTypeAdapter(Medium.class, new MediumSerializer());
        gsonBuilder.registerTypeAdapter(Client.class, new ClientSerializer());
        gsonBuilder.registerTypeAdapter(Prediction.class, new PredictionSerializer());
        Gson gson = gsonBuilder.create();

        jsonConsultation.addProperty("id", consultation.getId());
        jsonConsultation.addProperty("state", consultation.getState().name());
        
        List<Prediction> predictions = consultation.getPredictions();
        JsonArray jsonPredictions = new JsonArray(predictions.size());
        for(Prediction prediction : predictions)
            jsonPredictions.add(gson.toJsonTree(prediction));
        
        jsonConsultation.add("predictions", jsonPredictions);
      
        jsonConsultation.addProperty("comment", consultation.getComment());
        
        jsonConsultation.addProperty("createdAt", (consultation.getCreatedAt() != null) ? df.format(consultation.getCreatedAt()) : "null"); 
        jsonConsultation.addProperty("answeredAt", (consultation.getAnsweredAt() != null) ? df.format(consultation.getAnsweredAt()) : "null");
        jsonConsultation.addProperty("closedAt", (consultation.getClosedAt()!= null) ? df.format(consultation.getClosedAt()) : "null");        
        
        jsonConsultation.add("employee", gson.toJsonTree(consultation.getEmployee()));
        jsonConsultation.add("client", gson.toJsonTree(consultation.getClient()));
        jsonConsultation.add("medium", gson.toJsonTree(consultation.getMedium()));
        
        return jsonConsultation;
    }
}