package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int scoreSum, scoreMultiply, maxScore;
        scoreSum = 0;
        scoreMultiply = 1;

        List<Integer> userScoreArr, totalScoreArr;
        totalScoreArr = new ArrayList<>();
        List<List<Integer>> userArr = List.of(pobi, crong);

        // 1. 왼쪽과 오른쪽 페이지의 쪽수 차이가 2 이상일 때 예외 사항으로 간주 (-1 반환)
        if ((Math.abs(pobi.get(0) - pobi.get(1)) > 1) || (Math.abs(crong.get(0) - crong.get(1)) > 1)) {
            answer = -1;
        } else {
            // 2. 왼쪽과 오른쪽 페이지의 쪽수 차이가 1일 때 각 자리 숫자를 모두 더한 값과 모두 곱한 값을 구함.
            for (List<Integer> user : userArr) {
                userScoreArr = new ArrayList<>();
                for (Integer score : user) {
                    while (score != 0) {
                        scoreSum += score % 10;
                        scoreMultiply *= score % 10;
                        score /= 10;
                    }
                    maxScore = Math.max(scoreSum, scoreMultiply);
                    userScoreArr.add(maxScore);
                    scoreSum = 0;
                    scoreMultiply = 1;
                }
            }
        }
        return answer;
    }
}