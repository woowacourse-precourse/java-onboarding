package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {

     /*[기능 구현]
        1. 1부터 number까지 자리수 나누기
        2. 나눈 자리수를 배열에 담기
        3. 배열 값이 3,6,9에 해당하면 +1 카운트
        4. 출력

      */
        int answer = 0;
        String strNum = splitNum(number);

        return answer;
    }
    public static String splitNum(int number){
        StringBuilder num = new StringBuilder();
        for(int i = 1;i<=number; i++){
            num.append(i);
        }

        return num.toString();
    }





}
