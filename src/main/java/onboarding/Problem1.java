package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (!isPossible(pobi) || !isPossible(crong)) {
            return answer = -1;
        }

        int pobi_score = findHighScore(pobi);
        int crong_score = findHighScore(crong);

        return answer;
    }

    public static boolean isPossible(List<Integer> name) {
        if (name.get(0) + 1 == name.get(1) && name.size() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static int calculateAdd(int num) {
        int addScore = 0;

        while (num != 0) {
            addScore += num % 10;
            num /= 10;
        }

        return addScore;
    }

    public static int calculateMult(int num) {
        int multScore = 1;

        while (num != 0) {
            multScore *= num % 10;
            num /= 10;
        }

        return multScore;
    }

    public static int findHighScore(List<Integer> name) {
        int add = Math.max(calculateAdd(name.get(0)), calculateMult(name.get(0)));
        int mult = Math.max(calculateAdd(name.get(1)), calculateMult(name.get(1)));
        return Math.max(add, mult);
    }
}