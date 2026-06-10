package se.lexicon;


public class CafeApp {
    public static void main(String[] args) {

        String item1 = "Espresso", item2 = "Cappuccino", item3 = "Latte", item4 = "Croissant", item5 = "Sandwich";
        int qty = 0;
        double price1 = 25.00, price2 = 35.00, price3 = 40.00, price4 = 30.00, price5 = 55.00;
        double vat, discount, totalRev = 0;
        int totalCustomers = 0;

        while (true) {
            double total = 0, subTotal = 0;
            String currItem = "";
            String customerName = IO.readln("Next customer name (or 'done' to close): ");
            if (customerName.equalsIgnoreCase("done")) {
                IO.println("==============================\n        END OF DAY REPORT\n==============================");
                IO.println("Customers served:   " + totalCustomers);
                IO.println(String.format("Total revenue:    %.2f SEK", totalRev));
                IO.println("==============================");
                break;
            }

            IO.println("Hi " + customerName + "! " + "Here is our menu:");
            IO.println("==============================\n        Lexicon Cafe\n==============================");
            IO.println(String.format("1. %-17s %.2f SEK", item1, price1));
            IO.println(String.format("2. %-17s %.2f SEK", item2, price2));
            IO.println(String.format("3. %-17s %.2f SEK", item3, price3));
            IO.println(String.format("4. %-17s %.2f SEK", item4, price4));
            IO.println(String.format("5. %-17s %.2f SEK", item5, price5));
            IO.println("==============================\n");

            int choice = readInt("Enter item number (1-5) ", 1, 5);
            switch (choice) {
                case 1 -> {
                    qty = readInt("How many? (1-20) ", 1, 20);
                    subTotal += price1 * qty;
                    currItem = item1;
                }
                case 2 -> {
                    qty = readInt("How many? (1-20) ", 1, 20);
                    subTotal += price2 * qty;
                    currItem = item2;
                }
                case 3 -> {
                    qty = readInt("How many? (1-20) ", 1, 20);
                    subTotal += price3 * qty;
                    currItem = item3;
                }
                case 4 -> {
                    qty = readInt("How many? (1-20) ", 1, 20);
                    subTotal += price4 * qty;
                    currItem = item4;
                }
                case 5 -> {
                    qty = readInt("How many? (1-20) ", 1, 20);
                    subTotal += price5 * qty;
                    currItem = item5;
                }
            }
            String memberQuestion = "";
            boolean validAns = false;
            while (!validAns) {
                memberQuestion = IO.readln("Loyalty member? (yes/no): ");
                if (memberQuestion.equalsIgnoreCase("yes") || memberQuestion.equalsIgnoreCase("no")) {
                    validAns = true;
                } else  {
                    IO.println("Please answer yes or no: ");
                }
            }
            if (memberQuestion.equalsIgnoreCase("yes")) {
                IO.println("==============================\n        Lexicon Cafe\n==============================");
                IO.println("Customer:    " + customerName);
                IO.println("Item(s):     " + currItem + " x " + qty);
                IO.println("Subtotal:    " + subTotal + " SEK");
                IO.println("Discount:    -" + (discount = subTotal * 0.15) + " SEK");
                IO.println("VAT:         " + (vat = (subTotal - discount) * 0.12) + " SEK");
                IO.println("------------------------------");
                IO.println(String.format("TOTAL:       %.2f SEK", (total = subTotal - discount + vat)));
                IO.println("==============================\n" + "      Thank you, " + customerName + "!\n" + "      See you next time." + "\n==============================");
            } else if (subTotal > 150.00) {
                IO.println("==============================\n        Lexicon Cafe\n==============================");
                IO.println("Customer:    " + customerName);
                IO.println("Item(s):     " + currItem + " x " + qty);
                IO.println("Subtotal:    " + subTotal + " SEK");
                IO.println("Discount:    -" + (discount = subTotal * 0.1) + " SEK");
                IO.println("VAT:         " + (vat = (subTotal - discount) * 0.12) + " SEK");
                IO.println("------------------------------");
                IO.println(String.format("TOTAL:       %.2f SEK", (total = subTotal - discount + vat)));
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
            totalRev += total;
            totalCustomers++;
        }
    }

    static int readInt(String prompt, int min, int max) {
        int value = -1;
        while (value < min || value > max) {
            try {
                value = Integer.parseInt(IO.readln(prompt));
                if (value < min || value > max) {
                    IO.println("Invalid input, please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                IO.println("Please enter a valid number.");
            }
        }
        return value;
    }

}

