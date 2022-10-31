package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

//기능 목록
// 1. 인접한 중복 문자 찾고 소문자 알파벳이 아닌 특수문자로 치환.
// 2. 치환되지 않은 문자열 합치기
// 3. 1번과 2번을 치환되지 않을때까지 반복
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        //반복
        while (true){
            //인접한 중복 문자 찾고 치환
            char[] chars = cryptogram.toCharArray();
            for(int i =0 ; i < cryptogram.length() - 1; i++){
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    chars[i] = '@'; chars[i+1] = '@';
                }
            }
            //@로 치환되지 않은 부분만 answer에 담기
            answer = "";
            for (char c : chars) {
                if (c != '@') {
                    answer += c;
                }
            }
            if(cryptogram.equals(answer)) return answer;
            cryptogram = answer;
        }
    }
}
