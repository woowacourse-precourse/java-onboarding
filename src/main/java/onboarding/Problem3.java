package onboarding;
 
public class Problem3 {
    public static int solution(int number) {
    	System.out.println("problem3 start");
    	
    	int answer = 0;
    	for(int i= 1 ; i<=number ; i++) {
    		String numCnt = String.valueOf(i);
    		
    		for (int j=0; j < numCnt.length();j++) {
    			char chk = numCnt.charAt(j);
    			if(chk == '3' || chk =='6' || chk == '9') {
    				answer ++;
    			}
    		}
    	}
        return answer;
    }
}
