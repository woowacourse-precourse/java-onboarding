package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int addEachDigit(int num){
        int first = num / 100;
        int second = (num%100) /10;
        int third = ((num%100) %10);
        return first + second + third;
    }
}