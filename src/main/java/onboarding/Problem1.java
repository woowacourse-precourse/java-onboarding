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

    public static boolean isPossible(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) {
            return false;
        }

        int leftPage[] = {pobi.get(0), crong.get(0)};
        int rightPage[] = {pobi.get(1), crong.get(1)};

        for (int i = 0; i < 2 ; i++) {
            if(leftPage[i] % 2 != 1 || rightPage[i] % 2 != 0) {
                return false;
            }
        }

        for (int i = 0; i < 2; i++) {
            if(leftPage[i] + 1 != rightPage[i]) {
                return false;
            }
        }

        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isPossible(pobi, crong)) return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = getResult(pobiScore, crongScore);
        return answer;
    }
}