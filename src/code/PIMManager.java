/*
 * Copyright (c) 2020.
 * projectName:FinalHomework
 * fileName:PIMManager.java
 * Date:2020/6/27 下午8:44
 * Author: Zan Zhao
 */

/*
	项目说明：该项目在PIMCmd基础上进行更改，PIMManager部分并未做大的更改，仅仅增加了GUI部分
	下一步目标：
	1.实现基于Swing的日历
	2.本地文件实现账号密码
	3.编写完善CustomizedException类
	4.编写完善PIMCollection类
 */

package code;

import Account.LocalSave;
import Account.Login;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import sun.security.x509.OIDMap;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PIMManager {
	//save function
	public static File file;

	public static PIMCollection<PIMEntity> EntityList = new PIMCollection<>();

	public static void Save() {
		file = new File(Login.userName + ".txt");
		boolean isExist = false;//定义一个用来判断文件是否需要截掉头aced 0005的
		long pos = 0;

		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileReader fr = new FileReader(file);
			if(file.exists() && (fr.read() != -1)){
				isExist = true;
			}
			FileOutputStream fn = new FileOutputStream(file,true);
			ObjectOutputStream oos = new ObjectOutputStream(fn);

			if(isExist){
				pos = fn.getChannel().position() - 4;

				fn.getChannel().truncate(pos);
				System.out.println("追加成功~");
			}

			for (PIMEntity p : EntityList) {
				oos.writeObject(p);
			}
			oos.close();fn.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}




//		try {
//			FileOutputStream fn = new FileOutputStream(file,true);
//			ObjectOutputStream oos = new ObjectOutputStream(fn);
////			long pos = 0;
//			for (PIMEntity p : EntityList) {
//				oos.writeObject(p);
//			}
//			oos.writeObject(null);
//			oos.flush();
//			oos.close();
//		} catch (IOException ioException) {
//			ioException.printStackTrace();
//		}
	}

	public static void List(){
		file = new File(Login.userName + ".txt");
		try {
			JFrame listFrame = new JFrame("Items");
			JTextArea text = new JTextArea(10, 10);
			text.setFont(new Font("Monospace", Font.BOLD, 25));
			text.setBackground(Color.lightGray);
			text.setEditable(false);
			listFrame.add(new JScrollPane(text), BorderLayout.CENTER);
			listFrame.setVisible(true);
			listFrame.setBounds(200,200,800,500);

			PIMCollection<PIMEntity> list = new PIMCollection<>();
			FileInputStream fn = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fn);
			String all = "";
			while (fn.available() > 0){
				list.add((PIMEntity) ois.readObject());
			}
			for (PIMEntity p : list) {
				all = all + p + "\n";
			}
			text.setText(all);

//			String all = "";
//			FileInputStream fn = new FileInputStream(file);
//			ObjectInputStream ois = new ObjectInputStream(fn);
//			Object obj;
//			while ((obj =  ois.readObject()) != null){
//				PIMEntity pp = (PIMEntity) obj;
//				all = all + pp.toString() + "\n";
//			}
//
//			text.setText(all);
//			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		Here are the start of new operations:
	 	*/
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Login pimLogin = new Login();
			}
		});
		/*
			end
		 */
	}
}