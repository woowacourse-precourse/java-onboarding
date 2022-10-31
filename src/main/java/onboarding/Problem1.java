package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            // 예외 상황 - 다음의 3가지 중 하나라도 만족하지 않는 경우
            // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수, 왼쪽 페이지 == 오른쪽 페이지-1
            if(pobi.get(0)%2 == 0 || pobi.get(1)%2 == 1 || pobi.get(0)!=pobi.get(1)-1)
                throw new IllegalArgumentException();
            if(crong.get(0)%2 == 0 || crong.get(1)%2 == 1 || crong.get(0)!=crong.get(1)-1)
                throw new IllegalArgumentException();

            // pobi의 점수 계산
            int pobiMax = getMax(pobi.get(0));
            pobiMax = max(pobiMax, getMax(pobi.get(1)));

            // crong의 점수 계산
            int crongMax = getMax(crong.get(0));
            crongMax = max(crongMax, getMax(crong.get(1)));

            if (pobiMax > crongMax) {
                return 1;
            }
            if (pobiMax < crongMax) {
                return 2;
            }
            if (pobiMax == crongMax) {
                return 0;
            }
            return -1;

        } catch (Exception e) {
            return -1;
        }
    }

    // 덧셈과 곱셈을 계산하고 둘 중 최댓값을 반환
    private static int getMax(int value) {
        int sum = 0;        // 모든 자리의 합
        int product = 1;    // 모든 자리의 곱
        while(value != 0) {
            sum += (value % 10);
            product *= (value % 10);
            value /= 10;
        }
        return max(sum, product);
    }
}