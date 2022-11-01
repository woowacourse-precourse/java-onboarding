package onboarding;

import java.util.List;

class Problem1 {

    public static final int START_PAGE = 1;
    public static final int FINAl_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkValidation(pobi) == -1 || checkValidation(pobi) == -1) {
            return -1;
        }

        int pobiLeftPageMaxScore = findMaxScore(pobi, 0);
        int pobiRightPageMaxScore = findMaxScore(pobi, 1);
        int pobiMaxScore = findMaxScore(pobiLeftPageMaxScore, pobiRightPageMaxScore);

        int crongLeftPageMaxScore = findMaxScore(crong, 0);
        int crongRightPageMaxScore = findMaxScore(crong, 1);
        int crongMaxScore = findMaxScore(crongLeftPageMaxScore, crongRightPageMaxScore);

        answer = findWinner(pobiMaxScore, crongMaxScore);

        return answer;
    }

    private static int findMaxScore(List<Integer> pageList, int index) {
        int sumOfScore = sumScore(pageList, index);
        int multiplicationOfScore = mulitplyScore(pageList, index);

        return findMaxScore(sumOfScore, multiplicationOfScore);
    }

    private static int findMaxScore(int a, int b) {
        return Math.max(a, b);
    }

    private static int sumScore(List<Integer> pageList, int index) {
        int pageNumber = pageList.get(index);
        int sum = 0;

        while (pageNumber > 1) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }

        return sum;
    }

    private static int mulitplyScore(List<Integer> pageList, int index) {
        int pageNumber = pageList.get(index);
        int multiplication = 1;

        while (pageNumber > 1) {
            multiplication *= pageNumber % 10;
            pageNumber /= 10;
        }
        return multiplication;
    }

    private static int checkValidation(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);
        if(leftPage == START_PAGE || rightPage == FINAl_PAGE || leftPage == rightPage){
            return -1;
        }
        if (rightPage - leftPage > 2) {
            return -1;
        } else {
            return 0;
        }
    }

    private static int findWinner(int pobiMaxnumber, int crongMaxNumber) {
        if (pobiMaxnumber > crongMaxNumber) {
            return 1;
        } else if (pobiMaxnumber < crongMaxNumber) {
            return 2;
        } else {
            return 0;
        }
    }
}