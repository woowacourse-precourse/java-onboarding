package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int EXCEPTION = -1;
        final int POBIWIN = 1;
        final int CRONGWIN = 2;
        final int TIE = 0;

        if(!isOk(pobi) || !isOk(crong)) return EXCEPTION;

        int pobiScore = comparePage(pobi);
        int crongScore = comparePage(crong);

        if(pobiScore > crongScore) return POBIWIN;
        if(pobiScore < crongScore) return CRONGWIN;
        else return TIE;
    }

    public static boolean isOk(List<Integer> bookPages){
        int leftPage = bookPages.get(0);
        int rightPage = bookPages.get(1);

        if(leftPage<1 || leftPage>400 || rightPage<1 || rightPage>400) return false;
        if(rightPage - leftPage != 1) return false;

        return true;
    }

    public static int comparePage(List<Integer> bookPages){
        int leftPage = bookPages.get(0);
        int rightPage = bookPages.get(1);

        int leftPageScore = calculatePage(leftPage);
        int rightPageScore = calculatePage(rightPage);

        return leftPageScore > rightPageScore ? leftPageScore : rightPageScore;
    }

    public static int calculatePage(int bookPage){
        int plusResult = 0;
        int multiResult = 1;

        while(bookPage > 0){
            plusResult += bookPage % 10;
            multiResult *= bookPage % 10;

            bookPage /= 10;
        }

        return plusResult > multiResult ? plusResult : multiResult;
    }

}