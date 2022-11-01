package onboarding;

import onboarding.Problem1Package.Calc;
import onboarding.Problem1Package.Product;
import onboarding.Problem1Package.Sum;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
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
}