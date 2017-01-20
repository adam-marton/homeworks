package xyz.codingmentor.webshop.rest;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webshop.entity.DeviceEntity;
import xyz.codingmentor.webshop.shoppingcart.ShoppingCart;

/**
 *
 * @author Ádám
 */
@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@SessionScoped
public class CartRESTService implements Serializable {
    @Inject
    private ShoppingCart shoppingCart;
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/cart
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DeviceEntity> addToCart(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        shoppingCart.addDeviceToCart(device.getId(), device.getCount());
        return shoppingCart.getCart();
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/cart
     */    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DeviceEntity> deleteFromCart(@Context HttpServletRequest request, DeviceEntity device) {
        checkCredentials(request);
        shoppingCart.deleteDeviceFromCart(device.getId(), device.getCount());
        return shoppingCart.getCart();
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/cart/buy
     */    
    @POST
    @Path("/buy")
    public List<DeviceEntity> buyCart(@Context HttpServletRequest request) {
        checkCredentials(request);
        List<DeviceEntity> devicesToBuy = shoppingCart.buyDevicesInCart();
        request.getSession().invalidate();
        return devicesToBuy;
    }
    
    public void checkCredentials(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(UserRESTService.USER_KEY) == null){
            throw new IllegalStateException("You are not logged in!");
        }
    }
}