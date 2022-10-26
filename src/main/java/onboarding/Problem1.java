package onboarding;

import java.util.List;

class Problem1 {
    private static final int ERROR_CODE=-1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isInputValid(pobi)||!isInputValid(crong)){
            return ERROR_CODE;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static Boolean isInputValid(List<Integer> person){
        int leftPage=person.get(0);
        int rightPage=person.get(1);
        if(isPageRangeInBook(leftPage,rightPage)&&isPageInRow(leftPage,rightPage)&&isOddEven(leftPage,rightPage)) {
            return true;
        }
        return false;
    }

    private static Boolean isPageRangeInBook(int leftPage, int rightPage) {
        if(leftPage<1||leftPage>400){
            return false;
        }
        if(rightPage<1||rightPage>400){
            return false;
        }
        return true;
    }

    private static Boolean isPageInRow(int leftPage, int rightPage){
        if(leftPage+1==rightPage){
            return true;
        }
        return false;
    }

    private static Boolean isOddEven(int leftPage, int rightPage){
        if(leftPage%2==0||rightPage%2==1){
            return false;
        }
        return true;
    }

}
