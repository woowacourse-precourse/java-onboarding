package onboarding;

//기능1. 알파벳을 아스키코드로 변환한다.
//기능2. 아스키코드에서 -65를 하여 몇번째 알파벳인지 구한다(n)
//기능3. 반대문자 = 원래문자+(25-2n)을 하여 반대문자를 구한 뒤 answer에 넣는다.
//기능4. 리스트를 문자열로 변환 후 반환한다.
//기능5. 기능2,3,4 를 포문으로 만든뒤 완성된 문자열을 answer로 반환한다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int n =0;


        System.out.println((int)word.charAt(0)); //73, 기능1
        System.out.println((int)word.charAt(0)-65); // n=8, 기능2
        System.out.println((int)word.charAt(0)+25-2*((int)word.charAt(0)-65)); //출력값 82, 기능3

        return answer;
    }
}
