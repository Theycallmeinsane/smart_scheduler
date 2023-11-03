import java.util.ArrayList;
import java.util.Scanner;

public class Slots {
    private MyTime start;
    private MyTime end;


    public Slots(MyTime start, MyTime end) {
        this.start = start;
        this.end = end;

    }

    public Slots(MyTime start) {
        this.start = start;
    }

    public Slots() {
    }

    public MyTime getStart() {
        return start;
    }

    public void setStart(MyTime start) {
        this.start = start;
    }

    public MyTime getEnd() {
        return end;
    }

    public void setEnd(MyTime end) {
        this.end = end;
    }


    public ArrayList makeSlots() {
        Scanner sc = new Scanner(System.in);
        ArrayList daySlot = new ArrayList();

        System.out.println("How many slots you have");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Start time and end time of class");
            String start = sc.next();
            String[] strt = start.split(":");
            MyTime startTime = new MyTime(Integer.parseInt(strt[0]), Integer.parseInt(strt[1]));
            System.out.println(startTime);
            System.out.println("End Time?");
            String end = sc.next();
            String[] ET = end.split(":");
            MyTime endTime = new MyTime(Integer.parseInt(ET[0]), Integer.parseInt(ET[1]));

            daySlot.add(new Slots(startTime, endTime));


        }
        return daySlot;
    }


    public String toString() {
        return "{" +
                start +
                "-" + end +
                '}';
    }
}

