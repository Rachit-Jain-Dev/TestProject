package selenium;

public class AbstractClass {
	public static void main(String args[]){
		RachitRobot rac = new RachitRobot();
		testRachitRobot(rac);					//or directly - testRachitRobot(new RachitRobot());
		
		PalaniRobot pal = new PalaniRobot();
		testPalaniRobot(pal);					//or directly - testPalaniRobot(new PalaniRobot());
		
		testRobot(new RachitRobot());
		testRobot(new PalaniRobot());
	}
	public static void testRachitRobot(RachitRobot r){
		r.cook();	r.walk();	r.talk();
	}
	public static void testPalaniRobot(PalaniRobot p){
		p.cook();	p.walk();	p.talk();
	}
	public static void testRobot(Robot R){
		R.cook();	R.walk();	R.talk();
	}
}

abstract class Robot{
	public void cook(){
		System.out.println("\nRobot can cook");
	}
	abstract public void walk();
	abstract public void talk();
}

class RachitRobot extends Robot{
	public void cook(){
		System.out.println("\nRachitRobot can cook");
	}
	public void walk() {
		System.out.println("RachitRobot walks");	
	}
	public void talk() {
		System.out.println("RachitRobot talks");	
	}	
}
class PalaniRobot extends Robot{
	public void walk() {
		System.out.println("PalaniRobot walks");	
	}
	public void talk() {
		System.out.println("PalaniRobot talks");	
	}	
}