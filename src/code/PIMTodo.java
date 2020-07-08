package code;

import java.text.*;

public class PIMTodo extends PIMDateable{
    public static String kind = "APPOINTMENT";

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[" + kind + " " + Priority
                + " " + dateToStr(deadline) + " " + content + "]";
    }
}
