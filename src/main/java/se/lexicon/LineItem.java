package se.lexicon;

public class LineItem {

    private String itemName;
    private double itemPrice;
    private int quantity;

    public LineItem(String itemName, double itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }

    public double getItemPrice() { return itemPrice; }

    public int getQuantity() { return quantity; }

    public double lineTotal() {
        return itemPrice * quantity;
    }

}
