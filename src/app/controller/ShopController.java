package app.controller;

import app.entity.Buyer;
import app.entity.BuyOrder;
import app.model.impl.ShopShipingModel;
import app.model.impl.ShopPickupModel;
import app.utils.Rounder;
import app.view.ShopView;

public class ShopController {

private final ShopView shopView;
private final Buyer buyer;
private final BuyOrder buyOrder;

    public ShopController() {
        this.shopView = new ShopView();
        String[] data = shopView.getData();
        this.buyer = getBuyer(data);
        this.buyOrder = getOrderBuy(data);
    }

    private final static String CURRENCY = "EUR";
    public void getPayment() {
        String output;
        if ( !buyOrder.isPickup()) {
            ShopShipingModel model = new ShopShipingModel();
            String payment = Rounder.roundValue(model.calculationPrice(buyOrder));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            shopView.getOutput(output);
        } else {
            ShopPickupModel model = new ShopPickupModel();
            String payment = Rounder.roundValue(model.calculationPrice(buyOrder));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            shopView.getOutput(output);
        }
    }

    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[1]);
    }

    private BuyOrder getOrderBuy(String[] data) {
        return new BuyOrder(Integer.parseInt(data[2]),
                Double.parseDouble(data[3]),
                data[4].equalsIgnoreCase("yes"));
    }




}
