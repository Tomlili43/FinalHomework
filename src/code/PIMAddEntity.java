package code;

import Account.LocalSave;
import Account.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PIMAddEntity extends JFrame {
//    public static         //txt to write textField
//            File file = new File("items.txt");

    public static File file;
    private JButton ADDTOPIMManagerButton;
    private JPanel rootPanel;
    private JLabel up;
    private JPanel elevel;
    private JPanel kind;
    private JRadioButton exUrgentRadioButton;
    private JRadioButton unlimitedRadioButton;
    private JRadioButton urgentRadioButton;
    private JRadioButton normalRadioButton;
    private JRadioButton NOTERadioButton;
    private JRadioButton TODORadioButton;
    private JRadioButton CONTACTRadioButton;
    private JRadioButton APPOINTMENTRadioButton;
    public JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public PIMAddEntity(){
        textField1 = new JTextField();
        add(rootPanel);

        //combine levelGroup
        ButtonGroup levelGroup = new ButtonGroup();
        levelGroup.add(exUrgentRadioButton);
        levelGroup.add(urgentRadioButton);
        levelGroup.add(normalRadioButton);
        levelGroup.add(unlimitedRadioButton);

        //combine kindGroup
        ButtonGroup kindGroup = new ButtonGroup();
        kindGroup.add(NOTERadioButton);
        kindGroup.add(TODORadioButton);
        kindGroup.add(CONTACTRadioButton);
        kindGroup.add(APPOINTMENTRadioButton);



        //able to close
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //title,size and location
        setTitle("PIMAddEntity");
        setSize(350,450);
        setLocation(350,300);


        /*
        new file name
         */

//        File file = new File("itemOf" + LocalSave.account.getUserName() + ".txt");


        //ActionListener(when press the bottom button)
        ADDTOPIMManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = textField1.getText();
                //write in txt file
                try {
                    String levelSelected = null;

                    if(exUrgentRadioButton.isSelected()){
                        levelSelected = exUrgentRadioButton.getText();
                    }
                    else if(urgentRadioButton.isSelected()){
                        levelSelected = urgentRadioButton.getText();
                    }
                    else if(normalRadioButton.isSelected()){
                        levelSelected = normalRadioButton.getText();
                    }
                    else if(unlimitedRadioButton.isSelected()){
                        levelSelected = unlimitedRadioButton.getText();
                    }

                    PIMEntity pe = null;
                    if(NOTERadioButton.isSelected()){
                        pe = new PIMNote();
                    }
                    else if(TODORadioButton.isSelected()){
                        pe = new PIMTodo();
                    }
                    else if(CONTACTRadioButton.isSelected()){
                        pe = new PIMContact();
                    }
                    else if(APPOINTMENTRadioButton.isSelected()){
                        pe = new PIMAppointment();
                    }

                    pe.setPriority(levelSelected);
                    pe.owner = Login.userName;
                    pe.content = in;

                    file = new File(pe.owner + ".txt");
                    RandomAccessFile r = new RandomAccessFile(file,"rw");
                    long fileLength = r.length();
                    r.seek(fileLength);
                    r.writeChars(pe.toString()+ "\n");
                    r.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                JOptionPane.showMessageDialog(rootPane,"Success!");
            }
        });
    }
}