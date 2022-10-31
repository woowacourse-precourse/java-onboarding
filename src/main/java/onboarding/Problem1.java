package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (!isPossible(pobi) || !isPossible(crong)) {
            return answer = -1;
        }

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
}