package xyz.codingmentor.webshop.rest;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webshop.database.DeviceDB;
import xyz.codingmentor.webshop.dto.ResultDTO;
import xyz.codingmentor.webshop.dto.ResultType;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.entity.UserEntity;

/**
 *
 * @author Ádám
 */
@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceRESTService {
    @Inject
    private DeviceDB deviceDB;
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/devices/{id}
     */    
    @GET
    @Path("/{id}")
    public DeviceEntity getDeviceById(@PathParam ("id") String id) {
        return deviceDB.getDevice(id);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/devices
     */    
    @GET
    public List<DeviceEntity> getAllDevices() {
        return deviceDB.getAllDevices();
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/devices
     */    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        checkAdmin(request);
        deviceDB.addDevice(device);
        return new ResultDTO(ResultType.SUCCESS, device);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/devices
     */    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO deleteDevice(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        checkAdmin(request);
        deviceDB.deleteDevice(device);
        return new ResultDTO(ResultType.SUCCESS, device);
    }
        
    public void checkCredentials(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(UserRESTService.USER_KEY) == null){
            throw new IllegalStateException("You are not logged in!");
        }
    }
    
    public void checkAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        if(!user.isAdmin()) {
            throw new IllegalStateException("You are not an admin!");
        }
    }
}
