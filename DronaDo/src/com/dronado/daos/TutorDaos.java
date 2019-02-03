package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Tutor;
import com.dronado.utilities.ConnectionPool;

public class TutorDaos {
	
	public int insert(Tutor t) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		int tuid = -1;
		try {
			String sql1 = "insert into user (username ,password,usertype) values(?,?,?)";
			PreparedStatement pd =c.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			pd.setString(1, t.getUsername());
			pd.setString(2, t.getPassword());
			pd.setString(3, t.getUserType());
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if(rs.next()) {
				t.setUId(rs.getInt(1));
			}
			String sql2 = "insert into tutor (tuFullName,tuEmail ,tuPhoneNo,tuAddress,qualification,tuAddressId,uid) values(?,?,?,?,?,?,?)";
			pd = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			pd.setString(1, t.getTuFullName());
			pd.setString(2, t.getTuEmail());
			pd.setString(3, t.getTuPhoneNo());
			pd.setString(4, t.getTuAddress());
			pd.setString(5, t.getQualification());
			pd.setInt(6, t.getTuAddressId());
			pd.setInt(7, t.getUId());
			pd.executeUpdate();
			 rs = pd.getGeneratedKeys();
			if(rs.next()) {
			tuid = rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in TutorDaos.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return tuid;
	}
	public void edit(Tutor t) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "update tutor set tuFullName =?,tuEmail  =?,tuPhoneNo =?,tuAddress =?,qualification =?,tuAddressId =? where tuid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setString(1, t.getTuFullName());
			pd.setString(2, t.getTuEmail());
			pd.setString(3, t.getTuPhoneNo());
			pd.setString(4, t.getTuAddress());
			pd.setString(5, t.getQualification());
			pd.setInt(6, t.getTuAddressId());
			pd.setInt(7, t.getTuId());
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in TutorDaos.edit" +e);
		}finally {
			cp.putConnection(c);
		}
	}
	public void remove(Tutor t) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "delete from Tutor where tuid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, t.getTuId());
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in TutorDaos.remove" +e);
		}finally {
			cp.putConnection(c);
		}
	}
	public ArrayList<Tutor> findByAddressId(int tuId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList <Tutor> array = new ArrayList<>();
		UserDaos ud = new UserDaos();
		try {
			String sql = "select * from Tutor where tuaddressid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, tuId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				Tutor t = new Tutor(rs.getInt("tuId"), rs.getInt("uid"), rs.getString("tuFullName"), rs.getString("tuEmail"), rs.getString("tuPhoneNo"), rs.getString("tuAddress"), rs.getString("qualification"), rs.getInt("tuAddressId"));
				t.setUsername(ud.getUsernameByUId(t.getUId()));
			
				t.setUserType("tutor");
				array.add(t);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in TutorDaos.findByAddressId" +e);
		}finally {
			cp.putConnection(c);
		}
		return array;
	}
	
	public Tutor findByTuId(int tuId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Tutor t = null;
		UserDaos ud = new UserDaos();
		try {
			String sql = "select * from Tutor where tuid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, tuId);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				t = new Tutor(rs.getString("tuFullName"), rs.getString("tuEmail"), rs.getString("tuPhoneNo"), rs.getString("tuAddress"), rs.getString("qualification"), rs.getInt("tuAddressId"));
				t.setUId(rs.getInt("uid"));
				t.setTuId(rs.getInt("tuid"));
				t.setUsername(ud.getUsernameByUId(t.getUId()));
				
				t.setUserType("tutor");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in TutorDaos.findByTuId" +e);
		}finally {
			cp.putConnection(c);
		}
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TutorDaos td = new TutorDaos();
		for (Tutor t : td.findByAddressId(1)) {
			System.out.println(t);
		}
	//System.out.println(td.insert(t));
	}

}
