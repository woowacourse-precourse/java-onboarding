package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isCorrectInput(pobi.get(0), pobi.get(1)) || !isCorrectInput(crong.get(0), crong.get(1))) {
            return -1;
        }

        int scoreOfPobi = findMyScore(findMaxOfPage(pobi.get(0)), findMaxOfPage(pobi.get(1)));
        int scoreOfCrong = findMyScore(findMaxOfPage(crong.get(0)), findMaxOfPage(crong.get(1)));

        if (scoreOfPobi > scoreOfCrong) {
            return 1;
        }
        if (scoreOfPobi < scoreOfCrong) {
            return 2;
        }
        if (scoreOfPobi == scoreOfCrong) {
            return 0;
        }

        return -1;
    }

    public static boolean isCorrectInput(int numOfFirstPage, int numOfSecondPage) {

        if (numOfFirstPage < 1 || numOfSecondPage > 400) {
            return false;
        }

        if (((numOfFirstPage + 1) != numOfSecondPage) || numOfFirstPage % 2 != 1 || numOfSecondPage % 2 != 0) {
            return false;
        }
        return true;
    }

    public static int findMaxOfPage(int numOfPage) {
        String numOfStringPage = Integer.toString(numOfPage);
        int sumOfPage = 0;
        int productOfPage = 1;

        for (int i = 0; i < numOfStringPage.length(); i++) {
            int strToInt = Integer.parseInt(numOfStringPage.substring(i, i + 1));
            sumOfPage += strToInt;
            productOfPage *= strToInt;
        }

        return Math.max(sumOfPage, productOfPage);
    }

    public static int findMyScore(int maxOfLeftScore, int maxOfRightScore) {
        return Math.max(maxOfLeftScore, maxOfRightScore);
    }
}