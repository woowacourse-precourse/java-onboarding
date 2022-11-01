package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int a = pobi.get(0), b = pobi.get(1), sum1=0, mul1=1, sum2=0,mul2=1, max_sum1=0, max_mul1 = 0, max1;
        if((a+1)!=b){
            answer = -1;
            return answer;
        }
        while(a>0){
            sum1+=(a%10);
            a = a/10;
        }
        while(b>0){
            sum2+=(b%10);
            b = b/10;
        }
        max_sum1 = Math.max(sum1, sum2);

        a = pobi.get(0); b = pobi.get(1);
        while(a>0){
            mul1*=(a%10);
            a = a/10;
        }
        while(b>0){
            mul2*=(b%10);
            b = b/10;
        }
        max_mul1 = Math.max(mul1, mul2);
        max1 = Math.max(max_mul1,max_sum1);




/////////
        sum1=0; mul1=1; sum2=0; mul2=1;
        int max2=0;
        int max_sum2=0, max_mul2 = 0;
        a = crong.get(0); b = crong.get(1);

        if((a+1)!=b){
            answer = -1;
            return answer;
        }

        while(a>0){
            sum1+=(a%10);
            a = a/10;
        }
        while(b>0){
            sum2+=(b%10);
            b = b/10;
        }
        max_sum2 = Math.max(sum1, sum2);



        a = crong.get(0); b = crong.get(1);
        while(a>0){
            mul1*=(a%10);
            a = a/10;
        }
        while(b>0){
            mul2*=(b%10);
            b = b/10;
        }
        max_mul2 = Math.max(mul1, mul2);

        max2 = Math.max(max_mul2,max_sum2);



//////////////
        if(max1>max2)answer = 1;
        else if(max1==max2)answer =0;
        else if(max1<max2) answer=2;
        else answer=-1;


        return answer;
    }

//    public static void main(String[] args) {
//        List<Integer> pobi = new ArrayList<>();
//        pobi.add(99);pobi.add(102);
//        List<Integer> crong = new ArrayList<>();
//        crong.add(211); crong.add(212);
//        System.out.println(solution(pobi,crong));
//    }
}