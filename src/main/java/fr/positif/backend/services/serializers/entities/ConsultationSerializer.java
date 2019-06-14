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
import fr.positif.entities.Employee;
import java.lang.reflect.Type;
/**
 *
 * @author bfrolin
 */
public class ConsultationSerializer implements JsonSerializer<Employee> {

    //TODO : Left here Balthazar
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonConsultation = new JsonObject();

        return jsonConsultation;
    }
}