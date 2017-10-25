package CO2017.exercise2.fnd1;

public class Process extends Object implements Runnable {

	int size;
	char ID;
	int runtime;
	String s;
	MemManager memManager;
	
	public Process(MemManager m, char i, int s, int r){
		size = s;
		ID = i;
		runtime = r;
		memManager = m;
	}
	
	public int getSize(){
		return size;
	}
	
	public char getID(){
		return ID;
		
	}
	
	public void setAddress(int a){
		
	}
	
	public int getAddress(){
		return 0;
		
	}
	
	public String toString(){
		s = ID + ":" + "U + " + size;
		return s;
	}
	
	public void run() {
		System.out.println(toString() + " waiting to run");
		System.out.println(toString() + " running");
			//memManager.allocate();
		try {
			Thread.sleep(runtime*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(toString() + " has finished");
	}
	
	

}