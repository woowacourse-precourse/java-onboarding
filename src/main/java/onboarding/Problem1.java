package onboarding;
/*
    기능 목록
    1. 각 자리수를 더하는 기능 -> getSum
    2. 각 자리수를 곱하는 기능 -> getMul
    3. 두 페이지의 각 자릿수에 1, 2를 적용한 후 Max값을 구하는 기능 -> getMax
    4. 리스트의 값이 유효한지 검사하는 기능 -> validation
 */
import java.util.List;
import java.lang.Math;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiVal;
        int crongVal;

        if (validation(pobi) || validation(crong))
            return -1;
        pobiVal = Math.max(getMax(pobi.get(0)), getMax(pobi.get(1)));
        crongVal = Math.max(getMax(crong.get(0)), getMax(crong.get(1)));
        if (pobiVal > crongVal)
            answer = 1;
        else if (pobiVal < crongVal)
            answer = 2;
        else answer = 0;
        return answer;
    }

    private static int getSum(int page) {
        int ret = 0;

        while (page > 0) {
            ret += page % 10;
            page /= 10;
        }
        return ret;
    }

    private static int getMul(int page) {
        int ret = 1;

        while (page > 0) {
            ret *= page % 10;
            page /= 10;
        }
        return ret;
    }

    private static int getMax(int page) { return Math.max(getSum(page), getMul(page)); }

    private static boolean validation(List<Integer> list) {
        if ((list.get(0) < 1 || list.get(0) > 399) || (list.get(1) < 2 || list.get(1) > 400))
            return true;
        else if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0)
            return true;
        else return list.get(1) - list.get(0) != 1;
    }
}