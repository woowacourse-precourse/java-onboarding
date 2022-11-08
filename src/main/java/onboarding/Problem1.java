package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_max = Integer.MAX_VALUE;
        int crong_max = Integer.MAX_VALUE;

        if (!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }

        for (int i = 0; i < 2; i++) {

            pobi_max = Math.max(sum(pobi.get(i)), time(pobi.get(i)));
            crong_max = Math.max(sum(crong.get(i)), time(crong.get(i)));

        }

        if (pobi_max > crong_max) {
            answer = 1;
        } else if (pobi_max < crong_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }

        return answer;
    }

    public static boolean validatePage(List<Integer> pages) {
        if (pages.get(1) - pages.get(0) == 1) {
            return true;
        }
        return false;
    }

    public static int sum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static int time(int num) {
        int result = 1;
        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }
}