import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 首先按年龄比较
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        // 如果年龄相同，则按身高比较
        return Double.compare(v1.getHeight(), v2.getHeight());
    }
}