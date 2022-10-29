package onboarding;

import java.util.List;
import java.lang.Math;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        boolean pobiValid = (pobi.get(1) - pobi.get(0) == 1) && (pobi.get(0) % 2 == 1); // pobiValid: 왼쪽 페이지 번호와 오른쪽 페이지 번호가 연속된 숫자이면서, 왼쪽페이지가 홀수라면 true
        boolean crongValid = (crong.get(1) - crong.get(0) == 1) && (crong.get(0) % 2 == 1); // crongValid: 왼쪽 페이지 번호와 오른쪽 페이지 번호가 연속된 숫자이면서, 왼쪽페이지가 홀수라면 true

        /* pobi 또는 crong 중 유효하지 않은 것이 있다면 예외사항 발생 */
        if (!(pobiValid && crongValid)) {
            answer = -1;
        } else {
            if (getScore(pobi.get(0), pobi.get(1)) > getScore(crong.get(0), crong.get(1))) {
                answer = 1; // 포비가 이기는 경우
            } else if (getScore(pobi.get(0), pobi.get(1)) < getScore(crong.get(0), crong.get(1))) {
                answer = 2; // 크롱이 이기는 경우
            } else {
                answer = 0; // 무승부인 경우
            }
        }

        return answer;
    }

    /**
     * 인수로 주어진 숫자의 각 자리수를 더해서 반환하는 함수
     */
    public static int addEachDigit(int number) {
        int result = 0;

        while (number > 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    /**
     * 인수로 주어진 숫자의 각 자리수를 곱해서 반환하는 함수
     */
    public static int multiplyEachDigit(int number) {
        int result = 1;

        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }

    /**
     * 왼쪽 페이지번호와 오른쪽 페이지번호를 인자로 전달받아 점수를 계산하는 함수
     */
    public static int getScore(int leftPage, int rightPage) {
        int leftPageAdded = addEachDigit(leftPage);
        int leftPageMultiplied = multiplyEachDigit(leftPage);
        int rightPageAdded = addEachDigit(rightPage);
        int rightPageMultiplied = multiplyEachDigit(rightPage);

        int leftPageScore = Math.max(leftPageAdded, leftPageMultiplied);
        int rightPageScore = Math.max(rightPageAdded, rightPageMultiplied);

        return Math.max(leftPageScore, rightPageScore);
    }
}