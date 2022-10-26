package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    int sumOfDigits(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number%10;
            sum /= 10;
        }
        return sum;
    }
    int mulOfDigits(int number) {
        int result = 1;
        String str = String.valueOf(number);
        String[] strs = str.split(" ");
        for(int i = 0; i < strs.length; i++) {
            result *= Integer.parseInt(strs[i]);
        }
        return result;
    }
}