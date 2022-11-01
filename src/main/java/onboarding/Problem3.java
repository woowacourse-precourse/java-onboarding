package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    public static int count369(int number,int answer){
        for(int i=1;i<=number;i++){
            int[] divideByDigit = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            for (int j:divideByDigit){
                if(j==3||j==6||j==9){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution(int number) {
        int answer = 0;
        return count369(number,answer);
    }
}
