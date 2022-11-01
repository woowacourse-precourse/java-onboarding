package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    // A -> Z, Z -> A 로 변환하는 Map을 세팅하는 함수
    public static void mapSet(Map<Character, Character> map) {
        char small = 'a';
        char capital = 'A';
        int maxlen = 'Z' - 'A';

        for (int i=0; i<=maxlen; i++) {
            map.put(small++, (char)('z' - i));
            map.put(capital++, (char) ('Z' - i));
        }
    }

    // 입력받은 문자열의 리버스 문자열을 구하는 함수
    public static String reverString(String word, Map<Character, Character> map){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == ' '){
                sb.append(" ");
            }else if(map.keySet().contains(ch)){
                sb.append(map.get(ch));
            }else{
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String solution(String word) {
        Map<Character, Character> map = new HashMap<>();
        mapSet(map);
        System.out.println(map);

        return reverString(word, map);
    }
}
