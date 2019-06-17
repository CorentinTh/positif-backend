/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.backend.services.serializers.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import fr.positif.entities.Prediction;
import java.lang.reflect.Type;
/**
 *
 * @author bfrolin
 */
public class PredictionSerializer implements JsonSerializer<Prediction> {

    @Override
    public JsonElement serialize(Prediction prediction, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonPrediction = new JsonObject();
        
        jsonPrediction.addProperty("type", prediction.getType().name());
        jsonPrediction.addProperty("content", prediction.getContent());
        jsonPrediction.addProperty("degree", prediction.getDegree());
        
        return jsonPrediction;
    }
}