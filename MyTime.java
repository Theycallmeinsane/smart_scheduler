import java.util.Scanner;

public class MyTime {
    private int hour;
    private int minute;
    

    public MyTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;

        boolean check = false;
        this.hour = hour;
        this.minute = minute;


        Scanner sc = new Scanner(System.in);
        try {
            if (hour > 23 || hour < 00)
                throw new IllegalArgumentException();
            if (minute > 59 || minute < 00)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid Hour,Minute or Seconds ");
            MyTime F = new MyTime(sc.nextInt(), sc.nextInt());
            this.hour = F.hour;
            this.minute = F.minute;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int nextMinute(int minutesDuration, int minutesBreak) {
        minute += minutesBreak + minutesDuration;
        if (minute > 59) {
            hour++;
            minute = 00;
        }
        if (hour > 23) {
            hour = 00;
        }
        return minute;
    }

    public MyTime nextHourMinute(int hoursDuration, int hoursBreak, int minutesDuration, int minutesBreak) {
        int newHour = hour + hoursDuration + hoursBreak;
        int newMinute = minute + minutesDuration + minutesBreak;

        if (newMinute >= 60) {
            newHour += 1;
            newMinute -= 60;
        }
        if (newHour >= 24) {
            newHour -= 24;
        }

        try {
            if (newHour < 0 || newHour >= 24)
                throw new IllegalArgumentException();
            if (newMinute < 0 || newMinute >= 60)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid Hour or Minute ");
            Scanner sc = new Scanner(System.in);
            MyTime F = new MyTime(sc.nextInt(), sc.nextInt());
            return F;
        }

        return new MyTime(newHour, newMinute);
    }


    public String toString() {

        return hour + ":" + minute;
    }

}
