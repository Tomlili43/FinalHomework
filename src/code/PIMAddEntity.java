package code;

import Account.LocalSave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PIMAddEntity extends JFrame {
//    public static         //txt to write textField
//            File file = new File("items.txt");
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
    private JList list1;

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


        /*
        new file name
         */

        File file = new File("itemOf" + LocalSave.account.getUserName() + ".txt");

        //ActionListener(when press the bottom button)
        ADDTOPIMManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //write in txt file
                try {
//                    BufferedWriter bwinCal = new BufferedWriter(new FileWriter(file,true));
                    RandomAccessFile r = new RandomAccessFile(file,"rw");
                    long fileLength = r.length();

                    String levelSelected = null, kindSelected = null;
                    String in = textField1.getText();

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
                        kindSelected = NOTERadioButton.getText();
//                        PIMNote note = new PIMNote();
                    }
                    else if(TODORadioButton.isSelected()){
                        kindSelected = TODORadioButton.getText();
                    }
                    else if(CONTACTRadioButton.isSelected()){
                        kindSelected = CONTACTRadioButton.getText();
                    }
                    else if(APPOINTMENTRadioButton.isSelected()){
                        kindSelected = APPOINTMENTRadioButton.getText();
                    }

                    r.seek(fileLength);
                    r.writeChars("level:" + levelSelected +" "
                            + "kind:" + kindSelected + " "
                            + "Item:" + in + "\n");
                    r.close();

//                    bwinCal.write("level:" + levelSelected +" "
//                            + "kind:" + kindSelected + " "
//                            + "Item:" + in);
//                    bwinCal.newLine();
//                    bwinCal.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                JOptionPane.showMessageDialog(rootPane,"Success!");
            }
        });
    }
}