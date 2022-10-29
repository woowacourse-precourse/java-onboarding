package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(pobi.get(1)-pobi.get(0)!=1||crong.get(1)-crong.get(0)!=1)
            answer=-1;
        else{
            int maxp=0;
            int maxc=0;
            int maxl=0;
            int maxr=0;
            int sum1=0;
            int mul1=1;
            int sum2=0;
            int mul2=1;
            for(int j=100;j>=1;j=j/10) {
                if ((pobi.get(1) / j) != 0) {
                    sum2 = sum2 + (pobi.get(1)/j);
                    mul2 = mul2 * (pobi.get(1)/j);
                    pobi.set(1, (pobi.get(1) % j));
                }
                else continue;
                if ((pobi.get(0) / j) != 0) {
                    sum1 = sum1 + (pobi.get(0) / j);
                    mul1 = mul1 * (pobi.get(0) / j);
                    pobi.set(0, (pobi.get(0) % j));
                }
            }
            maxl=Math.max(sum1,mul1);
            maxr=Math.max(sum2,mul2);
            maxp=Math.max(maxl,maxr);
            sum1=0;
            mul1=1;
            sum2=0;
            mul2=1;
            for(int i=100;i>=1;i=i/10) {
                if ((crong.get(1) / i) != 0) {
                    sum2 = sum2 + (crong.get(1) / i);
                    mul2 = mul2 * (crong.get(1) / i);
                    crong.set(1, (crong.get(1) % i));
                } else
                    continue;
                if ((crong.get(0) / i) != 0) {
                    sum1 = sum1 + (crong.get(0) / i);
                    mul1 = mul1 * (crong.get(0) / i);
                    crong.set(0,(crong.get(0) % i));
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