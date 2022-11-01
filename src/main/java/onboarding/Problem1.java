package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int MOD_NUMBER = 10;
    private static final String OPER_PLUS = "plus";
    private static final String OPER_MULTIPLY = "multiply";

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotAvailable(pobi) || isNotAvailable(crong)) { //둘 중 하나라도 NotAvailable 하다면 return -1
            return -1;
        }
        int pobi_max = getMax(pobi);
        int crong_max = getMax(crong);

        return getWinner(pobi_max, crong_max);
    }

    private static int getWinner(int pobi_max, int crong_max) {
        if (pobi_max > crong_max) {
            return 1;
        }
        else if (pobi_max < crong_max) {
            return 2;
        }
        else { //pobi_max == crong_max
            return 0;
        }
    }

    // 포비와 크롱의 Max를 구하는 메소드
    private static int getMax(List<Integer> pageList) {
        int max = Integer.MIN_VALUE;
        for (Integer pageNumber : pageList) {
            int sum = operatePage(pageNumber, OPER_PLUS);
            if (sum > max) {
                max = sum;
            }

            int multiple = operatePage(pageNumber, OPER_MULTIPLY);
            if (multiple > max) {
                max = multiple;
            }
        }
        return max;
    }

    private static int operatePage(int pageNumber, String operator) {
        int result = initNumber(operator);

        while(pageNumber / MOD_NUMBER != 0) {
            int rest = pageNumber % MOD_NUMBER;
            pageNumber /= MOD_NUMBER;

            result = calculation(result, rest, operator);
        }
        result = calculation(result, pageNumber, operator);

        return result;
    }

    private static int initNumber(String cal) {
        if (cal == OPER_MULTIPLY) {
            return 1;
        }
        return 0; //OPER_PLUS
    }
    private static int calculation(int result, int rest, String cal) {
        if (cal == OPER_MULTIPLY) {
            return result * rest;
        }
        return result + rest;//OPER_PLUS
    }

    //Available하고 NotAvailable을 두 개 만든건, !isAvailable 보다 isNotAvailable이 더 명확할 것 같아서쓴다.
    private static boolean isNotAvailable(List<Integer> list) {
        return !isAvailable(list);
    }
    private static boolean isAvailable(List<Integer> list) {
        //==제한 사항에 담겨 있는 것들 ==//
        if (list.size() != 2) { //리스트의 사이즈가 2가 아니라면, false
            return false;
        }
        if (list.get(0) % 2 != 1) { //0번 인덱스(왼쪽페이지)가 홀수가 아니라면, false
            return false;
        }
        if (list.get(1) % 2 != 0) { //1번 인덱스(오른쪽페이지)가 짝수가 아니라면, false
            return false;
        }
        if (list.get(0) == 1) { //시작 면은 나와서는 안된다.
            return false;
        }
        if (list.get(1) == 400) { //마지막 면이 나와서는 안된다.
            return false;
        }
        if (list.get(1) - list.get(0) != 1) { //홀수 짝수의 연속된 페이지가 아니라면
            return false;
        }

        return true;
    }
}