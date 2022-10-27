package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static int addDigit(List<Integer> list) {
        int result = 0;
        for(int i=0; i<2; i++) {
            int tmp = list.get(i);
            int sum = 0;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            result = Math.max(result,sum);
        }
        return result;
    }
}