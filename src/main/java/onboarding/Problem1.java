package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 0, 1, 2, -1은 모두 의미를 가지는 값이므로 로직 상 반환될 수 없는 값으로 초기화한다.
        int answer = Integer.MAX_VALUE;
        // getScore 메소드를 이용해 pobi, crong의 점수를 얻는다.
        int pobiScore = getScore(pobi.get(0), pobi.get(1));
        int crongScore = getScore(crong.get(0), crong.get(1));
        // pobi, crong의 점수를 비교해 반환할 값을 answer에 담는다.
        if (pobiScore < 0 || crongScore < 0) {
            // getScore 메소드에서 음수를 반환받았다면 예외상황이므로 -1을 반환한다.
            answer = -1;
        } else if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        }
        return answer;
    }

    /**
     * 두 정수가 유효한 입력값인지 확인한다.
     * @param number1
     * @param number2
     * @return 유효하면 true, 아니면 false
     */
    private static boolean isValid(Integer number1, Integer number2) {
        // 다른 계산식에서 오류가 발생하지 않도록 null값에 대한 예외처리를 먼저 한다.
        if (number1 == null || number2 == null) {
            return false;
        }
        // 홀수, 짝수에 대한 예외처리
        if (number1 % 2 == 0 || number2 % 2 != 0) {
            return false;
        }
        // 두 수의 연속성 여부에 대한 예외처리
        if (Math.abs(number1 - number2) != 1) {
            return false;
        }
        return true;
    }

    /**
     * 주어진 정수를 이루는 각 자리 수의 합을 반환한다.
     * @param number
     * @return 각 자리 수의 합
     */
    private static int getSumOfDigits(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    /**
     * 주어진 정수를 이루는 각 자리 수의 곱을 반환한다.
     * @param number
     * @return 각 자리 수의 곱
     */
    private static int getMultipliedOfDigits(int number) {
        int result = 1;
        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    /**
     * 주어진 각 페이지로 계산한 값을 비교해 정한 점수를 반환한다. 파라미터값이 유효하지 않은 경우 -1을 반환한다.
     * @param pages
     * @return 최종 점수 또는 -1
     */
    private static int getScore(int leftPage, int rightPage) {
        if (!isValid(leftPage, rightPage)) {
            return -1;
        }
        int leftPageValue = Math.max(getSumOfDigits(leftPage), getMultipliedOfDigits(leftPage));
        int rightPageValue = Math.max(getSumOfDigits(rightPage), getMultipliedOfDigits(rightPage));
        return Math.max(leftPageValue, rightPageValue);
    }
}