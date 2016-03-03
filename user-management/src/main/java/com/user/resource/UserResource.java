package com.user.resource;

import com.user.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venumadhav Nondapaka on 3/1/2016.
 *
 * This class is user resource class which exposes user operations as REST end points
 */
@Path("users")
public class UserResource {

    /**
     * This method is used return the list of users as Response
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllUsers() {
        List<User> users = new ArrayList<User>();
        User user1 = new User("Tom","Bell","M");
        User user2 = new User("Tejas","Non","M");
        users.add(user1);
        users.add(user2);
        return Response.ok(new GenericEntity<List<User>>(users){}).build();
        //System.out.println("Users>>>"+users);
        //return users;
    }


    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String userId) {
        System.out.println("UserId>>" + userId);
        User user1 = new User("Tom","Bell","M");
        return Response.ok(user1).build();

    }

    @POST
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        System.out.println("user>>" + user);
        return Response.ok(new User("New"," User","M")).build();
    }

    @PUT
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") String userId) {
        System.out.println("userId>>" + userId);
        return Response.ok(new User("Updated"," User","M")).build();
    }

    @DELETE
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") String userId) {
        System.out.println("userId>>" + userId);
        return Response.ok(new User("Deleted"," User","M")).build();
    }
}
