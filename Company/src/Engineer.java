public class Engineer extends Employee {
	protected float overTime;

	

	public Engineer(String name, String address, int age, boolean gender, float basicSalary, float overTime) {
		super(name, address, age, gender, basicSalary);
		setOverTime(overTime);
	}

	public float getOverTime() {
		return overTime;
	}

	public void setOverTime(float overTime) {
		if (overTime > 1000) {
			this.overTime = overTime;
		} else {
			this.overTime = 1000;
		}
	}
	@Override
	public String display() {
		StringBuffer sb = new StringBuffer(super.display());
		sb.append(", OverTime: ").append(overTime);
		return sb.toString();
	}
	

	@Override
	public float totalSalary() {
		return this.basicSalary+this.overTime;
	}

}
