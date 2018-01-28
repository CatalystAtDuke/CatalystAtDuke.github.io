package foundations;
import java.util.*;

public class RandomNumberGenerator {
    
    double[] cdf;
    
    
    private void generateCdf(double[] pmf) {
		cdf = new double[pmf.length];
		cdf[0] = pmf[0];
		for (int i = 1; i<cdf.length; i++) {
		    cdf[i] = cdf[i-1] + pmf[i];
		}
    }
    
    // consider this the black box, not really black box API for generating a random number
    private double rand() {
    	return Math.random();
    }
    
    
    /*
     * Note that this has just an if-else instead of three cases.
     * This is because with a double, you don't have to check for
     * the equality case.
     */
    public int generateNumber(double[] pmf) {
		if (cdf == null) {
		    generateCdf(pmf);
		}
		double rand = Math.random();
		int lo = 0;
		int hi = pmf.length - 1;
		while (lo < hi) {
		    int mid = (lo + hi)/2;
		    if (rand < cdf[mid]) {
		    	hi = mid;
		    } else {
		    	lo = mid + 1;
		    }
		}
		return hi;
    }
    
    public void tester(double[] pmf, int numTrials) {
    	
    }
    
    public static void main(String[] args) {
	    double[] pmf = new double[] {0.3, 0.4, 0.1, 0.2};
	    int numTrials = 10000;
	    RandomNumberGenerator rng = new RandomNumberGenerator();
	    rng.generateNumber(pmf);
	    int[] hits = new int[pmf.length];
	    for (int i = 0; i<numTrials; i++) {
	      hits[rng.generateNumber(pmf)]++;
	    }
	    System.out.println(Arrays.toString(hits));
    }
}
