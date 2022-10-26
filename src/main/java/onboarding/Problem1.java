package onboarding;

import java.util.List;

class Problem1 {
    public static void openBook(List<Integer> pages) {
        int randNum;
        for (int i = 0; i <= 1; i++) {
            randNum = pages.get(i);
            while (randNum == 1 || randNum == 400) {
                randNum = (int) (Math.random() * (399 - 2 + 1) + 2);
            }
            pages.set(i, randNum);
        }
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

    public static int getScore(List<Integer> pages){
        return Math.max(calcNumber(pages.get(0)), calcNumber(pages.get(1)));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        openBook(pobi);
        openBook(crong);


        return answer;
    }
}