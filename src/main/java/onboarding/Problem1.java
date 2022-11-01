package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pmax=0,cmax=0;
        if(pobi.get(0)+1!=pobi.get(1)||crong.get(0)+1!=crong.get(1))
            return -1;

        for(int i=0;i<2;i++) {
            pmax=cal(pobi.get(i));
            cmax=cal(crong.get(i));
        }

        if(pmax>cmax)
            answer=1;
        else if(pmax<cmax)
            answer=2;
        else if(cmax==pmax)
            answer=0;
        return answer;
    }
    public static int cal(int x){
        String s=Integer.toString(x);
        int plussum=0,multisum=1;
        for(int i=0;i<s.length();i++){
            plussum+=s.charAt(i)-'0';
            multisum*=s.charAt(i)-'0';
        }
        return Math.max(plussum,multisum);
    }
}