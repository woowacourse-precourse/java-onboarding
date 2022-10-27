package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();
        
        if(cryptogram.length()==1) return cryptogram;
        StringBuilder sbCryptogram = new StringBuilder(cryptogram);

        while(problem2.RepectDelete(sbCryptogram)!=0) {
        problem2.RepectDelete(sbCryptogram); 
        }//while
        
        String answer = sbCryptogram.toString();
        return answer;
    }// solution
    
    private int RepectDelete(StringBuilder sbCryptogram) {
    	int numberOfDelete = 0;
    	for(int i=1; i<sbCryptogram.length();i++) {
    		if(sbCryptogram.charAt(i-1)==sbCryptogram.charAt(i)) {
    			sbCryptogram.delete(i-1, i+1);
    			i=i-1;
    			numberOfDelete++;
    		}//if
    	}//for
    	return numberOfDelete;
    }// RepectDelete
}// class
