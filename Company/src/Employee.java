public abstract class Employee {
	protected String name;
	protected String address;
	protected int age;
	protected boolean gender;
	protected float basicSalary;

	public Employee(String name, String address, int age, boolean gender, float basicSalary)

	{
		super();
		setName(name);
		setAddress(address);
		setAge(age);
		setGender(gender);
		setBasicSalary(basicSalary);
	}
	
	public String display() {
	    StringBuffer sb = new StringBuffer();
	    sb.append("Name: ").append(name);
	    sb.append(", Gender: ").append(gender ? "Male" : "Female"); // Make boolean readable
	    sb.append(", Address: ").append(address);
	    sb.append(", Age: ").append(age);
	    sb.append(", Basic Salary: ").append(basicSalary);
	    return sb.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() > 3 || name.equals("")) {
			this.name = name;
		} else {
			name = "Default";
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 5 || address.equals("")) {
			this.address = address;
		} else {
			this.address = "Default Address";
		}

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 18 && age <= 60) {
			this.age = age;
		}

	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {

		this.gender = gender;

	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		if (basicSalary > 5000) {

			this.basicSalary = basicSalary;
		} else {
			this.basicSalary = 5000;
		}
	}
	
	public abstract float totalSalary();


}
