package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION=-1;
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

        // 1. 예외 체크
        // 1-1. 왼쪽 페이지 홀수, 오른쪽 페이지 짝수인지 체크
        if(isLeftPageOddRightPageEven(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        // 1-2. 왼쪽 페이지와 오른쪽 페이지의 차이가 1 페이지인지 체크 (왼쪽 페이지 + 1 = 오른쪽 페이지)
        if(isLeftPagePlusOneRightPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }
        // 1-3. 시작면이나 마지막면이 나왔는지 체크
        if(isStartPageOrEndPage(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)){
            answer = EXCEPTION;
            return answer;
        }

        // 2. 왼쪽 페이지 중에서 나올 수 있는 가장 큰 최대 값 뽑기 (각 자리 숫자를 모두 더하거나 곱함)
        pobiLeftMax = getMax(pobiLeftPage);
        crongLeftMax = getMax(crongLeftPage);

        // 3. 오른쪽 페이지 중에서 나올 수 있는 가장 큰 최대값 뽑기 (각 자리 숫자를 모두 더하거나 곱함)
        pobiRigtMax=getMax(pobiRightPage);
        crongRightMax = getMax(crongRightPage);

        // 4. 왼쪽 페이지, 오른쪽 페이지 점수 비교
        // 5. 결과값 출력

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
        return !(pobiLeftPage + 1 == pobiRightPage && crongLeftPage + 1 == crongRightPage);
    }

    private static boolean isLeftPageOddRightPageEven(int pobiLeftPage, int pobiRightPage, int crongLeftPage, int crongRightPage) {
        return !(isOdd(pobiLeftPage) && isEven(pobiRightPage)) || !(isOdd(crongLeftPage) && isEven(crongRightPage));
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

}