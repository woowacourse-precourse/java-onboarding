package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMaxScore = Integer.MIN_VALUE;
        int crongMaxScore = Integer.MIN_VALUE;


        if (checkInputCondition(pobi) && checkInputCondition(crong)) {
            pobiMaxScore = Math.max(getMaxValue(pobi.get(0)), getMaxValue(pobi.get(1)));
            crongMaxScore = Math.max(getMaxValue(crong.get(0)), getMaxValue(crong.get(1)));

            answer = getWinner(pobiMaxScore, crongMaxScore);
        } else answer = -1;

        return answer;
    }

    private static int getMaxValue(int pageNum){
        String strPage = String.valueOf(pageNum);
        int pageLength = strPage.length();
        int sumValue = 0;
        int multiplyValue = Integer.parseInt(String.valueOf(strPage.charAt(0)));

        for (int i = 0; i < pageLength; i++) {
            sumValue += Integer.parseInt(String.valueOf(strPage.charAt(i)));
        }

        for (int i = 1; i < pageLength; i++) {
            multiplyValue *= Integer.parseInt(String.valueOf(strPage.charAt(i)));
        }

        return Math.max(sumValue, multiplyValue);
    }

    private static int getWinner(int pobiScore, int crongScore){
        if (pobiScore > crongScore) {
            return 1;
        } else if (crongScore > pobiScore) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean checkInputCondition(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (rightPage - leftPage != 1) {
            return false;
        }else return true;
    }
}