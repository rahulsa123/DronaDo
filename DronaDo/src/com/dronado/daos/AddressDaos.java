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

public class AddressDaos {
	public int insert(Address a) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		int addressid =-1;
		try {
			String sql = " insert into address( latitude, longitude) values(?,?)";
			PreparedStatement pd = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pd.setFloat(1, a.getLatitude());
			pd.setFloat(2, a.getLongitude());
			pd.executeUpdate();
			ResultSet rs = pd.getGeneratedKeys();
			if(rs.next()) {
				addressid = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("Error in AddressDaos.insert "+e);
		}finally {
			cp.putConnection(c);
		}
		return addressid;
	}
	public void removeById( int addressid) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		try {
			String sql = " delete from address where addressid =?";
			PreparedStatement pd = c.prepareStatement( sql );
			pd.setInt(1, addressid);
			pd.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error in AddressDaos.remove "+e);
		}finally {
			cp.putConnection(c);
		}
	}
	public void edit( Address a) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		try {
			String sql = " update address  set latitude = ?, longitude = ? where addressid = ?";
			PreparedStatement pd = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pd.setFloat(1, a.getLatitude());
			pd.setFloat(2, a.getLongitude());
			pd.setInt(3, a.getAddressId());
			pd.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error in AddressDaos.edit "+e);
		}finally {
			cp.putConnection(c);
		}
	}
	public Address findByAddressId(int addressid) {
		ConnectionPool cp =  ConnectionPool.getInstance();
		Connection c  =  cp.getConnection();
		Address a = new Address();
		
		try {
			String sql = " select latitude, longitude from address where addressid =?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setFloat(1, addressid);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				a.setAddressId(addressid);
				a.setLatitude(rs.getFloat("latitude"));
				a.setLongitude(rs.getFloat("longitude"));
			}
		}catch (Exception e) {
			System.out.println("Error in AddressDaos.findByAddressid "+e);
		}finally {
			cp.putConnection(c);
		}
		return a;
	}
	public float[] findLatitudeAndLongitude( int addressid ){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		float[] ref = new float[2];	
		try {
			String sql = "Select latitude, longitude from address where addressid=?";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setInt(1, addressid);
			ResultSet rs = pd.executeQuery();
			if(rs.next()) {
				ref[0]=rs.getFloat("latitude");
				ref[1]=rs.getFloat("longitude");
			}
		}catch(Exception e) {
			System.out.println("Error in address.findLatitudeAndLongitude "+e);
		}finally {
			cp.putConnection(c);
		}
		return ref;
	}
	public ArrayList<Tutor> findAllNearTutor(Student s, float area){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		AddressDaos ad = new AddressDaos();
		TutorDaos td = new TutorDaos(); 
		ArrayList<Tutor> array = new ArrayList<Tutor>();
		try {
			int addressId = s.getStudAddressId();
			float [] ref = ad.findLatitudeAndLongitude(addressId);// size of array is two ref[0]=latitude and ref[1] =longitude
			String sql ="Select addressid from address where latitude > ? and latitude < ? and longitude > ? and longitude < ?";
			PreparedStatement pd =c.prepareStatement(sql);
			pd.setFloat(1, ref[0]-area);
			pd.setFloat(2, ref[0]+area);
			pd.setFloat(3, ref[1]-area);
			pd.setFloat(4, ref[1]+area);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				array.addAll(td.findByAddressId(rs.getInt("addressid")));
			}
		}catch(Exception e) {
			
		}finally {
			cp.putConnection(c);
		}
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressDaos ad = new AddressDaos();
//		Address a = new Address(-80.99f, 76.98f);
//		ad.insert(a);
	Student s = new Student();
//		s.setStudAddressId(1);
		for (Tutor t : ad.findAllNearTutor(s, 5.0f)) {
			System.out.println(t);
		}
		System.out.println("rahul");
		//a.setAddressId(1);
//		ad.edit(a);
		//System.out.println(ad.findByAddressId(2));
	}

}
