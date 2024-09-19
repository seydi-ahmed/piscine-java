import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeFinder {
    public int calculateAge(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            LocalDate birthDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            
            Period period = Period.between(birthDate, today);
            
            return period.getYears();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        AgeFinder AgeFinder = new AgeFinder();

        // Test case 1
        String date1 = "2000-01-01";
        System.out.println("Age: " + AgeFinder.calculateAge(date1));

        // Test case 2
        String date2 = "1990-06-15";
        System.out.println("Age: " + AgeFinder.calculateAge(date2));

        // Test case 3
        String date3 = "2010-12-25";
        System.out.println("Age: " + AgeFinder.calculateAge(date3));
    }
}
