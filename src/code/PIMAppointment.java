package code;

import java.text.*;
import java.util.Date;

public class PIMAppointment extends PIMDateable{
    public static String kind = "APPOINTMENT";

    @Override
    public String toString() {
        return "[" + kind + " " + Priority
                + " " + dateToStr(deadline) + " " + content + "]";
    }
}
