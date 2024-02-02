package app.entity;

public class BuyOrder {

    private int count;
    private double price;
    private boolean isPickup;

    public BuyOrder(int count, double price, boolean isPickup) {
        this.count = count;
        this.price = price;
        this.isPickup = isPickup;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPickup() {
        return isPickup;
    }

    public void setPickup(boolean pickup) {
        isPickup = pickup;
    }
}
