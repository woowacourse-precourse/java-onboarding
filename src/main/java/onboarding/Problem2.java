package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";        
        
        boolean isCheck = true;
		int booleanCnt=0;
        while(isCheck) {     
        	answer="";
        	booleanCnt=0;
        	if(cryptogram.equals("")) return answer;
        	for(int i=0; i<cryptogram.length(); i++) {        		
            	if(i==cryptogram.length()-1) {
            		answer+=cryptogram.charAt(i);            		
            	}
            	else if(cryptogram.charAt(i)==cryptogram.charAt(i+1)) {            		
            		i++;  
            		booleanCnt++;
            		isCheck=true;            		          		
            	}else {            		
            		answer+=cryptogram.charAt(i);
            		if(booleanCnt==0) {
            			isCheck=false;
            		}
            	}
            }        	
        	cryptogram=answer;
        }        
        return answer;
    }    
}
