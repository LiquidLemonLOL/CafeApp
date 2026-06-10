package se.lexicon;


import java.util.ArrayList;

public class CafeApp {

    private static final String[] ITEM_NAMES = {"Espresso", "Cappuccino", "Latte", "Croissant", "Sandwich"};
    private static final double[] ITEM_PRICES = {25.00, 35.00, 40.00, 30.00, 55.00};

    static void main(String[] args) {

        // List of orders for summary
        ArrayList<Order> orders = new ArrayList<>();
        // order loop
        while (true) {
            String customerName = IO.readln("Next customer name (or 'done' to close): ");

            if (customerName.equalsIgnoreCase("done")) {
                break;
            }

            IO.println("Hi " + customerName + "! " + "Here is our menu:");
            printMenu();
            boolean isMember = readYesNo("Loyalty member? (yes/no): ").equalsIgnoreCase("yes");
            Order order = new Order(isMember, customerName);

            // item loop
            while (true) {
                int choice = readInt("Enter item number (1-5, or 0 to finish) ", 0, 5);
                if (choice == 0){
                    break;
                }

                int qty = readInt("How many? (1-20) ", 1, 20);
                order.addItem(ITEM_NAMES[choice - 1], ITEM_PRICES[choice - 1], qty);
                IO.println(qty + " x " + ITEM_NAMES[choice - 1] + " added");
            }

            order.printReceipt();
            orders.add(order);
        }

        printSummary(orders);

    }


    // Input Validations

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

    static String readYesNo(String prompt) {
        String ans = "";
        while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")) {
            ans = IO.readln("Loyalty member? (yes/no): ");
            if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no")) {
                IO.println("Please answer yes or no: ");
            }
            }
        return ans;
    }

    // Print methods

    static void printMenu() {
        IO.println("==============================");
        IO.println("        Lexicon Cafe          ");
        IO.println("==============================");
        for (int i = 0; i < ITEM_NAMES.length; i++) {
            IO.println(String.format("%d. %-17s %.2f SEK", i+1, ITEM_NAMES[i], ITEM_PRICES[i]));
        }
        IO.println("==============================");
        IO.println("Enter 0 to stop ordering\n");
    }

    static void printSummary(ArrayList<Order> orders) {
        int totalCustomers = orders.size();
        double totalRev = 0;

        for (Order o : orders) {
            totalRev += o.getTotal();
        }

        IO.println("==============================");
        IO.println("       END OF DAY REPORT      ");
        IO.println("==============================");
        IO.println("Customers served: " + totalCustomers);
        IO.println(String.format("Total revenue:    %.2f", totalRev));
        IO.println("==============================");
        IO.println("Customers and totals: ");
        IO.println("------------------------------");
        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            IO.println(String.format("%d %-17s %.2f SEK", i+1, o.getCustomerName(), o.getTotal()));
        }
        IO.println("------------------------------");
    }

}

