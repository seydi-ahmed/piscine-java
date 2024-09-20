import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayOfWeekFinder {
    public String findNextDayOfWeek(String startDate, String dayOfWeek) {
        try {
            // Parse the input date
            // LocalDate date = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(startDate, formatter);
            
            // Convert the input day of the week string to a DayOfWeek enum
            DayOfWeek targetDay;
            try {
                targetDay = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
            } catch (IllegalArgumentException e) {
                return "Error"; // Invalid day of the week
            }

            // Get the current day of the week from the start date
            DayOfWeek currentDay = date.getDayOfWeek();

            // Calculate the difference between the target day and the current day
            int daysUntilNext = (targetDay.getValue() - currentDay.getValue() + 7) % 7;
            if (daysUntilNext == 0) {
                daysUntilNext = 7; // If the same day, we want the next occurrence, which is 7 days later
            }

            // Find the next occurrence of the target day
            LocalDate nextDate = date.plusDays(daysUntilNext);

            // Return the next date in the "yyyy-MM-dd" format
            return nextDate.toString();
        } catch (DateTimeParseException e) {
            return "Error"; // Invalid date format
        }
    }

    public static void main(String[] args) {
        DayOfWeekFinder finder = new DayOfWeekFinder();

        // Test case 1
        String startDate1 = "2023-06-22";
        String dayOfWeek1 = "Monday";
        System.out.println("Next " + dayOfWeek1 + " after " + startDate1 + ": " + finder.findNextDayOfWeek(startDate1, dayOfWeek1));

        // Test case 2
        String startDate2 = "2023-06-22";
        String dayOfWeek2 = "Friday";
        System.out.println("Next " + dayOfWeek2 + " after " + startDate2 + ": " + finder.findNextDayOfWeek(startDate2, dayOfWeek2));

        // Test case 3
        String startDate3 = "2023-06-22";
        String dayOfWeek3 = "Sunday";
        System.out.println("Next " + dayOfWeek3 + " after " + startDate3 + ": " + finder.findNextDayOfWeek(startDate3, dayOfWeek3));

        // Error case: invalid date format
        String startDate4 = "invalid-date";
        String dayOfWeek4 = "Monday";
        System.out.println("Next " + dayOfWeek4 + " after " + startDate4 + ": " + finder.findNextDayOfWeek(startDate4, dayOfWeek4));

        // Error case: invalid day of the week
        String startDate5 = "2023-06-22";
        String dayOfWeek5 = "Funday";
        System.out.println("Next " + dayOfWeek5 + " after " + startDate5 + ": " + finder.findNextDayOfWeek(startDate5, dayOfWeek5));
    }
}