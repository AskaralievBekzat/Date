import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date: " + month + "/" + day + "/" + year);
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date update attempt.");
        }
    }

    public String getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public int calculateDifference(Date otherDate) {
        LocalDate thisDate = LocalDate.of(year, month, day);
        LocalDate thatDate = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return (int) ChronoUnit.DAYS.between(thisDate, thatDate);
    }

    public void printDate() {
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println(date.getMonth() + " " + day + ", " + year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }
}