import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    // Function to get the duration between two LocalTime objects
    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        // Compute duration between times and ensure it's positive
        Duration duration = Duration.between(localTime1, localTime2);
        return duration.abs();
    }

    // Function to get the period between two LocalDate objects
    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        // Compute period between dates and ensure it's positive
        Period period = Period.between(date1, date2);
        return period.normalized();  // Normalize to ensure positive values
    }

    // Function to get the number of hours between two LocalDateTime objects
    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // Compute duration between date-times and ensure it's positive
        Duration duration = Duration.between(dateTime1, dateTime2);
        return Math.abs(duration.toHours());
    }

    public static void main(String[] args) {
        Duration duration = DifferenceBetweenDate.durationBetweenTime(LocalTime.of(12, 54, 32), LocalTime.of(21, 23, 53));
        System.out.println(duration.toHoursPart() + "H" + duration.toMinutesPart() + "M" + duration.toSecondsPart() + "S");
        Period period = DifferenceBetweenDate.periodBetweenDate(LocalDate.of(2020, 10, 13), LocalDate.of(2022, 5, 8));
        System.out.println(period.getYears() + "Y" + period.getMonths() + "M" + period.getDays() + "D");
        System.out.println(DifferenceBetweenDate.numberOfHoursBetweenDateTime(LocalDateTime.of(2022, 4, 12, 16, 18, 56), LocalDateTime.of(2022, 5, 10, 21, 54, 56)));
    }

}
