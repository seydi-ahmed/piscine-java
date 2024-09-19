import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
        try {
            // Parse the input dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);

            // Calculate the period between the two dates
            Period period = Period.between(start, end);

            int years = Math.abs(period.getYears());
            int months = Math.abs(period.getMonths());

            // Build the output string based on the calculated period
            if (years > 0 && months > 0) {
                if (years > 1) {
                    if (months > 1) {
                        return years + " years and " + months + " months";
                    } else {
                        return years + " years and " + months + " month";
                    }
                } else {
                    if (months > 1) {
                        return years + " year and " + months + " months";
                    } else {
                        return years + " year and " + months + " month";
                    }
                }
            } else if (years > 0) {
                if (years > 1) {
                    return years + " years";
                } else {
                    return years + " year";
                }
            } else if (months > 0) {
                if (months > 1) {
                    return months + " months";
                } else {
                    return months + " month";
                }
            } else {
                return "0 months"; // Si la période est nulle
            }

        } catch (DateTimeParseException e) {
            return "Error"; // Return error for invalid date formats
        }
    }

    public static void main(String[] args) {
        MonthlyPeriod MonthlyPeriod = new MonthlyPeriod();

        String startDate1 = "2020-01-01";
        String endDate1 = "2023-06-15";
        System.out.println("Period: " + MonthlyPeriod.calculatePeriod(startDate1, endDate1));

        String startDate2 = "2015-05-20";
        String endDate2 = "2015-10-19";
        System.out.println("Period: " + MonthlyPeriod.calculatePeriod(startDate2, endDate2));

        String startDate3 = "2015-05-20";
        String endDate3 = "2015-10-19";
        System.out.println("Period: " + MonthlyPeriod.calculatePeriod(startDate3, endDate3));

        String startDate4 = "2018-12-25";
        String endDate4 = "2021-12-25";
        System.out.println("Period: " + MonthlyPeriod.calculatePeriod(startDate4, endDate4));

        String startDate5 = "2018-10-25";
        String endDate5 = "2019-11-30";
        System.out.println("Period: " + MonthlyPeriod.calculatePeriod(startDate5, endDate5));
    }
}


// Period: 3 years and 5 months
// Period: 4 months
// Period: 5 months
// Period: 3 years
// Period: 1 year and 1 month