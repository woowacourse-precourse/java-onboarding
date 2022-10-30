package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {

     /*[기능 구현]
        1. 1부터 number까지 자리수 나누기
        2. 나눈 자리수를 배열에 담기
        3. 배열 값이 3,6,9에 해당하면 +1 카운트
        4. 출력

      */

        int answer = 0;
        return answer;
    }

    public static ArrayList inputArray(int number){
        ArrayList<Integer> arrNum = new ArrayList<>();
        while (number>0){
            arrNum.add(number % 10);
            number /= 10;
        }
        return arrNum;
    }



}
