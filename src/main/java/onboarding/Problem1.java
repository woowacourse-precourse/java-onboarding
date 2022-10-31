package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        String pobiLeft= Integer.toString(pobi.get(0));
        String pobiRight= Integer.toString(pobi.get(1));
        String crongLeft= Integer.toString(crong.get(0));
        String crongRight= Integer.toString(crong.get(1));
        int pobiLeftSum= 0, pobiRightSum=0, crongLeftSum=0, crongRightSum=0;
        int pobiLeftProduct=1, pobiRightProduct=1, crongLeftProduct=1, crongRightProduct=1;
        for(int i=0;i<pobiLeft.length();i++){
            pobiLeftSum+=(pobiLeft.charAt(i)-'0');
            pobiLeftProduct*=(pobiLeft.charAt(i)-'0');
        }
        for(int i=0;i<pobiRight.length();i++){
            pobiRightSum+=(pobiRight.charAt(i)-'0');
            pobiRightProduct*=(pobiRight.charAt(i)-'0');
        }
        for(int i=0;i<crongLeft.length();i++){
            crongLeftSum+=(crongLeft.charAt(i)-'0');
            crongLeftProduct*=(crongLeft.charAt(i)-'0');
        }
        for(int i=0;i<crongRight.length();i++){
            crongRightSum+=(crongRight.charAt(i)-'0');
            crongRightProduct*=(crongRight.charAt(i)-'0');
        }

        int pobiLeftMax = (pobiLeftSum > pobiLeftProduct) ? pobiLeftSum : pobiLeftProduct;
        int pobiRightMax = (pobiRightSum > pobiRightProduct) ? pobiRightSum : pobiRightProduct;
        int crongLeftMax = (crongLeftSum > crongLeftProduct) ? crongLeftSum : crongLeftProduct;
        int crongRightMax= (crongRightSum > crongRightProduct) ? crongRightSum : crongRightProduct;
        int pobiMax = (pobiLeftMax > pobiRightMax) ? pobiLeftMax : pobiRightMax;
        int crongMax= (crongLeftMax > crongRightMax) ? crongLeftMax : crongRightMax;
        if(Math.abs(pobi.get(0)-pobi.get(1))!=1 || Math.abs(crong.get(0)-crong.get(1))!=1){
            answer=-1;
        }else {
            if(pobiMax>crongMax){
                answer=1;
            } else if (pobiMax<crongMax) {
                answer=2;
            } else if (pobiMax==crongMax) {
                answer=0;
            }
        }

        return answer;
    }
}

