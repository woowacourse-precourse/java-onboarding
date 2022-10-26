package onboarding;

import java.util.List;

class InvalidatePageException extends Exception {

}


class Problem1 {
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;

    private static boolean checkPage(int leftPage, int rightPage) {
        boolean validate = checkMinMaxPage(leftPage) && checkMinMaxPage(rightPage);
        validate &= Math.abs(leftPage - rightPage) == 1;
        return validate;
    }

    private static boolean checkMinMaxPage(int page) {
        return page >= MIN_PAGE && page <= MAX_PAGE;
    }

    private static int createScoreByPage(int page) {
        int sum = 0;
        int mul = 1;
        while (page > 0) {
            int operand = page % 10;
            sum += operand;
            mul *= operand;
            page /= 10;
        }
        return Math.max(sum, mul);
    }

    private static int getMaxScore(List<Integer> person) throws InvalidatePageException {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        if (!checkPage(leftPage, rightPage)) {
            throw new InvalidatePageException();
        }
        return Math.max(createScoreByPage(leftPage), createScoreByPage(rightPage));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        try {
            int pobiScore = getMaxScore(pobi);
            int crongScore = getMaxScore(crong);
            if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            } else {
                answer = 0;
            }
        } catch (InvalidatePageException e) {
            answer = -1;
        }
        return answer;
    }
}