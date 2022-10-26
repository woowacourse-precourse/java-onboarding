package onboarding;

import java.util.List;

class Problem1 {

    public static boolean checkException(int n1, int n2){
        if(n1%2 == 1 && n2%2 == 0) {
            if (n2 - n1 == 1){
                if( (n1 != 1 && n2 != 2) && (n1 != 399 && n2 != 400) )
                    return true;
            }
        }
        return false;
    }

    public static int getValue(int val){
        int addSum = 0;
        int mulSum = 1;

        while(val > 0){
            int temp = val % 10;
            addSum += temp;
            mulSum *= temp;
            val /= 10;
        }
        return Math.max(addSum, mulSum);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiFirst = pobi.get(0);
        int pobiSecond = pobi.get(1);
        int crongFirst = crong.get(0);
        int crongSecond = crong.get(1);

        if(!checkException(pobiFirst, pobiSecond) || !checkException(crongFirst, crongSecond))  return -1;

        int pobiVal = Math.max(getValue(pobiFirst), getValue(pobiSecond));
        int crongVal = Math.max(getValue(crongFirst), getValue(crongSecond));

        if(pobiVal > crongVal) return 1;
        if(pobiVal < crongVal) return 2;
        return 0;
    }
}