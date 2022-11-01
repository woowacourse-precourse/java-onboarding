package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<=1;i++) {
        	if(pobi.get(i)%10 + pobi.get(i)/10 >= pobi.get(i)%10 * pobi.get(i)/10)
            	pobi.add(2,pobi.get(i)%10 + pobi.get(i)/10);
            else pobi.add(2,pobi.get(i)%10 * pobi.get(i)/10);
        	
        	if(crong.get(i)%10 + crong.get(i)/10 >= crong.get(i)%10 * crong.get(i)/10)
        		crong.add(2,crong.get(i)%10 + crong.get(i)/10);
            else crong.add(2,crong.get(i)%10 * crong.get(i)/10);
        
        }
        return answer;
    }
}