package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    /*
    * number 가 입력됐을 때 손벽을 몇번 쳐야하는지 횟수를 세는 함수
    * parameter : int (number)
    * return : int (count)
    * */
    public static int clapNum(int number) {

        int clap = 0;
        while(number != 0){
            int digit = number % 10;
            if(digit % 3 == 0 && digit != 0) clap++;
            number/=10;
        }

        return clap;
    }

    /*
    * 1부터 number 까지 손뼉을 몇 번 쳐야 하는지 횟수를 측정하는 함수
    * parameter : int (number)
    * return : int (count)
    * */
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += clapNum(i);
        }
        return count;
    }
}
