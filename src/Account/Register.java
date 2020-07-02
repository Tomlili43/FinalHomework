/*
 * Copyright (c) 2020.
 * projectName:FinalHomework
 * fileName:Register.java
 * Date:2020/7/1 上午8:51
 * Author: Zan Zhao
 */

package Account;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Register extends JFrame {

    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JPanel panel1,panel2;
    private Container container;
    private JLabel userLabel, passLabel;
    private JButton okay;
    public static File file = new File("account.txt");

    public static void appendMethod(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content+"\r\n");
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Register() {
        super("注册");

        container = getContentPane();
        panel1=new JPanel();
        panel2=new JPanel();
        panel1.setLayout(new GridLayout(2,2));


        userLabel = new JLabel("请输入用户名");
        usernameInput = new JTextField();
        panel1.add(userLabel);
        panel1.add(usernameInput);

        passLabel = new JLabel("请输入密码");
        passwordInput = new JPasswordField();

        panel1.add(passLabel);
        panel1.add(passwordInput);

        okay = new JButton("确定");
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
//                try {
//                    BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
//                    RandomAccessFile r2 = new RandomAccessFile(file,"rw");
//                    bw.write(usernameInput.getText() + " " + passwordInput.getText());
//                    bw.newLine();
//                    bw.flush();
//                    bw.close();
//                    r2.writeChars(usernameInput.getText() + " "
//                            + passwordInput.getText() + "\n");
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//                appendMethod(file.getName(),usernameInput.getText() + " "
//                            + passwordInput.getText() + "\n");
                appendMethod(file.getName(),usernameInput.getText() + " "
                        + passwordInput.getText() + " ");
                JOptionPane.showMessageDialog(container, "注册成功！" );

            }
        });
        panel2.add(okay);


        container.add(panel1, BorderLayout.CENTER);
        container.add(panel2, BorderLayout.SOUTH);
        setSize(250, 120);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void createAccount() {
        LocalSave.account.setUserName(usernameInput.getText());
        LocalSave.account.setPassword(passwordInput.getText());
        LocalSave.accountPass.put(usernameInput.getText(),passwordInput.getText());
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//            bw.write(LocalSave.accountPass.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*
        new update
         */
//        appendMethod(file.getName(),LocalSave.accountPass.toString());
//        appendMethod(file.getName(),usernameInput.getText() + " "
//                            + passwordInput.getText() + "\n");

        System.out.println(LocalSave.accountPass.toString());
    }
}