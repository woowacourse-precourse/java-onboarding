package onboarding;

import java.util.List;
import java.util.Scanner;

class Problem1 {
    public static int add(int num) {
        int sum=0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static int mul(int num) {
        int mul=1;
        while (num!=0){
            mul = mul * (num%10);
            num=num/10;
        }
        return mul;
    }
    public static int compare(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (((pobi.get(0)<=1) || (pobi.get(0)%2==0) || (crong.get(0)<=1) || (crong.get(0)%2==0)
                || (pobi.get(1)>=400) || (pobi.get(1)%2!=0) || (crong.get(1)>=400) || (crong.get(1)%2!=0))
                || (pobi.get(1)-pobi.get(0) !=1) || (crong.get(1)-crong.get(0) !=1) )
            return -1;

        int pobi_left=compare(add(pobi.get(0)),mul(pobi.get(0)));
        int pobi_right=compare(add(pobi.get(1)),mul(pobi.get(1)));

        int pobi_score=compare(pobi_left,pobi_right);

        int crong_left=compare(add(crong.get(0)),mul(crong.get(0)));
        int crong_right=compare(add(crong.get(1)),mul(crong.get(1)));

        int crong_score=compare(crong_left,crong_right);

        int winner=compare(pobi_score,crong_score);

        if (winner == pobi_score && winner !=crong_score)
            return 1;
        else if (winner == crong_score && winner !=pobi_score)
            return 2;
        else if (winner == pobi_score && winner ==crong_score)
            return 0;
        else
            return -1;
    }
}