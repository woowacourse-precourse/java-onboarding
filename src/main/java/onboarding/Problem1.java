package onboarding;

import java.util.List;

/**
 * 1.검증 요소
 * 왼쪽 페이지는 홀수
 * 오른쪽 페이지는 짝수
 * 두 페이지의 차는 항상 1
 * 왼쪽이 오른쪽 보다 커야함
 * 페이지의 범위는 1부터 400
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (inputValidator(pobi) != 5 || inputValidator(crong) != 5) {
            return -1;
        }

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        int pobiScore = Math.max(getScore(pobiLeft), getScore(pobiRight));
        int crongScore = Math.max(getScore(crongLeft), getScore(crongRight));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int getScore(int page) {

        int summationScore = 0;
        int multiplicationScore = 1;

        while (page > 0) {
            int digit = page % 10;
            summationScore += digit;
            multiplicationScore *= digit;
            page /= 10;
        }
        return  Math.max(summationScore, multiplicationScore);
    }

    public static int inputValidator(List<Integer> input) {
        if ((input.get(1) - input.get(0) != 1 || input.get(0) % 2 != 1)) {
            return 3;
        }
        if (input.get(0) < 1 || input.get(1) > 400) {
            return 4;
        }
        return 5;
    }



}