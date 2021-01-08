package com.oy.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.oy.dao.Dao;
 
public class SignMenu{
	public void init() {
		
		JFrame f = new JFrame("欢迎使用图书馆座位预定系统");
		
		//改变窗口图标
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		f.setIconImage(img); 
		
		//设置窗口大小
		f.setSize(620, 620);
		
		//使窗口居中
		f.setLocationRelativeTo(null);
		
		//设置布局为空
		f.setLayout(null);
		
		//设置窗口背景图案
		Icon i = new ImageIcon("D:\\Saved Pictures\\greenbook.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);
	
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		
		/*添加大标题：图书管理系统*/
		JLabel lable = new JLabel("图书馆座位预定系统");
		Font font = new Font("宋体",Font.BOLD,35);//设置字体
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(120, 80, 400, 400);//设置面板大小
		f.add(panel1);
		
		
		/*账号标签*/
		Dimension dimension = new Dimension(200,30);//框框的大小
		JLabel labid = new JLabel("   账号： ");
		Font font2 = new Font("宋体",Font.BOLD,25);	
		labid.setFont(font2);
		panel2.add(labid);
		
		/*输入账户的文本框*/
		JTextField id = new JTextField(10);
		id.setPreferredSize(dimension);
		panel2.add(id);
		panel2.setBounds(90, 170, 400, 300);
		f.add(panel2);
		
		
		/*密码标签*/
		JLabel labpassword = new JLabel("   密码： ");
		Font font3 = new Font("宋体",Font.BOLD,25);
		labpassword.setFont(font3);
		panel3.add(labpassword);
		
		/*输入密码文本框*/
		JTextField password = new JTextField(10);
		password.setPreferredSize(dimension);
		panel3.add(password);
		panel3.setBounds(90, 250, 400, 300);
		f.add(panel3);
		
		
		/*注册登陆按钮*/
		JButton btnRegister = new JButton("注册");
		JButton btnLogin = new JButton("登陆");
		btnRegister.setFont(font3);
		btnLogin.setFont(font3);
		Dimension dimension2 = new Dimension(100,50);
		btnRegister.setPreferredSize(dimension2);
		btnLogin.setPreferredSize(dimension2);
		panel4.add(btnRegister);
		panel5.add(btnLogin);
		panel4.setBounds(150, 370, 150, 400);
		panel5.setBounds(330, 370, 150, 400);
		f.add(panel4);
		f.add(panel5);
		
		
         //把组件变成透明
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);

		f.add(jLable);
		
		//设置不可改变窗口大小
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Dao user=new Dao();
		btnLogin.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogin) {
					if(user.foundLogin(id.getText(),password.getText())==false)
						JOptionPane.showMessageDialog(null, "该用户不存在，请注册");
					else {
						f.dispose();
						JOptionPane.showMessageDialog(null, "登录成功");
						new Userpage().init();
					}
				}
			}
		});
		btnRegister.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRegister) {
	
					if(user.foundLogin(id.getText(),password.getText())==true) {
						JOptionPane.showMessageDialog(null, "该用户已存在，请直接登录");
					}
					else {
						user.addUser(id.getText(),password.getText());
						f.dispose();
						JOptionPane.showMessageDialog(null, "注册成功");
					}
				}
			}		
		});
	}
   public static void main(String[] args) {
	   new SignMenu().init();
   }
}

