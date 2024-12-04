import java.util.Objects;

public class Employee extends Person {
    private String employeeId;
    private String department;

    // 默认构造函数
    public Employee() {
        super();
        this.employeeId = "Unknown";
        this.department = "Unassigned";
    }

    // 带参数的构造函数
    public Employee(String name, int age, String gender, double height, String employeeId, String department) {
        super(name, age, gender, height);
        setEmployeeId(employeeId);
        setDepartment(department);
    }

    // Getters and setters with input validation
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        this.employeeId = employeeId.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        this.department = department.trim();
    }

    @Override
    public String toString() {
        return String.format("Employee{%s, employeeId='%s', department='%s'}",
                super.toString(), employeeId, department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, department);
    }
}