package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCountSum = 0;
        Problem3 problem3 = new Problem3();
        
        for(int i=0;i<=number;i++) {
        	clapCountSum += problem3.clapCounting(i);
        }//for 
        
        return clapCountSum;
    }// solution
    
    public int clapCounting(int number) {
    	int clapCount = 0;
    	String numberStr = String.valueOf(number);
    	
    	for(char digit:numberStr.toCharArray()) {
    		if(digit=='3' || digit=='6' || digit=='9') clapCount++;
    	}//for
    	
    	return clapCount;
    }//clapCounting
}//end class
