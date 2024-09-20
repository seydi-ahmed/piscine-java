import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RevizCheck {
    public int calculateAge(String date) {
        try {

            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate newDate = LocalDate.parse(date, formatter);

            LocalDate jourj = LocalDate.now();
            
            Period diff = Period.between(newDate, jourj);

            return diff.getYears();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }



// ************************************************************************************************************************************    

    public static void main(String[] args) {
        RevizCheck RevizCheck = new RevizCheck();

        // Test case 1
        String date1 = "2000-01-01";
        System.out.println("Age: " + RevizCheck.calculateAge(date1));

        // Test case 2
        String date2 = "1990-06-15";
        System.out.println("Age: " + RevizCheck.calculateAge(date2));

        // Test case 3
        String date3 = "2010-12-25";
        System.out.println("Age: " + RevizCheck.calculateAge(date3));
    }
}
