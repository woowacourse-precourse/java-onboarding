package onboarding;

import java.util.List;

import static onboarding.Problem1.Const.*;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
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