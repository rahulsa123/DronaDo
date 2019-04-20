package com.dronado.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

import com.dronado.utilities.ConnectionPool;

public class AdminDaos {

	
	public ArrayList<String> getAllTableName() {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<String> tableName = new ArrayList<String>();
		try {
			String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='dronadodb'";
			PreparedStatement pd = c.prepareStatement(sql);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				tableName.add(rs.getString("TABLE_NAME"));
			}
		}catch (Exception e) {
			System.out.println("Error in Admin.getAllTableName "+e);
		}finally {
			cp.putConnection(c);
		}
		return tableName;
	}

	
	public ArrayList<String> getAllColumnNameOfTable(String tableName) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		ArrayList<String> columnName = new ArrayList<String>();
		try {
			String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS where TABLE_SCHEMA='dronadodb' and TABLE_NAME=?;";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.setString(1, tableName);
			ResultSet rs = pd.executeQuery();
			while(rs.next()) {
				columnName.add(rs.getString("COLUMN_NAME"));
			}
		}catch (Exception e) {
			System.out.println("Error in Admin.getAllTableName "+e);
		}finally {
			cp.putConnection(c);
		}
		return columnName;
	} 
	public  static HashMap<String, ArrayList<String>> getDataOfTable(String tableName,ArrayList<String> column){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		 HashMap<String, ArrayList<String>>  arrayOfdata = new  HashMap<String, ArrayList<String>> ();
		 try {
				String sql = "SELECT ";
				for(int i=0;i<column.size();i++) {
					if(i!=column.size()-1) {
						sql+=column.get(i)+",";
					}else
						sql+=column.get(i)+" ";
				}
				sql+="FROM "+tableName;
				System.out.println(sql);
				PreparedStatement pd = c.prepareStatement(sql);
				ResultSet rs = pd.executeQuery();
				ResultSetMetaData rsm = rs.getMetaData();
				int noofcol = rsm.getColumnCount();
				
				boolean first = true;
				while(rs.next()) {
					for(int i=1;i<=noofcol;i++) {
						if(first) {
							arrayOfdata.put(column.get(i-1), new ArrayList<String>());
							arrayOfdata.get(column.get(i-1)).add(rsm.getColumnClassName(i));	
							}
						if(arrayOfdata.get(column.get(i-1)).get(0).endsWith("Integer")) {
							arrayOfdata.get(column.get(i-1)).add(Integer.toString(rs.getInt(column.get(i-1))));
						}else if(arrayOfdata.get(column.get(i-1)).get(0).endsWith("Float")) {
							arrayOfdata.get(column.get(i-1)).add(Float.toString(rs.getFloat(column.get(i-1))));
						}else if(arrayOfdata.get(column.get(i-1)).get(0).endsWith("String")) {
							arrayOfdata.get(column.get(i-1)).add(rs.getString(column.get(i-1)));
						}else if(arrayOfdata.get(column.get(i-1)).get(0).endsWith("Date")) {
							arrayOfdata.get(column.get(i-1)).add((rs.getDate(column.get(i-1))).toString());
						}
						}
					first=false;
					}
			}catch (Exception e) {
				System.out.println("Error in Admin.getDataOfTable "+e);
			}finally {
				cp.putConnection(c);
			}
		 
		 
		 return arrayOfdata;
	}
	public void removeDataOfTable(String tableName,String colName,int value) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		try {
			String sql = "DELETE FROM "+tableName+" where "+colName+"="+value+";";
			PreparedStatement pd = c.prepareStatement(sql);
			pd.executeUpdate();
		}catch (Exception e) {
			System.out.println("Error in Admin.removeDataOfTable "+e);
		}finally {
			cp.putConnection(c);
		}
		
	}
	public static void main(String[] args){
		AdminDaos ad = new AdminDaos();
		 HashMap<String, ArrayList<String>>  arrayOfdata = ad.getDataOfTable("notification", ad.getAllColumnNameOfTable("notification"));
		 for(String col:arrayOfdata.keySet()) {
			 System.out.print(col+" :");
			 for(String data:arrayOfdata.get(col)) {
				 System.out.print(data+" ");
			 }
			 System.out.println();
		 }
		 
	}
 
}
