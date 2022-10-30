package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(1)-pobi.get(0)!=1 || pobi.get(1)%2==1 || crong.get(1)-crong.get(0)!=1 || crong.get(1)%2==1){
            answer=-1;
            return answer;
        }
        if(pobi.size()!=2 || crong.size()!=2){
            answer=-1;
            return answer;
        }

        String pobiLeft = pobi.get(0).toString();
        String pobiRight = pobi.get(1).toString();
        String crongLeft = crong.get(0).toString();
        String crongRight = crong.get(1).toString();

        Integer sumPL=0, mulPL=1, sumPR=0, mulPR=1;
        Integer sumCL=0, mulCL=1, sumCR=0, mulCR=1;
        for(int i=0;i<pobiLeft.length();i++){
            sumPL += pobiLeft.charAt(i) - '0';
            mulPL *= pobiLeft.charAt(i) - '0';
        }
        for(int i=0;i<pobiRight.length();i++){
            sumPR += pobiRight.charAt(i) - '0';
            mulPR *= pobiRight.charAt(i) - '0';
        }
        for(int i=0;i<crongLeft.length();i++){
            sumCL += crongLeft.charAt(i) - '0';
            mulCL *= crongLeft.charAt(i) - '0';
        }
        for(int i=0;i<crongRight.length();i++){
            sumCR += crongRight.charAt(i) - '0';
            mulCR *= crongRight.charAt(i) - '0';
        }

        Integer pobiMax = Math.max(Math.max(sumPL, mulPL), Math.max(sumPR, mulPR));
        Integer crongMax = Math.max(Math.max(sumCL, mulCL), Math.max(sumCR, mulCR));

        if(pobiMax==crongMax) answer=0;
        if(pobiMax>crongMax) answer=1;
        if(pobiMax<crongMax) answer=2;

        return answer;
    }
}