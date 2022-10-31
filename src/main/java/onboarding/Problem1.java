package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*예외사항*/
        if(pobi.get(0) <= 0 || pobi.get(1) >400 || crong.get(0) <= 0 || crong.get(1) >400) return -1;
        if(pobi.get(0) != pobi.get(1)-1 || crong.get(0) !=crong.get(1) -1) return -1;
        if(pobi.get(0)%2 == 0 || pobi.get(1)%2 ==1 || crong.get(0)%2 == 0 || crong.get(1)%2 ==1) return -1;

        int pobiScore = -1;

        for(int i=0; i<2; i++){
            int add = pobi.get(i)%10;
            int mul = pobi.get(i)%10;
            int c=1;
            do{
                add += (pobi.get(i)/(int)Math.pow(10,c))%10;
                mul *= (pobi.get(i)/(int)Math.pow(10,c))%10;
            }while(pobi.get(i)/(int)Math.pow(10,++c)> 0);
            if(add > pobiScore) pobiScore = add;
            if(mul > pobiScore) pobiScore = mul;
        }

        int crongScore = 0;

        for(int i=0; i<2; i++){
            int add = crong.get(i)%10;
            int mul = crong.get(i)%10;
            int c=1;
            do{
                add += (crong.get(i)/(int)Math.pow(10,c))%10;
                mul *= (crong.get(i)/(int)Math.pow(10,c))%10;
            }while(crong.get(i)/(int)Math.pow(10,++c) >0);

            if(add > crongScore) crongScore = add;
            if(mul > crongScore) crongScore = mul;
        }

        if(pobiScore==crongScore) answer =0;
        else if(pobiScore>crongScore) answer = 1;
        else answer = 2;

        return answer;
    }
}