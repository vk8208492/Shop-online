package app.controller;

import app.entity.Buyer;
import app.entity.Purchase;
import app.model.impl.AppBaseModel;
import app.model.impl.AppDiscountModel;
import app.utils.Rounder;
import app.view.Appview;

public class AppController {

private final Appview appview = new Appview();
private final static String CURRENCY = "EUR";
    public void getPayment() {
        Appview view = new Appview();
        String[] data = view.getData();
        Buyer buyer = getBuyer(data);
        Purchase purchase = getPurchase(data);
        String output;
        if (purchase.getQuota() <= 4) {
            AppBaseModel model = new AppBaseModel();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            view.getOutput(output);
        } else {
            AppDiscountModel model = new AppDiscountModel();
            String payment = Rounder.roundValue(model.calcPayment(purchase));
            output = "\nBuyer: " + buyer.getName() + ", " + buyer.getPhone() +
                    "\nPayment is " + CURRENCY + " " + payment;
            view.getOutput(output);
        }
    }

    private Buyer getBuyer(String[] data) {
        return new Buyer(data[0], data[1]);
    }

    private Purchase getPurchase(String[] data) {
        return new Purchase(Integer.parseInt(data[2]),
                Double.parseDouble(data[3]));
    }




}
