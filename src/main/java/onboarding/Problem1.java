package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = compareScore(pobiScore, crongScore);

        return answer;
    }

    /**
     * list를 입력하면 분석하고 계산한 점수를 반환함
     * @param list
     * @return int: 계산된 점수
     */
    private static int getScore(List<Integer> list) {
        int result = 0;
        // 양쪽 페이지의 차이는 무조건 1이여야 함
        if(Math.abs(list.get(0) - list.get(1)) != 1){
            return -1;
        }

        int leftScore = calcScore(list.get(0));
        int rightScore = calcScore(list.get(1));

        if(leftScore > rightScore)
            result = leftScore;
        else
            result = rightScore;

        return result;
    }

    /**
     * 점수를 넘겨주면 각 자릿수별로 더하거나 곱한 값을 비교하여
     * 더 높은 값을 반환함
     * @param score
     * @return int: 더 높은 점수
     */
    private static int calcScore(int score){
        int result = 0;
        int sumScore = 0;
        int mulScore = 1;

        List<Integer> list = new ArrayList<>();
        while(score > 0){
            list.add(score % 10);
            score /= 10;
        }

        for(int num: list) {
            sumScore += num;
            mulScore *= num;
        }

        if(sumScore > mulScore)
            result = sumScore;
        else
            result = mulScore;

        return result;
    }

    /**
     * 두 개의 점수를 입력받아 비교하여 승자를 판별함
     * @param pobiScore
     * @param crongScore
     * @return 1: 포비 승, 2: 크롱 승, -1: 예외 사항
     */
    private static int compareScore(int pobiScore, int crongScore) {
        int result = 0;
        if(isExceptionPage(pobiScore, crongScore))
            return -1;

        if(pobiScore > crongScore)
            result = 1;
        else if(pobiScore < crongScore)
            result = 2;
        else
            result = 0;
        return result;
    }

    /**
     * 입력받은 두 점수 중 하나라도 -1이 나오면 예외 사항으로 간주함
     * @param pobiScore
     * @param crongScore
     * @return true: 예외 사항, false: 정상
     */
    private static boolean isExceptionPage(int pobiScore, int crongScore) {
        if(pobiScore == -1 || crongScore == -1)
            return true;
        return false;
    }
}