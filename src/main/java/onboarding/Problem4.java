package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    /*
    * 1. 각 글자별로 매칭될 다른 글자를 Map으로 만든다.
    * 2. 이후에 모든 글자를 매칭된 글자로 변환을 진행.
    * */
    public static String solution(String word) {
        // 1. 매칭될 글자들을 순서대로 기입
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String reverseAlphabet = "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA";

        // 1.1 매칭 시작
        Map<String, String> characterMapper = new HashMap<>();
        for(int i =0; i< alphabet.length(); i++){
            characterMapper.put(alphabet.substring(i, i + 1), reverseAlphabet.substring(i, i + 1));
        }

        // 2. 변환진행, 단 위 map에 없는 글자일 경우에는 그대로 작성. ex) 숫자, 특수문자, 공백등등
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i<word.length(); i++){
            String currentChar = word.substring(i, i + 1);
            stringBuilder.append(characterMapper.getOrDefault(currentChar, currentChar)) ;
        }
        return stringBuilder.toString();
    }
}
