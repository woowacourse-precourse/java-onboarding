package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return -1;
        }

        int pobiScore = calcMaxScore(pobi);
        int crongScore = calcMaxScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (crongScore > pobiScore) {
            answer = 2;
        } else if (pobiScore == crongScore) {
            answer = 0;
        }

        return answer;
    }

    private static boolean isValidInput(List<Integer> input) {
        if (input.get(0) == null || input.get(1) == null) {
            return false;
        } else if (input.size() != 2) {
            return false;
        } else if (input.get(0) <= 1 || input.get(1) >= 400) {
            return false;
        } else if (input.get(0) % 2 != 1) {
            return false;
        } else if (input.get(1) - input.get(0) != 1) {
            return false;
        }

        return true;
    }

    private static int calcMaxScore(List<Integer> pages) {
        int leftPage = calcPageScore(pages.get(0));
        int rightPage = calcPageScore(pages.get(1));

        if (leftPage >= rightPage) {
            return leftPage;
        }

        return rightPage;
    }

    private static int calcPageScore(int pageNumber) {
        int multiplyPage = 1;
        int addPage = 0;
        int num = pageNumber;

        while (num != 0) {
            multiplyPage *= num % 10;
            addPage += num % 10;
            num /= 10;
        }

        if (multiplyPage >= addPage) {
            return multiplyPage;
        }

        return addPage;
    }
}