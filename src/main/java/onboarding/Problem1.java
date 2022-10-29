package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getLargerValue(int page) {
        String[] splitNums = String.valueOf(page).split("");

        int acc = 0;
        int mul = 1;

        for (String splitNum : splitNums) {
            acc += Integer.parseInt(splitNum);
            mul *= Integer.parseInt(splitNum);
        }

        return Math.max(acc, mul);
    }
}