package com.dronado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dronado.pojos.Assigned;
import com.dronado.pojos.Student;
import com.dronado.pojos.Teaches;
import com.dronado.pojos.Tutor;
import com.dronado.utilities.ConnectionPool;
import com.dronado.utilities.DateUtils;

public class AssignedDaos {

	public int insert(Assigned a) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		int aid = 0;
		try {
			String sql = "insert into assigned(tid,studid,dateofjoining) values(?,?,?)";
			PreparedStatement pd = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pd.setInt(1, a.gettId());
			pd.setInt(2, a.getStudId());
			pd.setDate(3, DateUtils.convertUtilToSql(a.getDateOfJoining()));
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if (rs.next()) {
				aid = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			cp.putConnection(c);
		}
		return aid;
	}

	
	
	public ArrayList<Student> findAllStudentByTid(int tid){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Student> arr = new ArrayList<Student>();
		try {
			String sql = "SELECT studid from assigned WHERE tid=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arr.add(new StudentDaos().findByStudId(rs.getInt("studid")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
		return arr;
	}
	
	public ArrayList<Teaches> findAllClassByStudentId(int studId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Teaches> array = new ArrayList<Teaches>();
		TeachesDaos sd = new TeachesDaos();
		try {
			String sql = "select tid from assigned where studid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, studId);
			ResultSet rs = pd.executeQuery();
			while (rs.next()) {
				array.add(sd.findByTId(rs.getInt("tid")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.findAllClassByStudentId" + e);
		} finally {
			cp.putConnection(c);
		}
		return array;
	}

	public ArrayList<Assigned> findAssignedDetailsByStudentId(int studId) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Assigned> aList = new ArrayList<Assigned>();
		try {
			String sql = "SELECT * FROM assigned WHERE studid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, studId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Assigned a = new Assigned();
				a.setaId(rs.getInt("aid"));
				a.setDateOfJoining(DateUtils.convertSqlToUtil(rs.getDate("dateofjoining")));
				a.setStudId(rs.getInt("studid"));
				a.settId(rs.getInt("tid"));
				aList.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
		return aList;
	}

	public ArrayList<Student> findStudentByDateRange(java.util.Date startDate, java.util.Date endDate) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Student> array = new ArrayList<Student>();
		StudentDaos sd = new StudentDaos();
		try {
			String sql = "select studid from assigned where dateofjoining BETWEEN ? and ?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setDate(1, DateUtils.convertUtilToSql(startDate));
			pd.setDate(2, DateUtils.convertUtilToSql(endDate));
			ResultSet rs = pd.executeQuery();
			while (rs.next()) {
				array.add(sd.findByStudId(rs.getInt("studid")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.findAllStudentByTuId" + e);
		} finally {
			cp.putConnection(c);
		}
		return array;
	}

	public ArrayList<Teaches> findTeachesByDateRange(java.util.Date startDate, java.util.Date endDate) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<Teaches> array = new ArrayList<Teaches>();
		TeachesDaos sd = new TeachesDaos();
		try {
			String sql = "select tid from assigned where dateofjoining BETWEEN ? and ?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setDate(1, DateUtils.convertUtilToSql(startDate));
			pd.setDate(2, DateUtils.convertUtilToSql(endDate));
			ResultSet rs = pd.executeQuery();
			while (rs.next()) {
				array.add(sd.findByTId(rs.getInt("tid")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in StudentDaos.findTeachesByDateRange" + e);
		} finally {
			cp.putConnection(c);
		}
		return array;

	}

	public Assigned getAssigned(int tid,int studid) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Assigned a = new Assigned();
		try {
			String sql = "SELECT aid FROM assigned WHERE tid =? and studid=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setInt(2, studid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a.setaId(rs.getInt("aid"));
				a.setDateOfJoining(DateUtils.convertSqlToUtil(rs.getDate("dateofjoining")));
				a.setStudId(rs.getInt("studid"));
				a.settId(rs.getInt("tid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
		return a;
	}

	
	public Assigned getAssignedById(int aid) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		Assigned a = new Assigned();
		try {
			String sql = "SELECT * FROM assigned WHERE aid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a.setaId(rs.getInt("aid"));
				a.setDateOfJoining(DateUtils.convertSqlToUtil(rs.getDate("dateofjoining")));
				a.setStudId(rs.getInt("studid"));
				a.settId(rs.getInt("tid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
		return a;
	}
	
	public void removeById(int id) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "DELETE FROM assigned WHERE aid=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
	}
	
	public void edit(Assigned a) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql="UPDATE TABLE assigned SET studid=?,tid=?,dateofjoining=? WHERE aid=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(4, a.getaId());
			ps.setInt(1,a.getStudId());
			ps.setInt(2, a.gettId());
			ps.setDate(3, DateUtils.convertUtilToSql(a.getDateOfJoining()));
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			cp.putConnection(c);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
