package CO2017.exercise2.fnd1;

import java.util.Arrays;

public abstract class MemManager {
	
	private volatile boolean _changed;
	private volatile int _largestSpace;
	char[] _memory;
	int counter;
	
	public MemManager(int s){
		_memory = new char[s];
		for(int i = 0; i < _memory.length; i++){
			_memory[i] = '.';
		}
	}
	
	public boolean isChanged(){
		return _changed;
	}
	
	abstract int findSpace(int s);
	
	int countFreeSpacesAt(int pos){
		return pos;
	}
	
	public void allocate(Process p) throws InterruptedException{
		findSpace(p.getSize());
		for(int i = 0; i < _memory.length; i++){
			_memory[i] = p.getID();
		}
	}
	
	public void free(Process p){
		
	}
	
	public String toString(){
		for (int i = 0; i < _memory.length; i++){
			if (_memory[i] == '.')
			counter++;	
		}
		return Arrays.toString(_memory) + " ls: " +counter;
	}

}