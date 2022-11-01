package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        int answer = getResult(pobiScore,crongScore);
        return answer;
    }

    private static int addEachDigits(int page){
        int result=0;
        while(page!=0){
            result += page%10;
            page /= 10;
        }
        return result;
    }

    private static int multiplyEachDigits(int page){
        int result=1;
        while(page!=0){
            result *= page%10;
            page /= 10;
        }
        return result;
    }

    private static int getScore(List<Integer> pages) {
        int leftScore=Math.max(addEachDigits(pages.get(0)),multiplyEachDigits(pages.get(0)));
        int rightScore=Math.max(addEachDigits(pages.get(1)),multiplyEachDigits(pages.get(1)));
        return Math.max(leftScore,rightScore);
    }

    private static int getResult(int pobiScore, int crongScore) {
        if(pobiScore>crongScore) {
            return 1;
        }else if(pobiScore<crongScore){
            return 2;
        }else{
            return 0;
        }
    }
}