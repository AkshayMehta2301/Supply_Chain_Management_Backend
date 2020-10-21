package com.Backend.Supply_Chain_Management.Services.AdminCRUD;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.AdminDAO;
import com.Backend.Supply_Chain_Management.DAO.LoginDAO;
import com.Backend.Supply_Chain_Management.DAO.ManufacturerDAO;
import com.Backend.Supply_Chain_Management.DAO.Tra_RetDAO;
import com.Backend.Supply_Chain_Management.Model.User;
import com.Backend.Supply_Chain_Management.Model.Manufacturer;
import com.Backend.Supply_Chain_Management.Model.Tra_Ret;
import com.Backend.Supply_Chain_Management.Model.Login;
import com.Backend.Supply_Chain_Management.Model.Admin;
import com.Backend.Supply_Chain_Management.Model.CompositeKey.ManufacturerIdentity;
import com.Backend.Supply_Chain_Management.Model.CompositeKey.TraRetIdentity;
import com.Backend.Supply_Chain_Management.Services.Generator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AddService {

    @Autowired
    private Tra_RetDAO tra_retDAO;
    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private Generator generator;

    public String addUser(User user)
    {
        String response = "";
        String id = user.getType().substring(0,3) + generator.generateID(7);
        String email = generator.generateEmail(user.getName());
        if( user.getType().equals( Constants.Manufacturer_type))
        {
            Manufacturer manufacturer = Manufacturer.builder()
                                        .id(id)
                                        .email(email)
                                        .manufacturerIdentity(ManufacturerIdentity.builder()
                                                .name( user.getName())
                                                .location(user.getLocation())
                                                .component(user.getComponent())
                                                .build())
                                        .build();
            List<Manufacturer> manufacturers = manufacturerDAO
                    .findByNameAndLocationAndComponent(manufacturer.getManufacturerIdentity().getName(),
                            manufacturer.getManufacturerIdentity().getLocation(),
                            manufacturer.getManufacturerIdentity().getComponent());
            if(manufacturers.isEmpty() == true)
            {
                manufacturerDAO.save(manufacturer);
                Login manufacturerLogin = Login.builder()
                        .email( manufacturer.getEmail())
                        .passwd("12344321")
                        .id( manufacturer.getId())
                        .build();
                loginDAO.save( manufacturerLogin);
                log.info("Manufacturer added : {}", manufacturer);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("Manufacturer already Exists");
                response = Constants.FAILURE;
            }
        }
        else if( user.getType().equals( Constants.Retailer_type) || user.getType().equals( Constants.Transporter_type))
        {
            Tra_Ret tra_ret = Tra_Ret.builder()
                                .id(id)
                                .email( email)
                                .traRetIdentity(TraRetIdentity.builder()
                                        .location( user.getLocation())
                                        .name(user.getName())
                                        .build())
                                .build();
            List<Tra_Ret> tra_Rets = tra_retDAO
                    .findByNameAndLocation( tra_ret.getTraRetIdentity().getName(),
                            tra_ret.getTraRetIdentity().getLocation());
            if(tra_Rets.isEmpty() == true)
            {
                tra_retDAO.save(tra_ret);
                Login tra_RetLogin = Login.builder()
                        .email( tra_ret.getEmail())
                        .passwd("12344321")
                        .id( tra_ret.getId())
                        .build();
                loginDAO.save( tra_RetLogin);
                log.info("Tra_Ret added : {}", tra_ret);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("Tra_Ret already Exists");
                response = Constants.FAILURE;
            }
        }
        else if(user.getType().equals(Constants.Admin_type))
        {
            Admin admin = Admin.builder()
                    .id( id)
                    .email( email)
                    .name( user.getName())
                    .location( user.getLocation())
                    .build();
            List<Admin> admins = adminDAO.findByName( admin.getName());
            if(admins.isEmpty() == true)
            {
                adminDAO.save( admin);
                Login adminLogin = Login.builder()
                        .email( admin.getEmail())
                        .passwd("12344321")
                        .id( admin.getId())
                        .build();
                loginDAO.save( adminLogin);
                log.info("Admin added : {}", admin);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("Admin already Exists");
                response = Constants.FAILURE;
            }
        }
        else
        {
            log.info("Not valid type of user : {}",user);
            response = Constants.FAILURE;
        }
        return response;
    }
}
