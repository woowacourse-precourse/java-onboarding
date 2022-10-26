package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    /* 점수 계산 메소드 */
    public static int calculateScore(List<Integer> page) {

        int result, left, right;
        List<Integer> score = new ArrayList<>();

        // 페이지 별 점수 구하기 (0 : 좌 / 1 : 우)
        for (int i = 0; i < 2 ; i++) {

            List<Integer> digit = new ArrayList<>();

            // 페이지 정보 읽기
            int page_info = page.get(i);

            // 페이지 파싱
            while(page_info > 0) {
                digit.add(page_info % 10);
                page_info /= 10;
            }

            // 각 자릿수의 합과 곱 비교
            score.add(compareScore(digit));

        }

        // 좌, 우 페이지 점수 비교 (0 : 좌 / 1 : 우)
        left = score.get(0); right = score.get(1);
        result = left >= right ? left : right;

        return result;
    }

    /* 각 자릿수 합과 곱 비교 메소드 */
    public static int compareScore(List<Integer> digit) {

        int sum_score, mul_score;

        sum_score = 0;
        mul_score = 1;

        for (int n : digit) {
            sum_score += n;
            mul_score *= n;
        }

        return sum_score >= mul_score ? sum_score : mul_score;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        /* 예외 처리 */
        // 1. R - L != 1 일 경우 예외 처리
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
            return answer;
        }

        // 2. 첫 페이지(1) 또는 마지막 페이지(400)일 경우 예외 처리
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            answer = -1;
            return answer;
        }

        /* 점수 계산 및 비교 */
        if (calculateScore(pobi) > calculateScore(crong)) {
            // 포비 승
            answer = 1;
        }
        else if (calculateScore(pobi) < calculateScore(crong)) {
            // 크롱 승
            answer = 2;
        }
        else {
            // 무승부
            answer = 0;
        }

        return answer;

    }

}