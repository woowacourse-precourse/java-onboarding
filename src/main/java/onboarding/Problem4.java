package onboarding;

import java.util.HashMap;

public class Problem4 {
    /*
        map이라는 HashMap 변수에 청개구리 문자 암호판을 구현
        for문을 돌려 j번째 문자열이 대문자인 경우 map에 맞는 값을 구해서 answer에 추가
        소문자인 경우 대문자로 변환해서 map에 맞는 값을 구한 후, 그 값을 다시 소문자로 변환해서 answer에 추가
        그 외의 경우 해당 j번째 문자열 그대로 answer에 추가
     */
    public static String solution(String word) {
        int num = 0;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i=65; i<=90; i++) {
            map.put((char)i, (char)(90-num));
            num ++;
        }

        String answer = "";

        for(int j=0;j<word.length();j++){
            if(Character.isUpperCase(word.charAt(j))) {
                answer += map.get(word.charAt(j));
            }else if(Character.isLowerCase(word.charAt(j))){
                answer += Character.toLowerCase(map.get(Character.toUpperCase(word.charAt(j))));
            }else {
                answer += word.charAt(j);
            }
        }

        return answer;
    }
}