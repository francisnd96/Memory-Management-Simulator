package CO2017.exercise2.fnd1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimController {
	
	public SimController(){
		
	}
	
	public void run(){
		
	}

	public static void main(String[] args){
		String policy = args[0];
		String size = args[1];
		String fileName = args[2];
		int memSize = Integer.parseInt(size);
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		
		
		
		switch(policy){
			case "f":  System.out.println("Policy: FIRST fit");
			FirstFitMemManager ffmm = new FirstFitMemManager(memSize);
			System.out.print("hello");
			QueueHandler qh = new QueueHandler(tpe, ffmm, fileName);
				break;
			case "w":  System.out.println("Policy: WORST fit");
			WorstFitMemManager wfmm = new WorstFitMemManager(memSize);
				break;
			case "b":  System.out.println("Policy: BEST fit");
			BestFitMemManager bfmm = new BestFitMemManager(memSize);
				break;
		}
		
		
		
		
	}
}
