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
	//save the 100 operation
	public static File file;

	public static PIMCollection<PIMEntity> EntityList = new PIMCollection<>();
//	public static File file = new File("items.txt");

	public static void Save() {
		file = new File(Login.userName + ".txt");
		boolean isExist = false;//定义一个用来判断文件是否需要截掉头aced 0005的
		long pos = 0;
		if(file.exists()){
			isExist = true;
		}
		try {
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


//		File file = new File("itemOf" + ".txt");

		/*
			end
		 */



		/*
		old version
		 */

//		Scanner in = new Scanner(System.in); //����Scanner����
//		System.out.println("Welcome to PIM.");
//		String command = null;
//		BufferedWriter bw0;

//		while (!"Quit".equals(command)) {
//
//			int k = 1;
//			System.out.println("---Enter a command (supported commands are List Create Save Load Quit)---");
//			command = in.nextLine(); //��ȡ�����һ���ַ���
//			switch (command) {
//				case "List":
//					System.out.println("There are " + operate.size() + " items.");
//					if(operate.size() > 0)
//						for(String s:operate) {
//							System.out.println("Item "+ k + ": " + s);
//							k++;
//						}
//					break;
//				case "Create":
//					System.out.println("Enter an item type ( todo, note, contact or appointment )");
//					String subcmd = in.nextLine();
//					switch (subcmd) {
//						case "todo":
//							PIMTodo todo = new PIMTodo();
//							// input date(String format), then turn it into Date format
//							System.out.println("Enter date for todo item: ");
//							BufferedReader brInTodo1 = new BufferedReader(new InputStreamReader(System.in));
//							String dt;
//							try {
//								dt = brInTodo1.readLine();
//								todo.fromString(dt);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							// input specific content
//							System.out.println("Enter todo text:");
//							BufferedReader brInTodo2 = new BufferedReader(new InputStreamReader(System.in));
//							String ct;
//							try {
//								ct = brInTodo2.readLine();
//								todo.setContent(ct);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							// input priority
//							System.out.println("Enter todo priority:");
//							System.out.println("AVAILABLE: ex-urgent , urgent , normal, unrestricted");
//
//							BufferedReader brInTodo3 = new BufferedReader(new InputStreamReader(System.in));
//							String pr;
//							try {
//								pr = brInTodo3.readLine();
//								todo.setPriority(pr);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							String opt = todo.toString();
//							operate.add(opt);
//							break;
//						case "note":
//							PIMNote note = new PIMNote();
//							// input specific content
//							System.out.println("Enter note text:");
//							BufferedReader brInNote1 = new BufferedReader(new InputStreamReader(System.in));
//							String ct1;
//							try {
//								ct1 = brInNote1.readLine();
//								note.setContent(ct1);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							// input priority
//							System.out.println("Enter note priority:");
//							System.out.println("AVAILABLE: ex-urgent , urgent , normal, unrestricted");
//							String pr1;
//							BufferedReader brInNote2 = new BufferedReader(new InputStreamReader(System.in));
//							try {
//								pr1 = brInNote2.readLine();
//								note.setPriority(pr1);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							String opt1 = note.toString();
//							operate.add(opt1);
//							break;
//						case "appointment":
//							PIMAppointment appointment = new PIMAppointment();
//							// input date(String format), then turn it into Date format
//							System.out.println("Enter date for appointment item: ");
//							BufferedReader brInAp1 = new BufferedReader(new InputStreamReader(System.in));
//							String dt1;
//							try {
//								dt1 = brInAp1.readLine();
//								appointment.fromString(dt1);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							// input specific content
//							System.out.println("Enter appointment text:");
//							BufferedReader brInAp2 = new BufferedReader(new InputStreamReader(System.in));
//							String ct2;
//							try {
//								ct2 = brInAp2.readLine();
//								appointment.setContent(ct2);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							// input priority
//							System.out.println("Enter appointment priority:");
//							System.out.println("AVAILABLE: ex-urgent , urgent , normal, unrestricted");
//							BufferedReader brInAp3 = new BufferedReader(new InputStreamReader(System.in));
//							String pr2;
//							try {
//								pr2 = brInAp3.readLine();
//								appointment.setPriority(pr2);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//							String opt2 = appointment.toString();
//							operate.add(opt2);
//							break;
//						case "contact":
//							PIMContact contact = new PIMContact();
//							// input priority
//							System.out.println("Enter contact priority:");
//							System.out.println("AVAILABLE: ex-urgent , urgent , normal, unrestricted");
////							String pr3 = in.nextLine();
//							BufferedReader brIncontact1 = new BufferedReader(new InputStreamReader(System.in));
//							BufferedReader brIncontact2 = new BufferedReader(new InputStreamReader(System.in));
//							BufferedReader brIncontact3 = new BufferedReader(new InputStreamReader(System.in));
//							BufferedReader brIncontact4 = new BufferedReader(new InputStreamReader(System.in));
//
//							String pr3,firn,famn,ea;
//							try {
//								pr3 = brIncontact1.readLine();
//								System.out.println("Enter contact firstname:");
//								firn = brIncontact2.readLine();
//								System.out.println("Enter contact familyname:");
//								famn = brIncontact3.readLine();
//								System.out.println("Enter contact email address:");
//								ea = brIncontact4.readLine();
//								// initialize new PIMContact
//								contact.set(pr3, firn, famn, ea);
//
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//
//
//
//							String opt3 = contact.toString();
//							operate.add(opt3);
//							break;
//						default:
//							System.out.println("Invalid Command! ");
//							break;
//					}
//					break;
//				case "Save":
//					try {
//						BufferedWriter bw1 = new BufferedWriter(new FileWriter(file));
//						for(String s: operate) {
//							bw1.write(s);
//							bw1.newLine();
//							bw1.flush();
//						}
//						bw1.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("Items have been saved.");
//					break;
//				case "Load":
//
//					String text = null;
//					try {
//						BufferedReader brs = new BufferedReader(
//								new InputStreamReader(new FileInputStream(file)));
//						while ((text = brs.readLine()) != null) {
//							System.out.println(text);
//						}
//
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//
//
//				case "Quit":
//					break;
//				default:
//					System.out.println("Invalid Command! ");
//					break;
//			}
//
//		}
//		in.close();
	}
}