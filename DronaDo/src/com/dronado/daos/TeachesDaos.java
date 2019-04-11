package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Teaches;
import com.dronado.utilities.ConnectionPool;

public class TeachesDaos {

	public int insert(Teaches t) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		int tid = -1;
		try {
			String sql = "insert into teaches(sid,tuid,fees,duration,taddress,Experience,tAddressId) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getsId());
			ps.setInt(2, t.getTuId());
			ps.setFloat(3, t.getFees());
			ps.setString(4, t.getDuration());
			ps.setString(5,t.gettAddress());
			ps.setString(6, t.getExperience());
			ps.setInt(7, t.gettAddressId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				tid = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("Error in Teaches.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return tid;
	}
	
	public void edit(Teaches t) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "UPDATE TABLE teaches SET sid=?,tuid=?,fees=?,duration=?,taddress=?,taddressid=?,experience=? WHERE tid=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, t.getsId());
			ps.setInt(2, t.getTuId());
			ps.setFloat(3, t.getFees());
			ps.setString(4, t.getDuration());
			ps.setString(5, t.gettAddress());
			ps.setInt(6, t.gettAddressId());
			ps.setString(7, t.getExperience());
			ps.setInt(8,t.gettId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
	}
	
	public void removeById(int id) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		try {
			String sql = "DELETE FROM teaches WHERE tid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(conn);
		}
	}
	public ArrayList<Teaches> findAllByTuId(int tuId){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Teaches> tList = new ArrayList<Teaches>();
		try {
			String sql ="Select * from teaches where tuid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, tuId);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				Teaches t = new Teaches();
				t.settId(rs.getInt("tid"));
				t.setDuration(rs.getString("duration"));
				t.setExperience(rs.getString("experience"));
				t.setFees(rs.getFloat("Fees")) ;
				t.setsId(rs.getInt("sId"));
				t.settAddress(rs.getString("tAddress"));
				t.settAddressId(rs.getInt("tAddressId"));
				t.setTuId(rs.getInt("tuId"));
				tList.add(t);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Teaches.findAllByTuId");
		}finally {
			cp.putConnection(c);
		}
		return tList;
	}
	public Teaches findByTId(int tid) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Teaches t = new Teaches();
		try {
			String sql ="Select * from Teaches where tid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, tid);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				t.settId(rs.getInt("tid"));
				t.setDuration(rs.getString("duration"));
				t.setExperience(rs.getString("experience"));
				t.setFees(rs.getFloat("Fees")) ;
				t.setsId(rs.getInt("sId"));
				t.settAddress(rs.getString("tAddress"));
				t.settAddressId(rs.getInt("tAddressId"));
				t.setTuId(rs.getInt("tuId"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Teaches.findByTId");
		}finally {
			cp.putConnection(c);
		}
		return t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeachesDaos td = new TeachesDaos();
		Teaches t = new Teaches(2, 3, 2, 400.90f, " 9 month", "Tcycyc", 1, "  month");
		System.out.println(td.insert(t));
	System.out.println(td.findByTId(8));
	System.out.println("Hello");
	}

}
