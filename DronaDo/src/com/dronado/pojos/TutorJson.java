package com.dronado.pojos;

import java.util.ArrayList;
import java.util.List;


public class TutorJson {
 	int iTotalRecords;

	int iTotalDisplayRecords;

	String sEcho;

	String sColumns;

	ArrayList<Tutor> aaData;

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public ArrayList<Tutor> getAaData() {
		return aaData;
	}

	public void setAaData(ArrayList<Tutor> aaData) {
		this.aaData = aaData;
	}
	
	
	
}
