package onboarding;

import java.util.List;

class Problem1 {
	public static boolean isExcept(int pageOne, int pageTwo) {
		if(pageTwo - pageOne != 1) return true;
		else return false;
	}
	
	 public static int addResult(int n) {
		int add = 0;
		while(n != 0) {
     		add += n % 10;
     		n /= 10;
		}
		return add;
	 }
	 
	 public static int mulResult(int n) {
		 int mul = 1;
		 while(n != 0) {
		 	mul *= n % 10;
		 	n /= 10;
		 }
		 return mul;
	}
	 
	
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        int pobiMax = 0;
        int crongMax = 0;
        
        if(isExcept(pobi.get(0), pobi.get(1))) return -1;
        if(isExcept(crong.get(0), crong.get(1))) return -1;
        
        for(int i = 0; i < 2; i++) {
        	int n = pobi.get(i);
        	int add = addResult(n);
        	int mul = mulResult(n);
        	if(pobiMax < add || pobiMax < mul) pobiMax = add > mul ? add : mul;
        }
        
        for(int i = 0; i < 2; i++) {
        	int n = crong.get(i);
        	int add = addResult(n);
        	int mul = mulResult(n);
        	if(crongMax < add || crongMax < mul) crongMax = add > mul ? add : mul;
        }
        
        if(pobiMax > crongMax) answer = 1;
        else if(pobiMax < crongMax) answer = 2;
        else answer = 0;
        
        return answer;
    }
}