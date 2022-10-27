package onboarding;

import java.util.*;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (!checkIsCountinous(pobi) || !checkIsCountinous(crong)){
            return -1 ;
        }
        int pobiMax = 0;
        int crongMax = 0;
        for(Integer i : pobi) {
            int maxValue = Math.max(getSumOfStream(getNumSplitStream(i))
                    , getMultiStream(getNumSplitStream(i)));
            pobiMax = Math.max(pobiMax, maxValue);
        }
        for( Integer j : crong){
            int maxValue = Math.max(getSumOfStream(getNumSplitStream(j))
                    , getMultiStream(getNumSplitStream(j)));
            crongMax = Math.max(crongMax, maxValue);
        }
        if(pobiMax > crongMax){
            answer = 1 ;
        }else if (pobiMax < crongMax){
            answer = 2 ;
        } else {
            answer = 0 ;
        }
        return answer ;
    }

    public static IntStream getNumSplitStream(Integer num){
        String[] splitList = num.toString().split("");
        return Arrays.stream(splitList).mapToInt(Integer::parseInt);
    }
    public static int getSumOfStream(IntStream intStream){
        return intStream.sum();
    }
    public static int getMultiStream(IntStream intStream){
        return intStream.reduce(1,(i,j) -> i*j);
    }

    public static Boolean checkIsCountinous(List<Integer> list) {
        Integer start = list.get(0);
        for(int i = 1 ; i < list.size(); ++i ){
            if (start+1 != list.get(i)) {
                return false ;
            }
            start = list.get(i);
        }
        return true ;
    }
}