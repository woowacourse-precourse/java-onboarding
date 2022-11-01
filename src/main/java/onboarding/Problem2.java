package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return solve(cryptogram);
    }
    public static String solve(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		int idx = 0, i;
		char[] c = s.toCharArray();
		for(i = 1; i < c.length; i++) {
			if(c[i] == c[i - 1]) {
				while(i < c.length && c[i - 1] == c[i]) {
					i++;
				}
			}
			else {
				c[idx++] = c[i - 1];
			}
		}
		
		if(c.length < i) {
			return "";
		}
		
		c[idx++] = c[i - 1];
		
		s = new String(c).substring(0, idx);
		
		if(idx != c.length) {
			return solve(s);
		}
    	return s;
    }
}
