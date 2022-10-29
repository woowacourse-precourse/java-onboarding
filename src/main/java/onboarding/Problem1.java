package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /*
     * 입력 페이지들이 연속적인지, 페이지가 1 ~ 400 내인지, 왼쪽 페이지가 홀수이고 오른쪽 페이지가 짝수인지 확인
     *
     * @return boolean
     * */
    private static boolean checkExceptions(int leftPage, int rightPage) {
        return isContiousPages(leftPage, rightPage) && isInRange(leftPage) && isInRange(rightPage) && isOddAndEven(leftPage, rightPage);
    }

    /*
     * 연속적인 페이지인지 확인
     *
     * @return false
     * */
    private static boolean isContiousPages(int leftPage, int rightPage) {
        return leftPage + 1 == rightPage;
    }

    /*
     * 책 내의 페이지인지 확인
     *
     * @return false
     * */
    private static boolean isInRange(int page) {
        return 1 <= page && page <= 400;
    }

    /*
     * 왼쪽 페이지가 홀수이고, 오른쪽 페이지가 짝수인지 확인
     *
     * @return false
     * */
    private static boolean isOddAndEven(int leftPage, int rightPage) {
        return (leftPage % 2 == 1) && (rightPage % 2 == 0);
    }

    /*
     * 주어진 숫자를 문자열로 변환한 후, split하여 한 자리씩 분리
     * stream을 이용해 하나씩 정수로 변환하고 배열로 저장
     *
     * @return int[]
     * */
    private static int[] splitNumber(int page) {
        String number = String.valueOf(page);
        return Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}