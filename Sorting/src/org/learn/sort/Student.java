package org.learn.sort;

public class Student implements Comparable<Student>{
	public Integer registartionID;
	public String name;
	public String address;
	public Integer grade;
	
	public Student(Integer registartionID, String name, String address, Integer grade){
		this.registartionID = registartionID;
		this.name = name;
		this.address = address;
		this.grade = grade;
	}
	
	public int getRegistartionID() {
		return registartionID;
	}
	public void setRegistartionID(int registartionID) {
		this.registartionID = registartionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.getGrade()>o.getGrade())
			return 1;
		else if (this.getGrade()<o.getGrade())
			return -1;
		else return 0;
	}
}
