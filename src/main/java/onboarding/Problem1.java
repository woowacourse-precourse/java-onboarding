package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외 처리
        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        } else if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            return -1;
        } else if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        } else if (pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400) {
            return -1;
        }

        int pobiScore = max(pobi);
        int crongScore = max(crong);

        if (pobiScore == crongScore) {
            return 0;
        } else if (compare(pobiScore, crongScore) == pobiScore) {
            return 1;
        } else if (compare(pobiScore, crongScore) == crongScore) {
            return 2;
        } else {
            return -1;
        }
    }

    // 각 자리수 더하기
    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // 각 자리수 곱하기
    public static int multiply(int n) {
        int multiply = 1;
        while (n > 0) {
            multiply *= n % 10;
            n /= 10;
        }
        return multiply;
    }

    // 큰 수 비교
    public static int compare(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 큰 수 구하기
    public static int max(List<Integer> numbers) {
        return compare(compare(sum(numbers.get(0)), multiply(numbers.get(0))), compare(sum(numbers.get(1)), multiply(numbers.get(1))));
    }
}