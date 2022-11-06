package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {

    // 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 페이지가 연속되지 않은 경우 예외처리
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        int pobiMax = max(plus(pobi.get(0)), plus(pobi.get(1)), multiply(pobi.get(0)), multiply(pobi.get(1)));
        int crongMax = max(plus(crong.get(0)), plus(crong.get(1)), multiply(crong.get(0)), multiply(crong.get(1)));

        if (pobiMax == crongMax) {
            return 0;
        } else if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return -1;
        }
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하는 함수
    public static int plus(int page) {
        String str = Integer.toString(page);
        String[] arr = str.split("");

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += Integer.parseInt(arr[i]);
        }

        return result;
    }

    // 페이지 번호의 각 자리 숫자를 모두 곱하는 함수
    public static int multiply(int page) {
        String str = Integer.toString(page);
        String[] arr = str.split("");

        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            result *= Integer.parseInt(arr[i]);
        }
        return result;
    }

    // 숫자를 비교해 큰 수를 구하는 함수
    public static int max(int one, int two, int three, int four) {
        int[] arr = {one, two, three, four};
        Arrays.sort(arr);

        int result = arr[3];
        return result;
    }
}