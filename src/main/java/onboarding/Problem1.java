package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isValidParameter(List<Integer> pages) {
        if (pages.get(0) <= 1 || pages.get(0) >= 399) {
            return false;
        }
        return pages.get(1) - pages.get(0) == 1;
    }

    public static int getEachMaximumNumber(Integer page) {
        int numberAddSum = 0;
        int numberProductSum = 1;

        for (char eachNumber: Integer.toString(page).toCharArray()) {
            int number = (eachNumber - '0');
            numberAddSum += number;
            numberProductSum *= number;
        }

        return Math.max(numberAddSum, numberProductSum);
    }

    public static int getMaximumNumber(List<Integer> pages) {
        int leftMax = getEachMaximumNumber(pages.get(0));
        int rightMax = getEachMaximumNumber(pages.get(1));

        return Math.max(leftMax, rightMax);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (isValidParameter(pobi) && isValidParameter(crong)) {
            int maximumPobi = getMaximumNumber(pobi);
            int maximumCrong = getMaximumNumber(crong);

            if (maximumPobi == maximumCrong) {
                answer = 0;
            } else if (maximumPobi > maximumCrong) {
                answer = 1;
            } else {
                answer = 2;
            }
        }

        return answer;
    }
}