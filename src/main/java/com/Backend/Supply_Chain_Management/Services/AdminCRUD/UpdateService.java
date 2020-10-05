package com.Backend.Supply_Chain_Management.Services.AdminCRUD;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.AdminDAO;
import com.Backend.Supply_Chain_Management.DAO.ManufacturerDAO;
import com.Backend.Supply_Chain_Management.DAO.Tra_RetDAO;
import com.Backend.Supply_Chain_Management.Model.Admin;
import com.Backend.Supply_Chain_Management.Model.Manufacturer;
import com.Backend.Supply_Chain_Management.Model.Tra_Ret;
import com.Backend.Supply_Chain_Management.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Autowired
    private Tra_RetDAO tra_retDAO;
    @Autowired
    private AdminDAO adminDAO;

    public String updateUser(String id, User user)
    {
        String response = "";
        if( id.contains("man"))
        {
            Manufacturer manufacturer = manufacturerDAO.findByUniqueId(id);
            if(manufacturer != null)
            {
                log.info("Fetched Manufacturer with given ID : {}", manufacturer);
                if(user.getComponent() != null)
                {
                    manufacturer.getManufacturerIdentity().setComponent(user.getComponent());
                }
                if(user.getLocation() != null)
                {
                    manufacturer.getManufacturerIdentity().setLocation(user.getLocation());
                }
                if(user.getName() != null)
                {
                    manufacturer.getManufacturerIdentity().setName(user.getName());
                }
                manufacturerDAO.save(manufacturer);
                response = Constants.SUCCESS;
                log.info("Updated Manufacturer : {}", manufacturer);
            }
            else
            {
                log.info("No Manufacturer Exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        else if( id.contains("tra") || id.contains("ret"))
        {
            Tra_Ret tra_ret = tra_retDAO.findByUniqueId( id);
            if(tra_ret != null)
            {
                log.info("Fetched Tra_Ret with given ID : {}", tra_ret);
                if(user.getLocation() != null)
                {
                    tra_ret.getTraRetIdentity().setLocation( user.getLocation());
                }
                if(user.getName() != null)
                {
                    tra_ret.getTraRetIdentity().setName( user.getName());
                }
                tra_retDAO.save(tra_ret);
                response = Constants.SUCCESS;
                log.info("Updated Tra_Ret : {}", tra_ret);
            }
            else
            {
                log.info("No Tra_Ret Exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        else if( id.contains("adm"))
        {
            Admin admin = adminDAO.findByUniqueId( id);
            if(admin != null)
            {
                log.info("Fetched Tra_Ret with given ID : {}", admin);
                if(user.getLocation() != null)
                {
                    admin.setLocation( user.getLocation());
                }
                if(user.getName() != null)
                {
                    admin.setName( user.getName());
                }
                adminDAO.save( admin);
                response = Constants.SUCCESS;
                log.info("Updated Admin : {}", admin);
            }
            else
            {
                log.info("No Admin Exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        return response;
    }
}
