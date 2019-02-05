package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dronado.pojos.User;
import com.dronado.utilities.ConnectionPool;

public class UserDaos {
	public int insert(User u) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		int uid = -1;
		try {
			String sql = "insert into user(username,password,usertype) values(?,?,?)";
			PreparedStatement pd = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pd.setString(1, u.getUsername());
			pd.setString(2, u.getPassword());
			pd.setString(3, u.getUserType());
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if(rs.next()) {
			uid = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in UserDaos.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return uid;
	}
	
	
	public void remove(int uid) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "delete from user where uid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, uid);
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in UserDaos.remove "+e);
		}finally {
			cp.putConnection(c);
		}
	
	}
	
	public String getUsernameByUId(int uId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String username = null;
		try {
			String sql = "select * from user where uid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, uId);
			ResultSet rs = pd.executeQuery();
			if (rs.next()) {
				username = rs.getString("username");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in UserDaos.getUsernameByUId "+e);
		}finally {
			cp.putConnection(c);
		}
		return username;
	}
	public void editPasswordByUId(int uId,String password) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql ="update user set password =? where uid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setString(1, password);
			pd.setInt(2, uId);
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in  editPasswordByUId "+e);
		}finally {
			cp.putConnection(c);
		}
	}
public String getPasswordByUId(int uId) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection c = cp.getConnection();
	String password = null;
	try {
		String sql = "select * from user where uid=?";
		PreparedStatement pd = c.prepareStatement(sql);
		pd.setInt(1, uId);
		ResultSet rs = pd.executeQuery();
		if (rs.next()) {
			password = rs.getString("Password");
		}
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in UserDaos.getPasswordByUId "+e);
	}finally {
		cp.putConnection(c);
	}
	return password;
	}

public String getUserTypeByUId(int uId) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection c = cp.getConnection();
	String userType = null;
	try {
		String sql = "select * from user where uid=?";
		PreparedStatement pd = c.prepareStatement(sql);
		pd.setInt(1, uId);
		ResultSet rs = pd.executeQuery();
		if (rs.next()) {
			userType = rs.getString("userType");
		}
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in UserDaos.getPasswordByUId "+e);
	}finally {
		cp.putConnection(c);
	}
	return userType;
	}

public String getPasswordByUsername(String username) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection c = cp.getConnection();
	String password = null;
	try {
		String sql = "select * from user where username=?";
		PreparedStatement pd = c.prepareStatement(sql);
		pd.setString(1, username);
		ResultSet rs = pd.executeQuery();
		if (rs.next()) {
			password = rs.getString("Password");
		}
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in UserDaos. getPasswordByUsername "+e);
	}finally {
		cp.putConnection(c);
	}
	return password;
	}
public int validUser(String username, String password) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection c = cp.getConnection();
	int uId =-1;
	String pass ;
	try {
		String sql = "select * from user where username=?";
		PreparedStatement pd = c.prepareStatement(sql);
		pd.setString(1, username);
		ResultSet rs = pd.executeQuery();
		if (rs.next()) {
			pass = rs.getString("Password");
			if(pass.compareTo(password)==0) {
			uId = rs.getInt("uId");	
			}
		}
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in UserDaos. getPasswordByUsername "+e);
	}finally {
		cp.putConnection(c);
	}
	return uId;
}
public static void main(String[] args) {
		UserDaos ud = new UserDaos();
		System.out.println(ud.validUser("jaya", "jay2a"));
	}
	
}
