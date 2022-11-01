package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(pobi.get(1)-pobi.get(0)!=1||crong.get(1)-crong.get(0)!=1)
            answer=-1;
        else{
            int right=pobi.get(1);
            int left=pobi.get(0);
            int maxp=0;
            int maxc=0;
            int maxl=0;
            int maxr=0;
            int sum1=0;
            int mul1=1;
            int sum2=0;
            int mul2=1;
            for(int j=100;j>=1;j=j/10) {
                if ((right / j) != 0) {
                    sum2 = sum2 + (right/j);
                    mul2 = mul2 * (right/j);
                    right= (right % j);
                }
                else continue;
                if ((left / j) != 0) {
                    sum1 = sum1 + (left / j);
                    mul1 = mul1 * (left / j);
                    left=(left % j);
                }
            }
            maxl=Math.max(sum1,mul1);
            maxr=Math.max(sum2,mul2);
            maxp=Math.max(maxl,maxr);
            right=crong.get(1);
            left=crong.get(0);
            sum1=0;
            mul1=1;
            sum2=0;
            mul2=1;
            for(int i=100;i>=1;i=i/10) {
                if ((right/i)!= 0) {
                    sum2 = sum2 + (right / i);
                    mul2 = mul2 * (right / i);
                    right= (right % i);
                } else
                    continue;
                if ((left/i) != 0) {
                    sum1 = sum1 + (left / i);
                    mul1 = mul1 * (left / i);
                    left=(left % i);
                }
            }
            maxl=Math.max(sum1,mul1);
            maxr=Math.max(sum2,mul2);
            maxc=Math.max(maxl,maxr);
            if(maxp>maxc)
                answer=1;
            else if(maxp<maxc)
                answer=2;
            else
                answer=0;
        }
        return answer;
    }
}