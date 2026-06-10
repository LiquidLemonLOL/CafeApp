package se.lexicon;


public class CafeApp {
    static void main() {

        String item1 = "Espresso", item2 = "Cappuccino", item3 = "Latte", item4 = "Croissant", item5 = "Sandwich";
        int qty = 0;
        double price1 = 25.00, price2 = 35.00, price3 = 40.00, price4 = 30.00, price5 = 55.00;
        double total = 0, subTotal = 0, vat, discount;
        String currItem = "";

        String customerName = IO.readln("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! " + "Here is our menu:");
        IO.println("==============================\n        Lexicon Cafe\n==============================");
        IO.println(String.format("1. %-17s %.2f SEK", item1, price1));
        IO.println(String.format("1. %-17s %.2f SEK", item2, price2));
        IO.println(String.format("1. %-17s %.2f SEK", item3, price3));
        IO.println(String.format("1. %-17s %.2f SEK", item4, price4));
        IO.println(String.format("1. %-17s %.2f SEK", item5, price5));
        IO.println("==============================\n");


        switch (Integer.parseInt(IO.readln("Enter item number (1-5) "))) {
            case 1 -> {
                qty = Integer.parseInt(IO.readln("How many? "));
                subTotal += price1 * qty;
                currItem = item1;
            }
            case 2 -> {
                qty = Integer.parseInt(IO.readln("How many? "));
                subTotal += price2 * qty;
                currItem = item2;
            }
            case 3 -> {
                qty = Integer.parseInt(IO.readln("How many? "));
                subTotal += price3 * qty;
                currItem = item3;
            }
            case 4 -> {
                qty = Integer.parseInt(IO.readln("How many? "));
                subTotal += price4 * qty;
                currItem = item4;
            }
            case 5 -> {
                qty = Integer.parseInt(IO.readln("How many? "));
                subTotal += price5 * qty;
                currItem = item5;
            }
            default -> IO.println("Invalid input!");
        }
        String memberQuestion = IO.readln("Loyalty member? (yes/no) ");
        if (memberQuestion.equalsIgnoreCase("yes")) {
            IO.println("==============================\n        Lexicon Cafe\n==============================");
            IO.println("Customer:    " + customerName);
            IO.println("Item(s):     " + currItem + " x " + qty);
            IO.println("Subtotal:    " + subTotal + " SEK");
            IO.println("Discount:    -" + (discount = subTotal * 0.15) + " SEK");
            IO.println("VAT:         " + (vat = (subTotal - discount) * 0.12) + " SEK");
            IO.println("------------------------------");
            IO.println(String.format("TOTAL:       %.2f", (total = subTotal - discount + vat)) + "SEK");
            IO.println("==============================\n" + "      Thank you, " + customerName + "!\n" + "      See you next time." + "\n==============================");
        } else if (subTotal > 150.00) {
            IO.println("==============================\n        Lexicon Cafe\n==============================");
            IO.println("Customer:    " + customerName);
            IO.println("Item(s):     " + currItem + " x " + qty);
            IO.println("Subtotal:    " + subTotal + " SEK");
            IO.println("Discount:    -" + (discount = subTotal * 0.1) + " SEK");
            IO.println("VAT:         " + (vat = (subTotal - discount) * 0.12) + " SEK");
            IO.println("------------------------------");
            IO.println(String.format("TOTAL:       %.2f", (total = subTotal - discount + vat)) + "SEK");
            IO.println("==============================\n" + "      Thank you, " + customerName + "!\n" + "      See you next time." + "\n==============================");
        } else {
            IO.println("==============================\n        Lexicon Cafe\n==============================");
            IO.println("Customer:    " + customerName);
            IO.println("Item(s):     " + currItem + " x " + qty);
            IO.println("Subtotal:    " + subTotal + " SEK");
            IO.println("VAT:         " + (vat = subTotal * 0.12) + " SEK");
            IO.println("------------------------------");
            IO.println(String.format("TOTAL:       %.2f", (total = subTotal + vat)) + "SEK");
            IO.println("==============================\n" + "      Thank you, " + customerName + "!\n" + "      See you next time." + "\n==============================");
        }
    }
}