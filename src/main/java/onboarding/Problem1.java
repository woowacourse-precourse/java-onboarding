package onboarding;

import java.util.List;

class Problem1 {
    static class BookPage {
        private int leftPage;
        private int rightPage;

        BookPage(int leftPage, int rightPage) throws Exception {
            if (!isValid(leftPage, rightPage)) throw new Exception("ERROR");
            this.leftPage = leftPage;
            this.rightPage = rightPage;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookPage pobiBookPage;
        BookPage crongBookPage;
        int answer;

        try {
            pobiBookPage = new BookPage(pobi.get(0), pobi.get(1));
            crongBookPage = new BookPage(crong.get(0), crong.get(1));
        } catch (Exception e) {
            return -1;
        }

        answer = getAnswer(pobiBookPage, crongBookPage);

        return answer;
    }

    private static boolean isValid(int leftPage, int rightPage) {
        boolean validValue = true;

        if ((leftPage <= 0) || (rightPage >= 400) || (leftPage % 2 == 0) || (rightPage % 2 == 1) || (rightPage - leftPage != 1)) {
            validValue = false;
        }

        return validValue;
    }

    private static int getAnswer(BookPage pobi, BookPage crong) {
        int answerValue;
        answerValue = compareScore(pobi, crong);

        return answerValue;
    }

    private static int compareScore(BookPage pobi, BookPage crong) {
        int winner = 0;
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            winner = 1;
        } else if (pobiScore < crongScore) {
            winner = 2;
        } else if (pobiScore == crongScore) {
            winner = 0;
        }

        return winner;
    }

    private static int getScore(BookPage person) {
        int score = 0;
        int leftScore = comparePlusMultiple(person.leftPage);
        int rightScore = comparePlusMultiple(person.rightPage);

        score = Math.max(leftScore, rightScore);
        return score;
    }

    private static int comparePlusMultiple(int page) {
        int maxNum;
        int plusNum = 0;
        int multipleNum = 1;

        while (page > 0) {
            plusNum += page % 10;
            multipleNum *= page % 10;
            page /= 10;
        }

        maxNum = Math.max(plusNum, multipleNum);
        return maxNum;
    }
}