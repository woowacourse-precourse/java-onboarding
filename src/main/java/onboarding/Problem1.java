package onboarding;

import java.util.List;

class Problem1 {
    /**
     * 기능 요구 사항
     * 1. pobi와 crong의 페이지가 연속된 값으로 들어오는지 확인한다. (예외 경우 확인)
     *      - 예외의 경우 return -1
     * 2. 페이지 합, 페이지 곱에서 가장 큰 값을 구한다.
     *      - 페이지 합, 페이지 곱을 구하는 함수를 만든다.
     *      - 이 함수를 사용하여 큰 값을 구하는 함수를 만든다.
     * 3. pobi의 큰 값과 crong의 큰 값을 비교한다.
     *      - pobi가 클 경우 return 1
     *      - crong이 클 경우 return 2
     *      - 무승부면 return 0
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 1. 예외 경우
        if (pobi.get(1) - pobi.get(0) != 1) return -1;
        else if(crong.get(1) - crong.get(0) != 1)  return -1;

        // 2. 가장 큰 합 구하기
        int pobiMaxScore = findMaxScore(pobi);
        int crongMaxScore = findMaxScore(crong);

        // 3. pobi와 crong의 값 비교
        if (pobiMaxScore > crongMaxScore) return 1;
        else if (pobiMaxScore < crongMaxScore) return 2;
        else return 0;

    }

    // 페이지 합을 구하는 함수
    public static int sumPage(int page) {
        int result = 0;
        while(page / 10 != 0) {
            result += page % 10;
            page /= 10;
        }
        result += page;
        return result;
    }

    // 페이지 곱을 구하는 함수
    public static int mulPage(int page) {
        int result = 1;
        while(page / 10 != 0) {
            result *= page % 10;
            page /= 10;
        }
        result *= page;
        return result;
    }

    // 왼쪽, 오른쪽 페이지의 max값을 구하는 함수
    public static int findMaxScore(List<Integer> arr){
        int maxLeftPage = Math.max(sumPage(arr.get(0)), mulPage(arr.get(0)));
        int maxRigtPage = Math.max(sumPage(arr.get(1)), mulPage(arr.get(1)));

        return Math.max(maxLeftPage, maxRigtPage);
    }
}