package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePage(pobi);
            validatePage(crong);

            int pobi_score = 0;
            int crong_score = 0;


            for (int i = 0; i < 2; i++) {
                pobi_score = max(pobi_score, getPageGameScore(pobi.get(i)));
                crong_score = max(crong_score, getPageGameScore(crong.get(i)));
            }

            int result;

            if (pobi_score > crong_score) {
                result = 1;

            } else if (pobi_score < crong_score) {
                result = 2;

            } else {
                result = 0;
            }

            return result;

        } catch (IllegalArgumentException e) {
            return -1;
        }

    }

    public static int getPageGameScore(int page) {

        String p = String.valueOf(page);

        int sum = 0;
        int product = 1;

        for (int digit = 0; digit < p.length(); digit++) {
            int curr = Character.getNumericValue(p.charAt(digit));
            sum += curr;
            product *= curr;
        }
        return max(sum, product);
    }

    public static void validatePage(List<Integer> pages) throws IllegalArgumentException {
        if ((pages.get(0) == null) ||
                (pages.get(1) == null) ||
                (pages.get(1) - pages.get(0) != 1) ||
                (pages.get(0) % 2 != 1) ||
                (pages.get(1) % 2 != 0)) {
            throw new IllegalArgumentException();
        }
    }

}
