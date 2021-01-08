package com.oy.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.oy.dao.Dao;
 
public class SignMenu{
	public void init() {
		
		JFrame f = new JFrame("��ӭʹ��ͼ�����λԤ��ϵͳ");
		
		//�ı䴰��ͼ��
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		f.setIconImage(img); 
		
		//���ô��ڴ�С
		f.setSize(620, 620);
		
		//ʹ���ھ���
		f.setLocationRelativeTo(null);
		
		//���ò���Ϊ��
		f.setLayout(null);
		
		//���ô��ڱ���ͼ��
		Icon i = new ImageIcon("D:\\Saved Pictures\\greenbook.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);
	
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		
		/*��Ӵ���⣺ͼ�����ϵͳ*/
		JLabel lable = new JLabel("ͼ�����λԤ��ϵͳ");
		Font font = new Font("����",Font.BOLD,35);//��������
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(120, 80, 400, 400);//��������С
		f.add(panel1);
		
		
		/*�˺ű�ǩ*/
		Dimension dimension = new Dimension(200,30);//���Ĵ�С
		JLabel labid = new JLabel("   �˺ţ� ");
		Font font2 = new Font("����",Font.BOLD,25);	
		labid.setFont(font2);
		panel2.add(labid);
		
		/*�����˻����ı���*/
		JTextField id = new JTextField(10);
		id.setPreferredSize(dimension);
		panel2.add(id);
		panel2.setBounds(90, 170, 400, 300);
		f.add(panel2);
		
		
		/*�����ǩ*/
		JLabel labpassword = new JLabel("   ���룺 ");
		Font font3 = new Font("����",Font.BOLD,25);
		labpassword.setFont(font3);
		panel3.add(labpassword);
		
		/*���������ı���*/
		JTextField password = new JTextField(10);
		password.setPreferredSize(dimension);
		panel3.add(password);
		panel3.setBounds(90, 250, 400, 300);
		f.add(panel3);
		
		
		/*ע���½��ť*/
		JButton btnRegister = new JButton("ע��");
		JButton btnLogin = new JButton("��½");
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
		
		
         //��������͸��
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);

		f.add(jLable);
		
		//���ò��ɸı䴰�ڴ�С
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Dao user=new Dao();
		btnLogin.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogin) {
					if(user.foundLogin(id.getText(),password.getText())==false)
						JOptionPane.showMessageDialog(null, "���û������ڣ���ע��");
					else {
						f.dispose();
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						new Userpage().init();
					}
				}
			}
		});
		btnRegister.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRegister) {
	
					if(user.foundLogin(id.getText(),password.getText())==true) {
						JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ���ֱ�ӵ�¼");
					}
					else {
						user.addUser(id.getText(),password.getText());
						f.dispose();
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
					}
				}
			}		
		});
	}
   public static void main(String[] args) {
	   new SignMenu().init();
   }
}

