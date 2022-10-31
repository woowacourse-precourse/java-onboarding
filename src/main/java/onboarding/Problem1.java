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
                sum += Integer.valueOf(digits[j]);
                mul *= Integer.valueOf(digits[j]);
            }

            score = max(score, sum);
            score = max(score, mul);
        }
        return score;
    }

    public static int getResult(int pobiScore, int crongScore) {
        int ans;
        if (pobiScore == crongScore) {
            ans = 0;
        } else if (pobiScore > crongScore) {
            ans =  1;
        } else {
            ans = 2;
        }
        return ans;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = getResult(pobiScore, crongScore);
        return answer;
    }
}