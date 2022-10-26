package onboarding;

import java.util.List;

class Problem1 {
    static final int START_PAGE = 1;
    static final int END_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if(!(checkValid(pobi) && checkValid(crong))) return -1;

        if(pobiScore > crongScore) answer = 1;
        else if(pobiScore < crongScore) answer = 2;
        else if(pobiScore == crongScore) answer = 0;

        return answer;
    }

    public static boolean checkValid(List<Integer> pageNums){
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        if(checkIsValidPages(leftPage, rightPage) && checkPagesDiff(leftPage, rightPage)) return true;

        return false;
    }

    public static boolean checkIsValidPages(int leftPage, int rightPage){

        if(leftPage%2!=1) return false;
        if(rightPage%2!=0) return false;

        if(leftPage < START_PAGE || leftPage >= END_PAGE) return false;
        if(rightPage <= START_PAGE || rightPage > END_PAGE) return false;

        return true;
    }

    public static boolean checkPagesDiff(int leftPage, int rightPage){
        int diff = Math.abs(leftPage - rightPage);

        if(diff == 1) return true;

        return false;
    }

    public static int getScore(List<Integer> pageNums){
        int score = 0;
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        int leftScore = getBiggerNum(leftPage);

        int rightScore = getBiggerNum(rightPage);

        score = Math.max(leftScore, rightScore);

        return score;
    }

    public static int getBiggerNum(int page){
        int biggerNum = 0;

        int sumOfEachDigit = getSumOfEachDigit(page);
        int productOfEachDigit = getProductOfEachDigit(page);

        biggerNum = Math.max(sumOfEachDigit, productOfEachDigit);

        return biggerNum;
    }

    public static int getSumOfEachDigit(int num){
        int sum = 0;
        while(num != 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }

    public static int getProductOfEachDigit(int num){
        int product = 1;
        while(num != 0){
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }

}