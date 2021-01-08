package com.oy.dao;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.oy.userinfo.RandomValueUtil;

public class Dao {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;


	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://127.0.0.1:1433;userName=sa;Password=123456;DatabaseName=library";// library为数据库名

	public boolean foundLogin(String id, String password) {
		boolean flag = false;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from account where id='" + id + "'  and password='" + password+"'" );
			if (rs.next())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public void addUser(String id, String password) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="insert into account(id,password) values(?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void addUserInfo(String id, String name,int age,String sex,String phone,String email) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="insert into userinfo(id,name,age,sex,phone,email) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setString(4,sex);
			pstmt.setString(5,phone);
			pstmt.setString(6,email);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void updataUserInfo( String name,String age,String sex,String phone,String email,String id) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="update userinfo set name=?,age=?,sex=?,phone=?,email=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,age);
			pstmt.setString(3,sex);
			pstmt.setString(4,phone);
			pstmt.setString(5,email);
			pstmt.setString(6,id);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void reserve( String number, String userid ) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="update seat set status=?,userid=? where number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"已预定");
			pstmt.setString(2,userid);
			pstmt.setString(3,number);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void cancel( String number) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="update seat set status=?,userid=? where number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"未预定");
			pstmt.setString(2,"无");
			pstmt.setString(3,number);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public String personSearch(String userid) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			PreparedStatement pstmt;
			String sql="select number from seat where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {		
				return rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
	public boolean foundUser(String userid) {
		boolean flag = false;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from userinfo where id='"+ userid +"'");
			if (rs.next())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
