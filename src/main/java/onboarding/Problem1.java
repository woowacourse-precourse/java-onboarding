package onboarding;

import java.util.List;


/**
 * 기능명세
 * 1. 페이지가 유효한지 체크한다.
 *   - 페이지 중간이 찢겨져 있는 경우 아웃
 *   - 1부터 시작되는 400페이지의 책을 주웠다는 가정이 있다.
 *     - 400페이지라는 것이 페이지 400개가 있는건지 마지막 페이지가 400인건지?
 *     - 이외의 예외상황에 대해서는 제시해준 바가 없으므로 예외상황에 넣지 않는다.
 *       - 현재 남아있는 장수가 400페이지라고 하는 경우를 말하는 것이라면 클라이언트와 정확한 소통 필요
 *         - 이렇게되면 400페이지 넘어가는 부분도 예외처리할 것인지 얘기해야 한다.
 * 2. 페이지로 만들 수 있는 최대값을 게임의 룰에 따라서 만들어낸다
 * 3. 값을 비교해서 승자를 결정한다.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPage(pobi) || !isValidPage(crong))
            return -1;

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        return determineWinner(pobiMax, crongMax);
    }
    private static int determineWinner(int pobiMax, int crongMax){
        if(pobiMax>crongMax)
            return 1;

        if(pobiMax==crongMax)
            return 0;

        return 2;
    }
    private static int getMax(List<Integer> pages) {
        return Math.max(Math.max(sumDigitOfPage(pages.get(0)), sumDigitOfPage(pages.get(1))),
                            Math.max(multiplyDigitOfPage(pages.get(0)),multiplyDigitOfPage(pages.get(1))));

    }

    private static boolean isValidPage(List<Integer> pages){
        return pages.get(1) - pages.get(0) == 1;
    }

    private static int sumDigitOfPage(Integer page){
        int result = page%10;
        page/=10;

        while(page!=0){
           result+=page%10;
           page/=10;
        }

        return result;
    }

    private static int multiplyDigitOfPage(Integer page){
        int result = page%10;
        page/=10;

        while(page!=0){
           result*=page%10;
           page/=10;
        }

        return result;
    }
}