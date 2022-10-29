package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore, crongScore, answer;

        if (!checkPages(pobi) || !checkPages(crong)){
            return -1;
        }

        pobiScore = getScore(pobi);
        crongScore = getScore(crong);
        answer = gameResult(pobiScore, crongScore);
        return answer;
    }

    private static Boolean checkPages(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (!isCorrectPage(leftPage) || !isCorrectPage(rightPage)){
            return false;
        }
        if (leftPage % 2 != 1 || rightPage % 2 != 0){
            return false;
        }
        return (leftPage + 1) == rightPage;
    }

    private static Boolean isCorrectPage(int page){
        return (page > 2) && (page < 399);
    }

    private static int getScore(List<Integer> pages){
        int leftScore, rightScore;
        leftScore = getMax(getSumScore(pages.get(0)), getMulScore(pages.get(0)));
        rightScore = getMax(getSumScore(pages.get(1)), getMulScore(pages.get(1)));
        return getMax(leftScore, rightScore);
    }

    private static int getSumScore(int num){
        int sumScore = 0;
        while (num != 0){
            sumScore += num % 10;
            num /= 10;
        }
        return sumScore;
    }

    private static int getMulScore(int num){
        int mulScore = 1;
        while (num != 0){
            mulScore *= num % 10;
            num /= 10;
        }
        return mulScore;
    }


    private static int getMax(int a, int b){
        if (a > b){
            return a;
        }
        return b;
    }

    private static int gameResult(int pobiScore, int crongScore){
        if (pobiScore > crongScore){
            return 1;
        }
        if (crongScore > pobiScore){
            return 2;
        }
        return 0;
    }


}