package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += clapCounter(i);
        }
        return answer;
    }


    static int clapCounter(int n){
        return (int)Arrays.stream(String.valueOf(n).split("")).
                filter(x -> x.equals("3") || x.equals("6") || x.equals("9")).
                count();
    }
}
