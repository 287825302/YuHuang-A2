import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String gender;
    private double height;

    // 默认构造函数
    public Person() {
        this("Unknown", 0, "Unspecified", 0.0);
    }

    // 带参数的构造函数
    public Person(String name, int age, String gender, double height) {
        setName(name);
        setAge(age);
        setGender(gender);
        setHeight(height);
    }

    // Getters and setters with input validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be non-negative");
        }
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0 || height > 300) {
            throw new IllegalArgumentException("Height must be between 0 and 300 cm");
        }
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        this.gender = gender.trim();
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, gender='%s', height=%.2f}", name, age, gender, height);
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, height);
    }
}