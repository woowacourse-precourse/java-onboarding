package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int higherValue(int num) {
        String number = String.valueOf(num);
        int sum = 0;
        int multiple = 1;
        for(int i = 0; i < number.length(); i++) {
            sum += number.charAt(i)-'0';
            multiple *= number.charAt(i)-'0';
        }
        return Math.max(sum, multiple);
    }
}