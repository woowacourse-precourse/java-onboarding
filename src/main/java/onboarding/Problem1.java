package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외사항
        if (exception(pobi) == false || exception(crong) == false) {
            return -1;
        }

        int pobiMax = Math.max(mulMax(pobi), addMax(pobi));
        int crongMax = Math.max(mulMax(crong), addMax(crong));

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean exception(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        // 페이지 범위 조건
        if (left <= 1 || left >= 400 || right <= 1 || right >= 400) {
            return false;
        }
        // 페이지 순서 조건
        if (right - left != 1) {
            return false;
        }

        return true;
    }

    public static int addMax(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        return Math.max(subAdd(left), subAdd(right));
    }

    public static int subAdd(int num) {

        int tmp = num;
        int cnt = 0;
        int result = 0;

        while (tmp != 0) {
            result += tmp % 10;
            tmp /= 10;
            cnt++;
        }

        return result;
    }

    public static int mulMax(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        return Math.max(subMul(left), subMul(right));
    }

    public static int subMul(int num) {
        int tmp = num;

        List<Integer> list = new ArrayList<>();
        int result = 1;
        int cnt = 0;

        while (tmp != 0) {
            result *= tmp % 10;
            list.add(tmp % 10);
            tmp /= 10;
            cnt++;
        }

        return result;
    }

}