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
import fr.positif.entities.Client;
import java.lang.reflect.Type;
/**
 *
 * @author bfrolin
 */
public class ClientSerializer implements JsonSerializer<Client> {

    @Override
    public JsonElement serialize(Client client, Type type, JsonSerializationContext jsc) 
    {
        JsonObject jsonClient = new JsonObject();
       
        jsonClient.addProperty("id", client.getId());
        jsonClient.addProperty("firstname", client.getFirstname());
        jsonClient.addProperty("lastname", client.getLastname());
        jsonClient.addProperty("gender", client.getGender());
        jsonClient.addProperty("email", client.getEmail());
        jsonClient.addProperty("birthDate", client.getBirthDate().toString());
                
        jsonClient.addProperty("id", client.getId());
        jsonClient.addProperty("firstname", client.getFirstname());
        jsonClient.addProperty("lastname", client.getLastname());
        jsonClient.addProperty("gender", client.getGender());
        jsonClient.addProperty("email", client.getEmail());
        jsonClient.addProperty("birthDate", client.getBirthDate().toString());
        jsonClient.addProperty("phone", client.getPhoneNumber());

        JsonObject jsonAstralProfil = new JsonObject();
        jsonAstralProfil.addProperty("animal", client.getAnimal());
        jsonAstralProfil.addProperty("chineseSign", client.getChineseSign());
        jsonAstralProfil.addProperty("color", client.getColor());
        jsonClient.add("astralProfil", jsonAstralProfil);

        JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("lon", client.getAddress().getLongitude());
        jsonAddress.addProperty("lat", client.getAddress().getLatitude());
        jsonAddress.addProperty("string", client.getAddress().getAddress());
        jsonClient.add("address", jsonAddress);         
                        
        return jsonClient;
    }
}