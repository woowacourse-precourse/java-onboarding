package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    // 예외 입력 검사
    private static boolean isValidInput(List<Integer> array) {
        int leftpage = array.get(0);
        int rightpage = array.get(1);

        if(leftpage < 1 || leftpage > 399 || leftpage % 2 == 0) {
            return false;
        }
        if(rightpage < 1 || rightpage > 400 || rightpage % 2 != 0) {
            return false;
        }
        if(rightpage - leftpage != 1) {
            return false;
        }
        return true;
    }

    // 페이지 번호 각 자리 수 더하기
    private static int sumPage(int page) {
        int result = 0;
        while(page > 0) {
            result  += page % 10;
            page /= 10;
        }
        return result;
    }

    // 페이지 번호 각 자리 수 곱하기
    private static int mulPage(int page) {
        int result = 1;
        while(page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }

    // 가장 큰 수 구하기
    private static int getScore(List<Integer> pageArray) {
        ArrayList<Integer> scoreList = new ArrayList<>();

        for(int e: pageArray) {
            scoreList.add(sumPage(e));
            scoreList.add(mulPage(e));
        }
        return Collections.max(scoreList)
    }

    // 게임 결과 구하기
    private static int findResult(int pobi_score, int crong_score) {
        if(pobi_score > crong_score) {
            return 1;
        } else if(pobi_score < crong_score) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        answer = findResult(getScore(pobi), getScore(crong));

        return answer;
    }
}