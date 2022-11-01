package onboarding;

import java.util.List;

/* 기능 목록
1. 페이지별로 가장 큰 수 구하기
2. 본임 점수 정하기
3. 승자 확인
4. 예외사항 체크
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //각자 점수 정하기
        int pobiScore = determineScore(pobi);
        int crongScore = determineScore(crong);
        //승자 확인
        if (pobiScore > crongScore) answer = 1;
        else if (pobiScore < crongScore) answer = 2;
        else answer = 0;
        //예외사항 체크
        if (checkException(pobi) || checkException(crong)) answer = -1;

        return answer;
    }

    static int makeScore(int page) {
        int score = 0;
        int sum = 0;
        int multiply = 0;

        if(page >= 100){
            int first = page/100;
            int second = page%100/10;
            int third = page%100%10;
            sum = first + second + third;
            multiply = first * second * third;
        }
        else if(page >= 10){
            int first = page/10;
            int second = page%10;
            sum = first + second;
            multiply = first * second;
        }
        else {
            sum = page;
            multiply = page;
        }

        if (sum > multiply) score = sum;
        else score = multiply;
        return score;
    }

    static int determineScore(List<Integer> pages) {
        int score = 0;

        int leftScore = makeScore(pages.get(0));
        int rightScore = makeScore(pages.get(1));

        if (leftScore > rightScore) score = leftScore;
        else score = rightScore;
        return score;
    }

    static boolean checkException(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }
}