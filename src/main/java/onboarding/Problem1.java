package onboarding;

import java.util.List;

class Problem1 {
    static final int TOTAL_PAGE_NUM = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getScore(List<Integer> pageNums){
        int score = 0;
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        //왼쪽 페이지 가장 큰 수 구하기
        int leftScore = getBiggerNum(leftPage);

        //오른쪽 페이지 가장 큰 수 구하기
        int rightScore = getBiggerNum(rightPage);

        //최종 점수 선택
        score = Math.max(leftScore, rightScore);

        return score;
    }

}