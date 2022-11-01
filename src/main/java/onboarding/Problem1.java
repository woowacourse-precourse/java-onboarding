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
        if(pobiScore < crongScore) answer = 2;
        if(pobiScore == crongScore) answer = 0;

        return answer;
    }

    public static boolean checkValid(List<Integer> pageNums){
        return checkIsValidPages(pageNums) && checkPagesDiff(pageNums);
    }

    public static boolean checkIsValidPages(List<Integer> pageNums){
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        if(leftPage%2!=1) return false;
        if(rightPage%2!=0) return false;

        if(leftPage < START_PAGE || leftPage >= END_PAGE) return false;
        if(rightPage <= START_PAGE || rightPage > END_PAGE) return false;

        return true;
    }

    public static boolean checkPagesDiff(List<Integer> pageNums){
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        int diff = Math.abs(leftPage - rightPage);

        if(diff == 1) return true;

        return false;
    }

    public static int getScore(List<Integer> pageNums){
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        int leftScore = getBiggerNumOfSumAndProductOfEachDigit(leftPage);

        int rightScore = getBiggerNumOfSumAndProductOfEachDigit(rightPage);

        return Math.max(leftScore, rightScore);
    }

    public static int getBiggerNumOfSumAndProductOfEachDigit(int pageNum){
        int sum = 0;
        int product = 1;

        while(pageNum != 0){
            int digit = pageNum % 10;
            sum += digit;
            product *= digit;
            pageNum /= 10;
        }

        return Math.max(sum, product);
    }


}