package onboarding;

import java.util.List;

class Problem1 {
    private static final int ERROR=-1;
    private static final int POBI_WIN=1;
    private static final int CRONG_WIN=2;
    private static final int DRAW=0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isInputValid(pobi)||!isInputValid(crong)){
            return ERROR;
        }
        //포비, 크롱 둘 다 더하기, 곱하기, 자기 점수 구하기, 인풋체크 해야함
        return calculateGameResult(pobi,crong);

    }

    private static Boolean isInputValid(List<Integer> person){
        int leftPage=person.get(0);
        int rightPage=person.get(1);
        if(isPageRangeInBook(leftPage,rightPage)&&isPageInRow(leftPage,rightPage)&&isOddEven(leftPage,rightPage)) {
            return true;
        }
        return false;
    }

    private static int addPageNumber(int page) {
        int hundredsPlace=page/100;
        page=page%100;
        int tensPlace=page/10;
        int onesPlace=page%10;
        return hundredsPlace+tensPlace+onesPlace;
    }

    private static int multiplyPageNumber(int page){
        int hundredsPlace=page/100;
        page=page%100;
        int tensPlace=page/10;
        int onesPlace=page%10;
        if(hundredsPlace==0){
            return tensPlace*onesPlace;
        } else if(tensPlace==0){
            return onesPlace;
        } else {
            return hundredsPlace*tensPlace*onesPlace;
        }
    }

    private static int getMyScore(List<Integer> person){
        int leftPage=person.get(0);
        int rightPage=person.get(1);
        int addHigh=Math.max(addPageNumber(leftPage),addPageNumber(rightPage));
        int multiplyHigh=Math.max(multiplyPageNumber(leftPage),multiplyPageNumber(rightPage));
        return Math.max(addHigh,multiplyHigh);
    }

    private static int calculateGameResult(List<Integer> pobi, List<Integer> crong){
        int pobiScore=getMyScore(pobi);
        int crongScore=getMyScore(crong);
        if(pobiScore>crongScore) {
            return POBI_WIN;
        }
        if(pobiScore<crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
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
