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
public class EmployeeSerializer implements JsonSerializer<Employee> {

    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonEmployee = new JsonObject();
        
        jsonEmployee.addProperty("id", employee.getId());
        jsonEmployee.addProperty("firstname", employee.getFirstname());
        jsonEmployee.addProperty("lastname", employee.getLastname());
        jsonEmployee.addProperty("gender", employee.getGender());
        jsonEmployee.addProperty("email", employee.getEmail());
        jsonEmployee.addProperty("birthDate", employee.getBirthDate().toString());
        
        jsonEmployee.addProperty("experience", employee.getExperience().name());
        jsonEmployee.addProperty("voiceType", employee.getVoiceType().name());
        
        return jsonEmployee;
    }
}