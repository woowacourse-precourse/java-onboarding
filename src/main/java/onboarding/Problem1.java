package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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
}
