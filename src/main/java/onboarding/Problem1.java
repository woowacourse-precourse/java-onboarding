package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = pobiMax(pobi);
        int crong_max = crongMax(crong);

        if (!(exception(crong) && exception(pobi))) {
            answer = -1;
            return answer;
        }

        if (pobi_max > crong_max) {
            answer = 1;
        } else if (crong_max < pobi_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }

        return answer;

    }

    public static boolean exception(List<Integer> judge) { // 예외 처리 기능
        int left = judge.get(0);
        int right = judge.get(1);
        if (Math.abs(right - left) > 1) { // 입력으로 연속된 페이지가 아닐 경우 예외 처리
            return false;
        } else if (right == 400 || left == 1) { // 펼쳤을때 첫 페이지, 끝 페이지 나올 경우 예외 처리
            return false;
        }
        return true;
    }

    public static int pobiMax(List<Integer> pobi) {  // pobi의 값중 가장 큰 값 찾기

        int left_max = divideNum(pobi.get(0));
        int right_max = divideNum(pobi.get(1));

        return Math.max(left_max, right_max);
    }

    public static int crongMax(List<Integer> crong) {  // crong의 값중 가장 큰 값 찾기
        int left_max = divideNum(crong.get(0));
        int right_max = divideNum(crong.get(1));

        return Math.max(left_max, right_max);
    }

    public static int divideNum(Integer x) { // 각 자릿수 별로 나누고, 더한것이 가장 큰지 곱한 것이 가장 큰지 비교
        int addSum = 0;
        int mulSum = 1;
        while (x > 0) {
            addSum += x % 10;
            mulSum *= x % 10;
            x /= 10;
        }

        int max = Math.max(addSum, mulSum);
        return max;
    }

}