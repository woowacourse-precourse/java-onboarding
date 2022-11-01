package onboarding;

import onboarding.Problem1Package.Calc;
import onboarding.Problem1Package.Product;
import onboarding.Problem1Package.Sum;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        if (pobi.get(1) != pobi.get(0) + 1 || crong.get(1) != crong.get(0) + 1) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 합과 곱 중 최대값 구하기
    private static int getMaxOfSumOrProduct(List<Integer> list) {
        Calc sum = new Sum();
        Calc product = new Product();

        int sumResult = sum.getResult(list);
        int productResult = product.getResult(list);

        int max = Math.max(sumResult, productResult);
        return max;
    }

    // pobi와 crong 중 누가 최대인지 비교하기
    public static int compareMax(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }
}