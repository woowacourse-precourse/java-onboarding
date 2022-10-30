package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1)-pobi.get(0) != 1) {
            return -1;
        }
        if (crong.get(1)-crong.get(0) != 1) {
            return -1;
        }

        int pobiLeftMax =max(pobi.get(0));
        int pobiRightMax =max(pobi.get(1));
        int crongLeftMax =max(pobi.get(0));
        int crongRightMax =max(pobi.get(1));

        int pobiMax =max(pobiLeftMax, pobiRightMax);
        int crongMax =max(crongLeftMax, crongRightMax);

        int winner =winner(pobiMax,crongMax);
        return winner;
    }

    private static int max(int n) {
        int addSum = 0;
        int multSum = 0;
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