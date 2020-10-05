package com.Backend.Supply_Chain_Management.Services.AdminCRUD;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.AdminDAO;
import com.Backend.Supply_Chain_Management.DAO.LoginDAO;
import com.Backend.Supply_Chain_Management.DAO.ManufacturerDAO;
import com.Backend.Supply_Chain_Management.DAO.Tra_RetDAO;
import com.Backend.Supply_Chain_Management.Model.Admin;
import com.Backend.Supply_Chain_Management.Model.Manufacturer;
import com.Backend.Supply_Chain_Management.Model.Tra_Ret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeleteService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Autowired
    private Tra_RetDAO tra_retDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private LoginDAO loginDAO;

    public String deleteUser(String id)
    {
        String response = "";
        if( id.substring(0, 3).equals("man"))
        {
            Manufacturer manufacturer = manufacturerDAO.findByUniqueId( id);
            if(manufacturer != null)
            {
                manufacturerDAO.delete( manufacturer);
                loginDAO.deleteById( manufacturer.getId());
                log.info("Removed Manufacturer : {}", manufacturer);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("No Manufacturer exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        else if( id.substring(0, 3).equals("tra") || id.substring(0, 3).equals("ret") )
        {
            Tra_Ret traRet = tra_retDAO.findByUniqueId( id);
            if(traRet != null)
            {
                tra_retDAO.delete( traRet);
                loginDAO.deleteById( traRet.getId());
                log.info("Removed Tra_Ret : {}", traRet);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("No Tra_Ret exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        else if( id.substring(0, 3).equals("adm"))
        {
            Admin admin = adminDAO.findByUniqueId( id);
            if(admin != null)
            {
                adminDAO.delete(admin);
                loginDAO.deleteById( admin.getId());
                log.info("Removed Admin : {}", admin);
                response = Constants.SUCCESS;
            }
            else
            {
                log.info("No Admin exist with given ID : {}", id);
                response = Constants.FAILURE;
            }
        }
        else
        {
            log.info("Not Valid ID : {}", id);
            response = Constants.FAILURE;
        }
        return response;
    }
}
