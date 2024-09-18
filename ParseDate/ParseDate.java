import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class ParseDate {

    // Parses the ISO 8601 format (e.g., 2022-04-25T20:51:28.709039322)
    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate, DateTimeFormatter.ISO_DATE_TIME);
    }

    // Parses a full-text formatted date (e.g., "lundi 25 avril 2022")
    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRANCE);
        return LocalDate.parse(stringDate, formatter);
    }

    // Parses a time string (e.g., "09 heures du soir, 07 minutes et 23 secondes")
    public static LocalTime parseTimeFormat(String stringDate) {
        // We need to extract hours, minutes, seconds and determine if it's AM or PM
        int hour = Integer.parseInt(stringDate.substring(0, 2));
        int minute = Integer.parseInt(stringDate.substring(21, 23));
        int second = Integer.parseInt(stringDate.substring(36, 38));

        // Determine if "soir" is in the string to convert to PM
        if (stringDate.contains("soir") && hour != 12) {
            hour += 12; // Convert to 24-hour format for PM times
        } else if (stringDate.contains("matin") && hour == 12) {
            hour = 0; // Special case for 12 AM
        }

        return LocalTime.of(hour, minute, second);
    }

    public static void main(String[] args) {
        System.out.println(parseIsoFormat("2022-04-25T20:51:28.709039322"));
        System.out.println(parseFullTextFormat("lundi 25 avril 2022"));
        System.out.println(parseTimeFormat("09 heures du soir, 07 minutes et 23 secondes"));
    }

}
