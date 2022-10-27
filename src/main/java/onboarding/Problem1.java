package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isNotPageValid(pobi) || isNotPageValid(crong)) {
            return -1;
        }

        return answer;
    }

    /**
     * 입력 페이지에 대한 검증을 진행한다.
     *
     * @param pageNums 사용자의 페이지 번호 리스트
     * @return 올바르지 않은 페이지 리스트라면 true, 아니라면 false
     */
    private static boolean isNotPageValid(List<Integer> pageNums) {
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        if (isNotPageRange(leftPage, rightPage)) {
            return true;
        }

        return false;
    }

    /**
     * 입력 페이지의 범위가 1~400 사이가 아닌지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 1~400 사이가 아니라면 true, 맞다면 false
     */
    private static boolean isNotPageRange(int leftPage, int rightPage) {
        return leftPage < 1 || leftPage >= 400 || rightPage < 2 || rightPage > 400;
    }

}