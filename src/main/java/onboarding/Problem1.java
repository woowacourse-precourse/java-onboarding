package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        int pobiLeftMax = Math.max(plus(pobiLeft), mul(pobiLeft));
        int pobiRightMax = Math.max(plus(pobiRight), mul(pobiRight));
        int pobiMax = Math.max(pobiLeftMax,pobiRightMax);
        int crongLeftMax = Math.max(plus(crongLeft), mul(crongLeft));
        int crongRightMax = Math.max(plus(crongRight), mul(crongRight));
        int crongMax = Math.max(crongLeftMax,crongRightMax);
        
        if(pobiMax > crongMax) {
            answer = 1;
        }
        else if(pobiMax < crongMax) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }

    public static int plus(int page) {

        int plusResult = 0;

        String pageString = Integer.toString(page);
        String[] stringArray = pageString.split("");

        for(int i = 0; i < stringArray.length; i++) {
            plusResult += Integer.parseInt(stringArray[i]);
        }

        return plusResult;
    }

    public static int mul(int page) {

        int mulResult = 1;

        String pageString = Integer.toString(page);
        String[] stringArray = pageString.split("");

        for(int i = 0; i < stringArray.length; i++) {
            mulResult *= Integer.parseInt(stringArray[i]);
        }

        return mulResult;
    }

}