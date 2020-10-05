package com.Backend.Supply_Chain_Management.Controller;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.LoginDAO;
import com.Backend.Supply_Chain_Management.Model.Login;
import com.Backend.Supply_Chain_Management.Model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@Slf4j
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginDAO loginDAO;

    //This will validate manufacturers, transporters, admins and retailers from database.
    @GetMapping
    public Response<Login> validate(@RequestParam("email") String email, @RequestParam("passwd") String passwd) {
        log.info("Got Email : {} and Passwd : {}", email, passwd);
        Login data = loginDAO.findByEmailAndPasswd( email, passwd);
        if(data != null)
        {
            Response<Login> response = Response.<Login>builder()
                        .obj( data)
                        .Msg( Constants.SUCCESS)
                        .build();
            log.info("Successful Login.");
            log.info("Returning Response from LoginController : {}", response);
            return response;
        }
        else
        {
            Response<Login> response = Response.<Login>builder()
                        .Msg( Constants.FAILURE)
                        .build();
            log.info("User Not Exist.");
            log.info("Returning Response from LoginController : {}", response);
            return response;
        }
    }
}
