package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int crongMax = 0;
        int pobiMax = 0;
        if(pobi.get(0) % 2 == 1 && pobi.get(1) % 2 == 0 && pobi.get(1) - pobi.get(0) == 1){
            String pobiOdd = pobi.get(0).toString();
            String pobiEven = pobi.get(1).toString();
            int pobiOddSum = 0;
            int pobiEvenSum = 0;
            int pobiOddMul = 1;
            int pobiEvenMul = 1;

            for(int i = 0; i < 3; i ++) {
                if (i < pobiOdd.length()) {
                    pobiOddSum += Character.getNumericValue(pobiOdd.charAt(i));
                    pobiOddMul *= Character.getNumericValue(pobiOdd.charAt(i));
                }
                if (i < pobiEven.length()) {
                    pobiEvenSum += Character.getNumericValue(pobiOdd.charAt(i));
                    pobiEvenMul += Character.getNumericValue(pobiOdd.charAt(i));
                }
            }
            int[] ansArray = {pobiOddSum,pobiOddMul,pobiEvenSum,pobiEvenMul};
            for(int i : ansArray){
                pobiMax = Math.max(i,pobiMax);
            }


        }
        else
            return -1;

        if(crong.get(0) % 2 == 1 && crong.get(1) % 2 == 0 && crong.get(1) - crong.get(0) == 1){
            String crongOdd = crong.get(0).toString();
            String crongEven = crong.get(1).toString();
            int crongOddSum = 0;
            int crongEvenSum = 0;
            int crongOddMul = 1;
            int crongEvenMul = 1;

            for(int i = 0; i < 3; i ++){
                if(i < crongOdd.length()){
                    crongOddSum += Character.getNumericValue(crongOdd.charAt(i));
                    crongOddMul *= Character.getNumericValue(crongOdd.charAt(i));
                }
                if(i < crongEven.length()){
                    crongEvenSum += Character.getNumericValue(crongOdd.charAt(i));
                    crongEvenMul += Character.getNumericValue(crongOdd.charAt(i));
                }
            }
            int[] ansArray = {crongOddSum,crongOddMul,crongEvenSum,crongEvenMul};
            for(int i : ansArray){
                crongMax = Math.max(i,crongMax);
            }

        }
        else
            return -1;

        if(pobiMax > crongMax){
            return 1;
        }
        else if(pobiMax < crongMax){
            return 2;
        }
        else{
            return 0;
        }
    }
}