import java.util.Comparator;

// This class implements the Comparator interface for Visitor objects
// It provides a custom way to compare two Visitor objects
public class VisitorComparator implements Comparator<Visitor> {

    // Overridden compare method from the Comparator interface
    // This method defines how two Visitor objects should be compared
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare the ages of the two Visitors
        // Integer.compare returns a negative integer, zero, or a positive integer
        // if v1's age is less than, equal to, or greater than v2's age respectively
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());

        // If the ages are different, return the result of the age comparison
        if (ageComparison != 0) {
            return ageComparison;
        }

        // If the ages are the same, compare the heights of the two Visitors
        // Double.compare returns a negative integer, zero, or a positive integer
        // if v1's height is less than, equal to, or greater than v2's height respectively
        return Double.compare(v1.getHeight(), v2.getHeight());
    }
}