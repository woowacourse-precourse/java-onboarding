package onboarding;

import java.util.List;
import java.util.Arrays;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = 0;
        int crongScore = 0;
        if(pobi.get(1) - pobi.get(0) == 1 && pobi.get(1) % 2 == 0){
            for(int i = 0; i < pobi.size(); i++){
                int num = Math.max(addNumElement(pobi.get(i)), mulNumElement(pobi.get(i)));
                pobiScore = Math.max(num, pobiScore);
            }
            for(int i = 0; i < crong.size(); i++){
                int num = Math.max(addNumElement(crong.get(i)), mulNumElement(crong.get(i)));
                crongScore = Math.max(num, crongScore);
            }
            if (pobiScore - crongScore > 0){
                return 1;
            }
            else if(pobiScore - crongScore == 0){
                return 0;
            }
            else {
                return 2;
            }
        }
        else
            return -1;
    }

    static int addNumElement(int num){
        String numString= "" + num;
        int[] numArr = new int[numString.length()];

        for(int i = 0; i < numArr.length; i++){
            numArr[i] = num % 10;
            num /= 10;
        }

        return Arrays.stream(numArr).sum();
    }

    static int mulNumElement(int num){
        String numString= "" + num;
        int[] numArr = new int[numString.length()];
        int result = 1;

        for(int i = 0; i < numArr.length; i++){
            numArr[i] = num % 10;
            num /= 10;
        }

        for(int i = 0; i < numArr.length; i++) {
            result *= numArr[i];
        }

        return result;
    }
}