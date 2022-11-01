package onboarding;

import java.util.List;
import java.lang.Math;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // return 값 초기화!
        int result = 0;

        // 예외이면 -1
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            result = -1;
            return result;
        }

        // int > string > char[] {'9', '7'} ,,,이런식 > cal 계산 후 해당 페이지 큰수 도출
        int pobiL = cal(pobi.get(0).toString().toCharArray());
        int pobiR = cal(pobi.get(1).toString().toCharArray());
        int crongL = cal(crong.get(0).toString().toCharArray());
        int crongR = cal(crong.get(1).toString().toCharArray());

        // pobi, crong 가장 큰수
        int pobimax = Math.max(pobiL, pobiR);
        int crongmax = Math.max(crongL, crongR);

        // 결과 도출
        if (pobimax > crongmax) {
            result = 1;
        } else if (pobimax < crongmax) {
            result = 2;
        } else if (pobimax == crongmax) {
            result = 0;
        }

        return result;
    }

    public static int cal(char[] nums) {
        // 값 초기화
        int add = 0, mul = 1;

        // 계산식 아스키코드 '0' = 48 > num[0] - '0' == 9(57) - '0'(48) 왜? character여서(아스키코드)
        for (int i = 0; i < nums.length; i++) {
            add += nums[i] - '0';
            mul *= nums[i] - '0';
        }

        return Math.max(add, mul);
    }
}