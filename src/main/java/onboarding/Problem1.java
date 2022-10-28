package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPageNum(pobi) || !isValidPageNum(crong)) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;;

        int pobiPoint = calcPoint(pobi);
        int crongPoint = calcPoint(crong);

        if (pobiPoint > crongPoint) {
            answer = 1;
        } else if (pobiPoint < crongPoint) {
            answer = 2;
        } else if (pobiPoint == crongPoint) {
            answer = 0;
        }

        return answer;
    }

    static boolean isValidPageNum(List<Integer> user) {
        if (user.size() != 2) return false;
        if (user.get(0) == null || user.get(1) == null) return false;

        int left = user.get(0);
        int right = user.get(1);

        if (left < 0 || right > 400) return false;
        if ( (left==1 && right ==2) || (left==399 && right==400) ) return false;
        if (left % 2 != 1 || right % 2 != 0) return false;
        if (right - left != 1) return false;

        return true;
    }

    static int calcPoint(List<Integer> user) {
        int leftPagePoint = calcEachDigit(user.get(0));
        int rightPagePoint = calcEachDigit(user.get(1));
        return Math.max(leftPagePoint, rightPagePoint);
    }

    static int calcEachDigit(int pageNum) {
        int eachDigitSum = calcEachDigitSum(pageNum);
        int eachDigitProduct = calcEachDigitProduct(pageNum);
        return Math.max(eachDigitSum, eachDigitProduct);
    }

    static int calcEachDigitSum(int pageNum) {
        int totalSum = 0;

        while (pageNum > 0) {
            int digit = pageNum % 10;
            totalSum += digit;
            pageNum /= 10;
        }

        return totalSum;
    }

    static int calcEachDigitProduct(int pageNum) {
        int totalProduct = 1;

        while (pageNum > 0) {
            int digit = pageNum % 10;
            totalProduct *= digit;
            pageNum /= 10;
        }

        return totalProduct;
    }

}