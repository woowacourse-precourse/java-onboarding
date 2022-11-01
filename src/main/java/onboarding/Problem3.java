package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int num=1; num<=number; num++) {
            int[] inputNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
            answer+=findNumber(inputNum);
        }

        return answer;
    }
    static int findNumber(int[] number) {
        int clap = 0;
        for(int n:number) {
            if (n==3||n==6||n==9){
                clap+=1;
            }
        }
        return clap;
    }
}
