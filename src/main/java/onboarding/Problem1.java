package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION=-1;
    private static final int POBIWIN=1;
    private static final int CRONGWIN=2;
    private static final int DRAW=0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        int pobiLeftPage=pobi.get(0);
        int pobiRightPage=pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        int pobiLeftMax = 0;
        int pobiRigtMax=0;
        int crongLeftMax=0;
        int crongRightMax=0;

        int pobiMax=0;
        int crongMax=0;

        if(isLeftPageOddRightPageEven(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        if(isLeftPagePlusOneRightPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        if(isStartPageOrEndPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }

        pobiLeftMax = getMax(pobiLeftPage);
        crongLeftMax = getMax(crongLeftPage);

        pobiRigtMax=getMax(pobiRightPage);
        crongRightMax = getMax(crongRightPage);

        pobiMax=Math.max(pobiLeftMax,pobiRigtMax);
        crongMax = Math.max(crongLeftMax, crongRightMax);

        answer = getAnswer(answer, pobiMax, crongMax);

        return answer;
    }

    private static int getAnswer(int answer, int pobiMax, int crongMax) {
        if(pobiMax > crongMax) answer =POBIWIN;
        if(pobiMax == crongMax) answer =DRAW;
        if(pobiMax < crongMax) answer =CRONGWIN;
        return answer;
    }

    private static int getMax(int page){
        int sum=0;
        int multiply=1;

        while(page>0){
            sum=sum+page%10;
            multiply=multiply*(page%10);

            page/=10;
        }

        return sum > multiply ? sum : multiply;
    }

    private static boolean isStartPageOrEndPage(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return pobiLeftPage == 1 || pobiLeftPage == 399 || pobiRightPage == 2 || pobiRightPage == 400
                || crongLeftPage == 1 || crongRightPage == 399 || crongLeftPage == 2 || crongRightPage == 400;
    }

    private static boolean isLeftPagePlusOneRightPage(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return pobiLeftPage + 1 != pobiRightPage || crongLeftPage + 1 != crongRightPage;
    }

    private static boolean isLeftPageOddRightPageEven(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return isEven(pobiLeftPage) || isOdd(pobiRightPage) || isEven(crongLeftPage) || isOdd(crongRightPage);
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

}