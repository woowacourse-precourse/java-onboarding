package onboarding;

import java.util.List;

class Problem1 {

    // solution함수가 static이기 때문에 다른 함수들도 static으로 해야한다.
    // 모든 조건을 만족하는지 판별
    static boolean checkValid(List<Integer> pages) {
        return checkInterval(pages) && checkOddEven(pages) && checkDiff(pages);
    }

    // 서로 차이가 1인지 판별
    static boolean checkDiff(List<Integer> pages) {
        return pages.get(1) - pages.get(0) == 1;
    }
    // 책 왼쪽 페이지 홀수, 오른쪽 페이지 짝수인지 판별
    static boolean checkOddEven(List<Integer> pages) {
        return pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0;
    }

    // 페이지가 범위내에 있는지
    static boolean checkInterval(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        return (1 <= left && left <= 399) && (2 <= right && right <= 400);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!(checkValid(pobi) && checkValid(crong))) {
            return -1;
        }


        return answer;
    }
}