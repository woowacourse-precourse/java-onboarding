package onboarding;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Problem1 {

    /**
     *
     * @param target (대상이 되는 수)
     * @return 규칙에 맞게 계산했을 때 나오는 가장 큰 수
     */
    private static int calculate(String target) {
        int addAns = 0;
        int mulAns = 1;

        for (int i = 0; i < target.length(); i++) {
            // 1. 각 자릿수를 모두 더하기
            addAns += (target.charAt(i) - '0');
            // 2. 각 자릿수를 모두 곱하기
            mulAns *= (target.charAt(i) - '0');
        }

        return max(addAns, mulAns);

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /**
         * 예외 처리
         * 1. 두 수의 차이의 절댓값이 2 이상인 경우
         * 2. 첫 페이지, 혹은 끝 페이지를 포함한 경우
         * 3. 왼쪽 페이지가 홀수가 아닌 경우
         * 4. 왼쪽 페이지 + 1 != 오른쪽 페이지 인경우
         */
        if (abs(pobi.get(0) - pobi.get(1)) > 2 || abs(crong.get(0) - crong.get(1)) > 2 ||
                pobi.contains(1) || pobi.contains(400) || crong.contains(1) || crong.contains(400) ||
                pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        int pobiValue = max(calculate(String.valueOf(pobi.get(0))), calculate(String.valueOf(pobi.get(1))));
        int crongValue = max(calculate(String.valueOf(crong.get(0))), calculate(String.valueOf(crong.get(1))));

        if (pobiValue > crongValue) return 1;
        else if (pobiValue == crongValue) return 0;
        else return 2;
    }
}