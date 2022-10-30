package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int sumDigit(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int multiplyDigit(int page){
        int multi = 1;
        while(page > 0){
            multi *= page % 10;
            page /= 10;
        }
        return multi;
    }
}