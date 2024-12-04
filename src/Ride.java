import java.util.Objects;

public class Ride {
    private String rideName;
    private int capacity;
    private Employee operator;

    // 默认构造函数
    public Ride() {
        this("Unknown", 0, null);
    }

    // 带参数的构造函数
    public Ride(String rideName, int capacity, Employee operator) {
        setRideName(rideName);
        setCapacity(capacity);
        setOperator(operator);
    }

    // Getters and setters with input validation
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