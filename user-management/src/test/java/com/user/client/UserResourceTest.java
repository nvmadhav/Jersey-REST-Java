package com.user.client;

import static org.junit.Assert.assertEquals;
import com.user.client.UserClient;
import com.user.domain.User;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by srila on 3/2/2016.
 */
public class UserResourceTest {

    @Test
    public void testGetUsers(){
        UserClient client= new UserClient();
        Response response = client.getUsers();
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }

    @Test
    public void testCreateUser(){
        UserClient client = new UserClient();
        Response response  = client.createUser(new User("Junit","create","F"));
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}
