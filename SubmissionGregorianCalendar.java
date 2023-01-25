/**
 * @Author Evan Musick
 * Date: 1/24/2023
 * Course: 23/SP-CIS-171-W01
 */

public class GregorianCalendar {

// Method that returns the calendars relative (to month) day into a variable (d)
public static int day (int month, int day, int year) {
    int y = year - (14 - month) / 12;
    int x = y + y/4 - y/100 + y/400;
    // Variable 'x' used only to store number of leap days
    int m = month + 12 * ((14 - month) / 12) - 2;
    int d = (day + x + (31*m)/12)%7;
    return d;
}    

// Method that checks to see if the year is a leap year
// Returns boolean
public static boolean ifLeapYear(int year) {
    if ((year % 4 == 0) && (year % 100 != 0)) return true;
    return year % 400 == 0;
}

// Main Method to run other methods and display Calendar relating to user input [Month, Year]
public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[0]);
    
    // Months Array
    String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    // Days of Months Array
    int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    // If Logic to check if year is Leap
    
    if (month == 2 && ifLeapYear(year)) days[month] = 29;
    
    System.out.println(" " + months[month] + " " + year);
    System.out.println(" S M Tu W Th F S");
    
    int d = day (month, 1, year);
    
    for (int i = 0; i < d; i++)
        System.out.print(" ");
    for (int i = 1; i <= days[month]; i++) {
        System.out.printf("%2d ", i);
        if (((i+d) %7 == 0) || (i == days[month]))
            System.out.println();
    }
        
        
}
}
