package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        // 입력 예외처리
        if (checkInput(pobiLeft, pobiRight) || checkInput(crongLeft, crongRight)) // 하나라도 조건에 맞지 않으면 -1을 리턴함
            return -1;

        return getResult(pobiLeft, pobiRight, crongLeft, crongRight);

    }

    static boolean checkInput(int left, int right){
        if (left < 1 || left > 400 || right < 1 || right > 400) //1 ~ 400 외의 범위일 경우
            return true;
        if (left + 1 != right) // 왼쪽 페이지 + 1 = 오른쪽 페이지 가 아닐 경우
            return true;
        return left % 2 != 1; // 왼쪽 페이지가 홀수가 아닐 경우
    }

    static int add(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    static int multiply(int num) {
        int result = 1;
        while (num > 0) {
            result *= (num % 10);
            num /= 10;
        }
        return result;
    }

    static int getMax(List<Integer> scores) {
        int max = Integer.MIN_VALUE;
        for (Integer score : scores)
            if (max < score) max = score;
        return max;
    }

    static int getResult(int l1, int r1, int l2, int r2) {
        // 각 자릿수의 곱, 합 중 가장 큰 값을 구함
        int Max1 = getMax(List.of(add(l1), add(r1), multiply(l1), multiply(r1)));
        int Max2 = getMax(List.of(add(l2), add(r2), multiply(l2), multiply(r2)));

        // 비교
        if (Max1 > Max2)
            return 1;
        else if (Max1 < Max2)
            return 2;
        else
            return 0;
    }

}