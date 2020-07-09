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
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField1;

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

//        ItemField = new JTextField();

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
//                    System.out.println(ItemField.getText());
                        pe.setContent(textField1.getText());
//                        System.out.println(textField1.getText());
//                        System.out.println("split");
//                        System.out.println(pe.content);
//                        System.out.println(pe.toString());
                        PIMManager.EntityList.add(pe);
//                        System.out.println(PIMManager.EntityList);
//
                        //TODO：移植
//                        PIMManager.Save();
                    }
//                    else if(TODORadioButton.isSelected()){
//                        pe = new PIMTodo();
//                    }
//                    else if(CONTACTRadioButton.isSelected()){
//                        pe = new PIMContact();
//                    }
//                    else if(APPOINTMENTRadioButton.isSelected()){
//                        pe = new PIMAppointment();
//                    }



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