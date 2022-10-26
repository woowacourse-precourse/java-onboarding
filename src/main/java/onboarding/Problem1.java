package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0)+1!=pobi.get(1) || crong.get(0)+1!=crong.get(1)){
            return -1;
        }

        int pobiScore=Math.max(calculate(pobi.get(0)),calculate(pobi.get(1)));
        int crongScore=Math.max(calculate(crong.get(0)),calculate(crong.get(1)));

        if (pobiScore==crongScore) return 0;
        if (pobiScore>crongScore) return 1;
        return 2;
    }
    public static int calculate(int num){
        int[] digit= Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int sum= Arrays.stream(digit).sum();
        int mul=1;
        for (int j : digit) mul *= j;
        return Math.max(sum,mul);
    }
}