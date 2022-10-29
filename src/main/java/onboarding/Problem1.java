package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore, crongScore;

        if (!checkPages(pobi) || !checkPages(crong)){
            return -1;
        }

        pobiScore = getScore(pobi);
        crongScore = getScore(crong);


        int answer = Integer.MAX_VALUE;
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
        return getMax(sumScore(pages), mulScore(pages));
    }

    private static int getMax(int a, int b){
        if (a > b){
            return a;
        }
        return b;
    }

    private static int sumScore(List<Integer> pages){
        return pages.get(0) + pages.get(1);
    }

    private static int mulScore(List<Integer> pages){
        return pages.get(0) * pages.get(1);
    }


}