package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION=-1;
    private static final int POBI_WIN =1;
    private static final int CRONG_WIN =2;
    private static final int DRAW=0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        final int pobiLeftPage=pobi.get(0);
        final int pobiRightPage=pobi.get(1);
        final int crongLeftPage = crong.get(0);
        final int crongRightPage = crong.get(1);

        // 예외 사항
        // 1-1 왼쪽 페이지가 짝수이거나 오른쪽 페이지가 홀수인 경우
        // 1-2 왼쪽 페이지와 오른쪽 페이지가 연속적이지 않은 경우
        // 1-3 펼친 페이지가 시작 페이지나 마지막 페이지일 경우
        // 1-4 pobi 와 crong 의 길이가 2가 아닐 경우
        if(isLeftPageEvenRightPageOdd(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)
        || isNotLeftPagePlusOneRightPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)
        || isStartPageOrEndPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)
        || isNotPobiSizeOrCrongSize(pobi, crong)){
            answer = EXCEPTION;
            return answer;
        }

        // 기능 2,3,4 를 수행후 answer 값 출력
        answer = getAnswer(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage);

        return answer;
    }

    private static int getAnswer(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        int pobiLeftMax=0;
        int crongLeftMax=0;
        int crongMax=0;
        int crongRightMax=0;
        int pobiRigtMax=0;
        int pobiMax=0;
        // 2,3. 왼쪽 페이지 최대 값 구하기, 오른쪽 페이지 최대 값 구하기
        pobiLeftMax = getMax(pobiLeftPage);
        crongLeftMax = getMax(crongLeftPage);
        pobiRigtMax=getMax(pobiRightPage);
        crongRightMax = getMax(crongRightPage);

        // 4. 왼쪽 페이지와 오른쪽 페이지 최대값 비교
        pobiMax=Math.max(pobiLeftMax,pobiRigtMax);
        crongMax = Math.max(crongLeftMax, crongRightMax);
        return getAnswer(pobiMax, crongMax);
    }

    private static boolean isNotPobiSizeOrCrongSize(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() != 2 || crong.size() != 2;
    }

    private static int getAnswer(int pobiMax, int crongMax) {
        if(pobiMax > crongMax) return POBI_WIN;
        if(pobiMax == crongMax) return DRAW;
        if(pobiMax < crongMax) return CRONG_WIN;
        return -1;
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