package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //exception
        if (pobi.get(0)+1!=pobi.get(1) || crong.get(0)+1!=crong.get(1)){
            return -1;
        }

        int pobiScore=Math.max(calculateAndCompare(pobi.get(0)), calculateAndCompare(pobi.get(1)));
        int crongScore=Math.max(calculateAndCompare(crong.get(0)), calculateAndCompare(crong.get(1)));

        if (pobiScore==crongScore) return 0;
        else if (pobiScore>crongScore) return 1;
        else return 2;

    }
    public static int calculateAndCompare(int num){
        int[] digit= Stream.of(String.valueOf(num).split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int sum= Arrays.stream(digit).sum();
        int mul= Arrays.stream(digit).reduce(1,(a,b)->a*b);

        return Math.max(sum,mul);
    }
}