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
import fr.positif.entities.Medium;
import java.lang.reflect.Type;
/**
 *
 * @author bfrolin
 */
public class MediumSerializer implements JsonSerializer<Medium> {

    @Override
    public JsonElement serialize(Medium medium, Type type, JsonSerializationContext jsc) {
                JsonObject jsonMedium = new JsonObject();
                
        jsonMedium.addProperty("id", medium.getId());
        jsonMedium.addProperty("name", medium.getName());
        jsonMedium.addProperty("picturePath", medium.getPicturePath());
        jsonMedium.addProperty("talent", medium.getTalent().name());
        jsonMedium.addProperty("speciality", medium.getSpeciality());
        jsonMedium.addProperty("training", medium.getTrainig());
        jsonMedium.addProperty("schoolYear", medium.getSchoolYear());
        
        return jsonMedium;
    }
}