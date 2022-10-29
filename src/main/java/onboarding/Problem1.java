package onboarding;

import java.util.List;

class Problem1 {
    private static final int length = 2;
    private static final int minPage = 3;
    private static final int maxPage = 398;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }
        return match(getScore(pobi), getScore(crong));
    }

    private static int match(int pobiScore, int crongScore) {
        if(pobiScore > crongScore) {
            return 1;
        }
        if(pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int getScore(List<Integer> pages) {
        int maxScore = 0;
        for (Integer page : pages) {
            maxScore = Math.max(maxScore, addEachDigits(page));
            maxScore = Math.max(maxScore, multiplyEachDigits(page));
        }
        return maxScore;
    }

    private static int addEachDigits(int page) {
        int score = 0;
        String pageAsStr = String.valueOf(page);
        for (int i = 0; i < pageAsStr.length(); i++) {
            score += pageAsStr.charAt(i) - '0';
        }
        return score;
    }

    private static int multiplyEachDigits(int page) {
        int score = 1;
        String pageAsStr = String.valueOf(page);
        for (int i = 0; i < pageAsStr.length(); i++) {
            score *= pageAsStr.charAt(i) - '0';
        }
        return score;
    }

    private static boolean validatePage(List<Integer> pages) {
        int leftIdx = 0;
        int rightIdx = 1;

        if(pages.size() != length) {
            return false;
        }
        if(!pageInRange(pages)) {
            return false;
        }
        if(pages.get(leftIdx) % 2 == 0 || pages.get(rightIdx) % 2 != 0) {
            return false;
        }
        return pages.get(leftIdx) + 1 == pages.get(rightIdx);
    }

    private static boolean pageInRange(List<Integer> pages) {
        return pages.stream()
            .allMatch(page -> page >= minPage && page <= maxPage);
    }
}