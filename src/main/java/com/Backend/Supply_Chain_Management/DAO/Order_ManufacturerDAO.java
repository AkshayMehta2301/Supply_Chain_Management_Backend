package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.OrderManufacturerIdentity;
import com.Backend.Supply_Chain_Management.Model.Orders.Order_Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Order_ManufacturerDAO extends JpaRepository<Order_Manufacturer, OrderManufacturerIdentity> {

    @Query("select ord_man from Order_Manufacturer ord_man where" +
            " ord_man.orderManufacturerIdentity.manufacturerID=:i and ord_man.isCompleted=false")
    List<Order_Manufacturer> findRunningOrderByManufacturerID( @Param("i") String manufacturerID);

    @Query("select ord_man from Order_Manufacturer ord_man where" +
            " ord_man.orderManufacturerIdentity.manufacturerID=:i and ord_man.isCompleted=true")
    List<Order_Manufacturer> findCompletedOrderByManufacturerID( @Param("i") String manufacturerID);

    @Query("select ord_man from Order_Manufacturer ord_man where " +
            "ord_man.orderManufacturerIdentity=:i")
    Order_Manufacturer findOrderManufacturerByOrderManufacturerIdentity(@Param("i") OrderManufacturerIdentity orderManufacturerIdentity);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order_Manufacturer ord_man set ord_man.isCompleted=true " +
            "where ord_man.orderManufacturerIdentity=:i")
    int updateOrderToCompleted(@Param("i") OrderManufacturerIdentity orderManufacturerIdentity);
}
