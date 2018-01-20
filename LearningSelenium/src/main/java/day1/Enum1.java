package day1;

public enum Enum1 implements InterfaceExample{
	North, South, East, West;

	public void showDirection() {
		System.out.println("Using method outside the Enum values");
	}
	
}
