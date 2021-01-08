package com.oy.ui;

import javax.swing.*;

import com.oy.service.SearchSeat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Userpage {
	public void init() {

		JFrame jf = new JFrame("欢迎使用图书馆座位预定系统");

		// 改变窗口图标
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		jf.setIconImage(img);

		// 设置窗口大小
		jf.setSize(620, 620);

		// 设置布局为空
		jf.setLayout(null);

		// 使窗口居中
		jf.setLocationRelativeTo(null);

		// 设置窗口背景图案
		Icon i = new ImageIcon("D:\\Saved Pictures\\greenbook.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);

		// 获取当前时间
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		jf.add(panel1);
		jf.add(panel2);
		jf.add(panel3);
		jf.add(panel4);
		jf.add(panel5);
		jf.add(panel6);

		/* 添加标题：图书管理系统 */
		JLabel lable = new JLabel("欢迎使用图书馆座位预定系统");
		Font font = new Font("宋体", Font.BOLD, 25);// 设置字体
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(100, 10, 400, 400);// 设置面板大小

		JLabel tlable = new JLabel("当前时间:\n" + dateFormat.format(calendar.getTime()));
		Font font2 = new Font("宋体", Font.BOLD, 5);
		tlable.setFont(font);
		panel2.add(tlable);
		panel2.setBounds(100, 55, 400, 400);// 设置面板大小

		/* 按钮 */
		JButton btn1 = new JButton("查询座位");
		JButton btn2 = new JButton("退订座位");
		JButton btn3 = new JButton("个人座位查询");
		JButton btn4 = new JButton("个人信息中心");
		Font font3 = new Font("宋体", Font.BOLD, 25);
		btn1.setFont(font3);
		btn2.setFont(font3);
		btn3.setFont(font3);
		btn4.setFont(font3);
		Dimension dimension = new Dimension(300, 50);
		btn1.setPreferredSize(dimension);
		btn2.setPreferredSize(dimension);
		btn3.setPreferredSize(dimension);
		btn4.setPreferredSize(dimension);
		panel3.add(btn1);
		panel4.add(btn2);
		panel5.add(btn3);
		panel6.add(btn4);
		panel3.setBounds(150, 120, 300, 200);
		panel4.setBounds(150, 220, 300, 200);
		panel5.setBounds(150, 320, 300, 200);
		panel6.setBounds(150, 420, 300, 200);

		// 把组件变成透明
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);

		jf.add(jLable);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final SearchSeat seatlist=new SearchSeat();
		btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {
						seatlist.SeatList(); 
					}
			}
		});
		final Cancel cancel=new Cancel();
		btn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2) {
						cancel.CancelSeat();
					}
			}
		});
		final PersonSearch ps=new PersonSearch();
		btn3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn3) {
						ps.personSearch();
					}
			}
		});
		final SearchPersonInfo spi=new SearchPersonInfo();
		btn4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn4) {
						spi.searchPersonInfo();
					}
			}
		});
	}

	public static void main(String[] args) {
		new Userpage().init();

	}

}
