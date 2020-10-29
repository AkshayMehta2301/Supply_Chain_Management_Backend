package com.Backend.Supply_Chain_Management.Controller;

import com.Backend.Supply_Chain_Management.Model.Orders.BaseOrder;
import com.Backend.Supply_Chain_Management.Model.Orders.OrderDetails;
import com.Backend.Supply_Chain_Management.Model.Orders.Order_Retailer;
import com.Backend.Supply_Chain_Management.Services.RetailerCRUD.AddOrder;
import com.Backend.Supply_Chain_Management.Services.RetailerCRUD.FetchRetailerOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@RequestMapping("/api/retailer")
@CrossOrigin
@RestController
public class RetailerController {

    @Autowired
    AddOrder addOrder;
    @Autowired
    FetchRetailerOrder fetchRetailerOrder;

    //We also have to add location so Retailer can select Location
    //and Based on that we can select Admin.
    //This method will used for placing orders of Items from Catalogs.
    @PostMapping(value="/placeOrder")
    public String placeOrder(@RequestParam("id") String id, @RequestParam("amount") String orderAmount, @RequestParam("location") String location, @RequestBody List<BaseOrder> orders) {
        log.info("Got id : {}, total Amount :{} and List of Orders :{}", id, orderAmount, orders);
        log.info("Order placed at location:{}", location);
        return addOrder.add(id, location, Long.parseLong(orderAmount), orders);
    }

    //This method will used for retrieving placed orders.
    @GetMapping(value="/getOrder")
    public List<Order_Retailer> getOrder (@RequestParam("id") String retailerID) {
        log.info("Get order for Given ID : {}", retailerID);
        return fetchRetailerOrder.fetch( retailerID);
    }

    //This method will used for retrieving each placed orders details.
    @GetMapping(value="/getOrderDetails")
    public List<OrderDetails> getOrderDetails(@RequestParam("orderID") String orderID) {
        log.info("Fetching order details for Given ID : {}", orderID);
        return fetchRetailerOrder.fetchOrderDetails( orderID);
    }
}
