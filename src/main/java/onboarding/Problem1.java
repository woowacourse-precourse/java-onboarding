package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static int calc(int num) {
        String numstr = Integer.toString(num);
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < numstr.length(); i++) {
            sum += (numstr.charAt(i) - '0');
            mult *= (numstr.charAt(i) - '0');
        }
        return Math.max(sum, mult);
    }
}