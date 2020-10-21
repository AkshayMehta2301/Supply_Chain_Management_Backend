package com.Backend.Supply_Chain_Management.DAO;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.OrderTransporterIdentity;
import com.Backend.Supply_Chain_Management.Model.Orders.Order_Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_TransporterDAO extends JpaRepository<Order_Transporter, OrderTransporterIdentity> {
}
