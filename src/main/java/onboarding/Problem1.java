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
    private static int digitSum(int pageNum) {
        int sum = 0;
        while (pageNum > 0) {
            sum += (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private static int digitProduct(int pageNum) {
        int sum = 1;
        while (pageNum > 0) {
            sum *= (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private static int sumOrProduct(int pageNum) {
        int sum = digitSum(pageNum);
        int product = digitProduct(pageNum);
        return (sum > product) ? sum : product;
    }

    private static int leftOrRight(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftMax = sumOrProduct(leftPage);
        int rightMax = sumOrProduct(rightPage);

        return (leftMax > rightMax) ? leftMax : rightMax;
    }

    private static  boolean isValid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        //왼쪽 페이지가 짝수면 false
        if (leftPage % 2 == 0) return false;
        //오른쪽 페이지가 왼쪽 페이지보다 1만큼 크지 않으면 false
        if (rightPage == leftPage + 1) return false;

        //예외상황이 아니면 true
        return true;
    }
}