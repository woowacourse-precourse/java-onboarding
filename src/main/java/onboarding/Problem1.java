package onboarding;

import java.util.*;

/**
 * 기능목록 <br>
 * 1. 페이지는 1~400 페이지 중에 포함되어야 하고, 시작면(1페이지)나 마지막면(400페이지)가 나오지 않아야 하며,
 * 왼쪽이 홀수, 오른쪽이 짝수이고, 왼쪽과 오른쪽은 한페이지 차이가 나야한다. 이 외의 경우 예외상황 -1을 출력한다 <br>
 * 2. 각 자릿수를 더하는 메서드, 각 자릿수의 곲을 구하는 메서드를 포함한다. <br>
 * 3. 포비와 크롱의 페이지에의 최대값을 구한다 <br>
 * 4. 포비가 이기는 경우 1, 크롱이 이기면2, 비기면 0을 리턴한다. <br>
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //예외처리를 한다.
        if (isRangeException(pobi) || isRangeException(crong)) return -1;

        //각 사람의 max값을 리턴한다.
        int pobiMax = calculateMaxValue(pobi);
        int crongMax = calculateMaxValue(crong);

        //결과를 출력한다.
        return showResult(pobiMax, crongMax);
    }

    //포비가 이기는 경우 1, 크롱이 이기면2, 비기면 0을 리턴한다.
    private static int showResult(int first, int second) {
        if (first == second) return 0;
        else if (first < second) return 2;
        else return 1;
    }

    //오른쪽, 왼쪽페이지의 가장 큰 값을 계산한다
    private static int calculateMaxValue(List<Integer> list) {
        int leftMax = calculatePage(list.get(0));
        int rightMax = calculatePage(list.get(1));
        return Math.max(leftMax, rightMax);
    }

    //각 페이지의 max 값을 계산한다.
    private static int calculatePage(int num) {
        return Math.max(calculatePlusMax(num), calculateMultiplyMax(num));
    }

    //페이지의 각 숫자의 덧셈을 계산한다.
    private static int calculatePlusMax(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    //페이지의 각 숫자의 곲셈을 계산한다.
    private static int calculateMultiplyMax(int num) {
        int sum = 1;

        while (num > 0) {
            sum *= num % 10;
            num /= 10;
        }
        return sum;
    }

    //예외상황이 발생하면 true를 리턴한다.
    private static boolean isRangeException(List<Integer> list) {
        //페이지는 1~400페이지 안에 있어야함
        if (list.get(0) <= 0 || list.get(1) <= 0) return true;
        if (list.get(0) > 400 || list.get(1) > 400) return true;
        //첫면 마지막면은 안된다.
        if (list.get(0) == 1) return true;
        if (list.get(1) == 400) return true;
        //왼쪽이 홀수 오른쪽이 짝수 여야한다.
        if (list.get(0) % 2 != 1) return true;
        if (list.get(1) % 2 != 0) return true;
        //두 페이지는 한페이지 차이가 나야한다.
        if (list.get(0) + 1 != list.get(1)) return true;
        return false;
    }

}