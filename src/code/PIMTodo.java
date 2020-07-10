package code;

import java.text.*;

public class PIMTodo extends PIMDateable{
    public static String kind = "TODO";

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[Public:" + OwnerIsPublic + " Kind:" + kind + " Priority:" + Priority
                + " Date:"+ dateToStr(deadline) + " Content:" + content + "]";
    }
}
