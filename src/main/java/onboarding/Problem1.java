package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1) answer =-1;
        for(int i=0;i<=1;i++) {
        	if(pobi.get(i)%10 + pobi.get(i)/10 >= pobi.get(i)%10 * pobi.get(i)/10)
            	pobi.add(i+2,pobi.get(i)%10 + pobi.get(i)/10);
            else pobi.add(i+2,pobi.get(i)%10 * pobi.get(i)/10);
        	
        	if(crong.get(i)%10 + crong.get(i)/10 >= crong.get(i)%10 * crong.get(i)/10)
        		crong.add(i+2,crong.get(i)%10 + crong.get(i)/10);
            else crong.add(i+2,crong.get(i)%10 * crong.get(i)/10);
        	
        	if(i==1) {
        		if(pobi.get(2)>=pobi.get(3)) pobi.add(4,pobi.get(2));
        		else pobi.add(4,pobi.get(3));
        		if(crong.get(2)>=crong.get(3)) crong.add(4,pobi.get(2));
        		else crong.add(4,crong.get(3));
        	}
        }
        if(pobi.get(2)>pobi.get(3)&answer!=-1) answer=1;
        else if(pobi.get(2)==pobi.get(3)&answer!=-1) answer=0;
        else if(pobi.get(2)<pobi.get(3)&answer!=-1) answer=2;
        return answer; 
    }
}