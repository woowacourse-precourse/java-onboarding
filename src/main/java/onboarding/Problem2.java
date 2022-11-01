package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
    	StringBuilder cryptogramSB = new StringBuilder(cryptogram);
		Character preChar = null;
    	for(int i = 0; i < cryptogramSB.length() && i != -1 ; i++) {
    		if(preChar == null) {
    			preChar = cryptogramSB.charAt(i);
    			continue;
    		}else {
    			if(cryptogramSB.charAt(i) == preChar) {
    				cryptogramSB.deleteCharAt(i);
    				cryptogramSB.deleteCharAt(i-1);
    				preChar = null;
    				i = i - 3;
    			}else {
    				preChar = cryptogramSB.charAt(i);
    			}
    		}  		
    	}
    	
    	return cryptogramSB.toString();
    }
}
