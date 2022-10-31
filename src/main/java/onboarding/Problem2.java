package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = solve(cryptogram);
        
        return answer;
    }
    
    static String solve(String str) { 
    	while(true) {
    		if(str.equals("")) {
    			break;
    		}
    		
    		boolean flag = false;
    		char[] sArr = str.toCharArray(); 
    		
    		for(int i = 0; i<sArr.length-1; i++) {
    			if(sArr[i] == sArr[i+1]) {
    				sArr[i] = '*';
    				sArr[i+1] = '*';
    				flag = true;
    			}
    		}
    		
    		str = "";
    		for(int i = 0; i<sArr.length; i++) {
    			if(sArr[i]!='*') {
    				str += sArr[i]; 
    			}
    		}
    		
    		if(!flag) {
    			break;
    		}
    		
    	}
    	return str;
    }
}