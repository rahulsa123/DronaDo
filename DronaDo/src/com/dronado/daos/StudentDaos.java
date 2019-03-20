package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Address;
import com.dronado.pojos.Student;
import com.dronado.pojos.Tutor;
import com.dronado.utilities.ConnectionPool;

public class StudentDaos {
	public int insert(Student s) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		int studid = -1;
		try {
			String sql1 = "insert into user (username ,password,usertype) values(?,?,?)";
			PreparedStatement pd =c.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			pd.setString(1, s.getUsername());
			pd.setString(2, s.getPassword());
			pd.setString(3, s.getUserType());
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if(rs.next()) {
				s.setUId(rs.getInt(1));
			}
			String sql2 = "insert into Student(studFullName, studEmail , studPhoneNo, studAddress, studAddressId,uid) values(?,?,?,?,?,?)";
			pd = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			pd.setString(1, s.getStudFullName());
			pd.setString(2, s.getStudEmail());
			pd.setString(3, s.getStudPhoneNo());
			pd.setString(4, s.getStudAddress());
			pd.setInt(5, s.getStudAddressId());
			pd.setInt(6, s.getUId());
			pd.executeUpdate();
			 rs = pd.getGeneratedKeys();
			if(rs.next()) {
			studid = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return studid;
	}
	public void edit(Student s) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "update student set studFullName =?, studEmail  =?, studPhoneNo =?, studAddress =?, studAddressId =? where studid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setString(1, s.getStudFullName());
			pd.setString(2, s.getStudEmail());
			pd.setString(3, s.getStudPhoneNo());
			pd.setString(4, s.getStudAddress());
			pd.setInt(5, s.getStudAddressId());
			pd.setInt(6, s.getStudId());
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.edit" +e);
		}finally {
			cp.putConnection(c);
		}
	}
	public void remove(Student s) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "delete from student where studid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, s.getStudId());
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.remove" +e);
		}finally {
			cp.putConnection(c);
		}
	}
	
	public Student findByStudId(int studId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Student s = null;
		UserDaos ud = new UserDaos();
		try {
			String sql = "select * from Student where studid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, studId);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				s = new Student(rs.getString("studFullName"), rs.getString("studEmail"), rs.getString("studPhoneNo"), rs.getString("studAddress"), rs.getInt("studAddressId"));
				s.setUId(rs.getInt("uid"));
				s.setStudId(rs.getInt("studid"));
				s.setUsername(ud.getUsernameByUId(s.getUId()));
				
				s.setUserType("student");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.findByStudId" +e);
		}finally {
			cp.putConnection(c);
		}
		return s;
	}
	
	public Student findByUId(int uId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Student s = null;
		UserDaos ud = new UserDaos();
		try {
			String sql = "select * from Student where uid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, uId);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				s = new Student(rs.getString("studFullName"), rs.getString("studEmail"), rs.getString("studPhoneNo"), rs.getString("studAddress"), rs.getInt("studAddressId"));
				s.setUId(rs.getInt("uid"));
				s.setStudId(rs.getInt("studid"));
				s.setUsername(ud.getUsernameByUId(s.getUId()));
				
				s.setUserType("student");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.findByStudId" +e);
		}finally {
			cp.putConnection(c);
		}
		return s;
	}
	
	public static void main(String [] args) {
		StudentDaos sd = new StudentDaos();
		AddressDaos ad = new AddressDaos();
		Student s = new Student("Rajendra", "Rajendra23100@gmail.com", "9988776655", "bhopal mp", ad.insert(new Address(27.8989f, 79.8989f)));
		s.setUsername("Rajendra200");
		s.setPassword("Rajendra");
		s.setUserType("Student");
		sd.insert(s);
	}
}
