package CO2017.exercise2.fnd1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class QueueHandler extends Object implements Runnable {

	String processData;
	MemManager memManager;
	
	public QueueHandler(ThreadPoolExecutor e, MemManager m, String f){
		processData = f;
		memManager = m;
	}
	public void run() {
		String fname = processData;
	    Path fpath = Paths.get(fname);
	    try (Scanner file = new Scanner(fpath)) {
	      int delay, size, rt;
	      char pid;

	      while (file.hasNextLine()) {
	        Scanner line = new Scanner(file.nextLine());
	        line.useDelimiter(":");
	        delay = line.nextInt();
	        pid   = line.next().charAt(0);
	        size  = line.nextInt();
	        rt    = line.nextInt();
	        line.close();

	        Process p = new Process(memManager, pid, size, rt);
	        
	       p.run();
	        
	       // System.out.printf("delay: %s, ID: %c, size: %s, runtime: %s\n",
	       //                   delay, pid, size, rt );
	        
	        Thread.sleep(delay*100);

	      }
	      file.close();
	    } catch (NoSuchFileException e) {
	      System.err.println("File not found: "+fname);
	      System.exit(1);
	    } catch (IOException e) {
	      System.err.println(e);
	      System.exit(1);
	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	}
	
