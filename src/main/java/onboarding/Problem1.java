package onboarding;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // pobi와 crong의 유효성 검사
        if (!validate(pobi) || !validate(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    // 책 페이지의 유효성 검사
    private static boolean validate(List<Integer> pages) {
        int left;
        int right;

        // 두 페이지 중에 null이 존재하면 invalid
        if ((pages.get(0) == null) || (pages.get(1) == null)) {
            return false;
        }

        left = pages.get(0);
        right = pages.get(1);

        // 왼쪽 페이지가 짝수이거나 오른쪽 페이지가 홀수이면 invalid
        if ((left % 2 == 0) || (right % 2 == 1)) {
            return false;
        }

        // 책의 시작 면이거나 마지막 면이 나오면 invalid
        if ((left == 1 || left == 399) && (right == 2 || right == 400)) {
            return false;
        }

        // 오른쪽 페이지와 왼쪽 페이지의 차이가 1이 아니면 invalid
        if (right - left != 1) {
            return false;
        }
        return true;
    }

    // 합 연산과 곱 연산 중 더 큰 숫자를 리턴
    private static int getLargerNumber(int page) {
        int sum = 0;
        int product = 1;
        int remain;

        while (page > 0) {
            remain = page % 10;
            sum += remain;
            product *= remain;
            page /= 10;
        }

        return Math.max(sum, product);
    }

    // 점수 획득
    private static int getScore(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        return Math.max(getLargerNumber(left), getLargerNumber(right));
    }
}