package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Address;
import com.dronado.pojos.Notification;
import com.dronado.utilities.ConnectionPool;
import com.dronado.utilities.DateUtils;

public class NotificationDaos {
	public int insert(Notification n) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		int nid =-1;
		try {
			String sql = " insert into notification(date,sender,receiver,message,type) values(?,?,?,?,?)";
			PreparedStatement pd = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pd.setDate(1, DateUtils.convertUtilToSql(n.getDate()));
			pd.setInt(2, n.getSender());
			pd.setInt(3, n.getReceiver());
			pd.setString(4, n.getMessage());
			pd.setString(5, n.getType());
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if(rs.next()) {
				nid = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return nid;
	}
	
	public void remove(int ni) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		try {
			String sql = " DELETE FROM notification WHERE nid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, ni);
			pd.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.Remove "+e);
		}finally {
			cp.putConnection(c);
		}
	}
	
	public void edit( Notification n) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		try {
			String sql = " update notification set date=?,sender=?,receiver=?,message=?,type=? where nid = ?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setDate(1, DateUtils.convertUtilToSql(n.getDate()));
			pd.setInt(2, n.getSender());
			pd.setInt(3, n.getReceiver());
			pd.setString(4, n.getMessage());
			pd.setString(5, n.getType());
			pd.setInt(6, n.getnId());
			pd.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.edit "+e);
		}finally {
			cp.putConnection(c);
		}
	}
	
	public ArrayList<Integer> getReceiversBySenderId(int senId){
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		try {
			String sql = " select distinct receiver from notification where sender =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, senId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				aList.add(rs.getInt("receiver"));
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.getReceiversBySenderId "+e);
		}finally {
			cp.putConnection(c);
		}
		return aList;
	}
	
	
	public Notification findByNotificationId(int nid) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		Notification a = new Notification();
		
		try {
			String sql = " select * from notification where nid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, nid);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				a.setnId(nid);
				a.setDate(DateUtils.convertSqlToUtil(rs.getDate("date")));
				a.setMessage(rs.getString("message"));
				a.setReceiver(rs.getInt("receiver"));
				a.setSender(rs.getInt("sender"));
				a.setType(rs.getString("type"));
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.findByNotificationid "+e);
		}finally {
			cp.putConnection(c);
		}
		return a;
	}
	
	public ArrayList<Notification> findByReceiverId(int recId) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		ArrayList<Notification> aList = new ArrayList<Notification>();
		
		try {
			String sql = " select * from notification where receiver =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, recId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				Notification a = new Notification();
				a.setnId(rs.getInt("nid"));
				a.setDate(DateUtils.convertSqlToUtil(rs.getDate("date")));
				a.setMessage(rs.getString("message"));
				a.setReceiver(rs.getInt("receiver"));
				a.setSender(rs.getInt("sender"));
				a.setType(rs.getString("type"));
				aList.add(a);
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.findByReceiverId "+e);
		}finally {
			cp.putConnection(c);
		}
		return aList;
	}
	
	public ArrayList<Notification> findBySenderOrReceiverUId(int uId) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		ArrayList<Notification> aList = new ArrayList<Notification>();
		
		try {
			String sql = " select * from notification where receiver =? or sender=? order by nid desc";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, uId);
			pd.setInt(2, uId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				Notification a = new Notification();
				a.setnId(rs.getInt("nid"));
				a.setDate(DateUtils.convertSqlToUtil(rs.getDate("date")));
				a.setMessage(rs.getString("message"));
				a.setReceiver(rs.getInt("receiver"));
				a.setSender(rs.getInt("sender"));
				a.setType(rs.getString("type"));
				aList.add(a);
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.findByReceiverId "+e);
		}finally {
			cp.putConnection(c);
		}
		return aList;
	}
	public ArrayList<Notification> findBySenderId(int senId) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		ArrayList<Notification> aList = new ArrayList<Notification>();
		
		try {
			String sql = " select * from notification where sender =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, senId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				Notification a = new Notification();
				a.setnId(rs.getInt("nid"));
				a.setDate(DateUtils.convertSqlToUtil(rs.getDate("date")));
				a.setMessage(rs.getString("message"));
				a.setReceiver(rs.getInt("receiver"));
				a.setSender(rs.getInt("sender"));
				a.setType(rs.getString("type"));
				aList.add(a);
			}
		}catch (Exception e) {
			System.out.println("Error in NotificationDaos.findBySenderId "+e);
		}finally {
			cp.putConnection(c);
		}
		return aList;
	}
}
