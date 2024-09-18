import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class FormatDate {
    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        // your code here
        // System.out.println("====================");
        // System.out.println(dateTime.getDayOfMonth());
        DateTimeFormatter frenchFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss", Locale.FRENCH);
        String month = dateTime.format(frenchFormatter).split(" ")[1];
        // System.out.println(month);
        return String.format("Le %d %s de l'an %d à %dh%dm et %ds", dateTime.getDayOfMonth(), month, dateTime.getYear(), dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
    }
    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("dd MMMM yy", Locale.ITALIAN);
        String month = date.format(italianFormatter).split(" ")[1];
        String year = date.format(italianFormatter).split(" ")[2];
        String day = date.format(italianFormatter).split(" ")[0];
        
        return String.format("%s %s %s", month, day, year);
    }
    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String formattedTime = time.format(timeFormatter);
        
        int nano = time.getNano();
        if (nano != 0) {
            
            formattedTime += "." + String.format("%09d", nano).replaceFirst("^0+(?!$)", "");
        }
        return formattedTime;
    }

    public static void main(String[] args) {
        System.out.println(FormatDate.formatToFullText(LocalDateTime.of(2021, 8, 22, 13, 25, 46)));
        System.out.println(FormatDate.formatSimple(LocalDate.of(2022, 2, 13)));
        System.out.println(FormatDate.formatIso(LocalTime.of(16, 18, 56, 8495847)));
    }

}
