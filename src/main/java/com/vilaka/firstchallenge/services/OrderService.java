package com.vilaka.firstchallenge.services;

import com.vilaka.firstchallenge.entities.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
        double discount = order.getBasic() * (order.getDiscount()/100);
        return order.getBasic() - discount + shippingService.shipment(order);
    }

}
