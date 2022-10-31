package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {
        System.out.println(number);

        String numberList = "";
        for (int k=1;k<=number;k++){
            numberList += Integer.toString(k);
        }
        System.out.println(numberList);
//1부터 input 값까지의 숫자를 모두 스트링 형태로 numberList 변수에 추가

        int answer = 0;
        for (int k=0;numberList.length()>k;k++){
            if (numberList.charAt(k)=='3'||numberList.charAt(k)=='6'||numberList.charAt(k)=='9'){
                answer +=1;
            }
        }
        System.out.println(answer);
//numberList의 charAt(k)값이 3,6,9이면 0부터 시작하는 answer에 +1을 주도록함 블록커 : charAt으로 조건문을할때 비교대상을 char을 나타내는 작은 따옴표로 감싸야 한다.

        return answer;
    }
}
