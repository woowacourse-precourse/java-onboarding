package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int[] pobiArr = pobi.stream().mapToInt(i->i).toArray();
        int pobiMax = getMax(pobiArr);

        int[] crongArr = crong.stream().mapToInt(i->i).toArray();
        int crongMax = getMax(crongArr);

        int answer = Integer.MAX_VALUE;

        if(pobiMax > crongMax){
            answer = 1;
            System.out.println("Pobi win");
        }else if(pobiMax < crongMax){
            answer = 2;
            System.out.println("Crong win");
        }else{
            answer = 0;
            System.out.println("무승부");
        }
        return answer;
    }

    private static int getMax(int[] pobiArr) {
        int[] pobiResArr = new int[2];
        for (int i = 0; i < pobiArr.length; i++){
            int[] pobiNum = Stream.of(String.valueOf(pobiArr[i]).split("")).mapToInt(Integer::parseInt).toArray();
            int pobiAdd = 0;
            int pobiMult = 1;
            for (int num: pobiNum){
                pobiAdd += num;
                pobiMult *= num;
            }
            if(pobiAdd>pobiMult){
                pobiResArr[i]=pobiAdd;
            }else{
                pobiResArr[i]=pobiMult;
            }
        }
        int pobiMax = pobiResArr[0];
        for(int i=1 ; i<pobiResArr.length ; i++) {
            if(pobiResArr[i]>pobiMax) {
                pobiMax = pobiResArr[i];
            }
        }
        return pobiMax;
    }
}