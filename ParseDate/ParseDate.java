import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (stringDate == null) {
            return null;
        }
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        boolean isPM = false;  // To check if the time is in the evening
        // Regex patterns for extracting time components from the string
        Pattern hoursPattern = Pattern.compile("(\\d{1,2}) heures? (du matin|du soir)");
        Pattern minutesPattern = Pattern.compile("(\\d{1,2}) minutes?");
        Pattern secondsPattern = Pattern.compile("(\\d{1,2}) secondes?");
        // Match and extract hours
        Matcher hoursMatcher = hoursPattern.matcher(stringDate);
        if (hoursMatcher.find()) {
            hours = Integer.parseInt(hoursMatcher.group(1));
            String period = hoursMatcher.group(2);
            if (period.equals("du soir")) {
                isPM = true;  // If it's "du soir", we'll adjust for PM later
            }
        }
        // Match and extract minutes
        Matcher minutesMatcher = minutesPattern.matcher(stringDate);
        if (minutesMatcher.find()) {
            minutes = Integer.parseInt(minutesMatcher.group(1));
        }
        // Match and extract seconds
        Matcher secondsMatcher = secondsPattern.matcher(stringDate);
        if (secondsMatcher.find()) {
            seconds = Integer.parseInt(secondsMatcher.group(1));
        }
        // Adjust for PM (add 12 to the hour unless it's 12 PM, which stays the same)
        if (isPM && hours < 12) {
            hours += 12;
        }
        // Return the constructed LocalTime object
        return LocalTime.of(hours, minutes, seconds);
    }

    public static void main(String[] args) {
        System.out.println(parseIsoFormat("2022-04-25T20:51:28.709039322"));
        System.out.println(parseFullTextFormat("lundi 25 avril 2022"));
        System.out.println(parseTimeFormat("09 heures du soir, 07 minutes et 23 secondes"));
    }

}
