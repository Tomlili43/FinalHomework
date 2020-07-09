package code;

import Account.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PIMAddEntity extends JFrame {

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
    public JTextField ItemField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public PIMAddEntity(){

        add(rootPanel);
        ItemField = new JTextField();
//        getContentPane().add(ItemField);

        ItemField.setText("fuck you");
        System.out.println(ItemField.getText());


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

        ItemField = new JTextField();

        //able to close
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //title,size and location
        setTitle("PIMAddEntity");
        setSize(350,450);
        setLocation(350,300);

        /*
        new file name
         */


        //ActionListener(when press the bottom button)
        ADDTOPIMManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    pe.content = ItemField.getText();

                    file = new File(pe.owner + ".txt");
                    RandomAccessFile r = new RandomAccessFile(file,"rw");
                    long fileLength = r.length();
                    r.seek(fileLength);
                    r.writeChars(pe.toString());
                    r.writeChars("\n");
                    r.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(rootPane,"Success!");
            }
        });
    }
}