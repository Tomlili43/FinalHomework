package code;


import Account.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyCalendar extends JFrame implements ActionListener,RemotePIMCollection {

    public JTextField text;
    JPanel head=new JPanel();//北部容器
    JPanel body=new JPanel();//中部容器
    JPanel foot=new JPanel();//南部容器
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    Calendar calendar = Calendar.getInstance();
    int dayNow = calendar.get(Calendar.DATE);
    int monthNow = calendar.get(Calendar.MONTH) + 1;
    int yearNow = calendar.get(Calendar.YEAR);
    int year = calendar.get(Calendar.YEAR);//获取当前查询年份，默认为当前年份
    int month = calendar.get(Calendar.MONTH) + 1;//获取当前查询月份，默认为当前月份
    public File file;

    public MyCalendar(String str){//构造方法
        //主要参数设置
        setTitle(str+"的日历");
        setSize(500,400);
        setLocationRelativeTo(null);//窗体居中
        setResizable(false);//关闭窗体大小可调
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        leftPanel.add(head);
        leftPanel.add(body);
        leftPanel.add(foot);
        //界面布局
        //北部容器
        head.setBackground(new Color(245,222,179));
        head.setLayout(new FlowLayout());
//        JButton searchJButton=new JButton("查询");
//        searchJButton.setFont(new Font("SimHei",Font.BOLD,15));
//        searchJButton.setForeground(new Color(245,245,245));
//        searchJButton.setBackground(new Color(255,140,0));
//        searchJButton.setPreferredSize(new Dimension(50,35));
//        searchJButton.setBorder(null);
        JButton upJButton=new JButton("Last");
        upJButton.setFont(new Font("SimHei",Font.BOLD,15));
        upJButton.setForeground(new Color(245,245,245));
        upJButton.setBackground(new Color(105,105,105));
        upJButton.setBorder(null);
        upJButton.setPreferredSize(new Dimension(50,35));
        JButton downJButton=new JButton("Next");
        downJButton.setFont(new Font("SimHei",Font.BOLD,15));
        downJButton.setForeground(new Color(245,245,245));
        downJButton.setBackground(new Color(105,105,105));
        downJButton.setBorder(null);
        downJButton.setPreferredSize(new Dimension(50,35));
//        JLabel jLabelShow=new JLabel("Year：");
//        jLabelShow.setFont(new Font("SimHei",Font.BOLD,15));
//        text=new JTextField(100);
//        head.add(jLabelShow);
//        head.add(text);
//        head.add(searchJButton);
        head.add(upJButton);
        head.add(downJButton);
//        searchJButton.addActionListener(this);
        upJButton.addActionListener(this);
        downJButton.addActionListener(this);

        MenuInit();

        //中部容器
        body.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);//每行添加组件的顺序
        body.setBackground(new Color(210,180,140));
        body.setLayout(new GridLayout(7,7,1,1));
        getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));

        //南部容器
        /*JButton addJButton = new JButton("添加");
        addJButton.setForeground(new Color(245,245,245));
        addJButton.setBackground(new Color(62, 78, 123));
        addJButton.setPreferredSize(new Dimension(50,35));
        addJButton.setBorder(null);
        addJButton.setLayout(new FlowLayout((FlowLayout.RIGHT)));*/
        foot.setSize(new Dimension(500,200));
        foot.setBackground(new Color(220,220,220));
        foot.setLayout(new FlowLayout(FlowLayout.CENTER));
        //foot.add(addJButton);
        //addJButton.addActionListener(this);


        Container integralContainer=this.getContentPane();//创建全局容器
        integralContainer.add(head,BorderLayout.NORTH);
        integralContainer.add(body,BorderLayout.CENTER);
        integralContainer.add(foot,BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {//监听事件
        String label=actionEvent.getActionCommand();
        switch (label) {
//            case "查询":
//                System.out.println("进入查询");
//                try {
//                    year = Integer.parseInt(text.getText());
//                    month=1;
//                    getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
//                }catch (NumberFormatException e){
//                    System.out.println("非数字异常已被捕获，进程正常！");
//                }
//                break;
            case "Last":
                System.out.println("Last Month");
                if (month==1){
                    year--;
                    month=12;
                }else
                    month--;
                getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
                break;
            case "Next":
                System.out.println("Next Month");

                if (month==12){
                    year++;
                    month=1;
                }else
                    month++;
                getDateInfo(String.valueOf(year)+"-"+String.valueOf(month));
                break;
            case "Add":
                System.out.println("Add new");
                UIManager.setInstalledLookAndFeels(UIManager.getInstalledLookAndFeels());

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PIMAddEntity pimAddEntity = new PIMAddEntity();
                        pimAddEntity.setVisible(true);
                    }
                });
                break;
        }
    }

    public void getDateInfo(String date) {//获取日期信息
        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM");// 日期格式化类
            Date parse = dFormat.parse(date);// 把字符串类型的日期转换为date类型的
            Calendar calendar = new GregorianCalendar();// 创建一个公历类的实例
            calendar.setTime(parse);// 把格式化好的日期对象放进Calendar
            calendar.set(Calendar.DATE, 1);//重置日期为第一天
            // 获取这个月的第一天是周几
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            // 获取每个月最大的天数
            int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            body.removeAll();
            body.repaint();

            String[] title = {"日", "一", "二", "三", "四", "五", "六"};
            for (String label : title) {
                JLabel jLabel = new JLabel(label);
                jLabel.setHorizontalAlignment(JLabel.CENTER);
                jLabel.setForeground(new Color(255, 0, 0));
                jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                jLabel.setFont(new Font("SimHei", Font.BOLD, 18));
                body.add(jLabel);
                body.revalidate();
            }
            for (int i = 1; i <= 42; i++) {
                if (i >= weekDay && i <= (maxDay + weekDay - 1)) {
                    JLabel jLabel = new JLabel(String.valueOf(i - weekDay + 1));
                    jLabel.setFont(new Font("SimHei", Font.BOLD, 15));
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                    if ((year==yearNow)&&(month==monthNow)&&(i - weekDay + 1==dayNow)){
                        System.out.println("今天");
                        jLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    }
                    body.add(jLabel);
                    body.revalidate();
                } else {
                    JLabel jLabel = new JLabel("");
                    jLabel.setHorizontalAlignment(JLabel.CENTER);
                    jLabel.setFont(new Font("SimHei", Font.BOLD, 15));
                    body.add(jLabel);
                    body.revalidate();
                }
            }
            if (year > 0 && year <= 9999) {
                foot.removeAll();
                foot.repaint();
                JLabel show = new JLabel(year + "年" + month + "月");
                show.setFont(new Font("SimHei", Font.BOLD, 20));
                JButton addJButton = new JButton("Add");
                addJButton.setForeground(new Color(245,245,245));
                addJButton.setBackground(new Color(62, 78, 123));
                addJButton.setPreferredSize(new Dimension(50,35));
                addJButton.setBorder(null);
                addJButton.setLayout(new FlowLayout((FlowLayout.RIGHT)));
                foot.add(addJButton);
                addJButton.addActionListener(this);
                foot.add(show);//将标签添加到南部容器
                foot.revalidate();
            }


        }catch (ParseException e){
            System.out.println("日期异常亦已被捕获，进程正常！");
        }
    }

    /*public static void main(String[] args){//主方法
        JFrame jFrame=new MyCalendar();
        jFrame.setVisible(true);
    }*/



    public void MenuInit() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveAction = new JMenuItem("Save");
        JMenuItem listAction = new JMenuItem("List");
        fileMenu.add(saveAction);
        fileMenu.add(listAction);

        JMenu viewMenu = new JMenu("View");
        JMenuItem todo = new JMenuItem("Todos");
        JMenuItem note = new JMenuItem("Note");
        JMenuItem appointment = new JMenuItem("Appointment");
        JMenuItem contact = new JMenuItem("Contact");
        viewMenu.add(todo);
        viewMenu.add(note);
        viewMenu.add(appointment);
        viewMenu.add(contact);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        setJMenuBar(menuBar);
        saveAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager.Save();
                JOptionPane.showMessageDialog(rootPane,"Saved!");
            }
        });
        listAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                PIMManager.List();
            }
        });




        //TODO:实现点击事件
        todo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    System.out.println(getTodos(Login.userName));
                } catch (CustomizedException e) {
                    e.printStackTrace();
                }
            }
        });
        note.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    System.out.println(getNotes(Login.userName));
                } catch (CustomizedException e) {
                    e.printStackTrace();
                }
            }
        });
        appointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    System.out.println(getAppointments(Login.userName));
                } catch (CustomizedException e) {
                    e.printStackTrace();
                }
            }
        });
        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    System.out.println(getContacts(Login.userName));
                } catch (CustomizedException e) {
                    e.printStackTrace();
                }
            }
        });




    }






    @Override
    public PIMCollection getNotes() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getNotes(String owner) throws CustomizedException {
        file = new File(owner + ".txt");
        try {
            FileInputStream fn = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fn);
            String line = "",all = "";
            PIMCollection<PIMEntity> collection = new PIMCollection<>();
            Object obj;
            while ((obj =  ois.readObject()) != null){
                if(obj instanceof PIMNote){
                    PIMNote pp = (PIMNote) obj;
                    collection.add(pp);
                }
            }
            ois.close();
            return collection;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    @Override
    public PIMCollection getTodos() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getTodos(String owner) throws CustomizedException {
        file = new File(owner + ".txt");
        try {
            FileInputStream fn = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fn);
            String line = "",all = "";
            PIMCollection<PIMEntity> collection = new PIMCollection<>();
            Object obj;
            while ((obj=ois.readObject())!=null){
                if(obj instanceof PIMTodo){
                    PIMTodo pp = (PIMTodo) obj;
                    collection.add(pp);
                }
            }
            ois.close();
            return collection;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PIMCollection getAppointments() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAppointments(String owner) throws CustomizedException {
        file = new File(owner + ".txt");
        try {
            FileInputStream fn = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fn);
            String line = "",all = "";
            PIMCollection<PIMEntity> collection = new PIMCollection<>();
            Object obj;
            while ((obj=ois.readObject())!=null){
                if(obj instanceof PIMAppointment){
                    PIMAppointment pp = (PIMAppointment) obj;
                    collection.add(pp);
                }
            }
            ois.close();
            return collection;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PIMCollection getContacts() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getContacts(String owner) throws CustomizedException {
        file = new File(owner + ".txt");
        try {
            FileInputStream fn = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fn);
            String line = "",all = "";
            PIMCollection<PIMEntity> collection = new PIMCollection<>();
            Object obj;
            while ((obj = ois.readObject())!=null){
                if(obj instanceof PIMContact){
                    PIMContact pp = (PIMContact) obj;
                    collection.add(pp);
                }
            }
            ois.close();
            return collection;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PIMCollection getItemsForDate(Date d) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getItemsForDate(Date d, String owner) throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAll() throws CustomizedException {
        return null;
    }

    @Override
    public PIMCollection getAllByOwner(String owner) throws CustomizedException {
        return null;
    }

    @Override
    public boolean add(PIMEntity pimEntity) throws CustomizedException {
        return false;
    }

}




