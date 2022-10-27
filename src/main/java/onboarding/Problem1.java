package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1
        || pobi.get(0) < 1 || pobi.get(0) > 400 || pobi.get(1) < 1 || pobi.get(1) > 400
        || crong.get(0) < 1 || crong.get(0) > 400 || crong.get(1) < 1 || crong.get(1) > 400
        || pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;

        int pobi_left_max = getPageMax(pobi.get(0)); // 왼쪽페이지 곱 or 합
        int pobi_right_max = getPageMax(pobi.get(1)); // 오른쪽 페이지 곱 or 합
        int pobi_max = Math.max(pobi_left_max, pobi_right_max);

        int crong_left_max = getPageMax(crong.get(0)); // 왼쪽페이지 곱 or 합
        int crong_right_max = getPageMax(crong.get(1)); // 오른쪽 페이지 곱 or 합
        int crong_max = Math.max(crong_left_max, crong_right_max);

        if (pobi_max > crong_max) {
            answer = 1;
        } else if (pobi_max < crong_max) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static int getPageMax(int pageNum) {
        int one = pageNum % 10;
        int ten = pageNum % 100 - one;
        int hun = pageNum / 100;

        int sum = one + ten + hun;
        int mul = 0;
        if (hun == 0) {
            mul = one * ten;
        } else {
            mul = one * ten * hun;
        }

        return Math.max(sum, mul);
    }
}