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
import fr.positif.backend.services.serializers.entities.PredictionSerializer;
import fr.positif.entities.Prediction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public class GeneratePredictionsSerializer extends AbstractSerializer {
    
    @Override
    public void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonContainer = new JsonObject();

        List<Prediction> predictions = (List<Prediction>) request.getAttribute("predictions");
        if (predictions != null)
        {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Prediction.class, new PredictionSerializer());
            Gson clientGson = gsonBuilder.create();

            JsonArray jsonPredictions = new JsonArray(predictions.size());
            
            for (Prediction prediction : predictions)
                jsonPredictions.add(clientGson.toJsonTree(prediction));
            
            jsonContainer.add("predictions", jsonPredictions);
        }
        
        request.getSession().setAttribute("lastPredictions", predictions);
        
        PrintWriter out = this.getWriterWithJsonHeader(response);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonContainer, out);
    }
    
}
