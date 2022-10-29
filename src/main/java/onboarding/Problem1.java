package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION=-1;
    private static final int POBI_WIN =1;
    private static final int CRONG_WIN =2;
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

        // 1-1 왼쪽 페이지가 짝수이거나 오른쪽 페이지가 홀수인 경우
        if(isLeftPageEvenRightPageOdd(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        //1-2 왼쪽 페이지와 오른쪽 페이지가 연속적이지 않은 경우
        if(isNotLeftPagePlusOneRightPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        // 1-3 펼친 페이지가 시작 페이지나 마지막 페이지일 경우
        if(isStartPageOrEndPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }

        // 1-4 pobi 와 crong 의 길이가 2가 아닐 경우
        if(isNotPobiSizeOrCrongSize(pobi, crong)){
            answer = EXCEPTION;
            return answer;
        }

        // 2. 왼쪽 페이지 최대 값 구하기
        pobiLeftMax = getMax(pobiLeftPage);
        crongLeftMax = getMax(crongLeftPage);

        // 3. 오른쪽 페이지 최대 값 구하기
        pobiRigtMax=getMax(pobiRightPage);
        crongRightMax = getMax(crongRightPage);

        // 4. 왼쪽 페이지와 오른쪽 페이지 최대값 비교
        pobiMax=Math.max(pobiLeftMax,pobiRigtMax);
        crongMax = Math.max(crongLeftMax, crongRightMax);
        answer = getAnswer(answer, pobiMax, crongMax);

        return answer;
    }

    private static boolean isNotPobiSizeOrCrongSize(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() != 2 || crong.size() != 2;
    }

    private static int getAnswer(int answer, int pobiMax, int crongMax) {
        if(pobiMax > crongMax) answer = POBI_WIN;
        if(pobiMax == crongMax) answer =DRAW;
        if(pobiMax < crongMax) answer = CRONG_WIN;
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

    private static boolean isNotLeftPagePlusOneRightPage(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return pobiLeftPage + 1 != pobiRightPage || crongLeftPage + 1 != crongRightPage;
    }

    private static boolean isLeftPageEvenRightPageOdd(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return isEven(pobiLeftPage) || isOdd(pobiRightPage) || isEven(crongLeftPage) || isOdd(crongRightPage);
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

}