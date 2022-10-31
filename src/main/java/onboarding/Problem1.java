package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobi1= Arrays.asList(pobi.get(0),pobi.get(1));
        List<Integer> crong1= Arrays.asList(crong.get(0),crong.get(1));
        if(pobi.get(0) ==1 | pobi.get(1)==400 | crong.get(0)==1 | crong.get(1)==400 ) {
            answer=-1;
        }else if(pobi.get(0)%2==0 |crong.get(0)%2==0) {
            answer=-1;
        }else if(pobi.get(1)-pobi.get(0) !=1 | crong.get(1)-crong.get(0) !=1 ) {
            answer=-1;
        }
        else {
            int a1=0;
            int b1=1;
            while(pobi1.get(0)/10 != 0) {
                a1=a1+pobi1.get(0)%10;
                b1=b1*(pobi1.get(0)%10);
                pobi1.set(0,pobi1.get(0)/10);
            }
            a1=a1+pobi1.get(0);
            b1=b1*pobi1.get(0);
            int a2=0;
            int b2=1;
            while(pobi1.get(1)/10 != 0) {
                a2=a2+pobi1.get(1)%10;
                b2=b2*(pobi1.get(1)%10);
                pobi1.set(1,pobi1.get(1)/10);
            }
            a2=a2+pobi1.get(1);
            b2=b2*pobi1.get(1);

            int a = Math.max(a1,a2);
            int b = Math.max(b1,b2);
            int pobi_score=Math.max(a,b);
            int c1=0;
            int d1=1;
            while(crong1.get(0)/10 != 0) {
                c1=c1+crong1.get(0)%10;
                d1=d1*(crong1.get(0)%10);
                crong1.set(0,crong1.get(0)/10);
            }
            c1=c1+crong1.get(0);
            d1=d1*crong1.get(0);
            int c2=0;
            int d2=1;
            while(crong1.get(1)/10 != 0) {
                c2=c2+crong1.get(1)%10;
                d2=d2*(crong1.get(1)%10);
                crong1.set(1,crong1.get(1)/10);
            }
            c2=c2+crong1.get(1);
            d2=d2*crong1.get(1);
            int c = Math.max(c1,c2);
            int d = Math.max(d1,d2);
            int crong_score=Math.max(c,d);

            if(pobi_score>crong_score) {
                answer=1;
            }else if(pobi_score<crong_score) {
                answer=2;
            }else {
                answer=0;
            }

        }
        return answer;
    }
}