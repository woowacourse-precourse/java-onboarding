package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //기능1. 각 자리의 합을 구하는 기능
        //기능2. 각 자리의 곱을 구하는 기능
        //기능3. 더한 값과 곱한 값 중 더 큰 값을 구하는 기능
        //기능4. 왼쪽 페이지와 오른쪽 페이지를 비교하는 기능
        //기능5. 포비의 최대값과 크롱의 최대값을 비교해서 0, 1, 2을 리턴
        //기능6. 예외처리

        int answer = Integer.MAX_VALUE;

        return answer;
    }
    private int digitSum(int pageNum) {
        int sum = 0;
        while (pageNum > 0) {
            sum += (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private int digitProduct(int pageNum) {
        int sum = 1;
        while (pageNum > 0) {
            sum *= (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private int sumOrProduct(int pageNum) {
        int sum = digitSum(pageNum);
        int product = digitProduct(pageNum);
        return (sum > product) ? sum : product;
    }
}