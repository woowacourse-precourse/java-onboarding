package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkInputException(pobi) || !checkInputException(crong)) {
            return -1;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if(pobiScore == crongScore) {
            return 0;
        } else if (pobiScore > crongScore) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean checkInputException(List<Integer> page) {
        if(page.size() != 2) {
            return false;
        }

        Integer left = page.get(0);
        Integer right = page.get(1);
        if(left == null || left <= 1 || left >= 400 || left%2 == 0
           || right == null || right <= 1 || right >= 400 || right%2 == 1) {
            return false;
        }

        if(right - left != 1) {
            return false;
        }

        return true;
    }

    private static int calculateScore(List<Integer> page) {
        int leftSum = Math.max(multiply(page.get(0)), add(page.get(0)));
        int rightSum = Math.max(multiply(page.get(1)), add(page.get(1)));
        return Math.max(leftSum, rightSum);
    }

    private static int multiply(int page) {
        int sum = 1;
        while(page > 0) {
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int add(int page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }
}