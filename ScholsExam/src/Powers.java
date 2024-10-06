import java.lang.Math;

public class Powers {
	
	int minNumber;

	public int computePower(int x, int n) { //will compute x^n
	    
		if (n == 0) {
			return  1;
		}
		else if (n<0) {
			return computePower(1 / x, -n);
		}
	    else if (n == 1) {
	    	return  x;
	    }
	    else if (n%2 == 0) {
	    	return computePower(x * x,  n / 2);
	    }
	    else {
	    	return x * computePower(x * x, (n - 1) / 2);
	    }
	}
	
	public int findMinMultiplications(int x, int n) {
		
		
		return 0;
	}
}
