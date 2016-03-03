package com.user.client;

import com.user.domain.User;

import javax.print.attribute.standard.Media;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by srila on 3/2/2016.
 */
public class UserClient {

    private Client client;
    public UserClient(){
        client = ClientBuilder.newClient();
    }
    public Response getUsers(){
        WebTarget target = client.target("http://localhost:8080/user-management/webapi/");
        Response response = target.path("users").request().get();
        return response;
    }

    public Response createUser(User user){
        WebTarget target = client.target("http://localhost:8080/user-management/webapi/");
        if(user == null){
            user = new User("Client","Create","M");
        }
        Response response = target.path("users/1234").request(MediaType.APPLICATION_JSON).post(Entity.entity(user, MediaType.APPLICATION_JSON));
        return response;
    }
}
