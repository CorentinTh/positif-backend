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
import fr.positif.entities.Person;
import java.lang.reflect.Type;
/**
 *
 * @author bfrolin
 */
public class PersonSerializer implements JsonSerializer<Person> {

    @Override
    public JsonElement serialize(Person person, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonUser = new JsonObject();
        
        jsonUser.addProperty("id", person.getId());
        jsonUser.addProperty("firstname", person.getFirstname());
        jsonUser.addProperty("lastname", person.getLastname());
        jsonUser.addProperty("gender", person.getGender());
        jsonUser.addProperty("email", person.getEmail());
        jsonUser.addProperty("birthDate", person.getBirthDate().toString());
        jsonUser.addProperty("role", (person instanceof Employee) ? "Employee" : "Client");
                
        return jsonUser;
    }
}