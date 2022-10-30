package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiRight - pobiLeft != 1) {
            return -1;
        }
        if (crongRight - crongLeft != 1) {
            return -1;
        }

        int pobiLeftMax = max(pobiLeft);
        int pobiRightMax = max(pobiRight);
        int crongLeftMax = max(crongLeft);
        int crongRightMax = max(crongRight);

        int pobiMax = max(pobiLeftMax, pobiRightMax);
        int crongMax = max(crongLeftMax, crongRightMax);

        int winner = winner(pobiMax, crongMax);
        return winner;
    }

    private static int max(int n) {
        int addSum = 0;
        int multSum = 1;
        String pageNum = Integer.toString(n);

        for(int i=0; i<pageNum.length(); i++){
            addSum += Integer.parseInt(pageNum.substring(i, i+1));
            multSum *= Integer.parseInt(pageNum.substring(i, i+1));
        }

        if (multSum >= addSum){
            return multSum;
        } else {
            return addSum;
        }
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        else {
            return b;
        }
    }

    private static int winner(int a, int b) {
        if (a > b) {
            return 1;
        }
        else if (a < b){
            return 2;
        }
        else {
            return 0;
        }
    }
}