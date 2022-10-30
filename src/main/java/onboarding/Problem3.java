package onboarding;

import java.util.List;

public class Problem3 {

    static int countClap(int number){
        int curNumber = number;
        int clap = 0;
        while(curNumber > 0){
            if((curNumber % 10 == 3) || (curNumber % 10 == 6) || (curNumber % 10 == 9)){
                clap++;
            }
            curNumber /= 10;
        }
        return clap;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            answer += countClap(i);
        }

        return answer;
    }
}
