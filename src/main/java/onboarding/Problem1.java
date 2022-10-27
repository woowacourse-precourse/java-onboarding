package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private class ExceptionChecker{
        int pobiLeftPage;
        int pobiRightPage;
        int crongLeftPage;
        int crongRightPage;

        ExceptionChecker() {}
        ExceptionChecker(List<Integer> pobi, List<Integer> crong) {
            pobiLeftPage = pobi.get(0);
            pobiRightPage = pobi.get(1);
            crongLeftPage = crong.get(0);
            crongRightPage = crong.get(1);
        }

        /* 책의 첫번째 면 혹은 마지막 면이 있는지 확인. 있으면 false, 없으면 true false면 예외사항 */
        private boolean checkInnerpages() {
            if (pobiLeftPage == 1 || pobiRightPage == 400 || crongLeftPage == 1 || crongRightPage ==400){
                return false;
            }

            return true;
        }
    }
}