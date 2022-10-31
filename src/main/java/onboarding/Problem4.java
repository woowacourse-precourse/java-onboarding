package onboarding;

//기능1. 알파벳을 아스키코드로 변환한다.
//기능2. 아스키코드에서 -65를 하여 몇번째 알파벳인지 구한다(N)
//기능3. 반대문자 = 원래문자+(25-2N)을 하여 반대문자를 구한 뒤 리스트에 ADD
//기능4. 리스트를 문자열로 변환 후 반환한다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        System.out.println((int)word.charAt(0)+25-2*((int)word.charAt(0)-65));
        System.out.println((char)82);
        return answer;
    }
}
