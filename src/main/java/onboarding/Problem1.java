package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 경우
        if (pobi.get(1) - pobi.get(0) != 1) return -1;
        else if(crong.get(1) - crong.get(0) != 1)  return -1;

        int pobiMaxScore = findMaxScore(pobi);
        int crongMaxScore = findMaxScore(crong);

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