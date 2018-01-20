package selenium.Threads;

public class ThreadRunClass implements Runnable{
	Thread t;
	
	ThreadRunClass(){
		t= new Thread(this);
		System.out.println("Executing: "+t.getName());//1st
		t.start();
		
		if(!Thread.interrupted()){
			t.interrupt();
			System.out.println("Thread "+t+" is getting interrupted");//2nd
		}
		
		try{
			t.join();
			System.out.println("Thread "+t+" is blocked by join");//4th
		}catch(InterruptedException e){
		}
	}
	
	public void run(){
		try{
			while(true){
				System.out.println("Thread "+t+" is sleeping");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println(t.getName()+" interrupted");//3rd
			System.out.println(e);
		}
	}
}
