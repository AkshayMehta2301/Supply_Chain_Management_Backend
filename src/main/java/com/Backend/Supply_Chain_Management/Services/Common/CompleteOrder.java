package com.Backend.Supply_Chain_Management.Services.Common;

import com.Backend.Supply_Chain_Management.Constants;
import com.Backend.Supply_Chain_Management.DAO.Order_ManufacturerDAO;
import com.Backend.Supply_Chain_Management.Model.CompositeKey.OrderManufacturerIdentity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompleteOrder {

    @Autowired
    Order_ManufacturerDAO order_manufacturerDAO;

    public String makeComplete(String orderID, String manufacturerID, String Component)
    {
        OrderManufacturerIdentity orderManufacturerIdentity = OrderManufacturerIdentity.builder()
                                                                .orderID( orderID)
                                                                .manufacturerID( manufacturerID)
                                                                .componentName( Component)
                                                                .build();
        log.info("Order details are : {}", order_manufacturerDAO.findById(orderManufacturerIdentity));
        order_manufacturerDAO.updateOrderToCompleted(orderManufacturerIdentity);
        log.info("Order Completion done.");
        //Here we have add logic off adding this order to transporter order.
        return Constants.SUCCESS;
    }
}
