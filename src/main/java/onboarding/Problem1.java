package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        return answer;
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


    //TODO(숫자 비교 함수)

}