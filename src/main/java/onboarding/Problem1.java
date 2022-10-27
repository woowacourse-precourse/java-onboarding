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

//        Crong
        int[] crongResArr = new int[2];
        int[] crongArr = crong.stream().mapToInt(i->i).toArray();
        int index2 =0;
        for (int crongValue: crongArr){
            int[] crongNum = Stream.of(String.valueOf(crongValue).split("")).mapToInt(Integer::parseInt).toArray();
            int crongAdd = 0;
            int crongMult = 1;
            for (int num: crongNum){
                crongAdd += num;
                crongMult *= num;
            }
            if(crongAdd>crongMult){
                crongResArr[index2]=crongAdd;
            }else{
                crongResArr[index2]=crongMult;
            }
            index2 = index2+ 1;
        }
        System.out.println(Arrays.toString(crongResArr));
        int crongMax = crongResArr[0];
        for(int i=1 ; i<crongResArr.length ; i++) {
            if(crongResArr[i]>crongMax) {
                crongMax = crongResArr[i];
            }
        }
        System.out.println(crongMax);

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
}