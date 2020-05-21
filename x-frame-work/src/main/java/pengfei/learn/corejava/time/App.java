package pengfei.learn.corejava.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.temporal.ChronoUnit.DAYS;

public class App {
    public static void main(String[] args) {

        Date d1 = new GregorianCalendar(2000, 1, 9, 0, 0, 0).getTime();
        Date d2 = new GregorianCalendar(2001, 1, 9, 0, 0, 0).getTime();


        LocalDate l1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate l2 = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long between = DAYS.between(l1, l2);

        System.out.println(between);


    }
}
