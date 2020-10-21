package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.Orders.Order_Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_RetailerDAO extends JpaRepository<Order_Retailer, String> {

    @Query("select ord from Order_Retailer ord where ord.retailerID=:i")
    List<Order_Retailer> findAllOrder( @Param("i") String retailerID);
}
