package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer=0;
        for(int i=1;i<=number;i++){
            answer+=calculate(i);
        }
        return answer;
    }

    public static int calculate(int num){
        int result=0;
        int[] nums=converter(num);
        for(int n:nums){
            if(check369(n))
                result++;
        }
        return result;
    }

    public static int[] converter(int num){
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean check369(int num){
        return num == 3 || num == 6 || num == 9;
    }
}
