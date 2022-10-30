package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
    	System.out.println("problem2 start");
    	// 중복되지 않을 때까지 반복
    	
    	boolean isChange = true;
    	StringBuilder crypto = new StringBuilder(cryptogram);
    	char cryptocheck ;
    	
    	while(isChange) {
    		int cnt = 0;
	    	try {
	    		for(int i = 0; i<cryptogram.length();i++) {
	    			cryptocheck = crypto.charAt(i);
	    			if(crypto.charAt(i) == crypto.charAt(i+1)) {
	    				crypto.deleteCharAt(i+1);
	    				crypto.deleteCharAt(i);
	    				cnt ++;
	    			}
	    		}
			} catch (Exception e) {
				System.out.println("오류발생 " + e.getMessage());
			}
	    	cryptogram = crypto.toString();
	    	
	    	if(cnt == 0) {
	    		isChange = false;
	    	}
	    }
    	
    	return cryptogram;
    }
    
}
