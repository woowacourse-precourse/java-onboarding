package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    // 가장 큰 수 반환 메서드
    public static int maxNum(String numStr) {
        int sumAdd = 0;
        int sumProduct = 1;

        for (String num : numStr.split("")) {
            sumAdd += Integer.parseInt(num);
        }

        for (String num : numStr.split("")) {
            sumProduct *= Integer.parseInt(num);
        }
        return Math.max(sumAdd, sumProduct);
    }
}