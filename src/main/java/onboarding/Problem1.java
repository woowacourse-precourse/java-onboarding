package onboarding;

import java.util.List;

class Exception{
    public final int CORRECT_LENGTH = 2;
    public final int LEFT_PAGE = 0;
    public final int RIGHT_PAGE = 1;
    public final int DIFFERENCE_BETWEEN_PAGES=1;
    public final int START_PAGE = 1;
    public final int FINAL_PAGE = 400;

    public boolean isWrongLength(List<Integer> bookPages){
        return bookPages.size() != CORRECT_LENGTH;
    }
    public boolean isWrongPosition(List<Integer> bookPages){
        return (bookPages.get(LEFT_PAGE) % 2!=1)||(bookPages.get(RIGHT_PAGE)%2!=0);
    }
    public boolean isWrongPage(List<Integer> bookPages){
        return ((bookPages.get(1)-bookPages.get(0))!=DIFFERENCE_BETWEEN_PAGES);
    }
    public boolean isFirstOrLastPage(List<Integer> bookPages){
        boolean isTrue = false;
        for(int i=0; i<CORRECT_LENGTH;i++){
            int page = bookPages.get(i);
            isTrue |= (page==FINAL_PAGE||page==START_PAGE);
        }
        return isTrue;
    }
    public boolean errorCheck(List<Integer> bookPages1, List<Integer> bookPages2){
        boolean wrongLength = (isWrongLength(bookPages1)||isWrongLength(bookPages2));
        boolean wrongPosition = (isWrongPosition(bookPages1)||isWrongPosition(bookPages2));
        boolean wrongPageDifference = (isWrongPage(bookPages1)||isWrongPage(bookPages2));
        boolean firstOrLast = (isFirstOrLastPage(bookPages1)||isFirstOrLastPage(bookPages2));
        return (wrongLength||wrongPosition||wrongPageDifference||firstOrLast);
    }
}
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}