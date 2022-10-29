package onboarding;

import java.util.List;

class Problem1 {
    public static final int WIN_NUMBER = 1;
    public static final int LOSE_NUMBER = 2;
    public static final int DRAW_NUMBER = 0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!validate(pobi) || !validate(crong)){
            return -1;
        }

        int pobiNumber = calculateMaxNumber(pobi);
        int crongNumber = calculateMaxNumber(crong);
        int answer = compare(pobiNumber, crongNumber);
        return answer;
    }

    public static int compare(int number, int compareNumber){
        if(number > compareNumber) return WIN_NUMBER;
        if(number < compareNumber) return LOSE_NUMBER;
        return DRAW_NUMBER;
    }

    public static int calculateMaxNumber(List<Integer> pageNumbers){
        int leftPageNumber = comparePlusAndMultiple(pageNumbers.get(0));
        int rightPageNumber = comparePlusAndMultiple(pageNumbers.get(1));
        return Integer.max(leftPageNumber, rightPageNumber);
    }

    public static int comparePlusAndMultiple(int pageNumber){
        return Integer.max(plus(pageNumber), multiple(pageNumber));
    }

    public static int plus(int pageNumber){
        int sum = 0 ;
        while(pageNumber != 0) {
            sum += pageNumber%10;
            pageNumber /= 10;
        }
        return sum;
    }

    public static int multiple(int pageNumber){
        int mul = 1;
        while(pageNumber != 0) {
            mul *= pageNumber%10;
            pageNumber /= 10;
        }
        return mul;
    }

    public static boolean validate(List<Integer> pages){
        if(pages.get(1) != pages.get(0)+1) return false;
        return true;
    }
}
