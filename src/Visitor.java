import java.util.Objects;

// This class represents a Visitor, which is a specific type of Person
// It extends the Person class, inheriting all its properties and methods
public class Visitor extends Person {
    // Additional private instance variables specific to Visitor
    private String ticketType;
    private boolean hasPassport;
    private int TimesOfPlay;

    // Default constructor
    // Calls the superclass (Person) default constructor and sets default values for Visitor-specific fields
    public Visitor() {
        super();
        this.ticketType = "Standard";
        this.hasPassport = false;
        this.TimesOfPlay = 0;
    }

    // Getter method for hasPassport
    // Returns whether the visitor has a passport
    public boolean isHasPassport() {
        return hasPassport;
    }

    // Getter method for TimesOfPlay
    // Returns the number of times the visitor has played
    public int getTimesOfPlay() {
        return TimesOfPlay;
    }

    // Setter method for TimesOfPlay
    // Sets the number of times the visitor has played
    public void setTimesOfPlay(int timesOfPlay) {
        TimesOfPlay = timesOfPlay;
    }

    // Parameterized constructor
    // Calls the superclass (Person) parameterized constructor and initializes Visitor-specific fields
    public Visitor(String name, int age, String gender, double height, String ticketType, boolean hasPassport) {
        super(name, age, gender, height);
        setTicketType(ticketType);
        setHasPassport(hasPassport);
        this.TimesOfPlay = 0;
    }

    // Getter method for ticketType
    // Returns the visitor's ticket type
    public String getTicketType() {
        return ticketType;
    }

    // Setter method for ticketType with input validation
    // Throws an exception if the ticketType is null or empty
    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket type cannot be null or empty");
        }
        this.ticketType = ticketType.trim();
    }

    // Getter method for hasPassport
    // Returns whether the visitor has a passport
    public boolean hasPassport() {
        return hasPassport;
    }

    // Setter method for hasPassport
    // Sets whether the visitor has a passport
    public void setHasPassport(boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    // Overridden toString method
    // Returns a string representation of the Visitor object, including the Person information
    @Override
    public String toString() {
        return String.format("Visitor{%s, ticketType='%s', hasPassport=%b}",
                super.toString(), ticketType, hasPassport);
    }

    // Overridden equals method
    // Compares this Visitor object with another object for equality
    // It first checks if the objects are equal as Persons, then compares Visitor-specific fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Visitor visitor = (Visitor) o;
        return hasPassport == visitor.hasPassport &&
                Objects.equals(ticketType, visitor.ticketType);
    }

    // Overridden hashCode method
    // Generates a hash code for the Visitor object, including the hash code from the Person superclass
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketType, hasPassport);
    }
}