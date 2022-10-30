package onboarding;

import java.util.List;

class Problem1 {
    public static int score(int odd) {

        int sum = 0;
        int multi = 1;
        while (odd > 0) {
            sum = sum + odd % 10;
            multi = multi * (odd % 10);
            odd = odd / 10;
        }
        if (sum > multi) {
            return sum;
        } else {
            return multi;
        }
    }

    public static int compare(int p1, int p2) {
        if (p1 > p2) {
            return 1;
        } else if (p1 < p2) {
            return 2;
        }

        return 0;
    }

    public static boolean exceptional(int odd, int even) {
        if (odd <= 1 || even >= 400) return true;
        if (odd + 1 != even) return true;
        if (odd % 2 != 1) return true;

        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // int answer = Integer.MAX_VALUE;

        int pobi_odd = pobi.get(0);
        int pobi_even = pobi.get(1);
        int crong_odd = crong.get(0);
        int crong_even = crong.get(1); //각 리스트로부터 점수 get

        if (exceptional(pobi_odd, pobi_even) || exceptional(crong_odd, crong_even)) {
            return -1;
        } //예외 조건 처리

        int result = compare(score(pobi_odd), score(crong_odd));
        return result;
    }
}