package code;

import java.io.Serializable;
import java.text.*;
import java.util.Date;

public class PIMDateable extends PIMEntity implements MyDate{
    public String Priority; // each appointment has a priority
    public String content; // each appointment has a content
    public java.util.Date deadline = null; // each appointment has a deadline

    PIMDateable() {
        Priority = "normal";
    }

    PIMDateable(String priority){
        this.Priority = priority;
    }

    @Override
    public String getPriority() {
        // TODO Auto-generated method stub
        return super.getPriority();
    }

    @Override
    public void setPriority(String p) {
        // TODO Auto-generated method stub
        this.Priority = p;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.util.Date getDeadline() {
        return deadline;
    }

    public void setDeadline(java.util.Date deadline) {
        this.deadline = deadline;
    }

    public void fromString(String s) {
        // TODO Auto-generated method stub
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		ParsePosition pos = new ParsePosition(0);
        try {
            this.deadline = formatter.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[" + Priority
                + " " + dateToStr(deadline) + " " + content + "]";
    }

    @Override
    public String dateToStr(Date date) {
        // TODO Auto-generated method stub
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String str = format.format(date);
        return str;
    }

}
