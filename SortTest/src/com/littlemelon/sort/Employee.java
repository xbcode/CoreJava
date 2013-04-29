package com.littlemelon.sort;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int age;
	private long salary;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Employee(int id,String name, int age, long salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	@Override
	public int compareTo(Employee e) {
		// TODO Auto-generated method stub
		return this.id-e.id;
	}
	
	@Override
	public String toString(){
		return "(id="+this.id+", name="+name+", age="+age+", salary="+salary+")";
	}
	
	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>(){
		@Override
		public int compare(Employee e1, Employee e2){
			return (int)(e1.getSalary()-e2.getSalary());
		}
	};
	
	public static Comparator<Employee> AgeComparator=new Comparator<Employee>(){
		@Override
		public int compare(Employee e1, Employee e2){
			return e1.getAge()-e2.getAge();
		}
	};
	public static Comparator<Employee> NameComparator=new Comparator<Employee>(){
		@Override
		public int compare(Employee e1, Employee e2){
			return e1.getName().compareTo(e2.getName());
		}
	};
}
