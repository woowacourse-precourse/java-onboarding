package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isWrongPage(pobi)||isWrongPage(crong)){
            return -1;
        }
        int pobiScore = getPlayerScore(pobi);
        int crongScore = getPlayerScore(crong);
        if(pobiScore>crongScore){
            answer=1;
        }else if(pobiScore==crongScore){
            answer=0;
        }else if(pobiScore<crongScore){
            answer=2;
        }
        return answer;

    }

    public static boolean isWrongPage(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if(leftPage%2!=1||rightPage%2!=0||rightPage-leftPage!=1){
            return true;
        }
        return false;
    }

    public static int getPlayerScore(List<Integer> pages){
        int score = 0;
        for (Integer page : pages) {
            int pageScore = Math.max(getSumOfPage(page), getMultiplyOfPage(page));
            score = Math.max(score, pageScore);
        }
        return score;
    }

    public static int getSumOfPage(Integer page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int getMultiplyOfPage(Integer page) {
        int multiply = 1;
        while (page > 0){
            multiply *= page%10;
            page/=10;
        }
        return multiply;
    }


}