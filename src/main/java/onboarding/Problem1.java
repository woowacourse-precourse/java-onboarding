package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;


class Problem1 {
    public static final int TIE = 0;
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result;

        List<List<Integer>> participants_pages = new ArrayList<>();
        participants_pages.add(pobi);
        participants_pages.add(crong);

        try {

            for (List<Integer> pages : participants_pages) {
                validatePages(pages);
            }

            List<Integer> scores = getParticipantsScores(participants_pages);

            result = 0;
        } catch (IllegalArgumentException e) {
            result = EXCEPTION;
        }

        return result;

    }

    public static void validatePages(List<Integer> pages) throws IllegalArgumentException {
        if ((pages.get(0) == null) || (pages.get(1) == null)) {
            throw new IllegalArgumentException("시작면이나 마지막면입니다");
        }

        if ((pages.get(0) % 2 != 1) || (pages.get(1) % 2 != 0)) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 합니다");
        }

        if (pages.get(1) - pages.get(0) != 1) {
            throw new IllegalArgumentException("연속된 페이지가 아닙니다");
        }

        if (pages.get(0) < 1 || pages.get(0) > 400 || pages.get(1) < 1 || pages.get(1) > 400) {
            throw new IllegalArgumentException("1 ~ 400 사이의 페이지만 선택 가능합니다");
        }
    }

    public static List<Integer> getParticipantsScores(List<List<Integer>> participants_pages) {
        List<Integer> scores = new ArrayList<>();

        for (List<Integer> page : participants_pages) {
            scores.add(getPageGameScore(page));
        }

        return scores;
    }

    public static int getPageGameScore(List<Integer> pages) {
        int leftPageScore = getPageGameScore(pages.get(0));
        int rightPageScore = getPageGameScore(pages.get(1));

        return max(leftPageScore, rightPageScore);
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

}
