package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean check1 = validateInput(pobi.get(0), pobi.get(1));
        boolean check2 = validateInput(crong.get(0), crong.get(1));

        return answer;
    }

    /**
     * Function for validating input conditions
     * */
    public static boolean validateInput(int leftPage, int rightRight) {

        //왼쪽 페이지는 홀수 오른쪽 페이지는 짝수 검증
        if ((leftPage%2) != 1 || (rightRight%2) != 0) {
            return false;
        }

        //왼쪽 페이지와 오른쪽 페이지가 한페이지 차이인지 검증
        if ((leftPage+1) != rightRight) {
            return false;
        }

        //페이지 범위 검증
        if ((leftPage < 1 || leftPage > 400) || (rightRight < 1 || rightRight > 400)) {
            return false;
        }
        return true;
    }
}