package com.oy.service;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

import com.oy.dao.Dao;
import com.oy.frame.SignMenu;
import com.oy.frame.Userpage;

public class SearchSeat {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://127.0.0.1:1433;userName=sa;Password=123456;DatabaseName=library";

	public void SeatList() {//ͼ�����λ��ѯ
		
		JFrame jf = new JFrame("��ѯ��λ");

		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		jf.setIconImage(img);

		jf.setSize(620, 620);
		jf.setLayout(null);
		jf.setLocationRelativeTo(null);

		JPanel panel1 = new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();
		JPanel panel5=new JPanel();
		JPanel panel6=new JPanel();
		JPanel panel7=new JPanel();
		jf.add(panel1);
		jf.add(panel2);
		jf.add(panel3);
		jf.add(panel4);
		jf.add(panel5);
		jf.add(panel6);
		jf.add(panel7);
		
		panel1.setBounds(50, 10, 500, 450);// ��������С
		panel2.setBounds(340, 460, 60, 40); 
		panel3.setBounds(170, 445, 200, 40);
		panel4.setBounds(170, 475, 200, 40);
		panel5.setBounds(115, 447, 80, 30);
		panel6.setBounds(115, 477, 80, 30);
		panel7.setBounds(410, 460, 60, 40); 
		
		JTextField number = new JTextField(10);//Ԥ����λ����ı���
		Dimension dimension = new Dimension(80,20);
		number.setPreferredSize(dimension);
		panel3.add(number);
		JLabel labnumber = new JLabel("   ��λ��ţ� ");
		panel5.add(labnumber);
		JTextField userid = new JTextField(10);//Ԥ���û�id�ı���
		number.setPreferredSize(dimension);
		panel4.add(userid);
		JLabel labid = new JLabel("   �˺ţ� ");
		panel6.add(labid);
		
		JButton btn1=new JButton("Ԥ��");
		panel2.add(btn1);
		JButton btn2=new JButton("ȡ��"); 
		panel7.add(btn2);
		
		Vector rowData = null,colName = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery("select * from seat");
			int count=0;
			while(rs.next()) {
				count++;
			}
			if(count==0) {
				JOptionPane.showMessageDialog(null, "��ѯʧ��");
			}else {
				colName=new Vector();
				colName.add("��λ���");//����
				colName.add("��λ״̬");
				colName.add("Ԥ�����˺�");
				rs.beforeFirst();
				rowData=new Vector();
				while(rs.next()) {
					Vector row =new Vector();
					row.add(rs.getString(1));
					row.add(rs.getString(2));
					row.add(rs.getString(3));
					rowData.add(row);
				}
			}
			JTable table=new JTable(rowData,colName);
			
			JScrollPane scrollPane = new JScrollPane(table);
			table.setSize(200,240);
			panel1.add(scrollPane);
			panel1.setOpaque(false);//�������͸��
			panel2.setOpaque(false);
			panel3.setOpaque(false);
			panel5.setOpaque(false);
			panel6.setOpaque(false);
			panel4.setOpaque(false);
			panel7.setOpaque(false);
			
			
			jf.setResizable(false);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			final Dao user=new Dao();
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==btn1) {
						user.reserve(number.getText(),userid.getText());
							JOptionPane.showMessageDialog(null, "Ԥ���ɹ�");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
