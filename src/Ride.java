import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        if (rideName == null || rideName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ride name cannot be null or empty");
        }
        this.rideName = rideName.trim();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingLine.offer(visitor);
    }

    @Override
    public void removeVisitorFromQueue() {
        waitingLine.poll();
    }

    @Override
    public void printQueue() {
        System.out.println("Waiting line for " + rideName + ":");
        for (Visitor visitor : waitingLine) {
            System.out.println(visitor);
        }
    }

    @Override
    public void runOneCycle() {
        int visitorCount = Math.min(capacity, waitingLine.size());
        for (int i = 0; i < visitorCount; i++) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
        }
        System.out.println("Ride " + rideName + " completed one cycle with " + visitorCount + " visitors.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor);
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
}