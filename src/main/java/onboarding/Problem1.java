package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private class ExceptionChecker{
        int pageOne;
        int pageTwo;
        int pageThree;
        int pageFour;

        ExceptionChecker() {}
        ExceptionChecker(List<Integer> pobi, List<Integer> crong) {
            pageOne = pobi.get(0);
            pageTwo = pobi.get(1);
            pageThree = crong.get(0);
            pageFour = crong.get(1);
        }

        /* 책의 첫번째 면 혹은 마지막 면이 있는지 확인 */
        private boolean checkInnerpages() {
            if (pageOne == 1 || pageTwo == 400 || pageThree == 1 || pageFour ==400){
                return false;
            }

            return true;
        }
    }
}