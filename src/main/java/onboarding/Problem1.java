package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isRightPage1GreaterThanLeftPage(List<Integer> pages) {
        return (pages.get(0) + 1 == pages.get(1));
    }

    public static boolean isLeftPageOddNumberAndRightPageEvenNumber(List<Integer> pages) {
        return (pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0);
    }

    public static boolean wrongPageNumber(List<Integer> pobi, List<Integer> crong) {
        if (!isRightPage1GreaterThanLeftPage(pobi)) return true;
        if (!isRightPage1GreaterThanLeftPage(crong)) return true;

        if (!isLeftPageOddNumberAndRightPageEvenNumber(pobi)) return true;
        if (!isLeftPageOddNumberAndRightPageEvenNumber(crong)) return true;

        return false;
    }

    public static int getMaximumScore(String page) {
       int sum = 0, mul = 1;
        for (int i = 0; i < page.length(); i++) {
            int x = page.charAt(i) - '0';
            sum += x;
            mul *= x;
        }
        return Math.max(sum, mul);
    }

    public static int judgeTheWinner(List<Integer> pobi, List<Integer> crong) {
        // pobi와 crong의 각 페이지를 String형으로 변환한다.
        String pobiLeftPage = String.valueOf(pobi.get(0));
        String pobiRightPage = String.valueOf(pobi.get(1));
        String crongLeftPage = String.valueOf(crong.get(0));
        String crongRightPage = String.valueOf(crong.get(1));

        // pobi와 crong의 각 점수들을 계산한다.
        int pobiScore = getMaximumScore(pobiLeftPage);
        pobiScore = Math.max(pobiScore, getMaximumScore(pobiRightPage));
        int crongScore = getMaximumScore(crongLeftPage);
        crongScore = Math.max(crongScore, getMaximumScore(crongRightPage));

        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (wrongPageNumber(pobi, crong)) return -1;

        int answer = judgeTheWinner(pobi, crong);
        return answer;
    }
}