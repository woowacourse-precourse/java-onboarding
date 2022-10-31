package onboarding;
 

public class Problem2 {
    public static String solution(String cryptogram) {
    	System.out.println("problem2 start");
    	// 중복되지 않을 때까지 반복
    	
    	boolean isChange = true;
    	StringBuilder crypto = new StringBuilder(cryptogram);
    	
    	while(isChange) {
    		int cnt = 0;
    		for(int i = 0; i<cryptogram.length();i++) {
    			System.out.println("cryptogrma length-> " + cryptogram.length());
    			char cryptocheck = crypto.charAt(i);
    			if(i < cryptogram.length()-1) {
    				if(crypto.charAt(i) == crypto.charAt(i+1)) {
    					crypto.deleteCharAt(i+1);
    					crypto.deleteCharAt(i);
    					cnt ++;	    		
    					cryptogram = crypto.toString();
    					break;
    				}		
    			}
    		}
	    	if(cnt == 0) {
	    		isChange = false;
	    	}
	    }
    	
    	return cryptogram;
    }
    
}
