package com.Backend.Supply_Chain_Management.Controller;

import com.Backend.Supply_Chain_Management.Model.User;
import com.Backend.Supply_Chain_Management.Services.AdminCRUD.AddService;
import com.Backend.Supply_Chain_Management.Services.AdminCRUD.DeleteService;
import com.Backend.Supply_Chain_Management.Services.AdminCRUD.FetchService;
import com.Backend.Supply_Chain_Management.Services.AdminCRUD.UpdateService;
import com.Backend.Supply_Chain_Management.Services.Generator;
import com.Backend.Supply_Chain_Management.UtilInterfaces.UserInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Autowired
    private Generator generator;
    @Autowired
    private AddService addService;
    @Autowired
    private DeleteService deleteService;
    @Autowired
    private UpdateService updateService;
    @Autowired
    private FetchService fetchService;

    //This will add users in Supply Chain.
    @PostMapping(value="/add")
    public String add(@RequestBody User user) {
        log.info("Got User value : {}", user);
        return addService.addUser( user);
    }

    //This will remove users from Supply Chain.
    @DeleteMapping(value = "/remove")
    public String remove(@RequestParam("id") String id) {
        log.info("got id : {} to remove", id);
        return deleteService.deleteUser(id);
    }

    //This will fetch Manufacturer, Transporter, Retailer and Admin based on passed RequestParam.
    @GetMapping(value = "/fetch")
    public List<UserInter> fetch(@RequestParam("type") String type) {
        log.info("Fetching user of type : {}", type);
        return fetchService.fetchUser(type);
    }
    
    //This will update Manufacturer, Transporter, Retailer and Admin based on passed RequestParam.
    @PutMapping(value="/update")
    public String update(@RequestParam("id") String id, @RequestBody User user) {
        log.info("Got id : {} and User : {} for Updating Info.", id, user);
        return updateService.updateUser(id, user);
    }
}
