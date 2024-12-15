import java.io.IOException;

public class AssignmentTwo {
    public static void main(String[] args) {
        // Main method to test other parts of the program
        // Each method call is wrapped in a try-catch block to handle potential exceptions

        try {

            partThree();


        } catch (Exception e) {
            System.out.println("Error occurred in partThree: " + e.getMessage());
            e.printStackTrace(); // This will print the full stack trace for more detailed error information
        }

        try {

            partFourA();

        } catch (Exception e) {
            System.out.println("Error occurred in partFourA: " + e.getMessage());
            e.printStackTrace();
        }

        try {

            partFourB();

        } catch (Exception e) {
            System.out.println("Error occurred in partFourB: " + e.getMessage());
            e.printStackTrace();
        }

        try {

            partFive();

        } catch (Exception e) {
            System.out.println("Error occurred in partFive: " + e.getMessage());
            e.printStackTrace();
        }
        try {

            partSix();

        } catch (Exception e) {
            System.out.println("Error occurred in partSix: " + e.getMessage());
            e.printStackTrace();
        }

        try {

            partSeven();

        } catch (Exception e) {
            System.out.println("Error occurred in partSeven: " + e.getMessage());
            e.printStackTrace();
        }

        // If you need to handle IOException specifically, you can add a separate catch block
        // catch (IOException e) {
        //     System.out.println("IOException occurred: " + e.getMessage());
        //     e.printStackTrace();
        // }
    }

    public static void partThree() throws Exception {
        // Implementation of Part Three of the program

        // Create a new Employee object to serve as the ride operator
        Employee operator = new Employee("John Doe", 30, "Male", 175.0, "EMP001", "Rides");

        // Create a new Ride object named "Thunderbolt" with a capacity of 4 and assign the operator
        Ride rollerCoaster = new Ride("Thunderbolt", 4, operator);

        // Print introductory messages
        System.out.println("Demonstrating Part 3 - Queue Interface");
        System.out.println("Created new Ride: " + rollerCoaster.getRideName());

        // Create at least 5 Visitor objects with various attributes
        Visitor v1 = new Visitor("Alice", 25, "Female", 165.0, "Standard", true);
        Visitor v2 = new Visitor("Bob", 30, "Male", 180.0, "VIP", false);
        Visitor v3 = new Visitor("Charlie", 22, "Male", 175.0, "Standard", true);
        Visitor v4 = new Visitor("Diana", 28, "Female", 170.0, "VIP", true);
        Visitor v5 = new Visitor("Eva", 35, "Female", 160.0, "Standard", false);

        // Add visitors to the ride queue
        System.out.println("\nAdding visitors to the queue:");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Print the current state of the queue after adding visitors
        System.out.println("\nPrinting the queue after adding visitors:");
        rollerCoaster.printQueue();

        // Remove a visitor from the queue
        System.out.println("\nRemoving a visitor from the queue:");
        rollerCoaster.removeVisitorFromQueue();

        // Print the updated state of the queue after removing a visitor
        System.out.println("\nPrinting the queue after removing a visitor:");
        rollerCoaster.printQueue();
    }



    public static void partFourA() throws Exception {
        // Implementation of Part Four A - Demonstrating Collection class (LinkedList)
        System.out.println("Demonstrating Part 4A - Collection class (LinkedList)");

        // Create a new Employee object to serve as the ride operator
        Employee operator = new Employee("Jane Smith", 28, "Female", 170.0, "EMP002", "Rides");
        // Create a new Ride object named "Giant Wheel" with a capacity of 6 and assign the operator
        Ride ferrisWheel = new Ride("Giant Wheel", 6, operator);
        System.out.println("Created new Ride: " + ferrisWheel.getRideName());

        // Create Visitor objects with various attributes
        Visitor v1 = new Visitor("Frank", 40, "Male", 185.0, "VIP", true);
        Visitor v2 = new Visitor("Grace", 35, "Female", 160.0, "Standard", true);
        Visitor v3 = new Visitor("Henry", 28, "Male", 175.0, "Standard", false);
        Visitor v4 = new Visitor("Ivy", 22, "Female", 165.0, "VIP", true);
        Visitor v5 = new Visitor("Jack", 31, "Male", 180.0, "Standard", true);

        // Add visitors to the ride history
        System.out.println("\nAdding visitors to ride history:");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // Check if a specific visitor (Frank) is in the ride history
        System.out.println("\nChecking if Frank is in the ride history:");
        boolean isInHistory = ferrisWheel.checkVisitorFromHistory(v1);
        System.out.println("Frank is in ride history: " + isInHistory);

        // Print the number of visitors in the ride history
        System.out.println("\nNumber of visitors in ride history:");
        System.out.println(ferrisWheel.numberOfVisitors());

        // Print all visitors in the ride history
        System.out.println("\nPrinting all visitors in ride history:");
        ferrisWheel.printRideHistory();
    }

    public static void partFourB() throws Exception {
        // Implementation of Part Four B - Demonstrating sorting of the collection
        System.out.println("Demonstrating Part 4B - Sorting the collection");

        // Create a new Employee object to serve as the ride operator
        Employee operator = new Employee("Alex Brown", 32, "Male", 178.0, "EMP003", "Rides");
        // Create a new Ride object named "Cyclone" with a capacity of 4 and assign the operator
        Ride rollerCoaster = new Ride("Cyclone", 4, operator);
        System.out.println("Created new Ride: " + rollerCoaster.getRideName());

        // Create Visitor objects with various attributes
        Visitor v1 = new Visitor("Zoe", 28, "Female", 165.0, "Standard", true);
        Visitor v2 = new Visitor("Yara", 35, "Female", 170.0, "VIP", false);
        Visitor v3 = new Visitor("Xavier", 22, "Male", 180.0, "Standard", true);
        Visitor v4 = new Visitor("William", 40, "Male", 175.0, "VIP", true);
        Visitor v5 = new Visitor("Victoria", 30, "Female", 168.0, "Standard", false);

        // Add visitors to the ride history
        System.out.println("\nAdding visitors to ride history:");
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        // Print the unsorted ride history
        System.out.println("\nPrinting unsorted ride history:");
        rollerCoaster.printRideHistory();

        // Sort the ride history
        System.out.println("\nSorting ride history:");
        rollerCoaster.sortVisitorHistory();

        // Print the sorted ride history
        System.out.println("\nPrinting sorted ride history:");
        rollerCoaster.printRideHistory();
    }
    public static void partFive() throws IOException {
        // Implementation of Part Five - Running a ride cycle
        System.out.println("Demonstrating Part 5 - Run a ride cycle");

        // Create a new Employee object to serve as the ride operator
        Employee operator = new Employee("John Doe", 35, "Male", 180.0, "EMP001", "Rides");
        // Create a new Ride object named "Thunderbolt" with a capacity of 4 and assign the operator
        Ride rollerCoaster = new Ride("Thunderbolt", 4, operator, 5);

        // Add at least 10 visitors to the queue
        for (int i = 1; i <= 11; i++) {
            if (i % 2 == 0) {
                Visitor v = new Visitor("Visitor" + i, 20 + i, (i % 2 == 0 ? "Male" : "Female"), 160.0 + i, "Standard", true);
                rollerCoaster.addVisitorToQueue(v);
            } else {
                Visitor v = new Visitor("Visitor" + i, 20 + i, (i % 2 == 0 ? "Male" : "Female"), 160.0 + i, "VIP", true);
                rollerCoaster.addVisitorToQueue(v);
            }
        }

        // Print all visitors in the queue
        System.out.println("\nPrinting all visitors in the queue:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        System.out.println("\nRunning one cycle:");
        rollerCoaster.runOneCycle();

        // Print visitors remaining in the queue after one cycle
        System.out.println("\nPrinting visitors in the queue after one cycle:");
        System.out.println("-------------------");
        rollerCoaster.printQueue();

        // Print visitors in the ride history
        System.out.println("\nPrinting visitors in the ride history:");
        rollerCoaster.printRideHistory();
    }

    public static void partSix() throws Exception {
        // Implementation of Part Six - Writing to a file
        System.out.println("\nDemonstrating Part 6 - Writing to a file");

        // Create a new Ride object
        Employee operator = new Employee("John Doe", 35, "Male", 180.0, "EMP001", "Rides");
        Ride rollerCoaster = new Ride("Mega Coaster", 40, operator, 4);

        // Add at least 5 visitors to the Ride's history
        rollerCoaster.addVisitorToHistory(new Visitor("Alice", 25, "Female", 165.0, "Standard", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Bob", 30, "Male", 180.0, "VIP", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Charlie", 22, "Male", 175.0, "Standard", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Diana", 28, "Female", 170.0, "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Ethan", 33, "Male", 185.0, "Standard", false));

        // Run one cycle (which likely writes the ride history to a file)
        rollerCoaster.runOneCycle();

        // Attempt to import the ride history from the file (to verify the write operation)
        try {
            rollerCoaster.importRideHistory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void partSeven() throws Exception {
        // Implementation of Part Seven - Reading from a file
        System.out.println("Demonstrating Part 7 - Reading from a file");

        // Create a new Ride object
        Employee operator = new Employee("John Doe", 35, "Male", 180.0, "EMP001", "Rides");
        Ride rollerCoaster = new Ride("Mega Coaster", 40, operator, 4);

        // Add at least 5 visitors to the Ride's history
        rollerCoaster.addVisitorToHistory(new Visitor("Alice", 25, "Female", 165.0, "Standard", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Bob", 30, "Male", 180.0, "VIP", false));
        rollerCoaster.addVisitorToHistory(new Visitor("Charlie", 22, "Male", 175.0, "Standard", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Diana", 28, "Female", 170.0, "VIP", true));
        rollerCoaster.addVisitorToHistory(new Visitor("Ethan", 33, "Male", 185.0, "Standard", false));

        // Run one cycle (which likely writes the ride history to a file)
        rollerCoaster.runOneCycle();

        // Print the current ride history (read from the file)
        System.out.println("\nCurrent ride history:");
        try {
            rollerCoaster.importRideHistory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
