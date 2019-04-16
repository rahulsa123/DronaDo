package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Subject;
import com.dronado.utilities.ConnectionPool;

public class SubjectDaos {

	public int insert(Subject s) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		int id=0;
		try {
			String sql = "INSERT INTO subject(sname,sstandard,sstream) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, s.getSName());
			ps.setString(2, s.getSStandard());
			ps.setString(3, s.getSStream());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return id;
	}
	public int checkExistance (String sName,String sStream, String sStandard) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		int sid = -1;
		try {
			String sql = "SELECT sid FROM subject WHERE sname = ? AND sstream = ? AND sstandard = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sName);
			ps.setString(2, sStream);
			ps.setString(3, sStandard);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				sid = rs.getInt("sid");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		
		return sid;
	}
	public ArrayList<Subject> getSubjectsByStream(String stream) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		ArrayList<Subject> subList = new ArrayList<Subject>();
		try {
			String sql = "SELECT * FROM subject WHERE sstream=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,stream);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Subject sub = new Subject();
				sub.setSId(rs.getInt("sid"));
				sub.setSName(rs.getString("sname"));
				sub.setSStandard(rs.getString("sstandard"));
				sub.setSStream(rs.getString("sstream"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}

	public ArrayList<Subject> getSubjectsByStandard(String standard) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		ArrayList<Subject> subList = new ArrayList<Subject>();
		try {
			String sql = "SELECT * FROM subject WHERE sstandard=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,standard);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Subject sub = new Subject();
				sub.setSId(rs.getInt("sid"));
				sub.setSName(rs.getString("sname"));
				sub.setSStandard(rs.getString("sstandard"));
				sub.setSStream(rs.getString("sstream"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}	
	
	public ArrayList<Subject> getSubjectsByName(String sname) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		ArrayList<Subject> subList = new ArrayList<Subject>();
		try {
			String sql = "SELECT * FROM subject WHERE sname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,sname);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Subject sub = new Subject();
				sub.setSId(rs.getInt("sid"));
				sub.setSName(rs.getString("sname"));
				sub.setSStandard(rs.getString("sstandard"));
				sub.setSStream(rs.getString("sstream"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}
	
	public String getSubjects() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		String subList = "";
		try {
			String sql = "SELECT sname FROM subject;";
			Statement ps = conn.createStatement();
			ResultSet rs =ps.executeQuery(sql);
			while(rs.next()) {
				subList += ",\""+rs.getString("sname")+"\"";
			}
			subList = subList.substring(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}
	
	public String getAllInSubjectsFromUid(int uid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		String subList = "";
		try {
			for(int i:new TutorDaos().getTuSubjects(uid)) {
				String sql = "SELECT sname,sstandard,stream FROM subject WHERE sid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, i);
				ResultSet rs =ps.executeQuery(sql);
				if(rs.next()) {
					subList += ",\""+rs.getString("sname")+" & "+rs.getString("sstandard")+" & "+rs.getString("sstream")+"\"";
				}
			}
			subList = subList.substring(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}
	public String getAllInSubjectsFromTuid(int tuid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		String subList = "";
		try {
			for(int i:new TutorDaos().getTuSubjectsByTuid(tuid)) {
				String sql = "SELECT sname,sstandard,sstream FROM subject WHERE sid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, i);
				ResultSet rs =ps.executeQuery();
				if(rs.next()) {
					subList += ",\""+rs.getString("sname")+" & "+rs.getString("sstandard")+" & "+rs.getString("sstream")+"\"";
				}
			}
			subList = subList.substring(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return subList;
	}
	public String getStreams() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		String streamList = "";
		try {
			String sql = "SELECT sstream FROM subject;";
			Statement ps = conn.createStatement();
			ResultSet rs =ps.executeQuery(sql);
			while(rs.next()) {
				streamList += ",\""+rs.getString("sstream")+"\"";
			}
			streamList = streamList.substring(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return streamList;
	}
	public Subject getSubjectById(int sid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		Subject sub = null;
		try {
			String sql = "SELECT * FROM subject WHERE sid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,sid);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				sub = new Subject();
				sub.setSId(rs.getInt("sid"));
				sub.setSName(rs.getString("sname"));
				sub.setSStandard(rs.getString("sstandard"));
				sub.setSStream(rs.getString("sstream"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.putConnection(conn);
		}
		return sub;
	}
	public void removeById(int sId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql ="delete from subject where sid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, sId);
			pd.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
	}
	public void edit(Subject s) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql ="update subject set sname=?, sstandard=?,sstream=?  where sid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setString(1, s.getSName());
			pd.setString(2, s.getSStandard());
			pd.setString(3, s.getSStream());
			pd.setInt(4, s.getSId());
			pd.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubjectDaos sd = new SubjectDaos();
		Subject s = sd.getSubjectById(0);
		System.out.println(s);
	}

}
