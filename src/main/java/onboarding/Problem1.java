package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
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
}