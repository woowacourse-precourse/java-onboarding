package onboarding;

import java.util.HashMap;
/*
##기능 목록

1. 각 알파벳에 대응하는 값을 담은 HashMap 생성
2. 해당 문자가 알파벳인지 확인
3. String의 각 문자를 확인하며 변환 및 결과 생성

 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> hashMap = makeHashMap();
        for (int i = 0; i < word.length(); i++) {
            if (isAlphabet(word.charAt(i))){
                answer += hashMap.get(word.charAt(i));
            }else{
                answer += word.charAt(i);
            }
        }
        return answer;
    }

    public static HashMap<Character, Character> makeHashMap() {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(' ',' ');
        for (int i = 0; i < 26; i++) {
            hashMap.put((char) ('a' + i), (char) ('a' + 25 - i));
        }
        for (int i = 0; i < 26; i++) {
            hashMap.put((char) ('A' + i), (char) ('A' + 25 - i));
        }
        return hashMap;
    }

    public static boolean isAlphabet(Character c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) return true;
        return false;
    }
}
