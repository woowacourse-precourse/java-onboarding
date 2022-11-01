package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean page = validation(pobi, crong);
        if (!page) {
            return -1;
        }

        int pobisum = sum(pobi);
        int pobimulti = multi(pobi);
        int pobiMax = maxScore(pobisum, pobimulti);

        int crongsum = sum(crong);
        int crongmulti = multi(crong);
        int crongMax = maxScore(crongsum, crongmulti);

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else if (pobiMax == crongMax) {
            return 0;
        } else {
            return -1;
        }
    }

   static int sum(List<Integer> value) {
        int value1 = 0; // 0의 값
        int value2 = 0; // 1의 값
        int value1tmp = value.get(0);
        int value2tmp = value.get(1);

        int tmp = 0; // 중간 저장


        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value1 += value1tmp%10;
            value1tmp /= 10;
        }

        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value2+= value2tmp%10;
            value2tmp /= 10;
        }

        return maxScore(value1, value2); // a or b 큰 수
    }

    static int multi(List<Integer> value){

        int value1 = 1;
        int value2 = 1;
        int value1tmp = value.get(0);
        int value2tmp = value.get(1);

        int tmp = 0; // 중간 저장


        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value1 *= value1tmp%10;
            value1tmp /= 10;
        }

        for (int i=0;i<(int)(Math.log10(value.get(0))+1);i++) {
            value2 *= value2tmp%10;
            value2tmp /= 10;
        }
        return maxScore(value1,value2);
    }

    static int maxScore(int a, int b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static public boolean validation(List<Integer> pobi,List<Integer> crong){
        boolean result = true;

        if(1 != Math.abs(pobi.get(0) - pobi.get(1))){
            return false;
        } else if(1 != Math.abs(crong.get(0) - crong.get(1))){
            return false;
        }else{
            return result;
        }
    }

}


