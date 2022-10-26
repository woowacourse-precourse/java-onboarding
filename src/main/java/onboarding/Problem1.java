package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isAvaliable(pobi, crong)) {
            return -1;
        }

        int pobiMax = getMaxValueAfterCalc(pobi.get(0));
        int crongMax = getMaxValueAfterCalc(crong.get(0));

        if (pobiMax > crongMax) {
            answer = 1;
        }else if (pobiMax == crongMax) {
            answer = 0;
        }else {
            answer = -1;
        }


        return answer;
    }

    private static int getMaxValueAfterCalc(int val) {
        int max = 0;
        for(int i=0; i<1; i++) { // 왼쪽페이지, 오른쪽페이지(+1)
            int add = 0, multiply = 1;
            while (val > 0) {
                add += val % 10;
                multiply *= val % 10;
                val /= 10;
            }

            if (max < add) max = add;
            if (max < multiply) max = multiply;

            val++;
        }

        return max;
    }

    private static boolean isAvaliable(List<Integer> pobi, List<Integer> crong) {
        // 예외1. 페이지가 잘못입력됨 (1 ~ 400가 아닐경우)
        for(int i=0; i<2; i++) {
            if (pobi.get(i) < 1 || 400 < pobi.get(i))  return false;
            if (crong.get(i) < 1 || 400 < crong.get(i)) return false;
        }

        // 예외2. 정상적인 값이 아님 (왼쪽페이지+1 != 오른쪽페이지)
        if (pobi.get(0)+1 != pobi.get(1)) return false;
        if (crong.get(0)+1 != crong.get(1)) return false;

        return true;
    }

}