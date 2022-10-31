package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ASCII 테이블을 이용 각각의 알파벳에 맞는 정수를 찾아낸다.
 * 알파벳 대문자의 정수 범위는 65 ~ 90
 * 알파벳 소문자의 정수 범위는 97 ~ 122
 * 주어진 알파벳과 리턴하는 반대의 알파벳 정수의 합은 (대문자 -> 65+90 = 155) (소문자 -> 97+122 = 219)
 * 리턴하는 알파벳의 정수값은 대문자 -> 155-알파벳, 소문자 -> 219-알파벳
 *
 * 매개변수 string을 character list으로 바꾸어 각각 알파벳에 상응하는 반대의 알파벳을 list에 저장
 * Stringbuilder를 이용하여 character list에 있는 모든 요소를 하나의 string으로 만든후 리턴
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem4 {
    // using ASCII table, the sum of given letter  and the convert should be 155
    // if uppercase, 219 if lowercase
    public static String solution(String word) {

        if(word.isBlank() || word.length()>1000) return null;
        List<Character> charArr = new ArrayList<>();

        for(int c: word.toCharArray()){
            if( (c >= 65 && c <=90 ) ){
                charArr.add((char)(155-c));
            } else if((c >= 97 &&  c <=122)){
                charArr.add((char)(219-c));
            } else{
                charArr.add((char)c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: charArr){
            sb.append(c);
        }

        return sb.toString();
    }
}
