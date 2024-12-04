import java.util.Objects;

public class Visitor extends Person {
    private String ticketType;
    private boolean hasPassport;

    // 默认构造函数
    public Visitor() {
    }

    // 带参数的构造函数
    public Visitor(String name, int age, String gender, String ticketType, boolean hasPassport) {
        super(name, age, gender);
        this.ticketType = ticketType;
        this.hasPassport = hasPassport;
    }

    // Getters and setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "ticketType='" + ticketType + '\'' +
                ", hasPassport=" + hasPassport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return hasPassport == visitor.hasPassport && Objects.equals(ticketType, visitor.ticketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketType, hasPassport);
    }
}

