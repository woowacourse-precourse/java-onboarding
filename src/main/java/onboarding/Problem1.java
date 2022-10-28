package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    // 기능요구사항
    // TODO 예외를 처리하는 함수
    static boolean errorCheck(List<Integer> error) {
        if (error.get(0) == null || error.get(1) == null) return true;
        if (!((error.get(0) <=400 && error.get(0) >= 1) || (error.get(1) <=400 && error.get(1) >= 1))) return true;
        if (error.get(1) - error.get(0) != 1) return true;
        return false;
    }


    // TODO 큰 값을 리턴하는 메서드
    static int getBigScore(List<Integer> num) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int multiple = 1;

        for (int i = 0; i < num.size(); i++) {
            int score = num.get(i);

            while (score != 0) {
                sum += score % 10;
                multiple *= score % 10;
                score = score / 10;
            }

            if (max < sum) {
                max = sum;
                sum = 0;
            }

            if(max < multiple) {
                max = multiple;
                multiple = 1;
            }
        }
        return max;
    }


    // TODO pobi와 crong의 값을 비교하는 메서드
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (errorCheck(pobi) || errorCheck(crong)) return -1;
        int pobiScore = getBigScore(pobi);
        int crongScore = getBigScore(crong);

        if (pobiScore > crongScore) return 1;
        if (pobiScore == crongScore) return 0;
        return -1;
    }
}