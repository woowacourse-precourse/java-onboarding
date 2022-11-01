package onboarding;

import java.util.List;

public class Problem1 {
    // [121, 122] , [211, 212]
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getAnwserValueTwoList(pobi, crong);
        return answer;
    }

    private static int getAnwserValueTwoList(List<Integer> ListOne, List<Integer> ListTwo) {
        int left = 0;
        int right = 1;
        if (isException(ListOne) || isException(ListTwo)) {
            return -1;
        }
        int ListOneValueMax = getMaxTwoIntValue(ListOne.get(left), ListOne.get(right));
        int ListTwoValueMax = getMaxTwoIntValue(ListTwo.get(left), ListTwo.get(right));

        if (ListOneValueMax == ListTwoValueMax) {
            return 0;
        } else if (ListOneValueMax > 0) {
            return 1;
        } else {
            return 2;
        }
    }

    // 2개의 값중 큰값을 리턴한다.
    private static int getMaxTwoIntValue(Integer valueOne, Integer valueTwo) {
        int getLeftMaxValue = getMaxSeatIntValue(valueOne);
        int getRightMaxValue = getMaxSeatIntValue(valueTwo);
        return Math.max(getLeftMaxValue, getRightMaxValue);
    }

    // num의 자릿수를 가져와서 더하고, 곱한값의 최댓값을 가져온다.
    private static int getMaxSeatIntValue(Integer num) {
        int hundSeat = num / 100;
        int tenSeat = num / 10 % 10;
        int oneSeat = num % 10;

        int sum = hundSeat + tenSeat + oneSeat;
        int multiple = 0;

        if (hundSeat != 0) {
            multiple = hundSeat * tenSeat * oneSeat;
        } else {
            multiple = tenSeat * oneSeat;
        }

        if (sum > multiple) {
            return sum;
        } else {
            return multiple;
        }
    }

    private static boolean isException(List<Integer> list) {
        // 범위를 넘었는가 검사
        if (list.get(0) < 1 || list.get(0) > 400 || list.get(1) < 1 || list.get(1) > 400) {
            return true;
        }
        // left가 홀수인가, right가 짝수인가
        else if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return true;
        }
        // left와 right가 연달아 있는가
        else if (list.get(1) - list.get(0) != 1) {
            return true;
        } else {
            return false;
        }
    }
}