package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(isValid(pobi) && isValid(crong))) return -1;

        int pobiMax = leftOrRight(pobi);
        int crongMax = leftOrRight(crong);

        if (pobiMax == crongMax) return 0;
        return (pobiMax > crongMax) ? 1 : 2;
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
        if (rightPage != leftPage + 1) return false;

        //예외상황이 아니면 true
        return true;
    }
}