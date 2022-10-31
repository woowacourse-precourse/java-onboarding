package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        if (pobi.get(0) < 3 || pobi.get(0) >= 399 || crong.get(0) < 3 || crong.get(0) >= 399) {
            return -1;
        }

        int pobiSocre = getScore(pobi), crongScore = getScore(crong);
        if (pobiSocre == crongScore) {
            return 0;
        } else {
            return pobiSocre > crongScore ? 1 : 2;
        }
    }

    private static int getScore(List<Integer> player) {
        int added, multiplied, score = 0;
        String pageString;

        for (int page : player) {
            added = 0;
            multiplied = 1;
            pageString = page + "";
            for (int i = 0; i < pageString.length(); i++) {
                added += Character.getNumericValue(pageString.charAt(i));
                multiplied *= Character.getNumericValue(pageString.charAt(i));
            }
            score = Math.max(score, Math.max(added, multiplied));
        }
        return score;
    }
}