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
    private JTextField dayfield;
    private JTextField yearfield;
    private JTextField monthfield;
    private JTextField textField1;
    private JTextField familynfield;
    private JTextField emailAfield;
    private JTextField firstnfield;

    public PIMAddEntity(){

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


                    if(NOTERadioButton.isSelected()){
                        PIMNote pe = new PIMNote();
                        pe.setPriority(levelSelected);
                        pe.owner = Login.userName;
                        pe.setContent(textField1.getText());

                        PIMManager.EntityList.add(pe);

                    }

                    else if(TODORadioButton.isSelected()){
                        PIMTodo pe = new PIMTodo();
                        pe.setPriority(levelSelected);
                        pe.owner = Login.userName;
                        pe.fromString(monthfield.getText() +
                                "/" + dayfield.getText() +
                                "/" + yearfield.getText());
                        pe.setContent(textField1.getText());

                        PIMManager.EntityList.add(pe);
                    }

                    else if(CONTACTRadioButton.isSelected()){
                        PIMContact pe = new PIMContact();
                        pe.owner = Login.userName;
                        pe.set(levelSelected,
                                firstnfield.getText(),
                                familynfield.getText(),
                                emailAfield.getText());

                        PIMManager.EntityList.add(pe);
                    }
                    else if(APPOINTMENTRadioButton.isSelected()){
                        PIMAppointment pe = new PIMAppointment();
                        pe.setPriority(levelSelected);
                        pe.owner = Login.userName;
                        pe.fromString(monthfield.getText() +
                                "/" + dayfield.getText() +
                                "/" + yearfield.getText());
                        pe.setContent(textField1.getText());

                        PIMManager.EntityList.add(pe);
                    }



//                } catch (IOException e1) {
//                    e1.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                JOptionPane.showMessageDialog(rootPane,"Success!");
            }
        });
    }
}