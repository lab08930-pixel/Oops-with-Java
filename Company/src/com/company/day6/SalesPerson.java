package com.company.day6;

public class SalesPerson extends Employee {
	
	protected float commission;
	
	public float getCommission() {
		return commission;
	}
	public void setCommision(float commission) {
		if(commission>0 && commission<5)
		{
			this.commission = commission;
		}
		else
		{
			this.commission =1;
		}
		
	}
	public SalesPerson(String name, String address, int age, boolean gender, float basicSalary, float commision) {
		super(name, address, age, gender, basicSalary);
		setCommision(commision);
	}
	
	@Override
	public String display() {
		StringBuffer sb = new StringBuffer(super.display());
		sb.append(", Commision: ").append(commission);
		return sb.toString();
	}
	

	@Override
	public float totalSalary() {
		return this.basicSalary+((this.commission/100)*basicSalary);
	}

}
