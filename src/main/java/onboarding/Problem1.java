package onboarding;

import java.util.List;

class Problem1 {
    public static final int CORRECT_LENGTH = 2;
    public static final int LEFT_PAGE = 0;
    public static final int RIGHT_PAGE = 1;
    public static final int DIFFERENCE_BETWEEN_PAGES=1;
    public static final int START_PAGE = 1;
    public static final int FINAL_PAGE = 400;
    public static Boolean isCorrectLength(List<Integer> bookPages){
        return bookPages.size() != CORRECT_LENGTH;
    }
    public static boolean isCorrectPosition(List<Integer> bookPages){
        return (bookPages.get(LEFT_PAGE) % 2!=1)||(bookPages.get(RIGHT_PAGE)%2!=0);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}