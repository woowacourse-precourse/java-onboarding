package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = Integer.MIN_VALUE;
        int crongScore = Integer.MIN_VALUE;
        //TODO(예외 처리)
        if(pageErrorChecking(pobi, crong)) {
            return -1;
        }
        //pobi, crong 점수 구하기
        for (int i : pobi) {
            pobiScore = Math.max(compareScore(i), pobiScore);
        }
        for (int i : crong) {
            crongScore = Math.max(compareScore(i), crongScore);
        }

        //포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
        int answer = makeAnswer(pobiScore, crongScore);
        return answer;
    }
    private static int makeAnswer(int pobiScore, int crongScore) {
        int answer = Integer.MAX_VALUE;
        if(pobiScore > crongScore) answer = 1;
        if(pobiScore == crongScore) answer = 0;
        if(pobiScore < crongScore) answer = 2;

        return answer;
    }
    private static boolean pageErrorChecking(List<Integer> pobi, List<Integer> crong) {
       if(pobi.get(1) - pobi.get(0) != 1) {
           return true;
       }else if(crong.get(1) - crong.get(0) != 1) {
           return true;
       }else if(pobi.contains(1) || pobi.contains(400)) {
           return true;
       }else if(crong.contains(1) || crong.contains(400)) {
            return true;
        }
       return false;
    }

    private static int compareScore(int score) {
        return Math.max(sumOfDigits(score), multiplicationOfDigits(score));
    }
    //TODO(페이지 번호의 각 숫자를 모두 더하는 함수)
    private static int sumOfDigits(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    //TODO(페이지 번호를 모두 곱하는 함수)
    private static int multiplicationOfDigits(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

}