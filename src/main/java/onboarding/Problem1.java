package onboarding;

import java.util.List;
/*
기능 구현 목록
1. 페이지 각 자릿수를 더하는 기능
2. 페이지 각 자릿수를 곱하는 기능
3. 가장 큰 점수를 찾는 기능
4. 승자를 정하는 기능
 */
class Problem1 {
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (!isPossible(pobi) || !isPossible(crong)) {
            return EXCEPTION;
        }

        int pobi_score = findHighScore(pobi);
        int crong_score = findHighScore(crong);

        return answer = whoIsWinner(pobi_score, crong_score);
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

    public static int whoIsWinner(int pobi, int crong) {
        if (pobi > crong) {
            return POBI_WIN;
        } else if (pobi < crong) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }
}