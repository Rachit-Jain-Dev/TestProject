
public class snake extends book{
	public void sleeping(){
		System.out.println("Snake is sleeping");
	}
	@Override
	public void makingNoise() {
		System.out.println("Snake is Hissing");
	}

	@Override
	public void walking() {
		System.out.println("Snake is crawling");
	}

}
