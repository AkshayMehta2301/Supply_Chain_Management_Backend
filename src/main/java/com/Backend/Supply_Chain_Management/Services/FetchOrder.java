package com.Backend.Supply_Chain_Management.Services;

import com.Backend.Supply_Chain_Management.DAO.OrderDetailsDAO;
import com.Backend.Supply_Chain_Management.DAO.Order_RetailerDAO;
import com.Backend.Supply_Chain_Management.Model.Orders.OrderDetails;
import com.Backend.Supply_Chain_Management.Model.Orders.Order_Retailer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FetchOrder {

    @Autowired
    Order_RetailerDAO order_retailerDAO;
    @Autowired
    OrderDetailsDAO orderDetailsDAO;

    public List<Order_Retailer> fetch(String retailerID)
    {
        List<Order_Retailer> orders = order_retailerDAO.findAllOrder( retailerID);
        log.info("Orders of  retailer : {} are : {}",retailerID, orders);
        return orders;
    }

    public List<OrderDetails> fetchOrderDetails(String orderID)
    {
        List<OrderDetails> orderDetails = orderDetailsDAO.findOrderDetails( orderID);
        return  orderDetails;
    }
}
