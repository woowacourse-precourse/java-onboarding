package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isValidInputSet(pobi, crong)){
            return -1;
        }

        int pobiMaxScore  = getPlayerMaxScore(pobi);
        int crongMaxScore = getPlayerMaxScore(crong);

        if(pobiMaxScore > crongMaxScore){
            return 1;
        }
        else if(crongMaxScore > pobiMaxScore){
            return 2;
        }
        else{
            return 0;
        }
    }

    public static boolean isValidInputSet(List<Integer> firstPlayer, List<Integer> secondPlayer){
        return isValidInput(firstPlayer) && isValidInput(secondPlayer);
    }

    public static boolean isValidInput(List<Integer> pages){
        if(!isValidNumber(pages)){
            return false;
        }
        if (!isContinuous(pages)) {
            return false;
        }

        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        if(!isOddNumber(leftPage) || !isEvenNumber(rightPage)){
            return false;
        }
        if(!isValidRange(leftPage) || !isValidRange(rightPage)){
            return false;
        }
        return true;
    }

    public static boolean isOddNumber(int page){
        return page % 2==1;
    }

    public static boolean isEvenNumber(int page){
        return page % 2 == 0;
    }

    public static boolean isValidRange(int page){
        return page >=1 && page <=400;
    }

    public static boolean isValidNumber(List<Integer> pages){
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        return leftPage != null && rightPage != null;
    }

    public static boolean isContinuous(List<Integer> pages){
        return pages.get(1) - pages.get(0) == 1;
    }

    public static int sumDigit(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int multiplyDigit(int page){
        int multi = 1;
        while(page > 0){
            multi *= page % 10;
            page /= 10;
        }
        return multi;
    }

    public static int getMaxScoreOfMultiAndSum(int page){
        int multiScore = multiplyDigit(page);
        int sumScore = sumDigit(page);
        return Math.max(multiScore, sumScore);
    }

    public static int getPlayerMaxScore(List<Integer> pages){
        int leftMaxScore = getMaxScoreOfMultiAndSum(pages.get(0));
        int rightMaxScore = getMaxScoreOfMultiAndSum(pages.get(1));
        return Math.max(leftMaxScore, rightMaxScore);
    }

}