import java.util.Objects;

public class Visitor extends Person {
    private String ticketType;
    private boolean hasPassport;

    // 默认构造函数
    public Visitor() {
        super();
        this.ticketType = "Standard";
        this.hasPassport = false;
    }

    // 带参数的构造函数
    public Visitor(String name, int age, String gender, double height, String ticketType, boolean hasPassport) {
        super(name, age, gender, height);
        setTicketType(ticketType);
        setHasPassport(hasPassport);
    }

    // Getters and setters with input validation
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket type cannot be null or empty");
        }
        this.ticketType = ticketType.trim();
    }

    public boolean hasPassport() {
        return hasPassport;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    @Override
    public String toString() {
        return String.format("Visitor{%s, ticketType='%s', hasPassport=%b}",
                super.toString(), ticketType, hasPassport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return hasPassport == visitor.hasPassport &&
                Objects.equals(ticketType, visitor.ticketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketType, hasPassport);
    }
}