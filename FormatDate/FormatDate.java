import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    // Function to format date to "Le 22 août de l'an 2021 à 13h25m et 46s"
    public static String formatToFullText(LocalDateTime dateTime) {
        DateTimeFormatter dayMonthFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale.FRENCH);
        String formattedDate = dateTime.format(dayMonthFormatter);
        return String.format("Le %s de l'an %d à %dh%dm et %ds", 
                             formattedDate, 
                             dateTime.getYear(),
                             dateTime.getHour(), 
                             dateTime.getMinute(), 
                             dateTime.getSecond());
    }

    // Function to format date to "febbraio 13 22"
    public static String formatSimple(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALIAN);
        return date.format(formatter);
    }

    // Function to format time to "16:18:56.8495847"
    public static String formatIso(LocalTime time) {
        // Using built-in formatter for ISO time with nanoseconds
        DateTimeFormatter isoTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.n");
        return time.format(isoTimeFormatter);
    }

    public static void main(String[] args) {
        System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));
    }

}
