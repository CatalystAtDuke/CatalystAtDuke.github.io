package foundations;

public class PeakFinding {
    
    /*
     * Note: this is different from the version posed in class.
     * This version of the problem has exactly one peak in the
     * middle of the array at some point, as opposed to having
     * possibly multiple or no peaks. As such, end points will
     * never be a correct solution.
     */
    
    
    //tester method
    public static double[] generatePeak(int index, int length) {
		assert index < length;
		double[] ret = new double[length];
		for (int i = 1; i<=index; i++) {
		    ret[i] = (ret[i-1] + 1) * 1.5;
		}
		for (int i = index + 1; i<length; i++) {
		    ret[i] = ret[i-1] * 0.9;
		}
		return ret;
    }
    
    private static boolean leftSlope(double[] heights, int i) {
		if (i == heights.length - 1) {
		    return heights[i-1] < heights[i];
		} else {
		    return heights[i] > heights[i+1];
		}
    }
    
    private static boolean isPeak(double[] heights, int i) {
		return i > -1 && i < heights.length && 
			heights[i] > heights[i-1] &&
			heights[i] > heights[i+1];
    }
    
    /* 
     * compare this code to first bad version.
     * How are the indices different? How is the
     * mid calculation method different? Compare 
     * it to the generic binary search code on the slides,
     * as well.
     */
    
    public static int findPeak(double[] heights) {
    	int lo = 0;
    	int hi = heights.length - 1;
    	while (lo < hi) {
    		int mid = (lo + hi)/2;
    		if (isPeak(heights, mid)) {
    			return mid;
			} else if (leftSlope(heights, mid)) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return hi;
	}
    
    
    public static void main(String[] args) {
		int peak = 68;
		int length = 180;
		System.out.println(findPeak(generatePeak(peak, length)));
    }
   
}
