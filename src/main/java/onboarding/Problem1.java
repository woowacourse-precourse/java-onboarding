package onboarding;

import java.util.List;

class Problem1 {
    public static final int CORRECT_LENGTH = 2;
    public static final int NUMBER_OF_PLAYER = 2;
    public static final int DIFFERENCE_BETWEEN_PAGES=1;
    public static final int START_PAGE = 1;
    public static final int FINAL_PAGE = 400;
    public static Boolean isCorrectLength(List<Integer> bookPages){
        return bookPages.size() != CORRECT_LENGTH;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(Problem1.isCorrectLength(pobi)&Problem1.isCorrectLength(crong)){
            return -1;
        }
        return answer;
    }
}