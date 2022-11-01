package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean validation1 = valid(pobi);
        boolean validation2 = valid(crong);

        if (validation1 || validation2) {
            return -1;
        }

        int pobiMax = getMaximum(pobi);
        int crongMax = getMaximum(crong);


        int answer = getWinner(pobiMax, crongMax);

        return answer;
    }

    private static boolean valid(List<Integer> pobi) {
        if (pobi.get(1) >= 400 || pobi.get(0) < 1) {
            return true;
        }
        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1) {
            return true;
        }
        if (pobi.get(1) - pobi.get(0) != 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int getMaximum(List<Integer> numbers) {
        char[] left = String.valueOf(numbers.get(0)).toCharArray();
        char[] right = String.valueOf(numbers.get(0)).toCharArray();

        int sum_left = 0;
        int sum_right = 0;
        int multiple_left = 1;
        int multiple_right = 1;

        for (char p : left) {
            sum_left += Character.getNumericValue(p);
            multiple_left *= Character.getNumericValue(p);
        }
        for (char p : right) {
            sum_right += Character.getNumericValue(p);
            multiple_right *= Character.getNumericValue(p);
        }
        int sum_max = Math.max(sum_left, sum_right);
        int multi_max = Math.max(multiple_left, multiple_right);

        return Math.max(sum_max, multi_max);
    }

}