package onboarding;

import java.util.List;

class Problem1 {

    public static boolean isPage(int left, int right) {
        if (left < 1 || left > 400 || right < 1 || right > 400) {
            return false;
        }
        if (left % 2 != 1) {
            return false;
        }
        if (left + 1 != right) {
            return false;
        }
        return true;
    }

    public static int getMax(int page) {
        int add = 0;
        int mult = 1;
        while (page != 0) {
            int i = page % 10;
            add += i;
            mult *= i;
            page /= 10;
        }
        return Math.max(add, mult);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        int pobiScore = 0;
        int crongScore = 0;

        /*
        예외 케이스 처리:
        1. 페이지가 1 이상 400 이하가 아닌 경우
        2. 왼쪽 페이지가 홀수 오른쪽 페이지가 짝수가 아닌 경우
        3. 오른쪽 페이지가 왼쪽 페이지보다 1페이지 이후가 아닌 경우 (2번의 경우 왼쪽 페이지 홀수 여부 확인 후,
        오른쪽 페이지 == 왼쪽 + 1 인지 확인
         */
        if (!isPage(pobiLeft, pobiRight) || !isPage(crongLeft, crongRight)) {
            return -1;
        }
        pobiScore = Math.max(getMax(pobiLeft), getMax(pobiRight));
        crongScore = Math.max(getMax(crongLeft), getMax(crongRight));
        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        return 2;
    }
}