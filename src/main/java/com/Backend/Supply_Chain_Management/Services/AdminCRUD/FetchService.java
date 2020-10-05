package com.Backend.Supply_Chain_Management.Services.AdminCRUD;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.AdminDAO;
import com.Backend.Supply_Chain_Management.DAO.ManufacturerDAO;
import com.Backend.Supply_Chain_Management.DAO.Tra_RetDAO;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FetchService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;
    @Autowired
    private Tra_RetDAO tra_retDAO;
    @Autowired
    private AdminDAO adminDAO;

    public List<UserInter> fetchUser(String type)
    {
        List<UserInter> fetchedUser = null;
        if(type.equals( Constants.Manufacturer_type))
        {
            fetchedUser = manufacturerDAO.getAllManufacturer();
        }
        else if( type.equals( Constants.Admin_type)) {
            fetchedUser = adminDAO.getAllAdmin();
        }
        else if( type.equals( Constants.Retailer_type))
        {
            fetchedUser = tra_retDAO.getAllRetailer();
        }
        else if( type.equals( Constants.Transporter_type))
        {
            fetchedUser = tra_retDAO.getAllTransporter();
        }
        return fetchedUser;
    }
}
