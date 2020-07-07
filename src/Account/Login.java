/*
 * Copyright (c) 2020.
 * projectName:FinalHomework
 * fileName:PIMLogin.java
 * Date:2020/7/1 上午8:45
 * Author: Zan Zhao
 */

package Account;

import code.MyCalendar;

import javax.swing.*;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;


public class
Login extends JFrame{
    public JTextField user;
    private JPasswordField pass;
    private JPanel u, p, b;
    private Container c;
    private JLabel ID, password;
    private JButton login, register;

    public Login() {
        super("PIMLogin");
        c = getContentPane();
        JLabel HeadLabel = new JLabel("Register/Login");
        HeadLabel.setFont(new Font("", Font.BOLD, 25));
        u = new JPanel();
        p = new JPanel();
        b = new JPanel();
        u.setLayout(new BorderLayout());
        p.setLayout(new BorderLayout());
        ID = new JLabel("账号");
        user = new JTextField();
        u.add(ID, BorderLayout.WEST);
        u.add(user, BorderLayout.CENTER);

        password = new JLabel("密码");
        pass = new JPasswordField();

        p.add(password, BorderLayout.WEST);
        p.add(pass, BorderLayout.CENTER);
        login = new JButton("登录");
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                check(user.getText(),pass.getText());

            }
        });
        register = new JButton("注册");
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Register r = new Register();

            }
        });
        b.add(login);
        b.add(register);

        c.add(u, BorderLayout.NORTH);
        c.add(p, BorderLayout.CENTER);
        c.add(b, BorderLayout.SOUTH);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void check(String name,String pswd){
        Map<String,String> passList = new HashMap<>();
        String str,substr[];
        try {
            BufferedReader br = new BufferedReader(new FileReader(Register.file));
            while ((str = br.readLine()) != null) {
                substr = str.split(" ");
                passList.put(substr[0],substr[1]);
            }
//            System.out.println(passList.toString());
            br.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        boolean flag = false;
        for(Map.Entry<String,String> entry : passList.entrySet()){
            if(name.equals(entry.getKey())
                    && pswd.equals(entry.getValue())){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("登录成功！！!");
            super.setVisible(false);
            JFrame jFrame=new MyCalendar(user.getText());
            jFrame.setVisible(true);
        }
        else{
            System.out.println("登录失败！！！");
            Object[] options = { "OK", "CANCEL" };
            JOptionPane.showOptionDialog(null, "登录失败，请重新输入", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        }
    }
}
