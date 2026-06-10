package se.lexicon;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Order {

    private String customerName;
    private boolean isMember;
    private ArrayList<LineItem> lineItems;

    private static final double VAT_RATE = 0.12;
    private static final double MEMBER_DISCOUNT = 0.15;
    private static final double BULK_DISCOUNT = 0.10;
    private static final double BULK_AMOUNT = 150.00;

    public Order(boolean isMember, String customerName) {
        this.isMember = isMember;
        this.customerName = customerName;
        this.lineItems = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getSubTotal() {
        double subTotal = 0;
        for (LineItem li : lineItems) {
            subTotal += li.lineTotal();
        }
        return subTotal;
    }

    public double getDiscountRate() {
        if (isMember) {
            return MEMBER_DISCOUNT;
        } else if (getSubTotal() > BULK_AMOUNT) {
            return BULK_DISCOUNT;
        } else {
            return 0.00;
        }
    }

    public double getDiscount() {
        return getSubTotal() * getDiscountRate();
    }

    public double getVat() {
        return (getSubTotal() - getDiscount()) * VAT_RATE;
    }

    public double getTotal() {
        return getSubTotal() - getDiscount() + getVat();
    }

    public void printReceipt() {
        double subTotal = getSubTotal();
        double discount = getDiscount();
        double vat = getVat();
        double total = getTotal();
        IO.println("==============================");
        IO.println("        Lexicon Cafe          ");
        IO.println("==============================");
        IO.println("Customer:       " + customerName);
        for (LineItem li : lineItems) {
            IO.println(String.format("%-17s x %d    %.2f SEK", li.getItemName(), li.getQuantity(), li.getItemPrice()));
        };
        IO.println("------------------------------");
        IO.println(String.format("Subtotal:       %.2f SEK", subTotal));
        if (discount > 0) {
            IO.println(String.format("Discount:       -%.2f SEK", discount));
        }
        IO.println(String.format("VAT:            %.2f SEK", vat));
        IO.println("------------------------------");
        IO.println(String.format("Total Price:    %.2f SEK", total));
        IO.println("==============================");
        IO.println("      Thank you, " + customerName + "!");
        IO.println("      See you next time.");
        IO.println("==============================");
    }

    public void addItem(String itemName, double itemPrice, int quantity) {
        lineItems.add(new LineItem(itemName, itemPrice, quantity));
    }

}
