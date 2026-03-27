
class Rectangle1 {
	 int length;
	int breadth;

	Rectangle1(int length, int breadth) {

		setLength(length);
		setBreadth(breadth);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length > 0 && length < 100) {
			this.length = length;
		} else {
			System.out.println("Invalid");
		}

	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		if (breadth > 0 && breadth < 100) {
			this.breadth = breadth;
		} else {
			System.out.println("Invalid");
		}
	}

	void area() {
		System.out.println("Area = " + (this.length * this.breadth));
	}

	void perimeter() {
		System.out.println("Perimeter = " + (2 * (this.length + this.breadth)));
	}
}

class Square extends Rectangle1 {
	Square(int side) {
		super(side, side);
	}
}

public class Rectangle {
	public static void main(String[] args) {
		Rectangle1 r = new Rectangle1(5, 6);
		r.area();
		r.perimeter();

		Square s = new Square(4);
		s.area();
		s.perimeter();
	}
}
