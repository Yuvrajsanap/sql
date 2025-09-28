package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.bean.User;

public class UserDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?useSSL=false", "root", "oneplus11R");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(User u) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into register(name,password,email,sex,country) values (?,?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getCountry());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int update(User u) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update register set name=?,password=?,email=?,sex=?,country=? where id=?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getCountry());
			ps.setInt(6, u.getId());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from register where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static User getRecordById(int id) {
		User u = null;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setCountry(rs.getString(6));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}

	public static List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setCountry(rs.getString(6));
				list.add(u);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
