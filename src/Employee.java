import java.util.Objects;

// This class represents an Employee, which is a specific type of Person
// It extends the Person class, inheriting all its properties and methods
public class Employee extends Person {
    // Additional private instance variables specific to Employee
    private String employeeId;
    private String department;

    // Default constructor
    // Calls the superclass (Person) default constructor and sets default values for Employee-specific fields
    public Employee() {
        super();
        this.employeeId = "Unknown";
        this.department = "Unassigned";
    }

    // Parameterized constructor
    // Calls the superclass (Person) parameterized constructor and initializes Employee-specific fields
    public Employee(String name, int age, String gender, double height, String employeeId, String department) {
        super(name, age, gender, height);
        setEmployeeId(employeeId);
        setDepartment(department);
    }

    // Getter method for employeeId
    // Returns the employee's ID
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter method for employeeId with input validation
    // Throws an exception if the employeeId is null or empty
    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        this.employeeId = employeeId.trim();
    }

    // Getter method for department
    // Returns the employee's department
    public String getDepartment() {
        return department;
    }

    // Setter method for department with input validation
    // Throws an exception if the department is null or empty
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        this.department = department.trim();
    }

    // Overridden toString method
    // Returns a string representation of the Employee object, including the Person information
    @Override
    public String toString() {
        return String.format("Employee{%s, employeeId='%s', department='%s'}",
                super.toString(), employeeId, department);
    }

    // Overridden equals method
    // Compares this Employee object with another object for equality
    // It first checks if the objects are equal as Persons, then compares Employee-specific fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(department, employee.department);
    }

    // Overridden hashCode method
    // Generates a hash code for the Employee object, including the hash code from the Person superclass
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, department);
    }
}