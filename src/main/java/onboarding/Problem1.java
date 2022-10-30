package onboarding;

import java.util.List;

class Problem1 {
    /**
     *  1. 왼쪽/오른 쪽 페이지 번호의 각 자리 숫자를 모두 더한 값을 구하는 부분 구현
     *  2. 왼쪽/오른 쪽 페이지 번호의 각 자리 숫자를 모두 곱한 값을 구하는 부분 구현
     *  3. 포비와 크롱의 점수를 비교해서 결과 값을 반환한다.(포비가 이기면 1, 크롱이 이기면 2, 무승부는 0, 예외사항 -1)
     **/
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    /**
     * 각 자리 숫자들을 더한 결과를 반환하는 함수
     * */
    public static int plusValue(int page) {
        int result = 0;
        int len = String.valueOf(page).length(); //숫자의 길이

        for(int i = 0; i < len; i++) {
            result += page % 10;

            page = page / 10;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}