package club.nullbyte3.adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();
        date.setYear(2023);
        date.setMonth(10);
        date.setDay(26);

        System.out.println("Initial date: " + date.getYear() + "/" + date.getMonth() + "/" + date.getDay());

        date.advanceDays(5);

        System.out.println("Date after advancing 5 days: " + date.getYear() + "/" + date.getMonth() + "/" + date.getDay());
    }
}
