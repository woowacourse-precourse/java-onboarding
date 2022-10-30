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

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}