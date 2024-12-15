import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Ride implements RideInterface {
    // Properties of the Ride class
    private String rideName;  // Name of the ride
    private int capacity;     // Maximum number of visitors the ride can accommodate at once
    private Employee operator;  // Employee responsible for operating the ride

    private int maxRider;     // Maximum number of riders allowed on the ride
    private int numOfCycles;  // Number of times the ride has been cycled

    // Default constructor
    public Ride() {
    }

    // Data structures to manage visitors
    private Queue<Visitor> waitingLine;     // Queue for regular visitors waiting in line
    private Queue<Visitor> VipWaitingLine;  // Queue for VIP visitors waiting in line
    private LinkedList<Visitor> rideHistory;  // List to keep track of visitors who have ridden

    // Constructor with all parameters including maxRider
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.VipWaitingLine = new LinkedList<>();  // Initialize VIP waiting line
        this.waitingLine = new LinkedList<>();     // Initialize regular waiting line
        this.rideHistory = new LinkedList<>();     // Initialize ride history

    }

    // Constructor without maxRider parameter (sets default maxRider to 10)
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider = 10;  // Set default maxRider to 10
        this.numOfCycles = 0;
        this.VipWaitingLine = new LinkedList<>();  // Initialize VIP waiting line
        this.waitingLine = new LinkedList<>();     // Initialize regular waiting line
        this.rideHistory = new LinkedList<>();     // Initialize ride history

    }

    // Getter method for ride name
    public String getRideName() {
        return rideName;
    }

    // Setter method for ride name with input validation
    public void setRideName(String rideName) {
        if (rideName == null || rideName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ride name cannot be null or empty");
        }
        this.rideName = rideName.trim();  // Remove leading and trailing whitespace
    }

    // Getter method for ride capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter method for ride capacity with input validation
    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        this.capacity = capacity;
    }

    // Getter method for ride operator
    public Employee getOperator() {
        return operator;
    }

    // Setter method for ride operator
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    //我额外添加了vip的队列，提供了和特惠票不一样的地方，保证买了VIP能得到提前玩的权力
    //I added an additional VIP queue to provide a different place from
    // he special ticket to ensure that I can get the right to play in advance when I buy a VIP
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null &&visitor.getTicketType().contains("VIP")){
        VipWaitingLine.offer(visitor);
        return;}

        waitingLine.offer(visitor);
    }

    //VIP能得到提前玩的权力
    //VIP can get the right to play in advance

    @Override
    public void removeVisitorFromQueue() {
        if (VipWaitingLine != null && !VipWaitingLine.isEmpty()) {
            VipWaitingLine.poll();
        } else if (waitingLine != null && !waitingLine.isEmpty()) {
            waitingLine.poll();
        }
    }

    @Override
// Method to print the current state of the waiting queues
    public void printQueue() {
        // Display the name of the ride for which the queue information is being printed
        System.out.println("Waiting line for " + rideName + ":");

        int v = 0;  // Counter for VIP visitors
        int c = 0;  // Counter for common (non-VIP) visitors

        // Iterate through and print all VIP visitors in the queue
        for (Visitor vip : VipWaitingLine){
            System.out.println(vip);
            v++;  // Increment VIP counter
        }
        System.out.print("The above is the vip queue");
        System.out.println("-------The number of VIP queue members is:" + v);
        System.out.println("----------------------------");

        // Iterate through and print all common visitors in the queue
        for (Visitor visitor : waitingLine) {
            System.out.println(visitor);
            c++;  // Increment common visitor counter
        }
        System.out.print("The above is the common queue");
        System.out.println("-------The number of com queue members is:" + c);
        System.out.println("----------------------------");
    }

    @Override
// Method to simulate one cycle of the ride
    public void runOneCycle() {
        // Print decorative header for the ride cycle
        System.out.println("********************************************************");
        System.out.println("*                                                      *");

        play();  // Call the play method (likely to simulate the ride experience)

        // Check if an operator is assigned to the ride
        if (operator == null) {
            System.out.println("No operator assigned. Ride cannot run.");
            return;  // Exit the method if no operator is assigned
        }

        // Check if there are any visitors waiting in either queue
        if (VipWaitingLine.isEmpty() && waitingLine.isEmpty()) {
            System.out.println("No waiting visitors. Ride cannot run.");
            return;  // Exit the method if both queues are empty
        }

        int ridersThisCycle = 0;  // Initialize counter for riders in this cycle

        // Process VIP queue first
        ridersThisCycle = Math.min(maxRider, VipWaitingLine.size());  // Determine how many VIP visitors can ride
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = VipWaitingLine.poll();  // Remove and get the next VIP visitor
            addVisitorToHistory(rider);  // Add the visitor to the ride history
        }

        // Process common queue if there's remaining capacity
        int remainingCapacity = maxRider - ridersThisCycle;
        for (int i = 0; i < remainingCapacity && !waitingLine.isEmpty(); i++) {
            Visitor rider = waitingLine.poll();  // Remove and get the next common visitor
            addVisitorToHistory(rider);  // Add the visitor to the ride history
            ridersThisCycle++;  // Increment the rider count
        }

        numOfCycles++;  // Increment the total number of cycles run
        // Print summary of the completed cycle
        System.out.println("Ride cycle completed. " + ridersThisCycle + " visitors rode the " + rideName);
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
    }
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Check if this is the visitor's first time on the ride
        if (visitor.getTimesOfPlay() == 0) {
            rideHistory.add(visitor);  // Add visitor to ride history
        } else {
            // Increment the visitor's play count and add to history
            visitor.setTimesOfPlay(visitor.getTimesOfPlay() + 1);
            rideHistory.add(visitor);
        }

        // Attempt to export the updated ride history
        try {
            exportRideHistory(rideHistory);
        } catch (Exception e) {
            throw new RuntimeException(e);  // If export fails, throw a RuntimeException
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Check if the given visitor is in the ride history
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        // Return the total number of visitors in the ride history
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        // Check if ride history is empty
        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("No ride history available for " + rideName + ".");
            return;
        }

        int vipNum = 0;     // Counter for VIP visitors
        int noVipNum = 0;   // Counter for non-VIP visitors

        System.out.println("Ride history for " + rideName + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor);
            // Count VIP and non-VIP visitors
            if (visitor.getTicketType().equalsIgnoreCase("VIP")) {
                vipNum++;
            } else {
                noVipNum++;
            }
        }

        // Print summary of VIP and non-VIP visitors
        System.out.println("Total VIP visitors: " + vipNum);
        System.out.println("Total ordinary visitors: " + noVipNum);
    }

    public void sortVisitorHistory() {
        // Sort the ride history using a custom VisitorComparator
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Visitor history has been sorted.");
    }

    public void exportRideHistory(List<Visitor> Queue) throws Exception {
        // Export ride history to a CSV file
        try (PrintWriter writer = new PrintWriter(new FileWriter("History.csv"))) {
            for (Visitor visitor : Queue) {
                // Write each visitor's details to the CSV file
                writer.println(visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getGender() + "," +
                        visitor.getHeight() + "," +
                        visitor.getTicketType() + "," +
                        visitor.hasPassport());
            }
            System.out.println("Visitors exported to History.csv");
        } catch (IOException e) {
            System.out.println("Error exporting visitors: " + e.getMessage());
        }
    }

    public void importRideHistory() throws IOException {
        System.out.println("----------The following is the history record saving file reading-----------");
        // Read the contents of the History.csv file
        FileInputStream READ = new FileInputStream("History.csv");
        BufferedInputStream BI = new BufferedInputStream(READ);
        byte[] buffer = new byte[1024 * 8];
        int len;

        // Print the contents of the file
        while ((len = BI.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, len));
        }
    }







    @Override
    public String toString() {
        return String.format("Ride{rideName='%s', capacity=%d, operator=%s}",
                rideName, capacity, operator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return capacity == ride.capacity &&
                Objects.equals(rideName, ride.rideName) &&
                Objects.equals(operator, ride.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideName, capacity, operator);
    }

    public void play(){
        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        System.out.println("*                      WELCOME                         *");
        System.out.println("*                   HAPPY GAME GO !!!                  *");
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
    }
}