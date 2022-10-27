package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] pobiResArr = new int[2];
        int[] pobiArr = pobi.stream().mapToInt(i->i).toArray();
        int index =0;
        for (int pobiValue: pobiArr){
            int[] pobiNum = Stream.of(String.valueOf(pobiValue).split("")).mapToInt(Integer::parseInt).toArray();
            int pobiAdd = 0;
            int pobiMult = 1;
            for (int num: pobiNum){
                pobiAdd += num;
                pobiMult *= num;
            }
            if(pobiAdd>pobiMult){
                pobiResArr[index]=pobiAdd;
            }else{
                pobiResArr[index]=pobiMult;
            }
            index = index+ 1;
        }
        System.out.println(Arrays.toString(pobiResArr));
        int pobiMax = pobiResArr[0];
        for(int i=1 ; i<pobiResArr.length ; i++) {
            if(pobiResArr[i]>pobiMax) {
                pobiMax = pobiResArr[i];
            }
        }
        System.out.println(pobiMax);


//        int[] crongValues = crong.stream().mapToInt(i->i).toArray();
//        for(int crongValue : crongValues){
//            int[] arrNum = Stream.of(String.valueOf(crongValue).split("")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(Arrays.toString(arrNum));
//        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}