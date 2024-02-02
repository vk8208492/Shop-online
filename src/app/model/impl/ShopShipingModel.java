package app.model.impl;

import app.entity.BuyOrder;
import app.model.OrderModel;

public class ShopShipingModel implements OrderModel {

    public double calculationPrice(BuyOrder buyOrder) {
        double totalPrice = buyOrder.getCount() * buyOrder.getPrice();
        double shipingPrice = totalPrice / 100;
        return totalPrice + shipingPrice;
    }
}
