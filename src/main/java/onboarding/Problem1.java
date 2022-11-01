package onboarding;

import java.util.List;

class Problem1 {
    private int digitSum(int num){
        int units = num % 10;
        int tens = num % 100 / 10;
        int hundreds = num / 100;
        return units + tens + hundreds;
    }
    private int digitProd(int num){
        int units = num % 10;
        int tens = num % 100 / 10;
        int hundreds = num / 100;
        if(hundreds == 0){
            if(tens == 0){ //1자리수
                return units;
            } else{ //2자리수
                return units*tens;
            }
        } else{ //3자리수
            return units*tens*hundreds;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /* 예외사항을 처리한다. */
        if(pobi == null || crong == null)
            return -1;
        if(pobi.size() != 2 || crong.size() != 2)
            return -1;
        if(pobi.get(0) == null || pobi.get(1) == null || crong.get(0) == null || crong.get(1) == null)
            return -1;
        int pobiLeft = pobi.get(0), pobiRight = pobi.get(1);
        int crongLeft = crong.get(0), crongRight = crong.get(1);
        if(pobiLeft != pobiRight - 1 || crongLeft != crongRight -1)
            return -1;
        if(pobiLeft % 2 != 1 || crongLeft % 2 != 1)
            return -1;
        if(pobiLeft <= 1 || crongLeft <= 1 || pobiLeft >= 399 || crongLeft >= 399)
            return -1;

        Problem1 p1 = new Problem1();
        int pobiMax = Math.max(Math.max(p1.digitSum(pobiLeft), p1.digitProd(pobiLeft))
                , Math.max(p1.digitSum(pobiRight), p1.digitProd(pobiRight)));
        int crongMax = Math.max(Math.max(p1.digitSum(crongLeft), p1.digitProd(crongLeft))
                , Math.max(p1.digitSum(crongRight), p1.digitProd(crongRight)));
        if(pobiMax > crongMax){
            answer = 1;
        } else if(pobiMax < crongMax){
            answer = 2;
        } else{
            answer = 0;
        }

        return answer;
    }
}