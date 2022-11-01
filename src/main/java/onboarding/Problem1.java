package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        String pobiLeft = String.valueOf(pobi.get(0));
        String pobiRight = String.valueOf(pobi.get(1));
        String crongLeft = String.valueOf(crong.get(0));
        String crongRight = String.valueOf(crong.get(1));

        int pobiLeftLen = pobiLeft.length();
        int pobiRightLen = pobiRight.length();
        int crongLeftLen = crongLeft.length();
        int crongRightLen = crongRight.length();

        if(Integer.parseInt(pobiLeft) != Integer.parseInt(pobiRight) - 1) return -1;
        if(Integer.parseInt(crongLeft) != Integer.parseInt(crongRight) - 1) return -1;

        int pobiLeftPlus = 0;
        int pobiLeftMulti = 1;
        for(int i = 0; i < pobiLeftLen; i++) {
            pobiLeftPlus += Integer.valueOf(pobiLeft.charAt(i)) - 48;
            pobiLeftMulti *= Integer.valueOf(pobiLeft.charAt(i)) - 48;
        }

        int pobiRightPlus = 0;
        int pobiRightMulti = 1;
        for(int i = 0; i < pobiRightLen; i++) {
            pobiRightPlus += Integer.valueOf(pobiRight.charAt(i)) - 48;
            pobiRightMulti *= Integer.valueOf(pobiRight.charAt(i)) - 48;
        }

        int crongLeftPlus = 0;
        int crongLeftMulti = 1;
        for(int i = 0; i < crongLeftLen; i++) {
            crongLeftPlus += Integer.valueOf(crongLeft.charAt(i)) - 48;
            crongLeftMulti *= Integer.valueOf(crongLeft.charAt(i)) - 48;
        }

        int crongRightPlus = 0;
        int crongRightMulti = 1;
        for(int i = 0; i < crongRightLen; i++) {
            crongRightPlus += Integer.valueOf(crongRight.charAt(i)) - 48;
            crongRightMulti *= Integer.valueOf(crongRight.charAt(i)) - 48;
        }

        int pobiMax = Math.max(Math.max(pobiLeftPlus, pobiLeftMulti), Math.max(pobiRightPlus, pobiRightMulti));
        int crongMax = Math.max(Math.max(crongLeftPlus, crongLeftMulti), Math.max(crongRightPlus, crongRightMulti));

        if(pobiMax > crongMax) answer = 1;
        else if(pobiMax < crongMax) answer = 2;
        else if(pobiMax == crongMax) answer = 0;
        else answer = -1;

        return answer;
    }
}