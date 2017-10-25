package CO2017.exercise2.fnd1;

public class FirstFitMemManager extends MemManager  {

	int counter;
	int address;
	
	public FirstFitMemManager(int s) {
		super(s);
	}

	int findSpace(int s) {
		for(int i = 0; i < _memory.length; i++){
			if (_memory[i] == '.')
				address = i;
				break;
		}
		
		for(int i = address; i < _memory.length; i++){
			if (_memory[i] == '.'){
				counter++;
				if (_memory[i] != '.')
					break;
			}
		}
		
		if (counter < s)
			return address;
		else 
			return 0;
	}

}