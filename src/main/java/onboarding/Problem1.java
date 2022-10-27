package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외처리
        if ( pobi.get(0) < 1 || pobi.get(0) > 400
            || pobi.get(1) < 1 || pobi.get(1) > 400
            || crong.get(0) < 1 || crong.get(0) > 400
            || crong.get(1) < 1 || crong.get(1) > 400
            || pobi.get(0)%2 != 1
            || pobi.get(1)%2 != 0
            || pobi.get(1) - pobi.get(0) != 1
            || crong.get(0)%2 != 1
            || crong.get(1)%2 != 0
            || crong.get(1) - crong.get(0) != 1
        ) {
            return -1;
        }

        int pobi_left = getMaxNum(pobi.get(0));
        int pobi_right = getMaxNum(pobi.get(1));
        int pobi_max = Math.max(pobi_left,pobi_right);

        int crong_left = getMaxNum(crong.get(0));
        int crong_right = getMaxNum(crong.get(1));
        int crong_max = Math.max(crong_left,crong_right);

        if (pobi_max > crong_max)
            answer = 1;
        else if (pobi_max < crong_max)
            answer = 2;
        else answer = 0;

        return answer;
    }

    private static int getMaxNum (int page) {
        int one = page%10;
        int ten = page%100 - one;
        int hun = page/100;

        int sum = one + ten + hun;
        int mul = (hun != 0) ? one*ten*hun : one*ten;

        return Math.max(sum,mul);
    }
}