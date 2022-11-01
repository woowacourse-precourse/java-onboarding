package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int pobiWin = 1;
    static int crontWin = 2;
    static int draw = 0;
    static int exception = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong){
        if(exceptCheck(pobi) || exceptCheck(crong)){
            return exception;
        };
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        int result = getWinner(pobiScore,crongScore);
        return result;
    }

    private static int getScore(List<Integer> pages){

        ArrayList score = new ArrayList();
        for(Integer page : pages){
            int sum = 0;
            int mul = 1;
            while (page > 0) {
                int calVar = page % 10;
                sum += calVar;
                mul *= calVar;
                page /= 10;
            }
            score.add(Math.max(sum,mul));
        }
        int leftPage = (int) score.get(0);
        int rightPage = (int) score.get(1);
        return (leftPage > rightPage) ? leftPage : rightPage;
    }

    private static int getWinner(Integer user1, Integer user2){
        int compareScore = user1 - user2;
        if (compareScore == 0){
            return draw;
        }
        return (compareScore > 0) ? pobiWin : crontWin;
    }

    private static boolean exceptCheck(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage= pages.get(1);
        if (leftPage %2 != 1 || rightPage %2 != 0){
            return true;
        }
        if(leftPage > rightPage || leftPage <1 || rightPage >400){
            return true;
        }
        if(leftPage != (rightPage -1)){
            return true;
        }
        return (leftPage == 1 || rightPage == 400) ? true : false;
    }
}