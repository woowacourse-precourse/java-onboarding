package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int sum(int page){
        int total_sum = 0;

        while(page > 0){
            total_sum += page % 10;
            page /= 10;
        }
        return total_sum;
    }

    public static int multiple(int page){
        int total_multiple = 1;

        while(page > 0){
            total_multiple *= page%10;
            page /= 10;
        }
        return total_multiple;
    }
}