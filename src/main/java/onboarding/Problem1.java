package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 제약 조건
        if (pobi.size()!=2 || crong.size()!=2 || pobi.get(0)!=pobi.get(1)-1 || crong.get(0)!=crong.get(1)-1) return -1;

        // 본인의 점수 구하기
        int pobiNum = maxNum(pobi);
        int crongNum = maxNum(crong);

        // 비교
        if (pobiNum==crongNum) return 0;
        if (pobiNum>crongNum) return 1;
        if (pobiNum<crongNum) return 2;

        return -1;
    }

    // 각 자리수 배열로 출력
    static List<Integer> jarisoo(int num) {
        List<Integer> numArr = new ArrayList<Integer>();
        while(num > 0){
            numArr.add(num % 10);
            num /= 10;
        }
        return numArr;
    }

    // List<Integer> 요소 더한 값 출력
    static int plus(List<Integer> nums) {
        int result = 0;
        for(int i : nums) result += i;
        return result;
    }

    // List<Integer> 요소 곱한 값 출력
    static int multiply(List<Integer> nums) {
        int result = 1;
        for(int i : nums) result *= i;
        return result;
    }

    static int maxNum(List<Integer> nums) {
        int maxNum = 0;
        for (int i : nums) {
            List<Integer> jariArr = jarisoo(i);
            int temp = Math.max(plus(jariArr),multiply(jariArr));
            if (maxNum < temp) maxNum = temp;
        }
        return maxNum;
    }
}