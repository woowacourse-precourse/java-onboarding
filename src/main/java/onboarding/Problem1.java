package onboarding;

import java.util.*;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkIsNotCountinous(pobi) || checkIsNotCountinous(crong) || checkIsNotOdd(pobi.get(0)) || checkIsNotOdd(crong.get(0))){
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
        return (pobiMax>crongMax) ? 1 : (pobiMax==crongMax) ? 0 : 2 ;
    }

    private static IntStream getNumSplitStream(Integer num){
        String[] splitList = num.toString().split("");
        return Arrays.stream(splitList).mapToInt(Integer::parseInt);
    }
    private static int getSumOfStream(IntStream intStream){
        return intStream.sum();
    }
    private static int getMultiStream(IntStream intStream){
        return intStream.reduce(1,(i,j) -> i*j);
    }

    private static boolean checkIsNotCountinous(List<Integer> list) {
        Integer start = list.get(0);
        for(int i = 1 ; i < list.size(); ++i ){
            if (start+1 != list.get(i)) {
                return true;
            }
            start = list.get(i);
        }
        return false;
    }
    private static boolean checkIsNotOdd(Integer num){
        return num%2 == 0 ;
    }
}