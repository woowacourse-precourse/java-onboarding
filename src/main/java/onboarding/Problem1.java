package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 유효한 페이지 번호인지 확인
        // 예외사항 존재 시 answer = -1
        if (isExceptionInPageNum(pobi) || (isExceptionInPageNum(crong))) {
            answer = -1;
        }

        // 페이지 번호에서 예외사항이 발생하지 않았을 경우
        if (answer != -1) {
            try {
                // 각 페이지에 대한 점수를 저장하는 List
                // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수들을 List로 저장
                List<Integer> scoreList_pobi = getScoreList(pobi);
                List<Integer> scoreList_crong = getScoreList(crong);

                // 가장 큰 점수
                int score_pobi = getMaxScore(scoreList_pobi);
                int score_crong = getMaxScore(scoreList_crong);

                // 가장 큰 점수끼리 비교 후 answer 값을 지정
                answer = getAnswer(score_pobi, score_crong);

            } catch (Exception e) {
                answer = -1; // 예외사항 발생 시 -1 반환
            }
        }
        return answer;
    }

    // 유효한 페이지 번호인지 확인하는 함수
    private static boolean isExceptionInPageNum(List<Integer> pageNumList) {
        boolean isException = false;

        int leftPageNum = pageNumList.get(0);
        int rightPageNum = pageNumList.get(1);

        // 1. 페이지 번호가 1 미만, 400 초과인 경우 예외
        if (leftPageNum < 1 || leftPageNum > 400) {
            isException = true;
        }
        if (rightPageNum < 1 || rightPageNum > 400) {
            isException = true;
        }
        // 2. 두 페이지 번호가 인접한 번호가 아닐 경우 예외
        if ((rightPageNum - leftPageNum) != 1) {
            isException = true;
        }
        // 3. 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 높거나 같을 경우 예외
        if (leftPageNum >= rightPageNum) {
            isException = true;
        }
        // 4. 왼쪽 페이지 번호가 홀수가 아닐 경우 예외
        if (leftPageNum % 2 == 0) {
            isException = true;
        }
        // 5. 오른쪽 페이지 번호가 짝수가 아닐 경우 예외
        if (rightPageNum % 2 != 0) {
            isException = true;
        }

        return isException;
    }

    // 왼쪽, 오른쪽 페이지에 대한 각각의 가장 큰 점수들을 List로 반환하는 함수
    private static List<Integer> getScoreList(List<Integer> pageNumList) {
        List<Integer> scoreList = new ArrayList<>();
        for (int pageNum : pageNumList) {
            scoreList.add(getScore(pageNum)); // // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수를 반환
        }
        return scoreList;
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수를 반환하는 함수
    private static int getScore(int pageNum) {
        int plusResult = 0; // 각 자리 숫자를 모두 더한 결과값
        int multiplyResult = 1; // 각 자리 숫자를 모두 곱한 결과값

        String pageNumToString = Integer.toString(pageNum); // 페이지 번호를 String으로 변환 (index로 각 수를 접근하기 위함)
        for (int i = 0; i < pageNumToString.length(); i++) {
            int digit = pageNumToString.charAt(i) - '0'; // 각 자리 숫자
            plusResult += digit;
            multiplyResult *= digit;
        }

        return Math.max(plusResult, multiplyResult);
    }

    // 가장 높은 점수(= 최종 점수)를 반환하는 함수
    private static int getMaxScore(List<Integer> scoreList_pobi) {
        int maxScore = Integer.MIN_VALUE;
        for (int score : scoreList_pobi) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    // 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부일 경우 0을 반환하는 함수
    private static int getAnswer(int score_pobi, int score_crong) {
        int answer = 0; // 무승부일 경우 0
        if (score_pobi > score_crong) { // 포비가 이길 경우 1 반환
            answer = 1;
        }
        if (score_pobi < score_crong) { // 크롱이 이길 경우 2 반환
            answer = 2;
        }
        return answer;
    }

}