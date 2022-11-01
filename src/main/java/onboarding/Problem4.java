package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {

        StringBuffer answer = new StringBuffer();
        HashMap<Character, Character> hashMap = makeCharacterHash();

        for (int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if('A' <= ch && ch <='Z' || 'a' <= ch && ch <='z') answer.append(hashMap.get(ch));
            else answer.append(ch);
        }
        return answer.toString();
    }

    //치환용 해시맵 생성기
    static HashMap<Character, Character> makeCharacterHash(){
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (char ch = 'A'; ch<='Z'; ch++){
            hashMap.put(ch, (char) ('Z' - ch + 'A'));
        }
        for (char ch = 'a'; ch<='z'; ch++){
            hashMap.put(ch, (char) ('z' - ch + 'a'));
        }
        return hashMap;
    }
}
