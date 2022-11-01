package onboarding;

import java.util.List;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;
    static final int Exception = -1;
    static final int BOOK_START_PAGE = 1;
    static final int BOOK_END_PAGE = 400;


    private static boolean isnotDifference_1(int left, int right){
        return right - left != 1;
    }
    private static boolean isnotOddandEven(int left, int right){
        return left % 2 == 0 || right % 2 == 1;
    }

    private static boolean isOutofRange(int left, int right){
        return left < BOOK_START_PAGE || right <=BOOK_START_PAGE || left>=BOOK_END_PAGE|| right >BOOK_END_PAGE ;
    }
    private static boolean isValidPage(List<Integer> pages){
        int left = pages.get(LEFT);
        int right = pages.get(RIGHT);
        boolean isValid = true;
        if(isOutofRange(left,right)) isValid=false;
        if(isnotOddandEven(left,right)) isValid=false;
        if(isnotDifference_1(left,right)) isValid=false;
        return isValid;
    }

    private static int compare_left_right(List<Integer> pages){
        return Math.max(getMaxScores(pages.get(LEFT)),getMaxScores(pages.get(RIGHT)));
    }
    private static int getMaxScores(int n){
        int tmp_add=0;
        int tmp_mul=1;
        while(n!=0){
            tmp_add += n%10;
            tmp_mul *= n%10;
            n /= 10;
        }
        return Math.max(tmp_add,tmp_mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPage(pobi) || !isValidPage(crong)) return Exception;
        int p_score = compare_left_right(pobi);
        int c_score = compare_left_right(crong);
        if(p_score>c_score) return POBI_WIN;
        if(p_score<c_score) return CRONG_WIN;
        else return DRAW;
    }
}