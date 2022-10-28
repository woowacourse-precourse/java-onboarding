package onboarding;
/*
    기능 목록
    1. 각 자리수를 더하는 기능 -> getSum
    2. 각 자리수를 곱하는 기능 -> getMul
    3. 두 페이지의 각 자릿수에 1, 2를 적용한 후 Max값을 구하는 기능 -> getMax
 */
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getSum(int page) {
        int ret = 0;

        while(page > 0) {
            ret += page % 10;
            page /= 10;
        }
        return ret;
    }

    private static int getMul(int page) {
        int ret = 1;

        while(page > 0) {
            ret *= page % 10;
            page /= 10;
        }
        return ret;
    }
}