package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] pobiValues = pobi.stream().mapToInt(i->i).toArray();
        for (int pobiValue: pobiValues){
            int[] arrNum = Stream.of(String.valueOf(pobiValue).split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(arrNum));
        }
        int[] crongValues = crong.stream().mapToInt(i->i).toArray();
        for(int crongValue : crongValues){
            int[] arrNum = Stream.of(String.valueOf(crongValue).split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(arrNum));
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}