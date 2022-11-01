package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
         * 예외처리(왼쪽이 홀수가 아닌 경우, 오른쪽이 짝수가 아닌 경우
         * 연속적인 숫자가 아닌 경우, 0이나 400가 나온 경우)
         */
        if (exceptions(pobi) || exceptions(crong)) {
            return -1;
        }

        int pobiScore = Math.max(score(pobi.get(0)), score(pobi.get(1)));
        int crongScore = Math.max(score(crong.get(0)), score(crong.get(1)));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean exceptions(List<Integer> x) {
        // 왼쪽이 홀수가 아닌 경우
        if (x.get(0) % 2 == 0) {
            return true;
        }
        // 오른쪽이 짝수가 아닌 경우
        if (x.get(1) % 2 != 0) {
            return true;
        }
        // 연속적인 숫자가 아닌 경우
        if (x.get(0) + 1 != x.get(1)) {
            return true;
        }
        // 첫 페이지나 마지막 페이지가 나온 경우
        if (x.get(0) == 1 || x.get(1) == 400) {
            return true;
        }

        return false;
    }

    public static int score(int num) {
        int sum = 0;
        int multi = 1;

        int n = num;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        n = num;
        while (n > 0) {
            multi *= n % 10;
            n /= 10;
        }

        return Math.max(sum, multi);
    }
}