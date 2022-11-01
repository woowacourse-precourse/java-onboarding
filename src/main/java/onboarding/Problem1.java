package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int leftPobiPage = pobi.get(0);
        int rightPobiPage = pobi.get(1);

        int leftCrongPage = crong.get(0);
        int rightCrongPage = crong.get(1);

        if (checkExceptions(leftPobiPage, rightPobiPage)
                || checkExceptions(leftCrongPage, rightCrongPage)) {
            return -1;
        }

        int pobiScore = Math.max(computeMaxScore(leftPobiPage), computeMaxScore(rightPobiPage));
        int crongScore = Math.max(computeMaxScore(leftCrongPage), computeMaxScore(rightCrongPage));

        return determineWinner(pobiScore, crongScore);
    }

    /*
     * 입력 페이지들이 연속적인지, 페이지가 1 ~ 400 내인지, 왼쪽 페이지가 홀수이고 오른쪽 페이지가 짝수인지 확인
     *
     * @return boolean
     * */
    private static boolean checkExceptions(int leftPage, int rightPage) {
        return !(isContinuousPages(leftPage, rightPage)
                && isInRange(leftPage)
                && isInRange(rightPage)
                && isOdd(leftPage)
                && !isOdd(rightPage)
        );
    }

    /*
     * 연속적인 페이지인지 확인
     *
     * @return false
     * */
    private static boolean isContinuousPages(int leftPage, int rightPage) {
        return leftPage + 1 == rightPage;
    }

    /*
     * 책 내의 페이지인지 확인
     *
     * @return false
     * */
    private static boolean isInRange(int page) {
        return START_PAGE <= page && page <= END_PAGE;
    }

    /*
     * 주어진 페이지가 홀수인지 확인
     *
     * @return false
     * */
    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

    /*
     * 입력 페이지에 대해 최대 점수를 계산
     * splitNumber()로 int[] 생성한 후, 더하거나 곱한 값 중 최대값 반환
     *
     * @return int
     * */
    private static int computeMaxScore(int page) {
        int[] numberArray = splitNumber(page);
        return Math.max(
                sumAllNumbers(numberArray),
                multiplyAllNumbers(numberArray)
        );
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

    /*
     * 주어진 배열의 값을 정수로 변환하여 합산
     *
     * @return int
     * */
    private static int sumAllNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    /*
     * 주어진 배열의 값을 정수로 변환하여 모두 곱함
     *
     * @return int
     * */
    private static int multiplyAllNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce(1, (number1, number2) -> number1 * number2);
    }

    /*
     * 주어진 두 점수로 게임의 승자를 반환
     *
     * @return 0;
     * */
    private static int determineWinner(int pobi, int crong) {
        if (pobi < crong) {
            return 2;
        }
        if (pobi > crong) {
            return 1;
        }
        return 0;
    }
}