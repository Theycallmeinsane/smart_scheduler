import java.util.Comparator;

public class ClassTimeSlotComparator implements Comparator<Class> {
    private final String[] DAY_ORDER = {"Monday/Wednesday", "Tuesday/Thursday", "Friday/Saturday"};

    @Override
    public int compare(Class c1, Class c2) {
        int dayComparison = c1.Day.compareTo(c2.Day);
        if (dayComparison != 0) {
            return dayComparison;
        }

        int hour1 = c1.getTimeSlot().getStart().getHour();
        int hour2 = c2.getTimeSlot().getStart().getHour();
        return Integer.compare(hour1, hour2);
    }

    private int getIndex(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}


