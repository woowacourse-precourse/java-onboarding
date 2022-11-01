package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    // 1. 예외처리 : 1~10000 사이의 숫자인지 체크
    public static boolean isException(Integer number){
        if(number >= 1 && number<= 10000){
            return true;
        }
        return false;
    }

    // 2. clap 함수 만들기.
    public static int clabNumber(int number){
        int clap = 0;

        for(int i= 1; i <= number; i++){
            int current = i;
            while(current != 0){
                if(current % 10 == 3 || current % 10 == 6 || current % 10 == 9){
                    clap++;
                }
                current /= 10;
            }
        }
        return clap;
    }

    public static int solution(int number) {
        int answer = 0;
        if (isException(number)){
            if(number < 3){
                return answer;
            }
            int clap = clabNumber(number);
            answer = clap;
        }
        return answer;
    }
}
