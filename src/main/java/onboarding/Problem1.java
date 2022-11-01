package onboarding;

import java.util.List;

class Problem1 {

    private static final int length = 2;
    private static final int minPage = 1;
    private static final int maxPage = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        int answer = getResult(pobiScore,crongScore);
        return answer;
    }

    private static boolean validation(List<Integer> page){
        int leftPage = page.get(0);
        int rightPage = page.get(1);
        if(isNotPageSize(page)){
            return false;
        }
        if(!isInRange(leftPage)||!isInRange(rightPage)){
            return false;
        }
        if(!isOddNumber(leftPage)){
            return false;
        }
        if(!isEvenNumber(rightPage)){
            return false;
        }
        if(notCheckPageOrder(leftPage,rightPage)){
            return false;
        }
        return true;
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

    private static boolean isNotPageSize(List<Integer> pages) {
        return pages.size()!=length;
    }

    private static boolean isInRange(int page) {
        return minPage <= page && page <= maxPage;
    }

    private static boolean isOddNumber(int page) {
        return page % 2 != 0;
    }

    private static boolean isEvenNumber(int page) {
        return page % 2 == 0;
    }

    private static boolean notCheckPageOrder(int leftPage, int rightPage) {
        return (rightPage - leftPage) != 1;
    }
}