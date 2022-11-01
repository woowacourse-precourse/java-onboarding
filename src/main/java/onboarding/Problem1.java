package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validation(List<Integer> pages) {
        int pageOdd = pages.get(0);
        int pageEven = pages.get(1);
        if (pages.size() != 2) {
            return false;
        }
        if (pageOdd % 2 != 1 || pageEven % 2 != 0 || pageOdd + 1 != pageEven) {
            return false;
        }
        if (pageOdd <= 1 || pageOdd > 400 || pageEven < 1 || pageEven >= 400){
            return false;
        }
        return true;
    }

    public static int calcNumber(Integer page) {
        String strPage = String.valueOf(page);
        int mult = 1, sum = 0;

        for (int i = 0; i < strPage.length(); i++) {
            mult *= strPage.charAt(i) - '0';
            sum += strPage.charAt(i) - '0';
        }
        return Math.max(mult, sum);
    }

    public static int getScore(List<Integer> pages) {
        return Math.max(calcNumber(pages.get(0)), calcNumber(pages.get(1)));
    }

    public static int chooseWinner(List<Integer> pages1, List<Integer> pages2) {
        int score1 = getScore(pages1), score2 = getScore(pages2);
        try {
            if (!validation(pages1) || !validation(pages2)){
                return -1;
            }
            if (score1 > score2) {
                return 1;
            } else if (score1 < score2) {
                return 2;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        answer = chooseWinner(pobi, crong);

        return answer;
    }
}