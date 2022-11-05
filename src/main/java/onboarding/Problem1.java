package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        int pobi_first = pobi.get(0);
        int pobi_second = pobi.get(1);
        int pobiLeftSum = 0, pobiLeftMul = 1;
        int pobiRightSum = 0, pobiRightMul = 1;

        int pobiMax = 0;

        if(pobi_first % 2 != 1 || pobi_second %2 != 0 || pobi_second - pobi_first != 1){
            return -1;
        }

        while(pobi_first > 0){
            pobiLeftSum += pobi_first%10;
            pobiLeftMul *= pobi_first%10;
            pobi_first /= 10;
        }

        while(pobi_second > 0){
            pobiRightSum += pobi_second%10;
            pobiRightMul *= pobi_second%10;
            pobi_second /= 10;
        }

        if(pobiLeftSum > pobiMax){
            pobiMax = pobiLeftSum;
        }

        if(pobiLeftMul > pobiMax){
            pobiMax = pobiLeftMul;
        }

        if(pobiRightSum > pobiMax){
            pobiMax = pobiRightSum;
        }

        if(pobiRightMul > pobiMax){
            pobiMax = pobiRightMul;
        }

        int crong_first = crong.get(0);
        int crong_second = crong.get(1);
        int crongLeftSum = 0, crongLeftMul = 1;
        int crongRightSum = 0, crongRightMul = 1;

        int crongMax = 0;

        if(crong_first % 2 != 1 || crong_second %2 != 0 || crong_second - crong_first != 1){
            return -1;
        }
        while(crong_first > 0){
            crongLeftSum += crong_first%10;
            crongLeftMul *= crong_first%10;
            crong_first /= 10;
        }

        while(crong_second > 0){
            crongRightSum += crong_second%10;
            crongRightMul *= crong_second%10;
            crong_second /= 10;
        }

        if(crongLeftSum > crongMax){
            crongMax = crongLeftSum;
        }

        if(crongLeftMul > crongMax){
            crongMax = crongLeftMul;
        }

        if(crongRightSum > crongMax){
            crongMax = crongRightSum;
        }

        if(crongRightMul > crongMax){
            crongMax = crongRightMul;
        }

        if(pobiMax > crongMax){
            answer = 1;
        }
        else if(pobiMax < crongMax){
            answer = 2;
        }
        else{
            answer = 0;
        }

        return answer;
    }
}