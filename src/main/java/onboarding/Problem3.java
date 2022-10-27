package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        long[] cntList = new long[number+1];
        for (int i = 1; i <= number ; ++i){
            String now = Integer.toString(i);
            if(now.contains("3")||now.contains("6")||now.contains("9")){
                cntList[i] = Arrays.stream(now.split(""))
                        .filter(value -> value.equals("3")||value.equals("6")||value.equals("9"))
                        .count();
            }
        }
        return (int)Arrays.stream(cntList).sum();
    }

}
