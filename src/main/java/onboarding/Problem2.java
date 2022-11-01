package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
    	String[] str1 = cryptogram.split("");
		String stack = "";
		int idx = 0;
		int change = 0;
		while(true) {
			while(true) {
				if(str1[idx].equals(str1[idx+1])) {
					stack += str1[idx];
					stack += str1[idx+1];
					idx++;
					change++;
				}
				idx++;
				cryptogram = cryptogram.replace(stack, "");
				stack = "";
				
				if((idx > cryptogram.length()-2) || (cryptogram.equals(""))) break;
			}
			str1 = cryptogram.split("");
			idx = 0;
			if(change == 0 || (cryptogram.equals(""))) break;
			change = 0;
		}
		return cryptogram;
    }
}
