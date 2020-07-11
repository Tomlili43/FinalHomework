/*
 * Copyright (c) 2020.
 * projectName:PIM1
 * fileName:dateSearch.java
 * Date:2020/7/11 下午4:44
 * Author: Zan Zhao
 */

package code;/*
    $file.className
    @author:Zan7 ZHAO (on Dell)
    @date:
    */

import javax.swing.*;
import java.awt.*;

public class DateSearch extends JFrame {
    private JTextField monthField;
    private JTextField dayField;
    private JTextField yearField;

    public DateSearch(){
        monthField = new JTextField();
        dayField = new JTextField();
        yearField = new JTextField();

        setLayout(new BorderLayout());
        setVisible(true);

    }

    public void getDate(){
        String month = monthField.getText();
        String day = dayField.getText();
        String year = yearField.getText();

    }

}
