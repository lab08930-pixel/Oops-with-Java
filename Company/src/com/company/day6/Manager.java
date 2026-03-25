package com.company.day6;

public class Manager extends Employee {

	protected float hra;

	public Manager(String name, String address, int age, boolean gender, float basicSalary, float hra) {
		super(name, address, age, gender, basicSalary);
		setHra(hra);
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		if (hra > 500) {
			this.hra = hra;
		} else {
			this.hra = 500; // Default minimum HRA
		}

	}

	@Override
	public String display() {
		StringBuffer sb = new StringBuffer(super.display());
		sb.append(", HRA: ").append(hra);
		return sb.toString();
	}
	

	@Override
	public float totalSalary() {
		return this.basicSalary+this.hra;
	}

	

}
