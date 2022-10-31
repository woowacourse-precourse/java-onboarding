package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

            if(check(pobi)==-1||check(crong)==-1)return -1;
            int A = my_sum(pobi);
            int B = my_sum(crong);
            int C = my_mul(pobi);
            int D = my_mul(crong);
            if(Math.max(A,C)>Math.max(B,D)){
                answer =1;
            }else if(Math.max(A,C)>Math.max(B,D)){
                answer =2;
            }else{
                answer =0;
            }

        return answer;
    }
    public static int check(List<Integer> pobi){
        if(pobi.get(1)-pobi.get(0)==1){
            if(pobi.get(0)>0&&pobi.get(0)<400){
                return 1;
            }
        }
        return -1;

    }
    public static int my_sum(List<Integer> pobi){
        int a = pobi.get(1);
        int sum=0;
        while (a != 0) {
            sum += a % 10;
            a/= 10;
        }
        return sum;
    }
    public static int my_mul(List<Integer> pobi){
        int a = pobi.get(0);
        int b = pobi.get(1);
        int mul1=1, mul2=1;
        while (a != 0) {
            mul1 *= a % 10;
            a/= 10;
        }
        while (b != 0) {
            mul2 *= b % 10;
            b/= 10;
        }
        return Math.max(mul1,mul2);

    }

}