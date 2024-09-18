import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    // Calculate the duration between two LocalTime instances
    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        // Calculate the duration between the two times
        Duration duration = Duration.between(localTime1, localTime2);
        // Return the absolute duration
        return duration.abs();
    }

    // Calculate the period between two LocalDate instances
    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        // Calculate the period between the two dates
        Period period = Period.between(date1, date2);
        // Return the absolute period
        return period.isNegative() ? period.negated() : period;
    }

    // Calculate the number of hours between two LocalDateTime instances
    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // Calculate the duration between the two date-times
        Duration duration = Duration.between(dateTime1, dateTime2);
        // Return the absolute number of hours
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
