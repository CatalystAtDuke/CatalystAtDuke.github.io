package foundations;

class FirstBadVersion {

	boolean[] versions;
	
	//testing function
	public void setFirstBadVersion(int firstBad, int totalVersions) {
	    versions = new boolean[totalVersions];
	    for (int i = 0; i<firstBad; i++) {
		versions[i] = true;
	    }
	}
	
	//testing function
	public boolean isGood(int x) {
		return versions[x-1];
	}
	
	// question1: how would you improve this to reduce calls to IsGood?
	// question2: in which case would this fail? Think about possible integer overflow.
	public int firstBadVersion(int currentVersion) {
		int lo = 1;
		int hi = currentVersion;
		while (lo < hi) {
			int mid = (lo + hi)/2;
			if (isGood(mid-1) && !isGood(mid)) {
				return mid;
			} else if (!isGood(mid)) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return hi;
	}

	public static void main(String[] args) {
		FirstBadVersion f = new FirstBadVersion();
		int firstBad = 3;
		int totalVersions = 6;
		f.setFirstBadVersion(firstBad, totalVersions);
		System.out.println(f.firstBadVersion(totalVersions));
	}
}

