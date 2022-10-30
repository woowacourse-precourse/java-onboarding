package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            // 페이지 번호가 연속되지 않는 경우
            return -1;
        }

        return Integer.MAX_VALUE;
    }

    // 페이지의 각 자리 숫자의 합과 곱 중 더 큰 값을 반환하는 함수
    public static int getMaxValue(int pageNumber) {
        int sum = 0;
        int mul = 1;

        String stringPage = Integer.toString(pageNumber);

        for(int i = 0; i < stringPage.length(); i++) {
            int number = Integer.parseInt(String.valueOf(stringPage.charAt(i)));
            sum += number;
            mul *= number;
        }

        return Math.max(sum, mul);
    }
}