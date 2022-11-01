package onboarding;

import java.util.List;

class Problem1 {

    public static int Sum(int page){
        int sum = 0;

        while(page > 0) {sum += page%10; page /= 10;}
        return sum;
    }
    public static int Mul(int page){
        int sum = 0;

        while(page > 0) {sum *= page%10; page /= 10;}
        return sum;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}