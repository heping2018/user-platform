package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Enumeration;

@Path("")
public class RegisterSuccessController implements PageController {

    @GET
    @POST
    @Path("/registersubmit")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        UserServiceImpl userService  = UserServiceImpl.getInstance();
        String email =  request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.register(user);
        return "registersuccess.jsp";
    }
}
