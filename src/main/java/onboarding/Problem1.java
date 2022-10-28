package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int getScoreFromPages(List<Integer> pages) {
        // 입력받은 페이지 배열에서 왼쪽 페이지와 오른쪽 페이지를 따로 계산
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 정수형 페이지 변수의 자릿수를 통해 점수를 계산하기 위해 자릿수 배열 생성
        List<Integer> leftPageDigits = getDigitsFromNumber(leftPage);
        List<Integer> rightPageDigits = getDigitsFromNumber(rightPage);

        // 자릿수 배열에서 기능 요구 사항에 맞춰 최대 점수 계산
        int maxLeftPage = getMaxScore(leftPageDigits);
        int maxRightPage = getMaxScore(rightPageDigits);

        // 최대 점수 후보 중 가장 큰 수 반환
        return Math.max(maxLeftPage, maxRightPage);
    }

    private List<Integer> getDigitsFromNumber(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private int getMaxScore(List<Integer> numList) {
        int maxScore = Integer.MAX_VALUE;
        return maxScore;
    }
}