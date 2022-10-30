package onboarding;

import java.util.HashMap;

public class Problem4 {

    static HashMap<Character, Character> frogHash = new HashMap<>();

    public static String solution(String word) {
        String answer = "";
        return answer;
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
