package onboarding;

import java.util.HashMap;

public class Problem4 {

    static HashMap<Character, Character> frogHash = new HashMap<>();

    public static String solution(String word) {
        createFrogHashMap();
        return frog(word);
    }

    // 청개구리가 하는 말을 반환하는 함수
    public static String frog(String word){
        StringBuilder frogWord = new StringBuilder(word.length());

        char[] frogChars = word.toCharArray();
        for (char c: frogChars){
            // 알파멧 외의 문자는 변환하지 않는다.
            if(frogHash.get(c) != null)
                frogWord.append(frogHash.get(c));
            else
                frogWord.append(c);
        }

        return frogWord.toString();
    }

    // 청개구리의 말을 번역할 해시맵
    public static void createFrogHashMap(){
        // 소문자
        int j = 'z';
        for(int i = 'a'; i <='z'; i++){
            frogHash.put((char)i, (char)j);
            j--;
        }

        // 대문자
        j = 'Z';
        for(int i = 'A'; i < 'Z'; i++){
            frogHash.put((char)i, (char)j);
            j--;
        }
    }
}
