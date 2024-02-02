package app.model.impl;

import app.entity.BuyOrder;
import app.model.OrderModel;

public class ShopPickupModel implements OrderModel {

    @Override
    public double calculationPrice(BuyOrder buyOrder) {
        return buyOrder.getCount() * buyOrder.getPrice();
    }
}






