package onboarding;

import java.util.List;

class Problem1 {

    static Boolean handleException(int leftPage, int rightPage) {   // 예외 사항 처리
        if (rightPage - leftPage > 1) {             // 연속된 페이지가 아닐 경우
            return true;
        }
        if (leftPage == 1 || rightPage == 400) {    // 시작면(1, 2)나 마지막 면(399, 400)이 포함되어 있을 경우
            return true;
        }
        return false;
    }

    static char[] splitPageNum(int page) {
        String numPage = Integer.toString(page);
        char[] numPageChar = numPage.toCharArray();

        return numPageChar;
    }

    static int sumPage(int rightPage) {
        int sum = 0;

        String numPage = Integer.toString(rightPage);
        char[] numPageChar = numPage.toCharArray();

        for (char x : numPageChar) {
            sum += x - '0';
        }

        return sum;
    }

    static int mulPage(int leftPage, int rightPage) {
        int Leftmul = 1;
        int Rightmul = 1;

        String numLeftPage = Integer.toString(leftPage);
        char[] numLeftPageChar = numLeftPage.toCharArray();

        String numRightPage = Integer.toString(rightPage);
        char[] numRightPageChar = numRightPage.toCharArray();

        for (char x : numLeftPageChar) {
            Leftmul *= x;
        }

        for (char x : numRightPageChar) {
            Rightmul *= x;
        }

        int maxMul = getMaxScore(Leftmul, Rightmul);

        return maxMul;
    }

    static int getMaxScore(int score1, int score2) {
        int max = Math.max(score1, score2);

        return max;
    }

    static int compareScore(int pobi, int crong) {
        int winner = Integer.MAX_VALUE;

        if (pobi > crong) {
            winner = 1;
        } else if (pobi < crong) {
            winner = 2;
        } else if (pobi == crong) {
            winner = 0;
        }

        return winner;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 포비와 크롱의 예외 확인
        Boolean isExceptionPobi = handleException(pobiLeftPage, pobiRightPage);
        Boolean isExceptionCrong = handleException(crongLeftPage, crongRightPage);

        if (isExceptionPobi || isExceptionCrong) {
            answer = -1;
        } else {
            int sumPobi = sumPage(pobiRightPage);
            int sumCrong = sumPage(crongRightPage);
            int mulPobi = mulPage(pobiLeftPage, pobiRightPage);
            int mulCrong = mulPage(crongLeftPage, crongRightPage);

            int maxPobi = getMaxScore(sumPobi, mulPobi);
            int maxCrong = getMaxScore(sumCrong, mulCrong);

            answer = compareScore(maxPobi, maxCrong);
        }
        return answer;
    }

}