package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        answer = findWinner(getScore(pobi), getScore(crong));

        return answer;
    }

    // 예외 처리 함수
    static boolean isValid(List<Integer> pageList) {
        // 리스트의 길이는 2여야 함
        if (pageList.size() != 2) {
            return false;
        }
        // 왼쪽 페이지는 홀수
        if (pageList.get(0) % 2 == 0) {
            return false;
        }
        // 왼쪽과 오른쪽 페이지는 연속되어야 함
        if (pageList.get(1) - pageList.get(0) != 1) {
            return false;
        }
        // 시작 면이나 마지막 면이 나오면 안됨
        if (pageList.get(0) == 1 || pageList.get(1) == 400) {
            return false;
        }

        return true;
    }

    // 자신의 점수인 가장 큰 수 구하기 함수
    static int getScore(List<Integer> pageList) {
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

    // 두 사람의 점수를 비교하여 승자 찾는 함수
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