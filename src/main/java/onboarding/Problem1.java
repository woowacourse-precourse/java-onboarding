package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int getScore(List<Integer> player) {
        int score = 0;
        for (int i = 0; i < player.size(); i++) {
            String page = String.valueOf(player.get(i));
            String[] digits = page.split("");

            int mul = 1, sum = 0;
            for (int j = 0; j < digits.length; j++) {
                sum += Integer.valueOf(digits[i]);
                mul *= Integer.valueOf(digits[i]);
            }

            score = max(score, sum);
            score = max(score, mul);
        }
        return score;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
    
        return answer;
    }
}