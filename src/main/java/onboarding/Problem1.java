package onboarding;

import java.util.List;

import static onboarding.Problem1.Const.*;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkArrayWrongSize(pobi) || checkArrayWrongSize(crong)){
            return EXCEPTION;
        }

        if (checkWrongPages(pobi) || checkWrongPages(crong)){
            return EXCEPTION;
        }

        answer = getWinner(getMaxScore(pobi), getMaxScore(crong));
        return answer;
    }

    private static int getWinner(int pobiScore, int crongScore){
        if (pobiScore > crongScore){
            return POBI_WIN;
        } else if (pobiScore < crongScore){
            return CRONG_WIN;
        } else{
            return DRAW;
        }
    }

    private static int getMaxScore(List<Integer> book) {
        Integer leftPage = book.get(LEFT_PAGE_INDEX);
        int leftPageMaxValue = Math.max(sumOfEachDigit(leftPage), mulOfEachDigit(leftPage));

        Integer rightPage = book.get(RIGHT_PAGE_INDEX);
        int rightPageMaxValue = Math.max(sumOfEachDigit(rightPage), mulOfEachDigit(rightPage));

        return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    private static int sumOfEachDigit(Integer number){
        int sum = 0;

        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    private static int mulOfEachDigit(Integer number){
        int mul = 1;

        while (number != 0){
            mul *= number % 10;
            number /= 10;
        }
        return mul;
    }


    private static Boolean checkWrongPages(List<Integer> pages){
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if (checkWrongRange(leftPage, rightPage)){
            return true;
        }

        if (checkWrongRange(leftPage, rightPage)) {
            return true;
        }

        // leftPage must be odd, rightPage must be even number
        if (isEvenNumber(leftPage) || isOddNumber(rightPage)){
            return true;
        }

        // difference of leftPage and rightPage must be +1
        if ((rightPage - leftPage) != 1){
            return true;
        }
        return false;
    }

    private static boolean checkWrongRange(Integer leftPage, Integer rightPage){
        return (leftPage <= FIRST_PAGE || rightPage >= LAST_PAGE);
    }


    private static boolean checkArrayWrongSize(List<Integer> pages){
        return pages.size() != ARRAY_SIZE;
    }

    private static boolean isOddNumber(Integer number){
        return number % 2 == 1;
    }


    private static boolean isEvenNumber(Integer number){
        return number % 2 == 0;
    }


    static class Const{
        public static final int ARRAY_SIZE = 2;

        public static final int LEFT_PAGE_INDEX = 0;
        public static final int RIGHT_PAGE_INDEX = 1;

        public static final int POBI_WIN = 1;
        public static final int CRONG_WIN = 2;
        public static final int DRAW = 0;
        public static final int EXCEPTION = -1;

        public static final int FIRST_PAGE = 1;
        public static final int LAST_PAGE = 400;
    }
}