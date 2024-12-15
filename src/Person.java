import java.util.Objects;

// This is an abstract class named Person, which means it cannot be instantiated directly
// It serves as a base class for other classes that represent specific types of persons
public abstract class Person {
    // Private instance variables to store person's attributes
    private String name;
    private int age;
    private String gender;
    private double height;

    // Default constructor
    // It calls the parameterized constructor with default values
    public Person() {
        this("Unknown", 0, "Unspecified", 0.0);
    }

    // Parameterized constructor
    // It initializes all instance variables using setter methods for input validation
    public Person(String name, int age, String gender, double height) {
        setName(name);
        setAge(age);
        setGender(gender);
        setHeight(height);
    }

    // Getter method for name
    // Returns the person's name
    public String getName() {
        return name;
    }

    // Setter method for name with input validation
    // Throws an exception if the name is null or empty
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    // Getter method for age
    // Returns the person's age
    public int getAge() {
        return age;
    }

    // Setter method for age with input validation
    // Throws an exception if the age is negative
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be non-negative");
        }
        this.age = age;
    }

    // Getter method for height
    // Returns the person's height
    public double getHeight() {
        return height;
    }

    // Setter method for height with input validation
    // Throws an exception if the height is not between 0 and 300 cm
    public void setHeight(double height) {
        if (height < 0 || height > 300) {
            throw new IllegalArgumentException("Height must be between 0 and 300 cm");
        }
        this.height = height;
    }

    // Getter method for gender
    // Returns the person's gender
    public String getGender() {
        return gender;
    }

    // Setter method for gender with input validation
    // Throws an exception if the gender is null or empty
    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        this.gender = gender.trim();
    }

    // Overridden toString method
    // Returns a string representation of the Person object
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, gender='%s', height=%.2f}", name, age, gender, height);
    }

    // Overridden equals method
    // Compares this Person object with another object for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    // Overridden hashCode method
    // Generates a hash code for the Person object
    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, height);
    }
}