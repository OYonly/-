package com.oy.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

import com.oy.dao.Dao;

public class Cancel {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://127.0.0.1:1433;userName=sa;Password=123456;DatabaseName=library";

	public void CancelSeat() {
		
		JFrame jf = new JFrame("退订座位");

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
	
		JLabel labnumber = new JLabel("   座位编号： ");//标签
		Font font = new Font("宋体",Font.BOLD,20);
		labnumber.setFont(font);
		panel1.add(labnumber);
		
		JButton btn1=new JButton("退订");//退订按钮
		btn1.setFont(font);
		btn1.setPreferredSize(new Dimension(80,50));
		panel2.add(btn1);
		
		JButton btn2=new JButton("取消");//取消按钮
		btn2.setFont(font);
		btn2.setPreferredSize(new Dimension(80,50));
		panel4.add(btn2);

		JTextField number = new JTextField(10);//座位编号文本框
		Dimension dimension = new Dimension(60,30);
		number.setPreferredSize(dimension);
		panel3.add(number);


		
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
					user.cancel(number.getText());
						JOptionPane.showMessageDialog(null, "退订成功");
						jf.dispose();			
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
}
