package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        // Step 1: Load dealership from file
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();

        if (dealership == null) {
            System.out.println("Unable to load dealership. Exiting...");
            return;
        }

        // Step 2: Launch user interface
        UserInterface ui = new UserInterface(dealership);
        ui.display();

        // Step 3: Save dealership back to file when user quits
        fileManager.saveDealership(dealership);
    }

}
