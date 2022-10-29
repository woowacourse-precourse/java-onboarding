package onboarding;

import java.util.List;

/**
 * 책을 임의로 펼친다.
 * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다.
 */

class Problem1 {
    private static int calculator(int val) {
        int divTotal = 0;
        int mulTotal = 1;

        while (val != 0) {
            divTotal += val % 10;
            mulTotal *= val % 10;
            val /= 10;
        }
        return Math.max(divTotal, mulTotal);
    }

    private static int exception(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == 1 || pobi.get(1) == 400
                || crong.get(0) == 1 || crong.get(1) == 400) {
            return -1;
        }
        //책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호.
        else if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 != 0
                || crong.get(0) % 2 == 0 || crong.get(1) % 2 != 0) {
            return -1;
        }
        //왼쪽 / 오른쪽 책 페이지가 1만큼 차이가 나야함.
        else if (pobi.get(1) - pobi.get(0) != 1
                || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        return 0;
    }

    private static int calculatorMaxValue(List<Integer> user) {
        int leftResultUserValue = calculator(user.get(0));
        int rightResultUserValue = calculator(user.get(1));

        return Math.max(leftResultUserValue, rightResultUserValue);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        int exception = exception(pobi, crong);
        if (exception == 0) {


            if (pobiMax > crongMax)
                return 1;
            else if (pobiMax < crongMax)
                return 2;
            else
                return 0;
        } return exception;
    }
}