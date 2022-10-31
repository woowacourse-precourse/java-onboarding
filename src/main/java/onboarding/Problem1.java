package onboarding;

import java.util.List;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;

    public static int addAllNumbers(int page) {
        return String.valueOf(page).chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static int multiplyAllNumbers(int page) {
        int sum = 1;

        for (char c : String.valueOf(page).toCharArray())
            sum *= Character.getNumericValue(c);

        return sum;
    }

    public static boolean validPages(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if (left < 1 || 400 < left || right < 1 || 400 < right)
            return false;

        if (right != left + 1)
            return false;

        if (left == 1 || right == 400)
            return false;

        if (left % 2 == 0 || right % 2 == 1)
            return false;

        return true;
    }

    public static int findMaxSum(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        int leftMax = Math.max(addAllNumbers(left), multiplyAllNumbers(left));
        int rightMax = Math.max(addAllNumbers(right), multiplyAllNumbers(right));

        return Math.max(leftMax, rightMax);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validPages(pobi) || !validPages(crong))
            return -1;

        int pobiScore = findMaxSum(pobi);
        int crongScore = findMaxSum(crong);

        if (pobiScore > crongScore)
            return POBI_WIN;
        if (pobiScore < crongScore)
            return CRONG_WIN;

        return DRAW;
    }
}