package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidList(pobi) || !isValidList(crong)) {
            return -1;
        }

        answer = findWinner(getMax(pobi), getMax(crong));

        return answer;
    }

    // 예외 처리 함수
    static boolean isValidList(List<Integer> pageList) {
        if (pageList.size() != 2 || pageList.get(0) % 2 == 0 || pageList.get(1) - pageList.get(0) != 1) {
            return false;
        }
        // 시작 면이나 마지막 면이 나오면 안됨
        if (pageList.get(0) == 0 || pageList.get(1) == 400) {
            return false;
        }

        return true;
    }

    // 자신의 점수인 가장 큰 수 구하기 함수
    static int getMax(List<Integer> pageList) {
        ArrayList<Integer> scoreList = new ArrayList<>();

        for (int e: pageList) {
            scoreList.add(getPlus(e));
            scoreList.add(getMultiply(e));
        }

        return Collections.max(scoreList);
    }

    // 각 자리 숫자 더하기 함수
    static int getPlus(int elem) {
        int score = 0;

        while (elem > 0) {
            score += elem % 10;
            elem /= 10;
        }

        return score;
    }

    // 각 자리 숫자 곱하기 함수
    static int getMultiply(int elem) {
        int score = 1;

        while (elem > 0) {
            score *= elem % 10;
            elem /= 10;
        }

        return score;
    }

    // 두 사람의 점수를 비교해 승자 찾기 함수
    static int findWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }

}