package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 포비와 크롱의 점수 구하기
        int pobiScore = makeOutScore(pobi);
        int crongScore = makeOutScore(crong);

        // 예외처리
        if (pobiScore == -1 || crongScore == -1) {
            return -1;
        }

        // 승부 정하기
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

    private static int makeOutScore(List<Integer> pageList){
        // 1. 왼쪽, 오른쪽 페이지 번호 추출
        int left = pageList.get(0);
        int right = pageList.get(1);

        // 예외처리 : 책의 시작 면이나 마지막 면 혹은 그 외의 범위가 나오면 오류
        if (left <= 0 || right >= 400) {
            return -1;
        }
        // 예외처리 : 페이지 번호가 잘못 되었으면 오류
        else if (left + 1 != right || left % 2 == 0 || right % 2 == 1) {
            return -1;
        }

        // 2. 왼쪽, 오른쪽 페이지 번호를 처리하여 점수 후보군 리스트로 만들기
        List<Integer> joinedTmpList = new ArrayList<>();
        joinedTmpList.addAll(makeTmpList(left));
        joinedTmpList.addAll(makeTmpList(right));

        // 3. 점수 리스트에서 최댓값(=최종 점수) 도출하기
        int max = 0;
        for (int tmp : joinedTmpList) {
            max = Math.max(tmp, max);
        }
        return max;
    }

    private static List<Integer> makeTmpList(int pageNumber) {
        // 각 자리 숫자를 더할 경우/곱할 경우를 분리하여 진행
        int plusTmp = 0;
        int multiplyTmp = 1;

        // 페이지 번호를 변환하여 각자리 숫자를 더하기/곱하기
        while(pageNumber > 0) {
            int eachNum = pageNumber % 10;
            plusTmp += eachNum;
            multiplyTmp *= eachNum;
            pageNumber /= 10;
        }
        // 각 자리를 더한 경우, 곱한 경우 모두 return
        return List.of(plusTmp, multiplyTmp);
    }
}