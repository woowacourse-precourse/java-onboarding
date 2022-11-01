package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiScore, crongScore;

        /*
        1. 예외처리
        - 배열 길이가 2가 아닌 경우
        - 두 페이지 관계가 x, x+1이 아닐 경우
        - x가 짝수인 경우
        - x<1 또는 x>400인 경우
         */
        if(pobi.size() != 2 || crong.size() != 2)
            return -1;
        if((pobi.get(0) + 1 != pobi.get(1)) || (crong.get(0) + 1 != crong.get(1)))
            return -1;
        if((pobi.get(0) % 2 == 0) || (crong.get(0) % 2 == 0))
            return -1;
        if((pobi.get(0) < 1 || pobi.get(0) > 400) || (crong.get(0) < 1 || crong.get(0) > 400))
            return -1;

        /*
        2. 포비와 크롱의 max 점수 구하기
        - 각각의 max 점수: max(max(왼쪽 페이지 자릿수 합, 왼쪽 페이지 자릿수 곱), max(오른쪽 페이지 자릿수 합, 오른쪽 페이지 자릿수 곱))
         */
        pobiScore = getMaxScore(pobi);
        crongScore = getMaxScore(crong);

        /*
        3. 게임 결과 구하기
        - 포비가 이기면 1
        - 비기면 0
        - 크롱이 이기면 2
         */
        if(pobiScore > crongScore) answer = 1;
        else if(pobiScore == crongScore) answer = 0;
        else answer = 2;

        return answer;
    }

    private static int getMaxScore(List<Integer> person) {
        int score;

        List<Integer> calculatedValue = calculateDigitSumAndProduct(person.get(0));
        score = Math.max(calculatedValue.get(0), calculatedValue.get(1));

        calculatedValue = calculateDigitSumAndProduct(person.get(1));
        score = Math.max(score, Math.max(calculatedValue.get(0), calculatedValue.get(1)));

        return score;
    }

    private static List<Integer> calculateDigitSumAndProduct(int num) {
        int sum = 0;
        int multi = 1;

        while(num > 0) {
            sum += num % 10;
            multi *= num % 10;
            num /= 10;
        }

        return List.of(sum, multi);
    }
}