package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (checkInput(pobiLeft, pobiRight) || checkInput(crongLeft, crongRight)) // 하나라도 조건에 맞지 않으면 -1을 리턴함
            return -1;

    }

    private static boolean checkInput(int left, int right){
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

}