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

		JFrame jf = new JFrame("��ӭʹ��ͼ�����λԤ��ϵͳ");

		// �ı䴰��ͼ��
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("D:\\Saved Pictures\\icon.jpg");
		jf.setIconImage(img);

		// ���ô��ڴ�С
		jf.setSize(620, 620);

		// ���ò���Ϊ��
		jf.setLayout(null);

		// ʹ���ھ���
		jf.setLocationRelativeTo(null);

		// ���ô��ڱ���ͼ��
		Icon i = new ImageIcon("D:\\Saved Pictures\\greenbook.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);

		// ��ȡ��ǰʱ��
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

		/* ��ӱ��⣺ͼ�����ϵͳ */
		JLabel lable = new JLabel("��ӭʹ��ͼ�����λԤ��ϵͳ");
		Font font = new Font("����", Font.BOLD, 25);// ��������
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(100, 10, 400, 400);// ��������С

		JLabel tlable = new JLabel("��ǰʱ��:\n" + dateFormat.format(calendar.getTime()));
		Font font2 = new Font("����", Font.BOLD, 5);
		tlable.setFont(font);
		panel2.add(tlable);
		panel2.setBounds(100, 55, 400, 400);// ��������С

		/* ��ť */
		JButton btn1 = new JButton("��ѯ��λ");
		JButton btn2 = new JButton("�˶���λ");
		JButton btn3 = new JButton("������λ��ѯ");
		JButton btn4 = new JButton("������Ϣ����");
		Font font3 = new Font("����", Font.BOLD, 25);
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

		// ��������͸��
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
