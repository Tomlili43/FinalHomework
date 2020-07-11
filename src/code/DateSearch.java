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

import Account.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DateSearch extends JFrame {
    private JTextField monthField;
    private JTextField dayField;
    private JTextField yearField;
    private JButton OKAYButton;
    private JPanel rootPanel;
    public File file;

    public DateSearch(){
        super("DateSearch");
//        monthField = new JTextField();
//        dayField = new JTextField();
//        yearField = new JTextField();
//        add(monthField);
//        add(dayField);
//        add(yearField);
        add(rootPanel);

//        setLayout(new BorderLayout());
        setVisible(true);
        setLocation(350,300);
        setSize(500,300);


        OKAYButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getDate();
            }
        });
    }

    public void getDate(){
        file = new File(Login.userName + ".txt");
        String month = monthField.getText();
        String day = dayField.getText();
        String year = yearField.getText();

        String dateSearchString = month + "/" + day + "/" + year;
        try {
            JFrame frame = new JFrame("Item for " + dateSearchString);
            JTextArea text = new JTextArea(10,10);
            text.setFont(new Font("Monospace", Font.BOLD, 20));
            text.setBackground(new Color(199, 238, 206));
            frame.add(new JScrollPane(text), BorderLayout.CENTER);
            frame.setVisible(true);
            frame.setBounds(200,200,800,500);
            String contactItems = "";

            PIMCollection<PIMEntity> list = new PIMCollection<>();
            FileInputStream fn = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fn);
            String all = "";
            while (fn.available() > 0) {
                Object obj = ois.readObject();
//                list.add((PIMEntity) ois.readObject());
                if(obj instanceof PIMTodo||obj instanceof PIMAppointment){
                    if(
                            (((PIMDateable) obj)
                            .dateToStr(((PIMDateable) obj)
                                    .getDeadline()))
                            .equals(dateSearchString)){
                        list.add((PIMDateable)obj);
                    }
                }
            }
            for (PIMEntity p : list) {
                all = all + p + "\n";
            }
            if(!list.isEmpty()){
                //TODO:改为面板输出
//                System.out.println(list);
                text.setText(String.valueOf(list));
            }
            else JOptionPane.showMessageDialog(rootPane,"Not Found!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
