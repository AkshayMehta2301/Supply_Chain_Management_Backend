package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.OrderManufacturerIdentity;
import com.Backend.Supply_Chain_Management.Model.Orders.Order_Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_ManufacturerDAO extends JpaRepository<Order_Manufacturer, OrderManufacturerIdentity> {

}
