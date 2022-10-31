package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem4 {

    public static String solution(String word) {
        HashMap<Character, Character> a = new HashMap<>();
        String answer = "";

        // 알파벳이 26자 이므로 char형 배열 26을 선언한다.
        char [] arr = new char[26];


        for (int i = 0 ; i <=arr.length; i++){

            // a~z순서 , z~a순서 로 put 해준다.
            a.put((char)('a'+i) , (char)('z'-i));

            // A~Z순서 , Z~A순서 로 put 해준다.
            a.put((char)('A'+i) , (char)('Z'-i));
        }

        for(int i = 0; i <word.length(); i++){
            // String인 word를 char형 변환해준다
            char w = word.charAt(i);

            // char w 가 'a'~'z' , 'A'~'Z' 범위에 해당되는 경우에 w 라는 키가 존재하면 w 키의 값을 반환해 answer에 담아준다.
            if (('a' <= w && w <= 'z') || ('A' <= w && w <= 'Z')) {
                answer += a.getOrDefault(w,w);

            }  //알파벳 소문자 , 대문자가 아니면 공백("")을 반환합니다 ex(R""olev""blf)
            else{
                answer += " ";

            }

        }
        return answer;
    }


}