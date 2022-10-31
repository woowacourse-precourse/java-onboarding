package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        int pobiScore = findMaxScore(pobi);
        int crongScore = findMaxScore(crong);

        if (pobiScore == -1 || crongScore == -1) {
            return -1;      // 예외처리
        }

        int winningScore = Math.max(pobiScore, crongScore);
        if (winningScore == pobiScore && winningScore == crongScore) {
            answer = 0;     // 무승부
        } else if (winningScore == pobiScore) {
            answer = 1;     // pobi 승
        } else {
            answer = 2;     // crong 승
        }
        return answer;
    }

    private static int findMaxScore(List<Integer> pageList){
        int left = pageList.get(0);
        int right = pageList.get(1);

        if (left <= 0 || right >= 400) {    // 유효하지 않은 페이지 범위
            return -1;
        }
        else if (left + 1 != right || left % 2 == 0 || right % 2 == 1) {    // 유효하지 않은 페이지 번호
            return -1;
        }

        List<Integer> scoreList = new ArrayList<>();
        scoreList.addAll(makeScores(left));
        scoreList.addAll(makeScores(right));

        int maxScore = 0;
        for (int tmp : scoreList) {
            maxScore = Math.max(tmp, maxScore);
        }
        return maxScore;
    }

    private static List<Integer> makeScores(int pageNumber) {
        int plusTmp = 0;
        int multiplyTmp = 1;

        while(pageNumber > 0) {
            int eachNum = pageNumber % 10;
            plusTmp += eachNum;
            multiplyTmp *= eachNum;
            pageNumber /= 10;
        }
        return List.of(plusTmp, multiplyTmp);
    }
}