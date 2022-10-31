package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            // 페이지 번호가 연속되지 않는 경우
            return -1;
        }

        int pobiNumber = getScore(pobi);
        int crongNumber = getScore(crong);

        if(pobiNumber > crongNumber) {
            return 1;
        }else if(pobiNumber < crongNumber) {
            return 2;
        }

        return 0;
    }

    // 펼친 페이지가 들어있는 리스트를 받아 최종 점수를 결정하는 함수
    public static int getScore(List<Integer> pageList){
        int left = pageList.get(0);
        int right = pageList.get(1);

        int maxLeftValue = getMaxValue(left);
        int maxRightValue = getMaxValue(right);

        return Math.max(maxLeftValue, maxRightValue);
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