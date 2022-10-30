package onboarding;

import java.util.List;

/*
* 1. 입력값으로 유효하지 않은 값이 들어오면, -1을 반환한다.
* 2. 각 리스트 별로 (포비, 크롱에 대해서) 자리수를 모두 더한 값과, 모두 곱한 값을 구한다.
* 3. 구한 값 중 가장 큰 값을 저장한다. (pobiMax, cromgMax)
* 4. 두 값을 비교한다.
* 4-1. pobiMax가 크면 1을 반환한다.
* 4-2. 두 값이 같다면 0을 반환한다.
* 4-2.  crongMax가 크면 2를 반환한다.
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValid(pobi, crong)) return -1;

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        if (pobiMax > crongMax) return 1;
        if (pobiMax == crongMax) return 0;
        return 2;
    }

    private static int getMax(List<Integer> list) {
        int answer = -1;
        for (int i = 0; i < 2; i++) {
            answer = Math.max(answer, getSumofDigits(list.get(i)));
            answer = Math.max(answer, getSumofDigitsMultiplies(list.get(i)));
        }

        return answer;
    }

    private static int getSumofDigits(int n) {
        int answer = 0;

        for (int i = 0; i < Math.log10(n) + 1; i++) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    private static int getSumofDigitsMultiplies(int n) {
        int answer = 1;

        for (int i = 0; i < Math.log10(n) + 1; i++) {
            answer *= n % 10;
            n /= 10;
        }

        return answer;
    }

    public static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) return false;
        else if (pobi.get(1) > 400 || crong.get(1) > 400 || pobi.get(0) < 1 || crong.get(0) < 1) return false;

        return true;
    }
}