package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if (isWrongPage(pobi, crong)) {
                throw new IllegalArgumentException();
            }

            int pMax = getMax(pobi);
            int cMax = getMax(crong);

            if (pMax == cMax) {
                return 0;
            } else if (pMax > cMax) {
                return 1;
            } else {
                return 2;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            int x = Math.max(plus(i), multiply(i));
            max = Math.max(max, x);
        }
        return max;
    }

    private static boolean isWrongPage(List<Integer> pobi, List<Integer> crong) {
        int p0 = pobi.get(0);
        int p1 = pobi.get(1);

        int c0 = crong.get(0);
        int c1 = crong.get(1);
        return p1 - p0 != 1 || c1 - c0 != 1
            || p0 <= 1 || 400 <= p0 || p1 <= 1 || 400 <= p1
            || c0 <= 1 || 400 <= c0 || c1 <= 1 || 400 <= c1;
    }

    private static int plus(int number) {
        String s = String.valueOf(number);
        int length = s.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return sum;
    }

    private static int multiply(int number) {
        String s = String.valueOf(number);
        int length = s.length();
        int mul = 1;

        for (int i = 0; i < length; i++) {
            mul *= Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return mul;
    }
}