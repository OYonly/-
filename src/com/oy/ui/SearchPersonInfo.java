package com.oy.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import com.oy.dao.Dao;
import com.oy.pojo.*;

import java.io.File;

public class SearchPersonInfo {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private static String keyid;
	
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://127.0.0.1:1433;userName=sa;Password=123456;DatabaseName=library";

	public void searchPersonInfo() {//进入个人信息中心
		
		JFrame jf = new JFrame("查询个人信息");

		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		jf.setIconImage(img);

		jf.setSize(550, 350);
		jf.setLayout(null);
		jf.setLocationRelativeTo(null);

		JPanel panel1 = new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();

		jf.add(panel1);
		jf.add(panel2);
		jf.add(panel3);
		jf.add(panel4);


		panel1.setBounds(100, 70, 100, 80);// 设置面板大小
		panel2.setBounds(130, 140,80, 60);
		panel3.setBounds(230, 70, 120,50);
		panel4.setBounds(280, 140, 80,60);
	
		JLabel labnumber = new JLabel("账号： ");//标签
		Font font = new Font("宋体",Font.BOLD,20);
		labnumber.setFont(font);
		panel1.add(labnumber);
		
		JButton btn1=new JButton("查询");//退订按钮
		btn1.setFont(font);
		btn1.setPreferredSize(new Dimension(80,50));
		panel2.add(btn1);
		
		JButton btn2=new JButton("取消");//取消按钮
		btn2.setFont(font);
		btn2.setPreferredSize(new Dimension(80,50));
		panel4.add(btn2);

		JTextField userid = new JTextField(10);//用户账号文本框
		Dimension dimension = new Dimension(60,30);
		userid.setPreferredSize(dimension);
		panel3.add(userid);

		
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		final Dao user=new Dao();

		btn1.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {
					if(user.foundUser(userid.getText())==true) {
						jf.dispose();		
						keyid=userid.getText();
						
						new SearchPersonInfo().personInfo();
					}else {
						JOptionPane.showMessageDialog(null, "查询失败，没有该用户");
					}
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2) {
						jf.dispose();			
				}
			}
		});
	}
	
	public void personInfo() {
		
		JFrame jf = new JFrame("个人信息中心");
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		jf.setIconImage(img);

		jf.setSize(1200, 500);
		jf.setLayout(null);
		jf.setLocationRelativeTo(null);

		JPanel panel1 = new JPanel();//设置面板
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();
		JPanel panel5=new JPanel();
		JPanel panel6=new JPanel();
		JPanel panel7=new JPanel();
		JPanel panel8=new JPanel();
		JPanel panel9=new JPanel();
		JPanel panel10=new JPanel();
		JPanel panel11=new JPanel();
		JPanel panel12=new JPanel();
		jf.add(panel1);
		jf.add(panel2);
		jf.add(panel3);
		jf.add(panel4);
		jf.add(panel5);
		jf.add(panel6);
		jf.add(panel7);
		jf.add(panel8);
		jf.add(panel9);
		jf.add(panel10);
		jf.add(panel11);
		jf.add(panel12);

		JPanel panela=new JPanel();
		JPanel panelb=new JPanel();
		JPanel panelc=new JPanel();
		JPanel paneld=new JPanel();
		JPanel panele=new JPanel();
		JPanel panelf=new JPanel();
		JPanel panelg=new JPanel();
		JPanel panelh=new JPanel();
		JPanel paneli=new JPanel();

		jf.add(panela);
		jf.add(panelb);
		jf.add(panelc);
		jf.add(paneld);
		jf.add(panele);
		jf.add(panelf);
		jf.add(panelg);
		jf.add(panelh);
		jf.add(paneli);



		
		Dimension dimension = new Dimension(80,20);
		
		JButton btn1=new JButton("完成");//按钮
		panel2.add(btn1);
		panel2.setBounds(380, 300, 60, 40); 
		JButton btn2=new JButton("退出"); 
		panel3.add(btn2);
		panel3.setBounds(500, 300, 60, 40);
		JButton btn3=new JButton("打印"); 
		panelf.add(btn3);
		panelf.setBounds(250, 300, 60, 40);
		JButton btn4=new JButton("注销"); 
		panelg.add(btn4);
		panelg.setBounds(130, 300, 60, 40);
		
		JTextField id = new JTextField(10);//用户姓名文本框
		id.setPreferredSize(dimension);
		panele.add(id);
		panele.setBounds(950, 10, 200, 40);
		JTextField name = new JTextField(10);
		name.setPreferredSize(dimension);
		panel4.add(name);
		panel4.setBounds(950, 70, 200, 40);
		JTextField age = new JTextField(10);
		age.setPreferredSize(dimension);
		panel9.add(age);
		panel9.setBounds(950, 130, 200, 30);
		JTextField  sex= new JTextField(10);
		sex.setPreferredSize(dimension);
		panela.add(sex);
		panela.setBounds(950, 190, 200, 30);
		JTextField  phone= new JTextField(10);
		phone.setPreferredSize(dimension);
		panelb.add(phone);
		panelb.setBounds(950, 250, 200, 30);
		JTextField  email= new JTextField(10);
		email.setPreferredSize(dimension);
		panelc.add(email);
		panelc.setBounds(950, 310, 200, 30);
	
		JLabel labid = new JLabel(" 账号：");
		paneld.add(labid);
		paneld.setBounds(900, 10, 40, 30);
		
		JLabel labname = new JLabel(" 姓名：");
		panel5.add(labname);
		panel5.setBounds(900, 70, 40, 30);

		
		JLabel labage = new JLabel(" 年龄：");
		panel6.add(labage);
		panel6.setBounds(900, 130, 40, 30);
		
		JLabel labsex = new JLabel(" 性别：");
		panel7.add(labsex);
		panel7.setBounds(900, 190, 40, 30);

		JLabel labphone = new JLabel(" 电话： ");
		panel8.add(labphone);
		panel8.setBounds(900, 250, 40, 30);
		
		JLabel labemail = new JLabel(" 邮箱：");
		panel11.add(labemail);
		panel11.setBounds(900, 310, 40, 30);

		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		panel7.setOpaque(false);
		panel8.setOpaque(false);
		panel9.setOpaque(false);
		panel10.setOpaque(false);
		panel11.setOpaque(false);
		panel12.setOpaque(false);
		panela.setOpaque(false);
		panelb.setOpaque(false);
		panelc.setOpaque(false);
		paneld.setOpaque(false);
		panele.setOpaque(false);
		
		
		final Dao user=new Dao();

		try {
			Vector rowData1 = null,colName1 = null;
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery("select * from userinfo where id='"+keyid+"'");
			
				colName1=new Vector();
				colName1.add("账号");//列名
				colName1.add("姓名");
				colName1.add("年龄");
				colName1.add("性别");
				colName1.add("电话号码");
				colName1.add("邮箱");
				rs.beforeFirst();
				rowData1=new Vector();
				while(rs.next()) {
					Vector row =new Vector();
					row.add(rs.getString(1));
					row.add(rs.getString(2));
					row.add(rs.getString(3));
					row.add(rs.getString(4));
					row.add(rs.getString(5));
					row.add(rs.getString(6));
					rowData1.add(row);
				}
				JTable table=new JTable(rowData1,colName1);			
				JScrollPane scrollPane = new JScrollPane(table);

			table.setSize(700,140);
			panel12.add(scrollPane);
			panel12.setBounds(5, 30, 700, 140);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {
					user.updataUserInfo(name.getText(), age.getText(), sex.getText(), phone.getText(), email.getText(),id.getText());
					JOptionPane.showMessageDialog(null, "保存成功！");
									 
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2) {
						jf.dispose();			
				}
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.deleteUserInfo(keyid);
				JOptionPane.showMessageDialog(null, "删除成功！");
			}
		});
	}
	public void print() {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
		
		 PreparedStatement pstmt=conn.prepareStatement("select * from userinfo where id=?");
		 pstmt.setString(1, keyid);
		 ResultSet rs1=pstmt.executeQuery();
		 ArrayList<UesrInfo> list=new ArrayList<UesrInfo>();
		 while(rs1.next()) {
			 UesrInfo user=new UesrInfo();
			 user.setId(rs1.getString(1));
			 user.setName(rs1.getString(2));
			 user.setAge(rs1.getString(3));
			 user.setSex(rs1.getString(4));
			 user.setPhone(rs1.getString(5));
			 user.setEmail(rs1.getString(6));
			 list.add(user);
		 }
		 FileOutputStream fileOutputStream1=new FileOutputStream(new File("D:\\打印信息\\个人信息.txt"));
		 byte bt1[]=new byte[1024];
		 bt1= list.toString().getBytes();
		 fileOutputStream1.write(bt1);
		 fileOutputStream1.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
