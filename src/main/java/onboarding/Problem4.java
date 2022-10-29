package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<26; i++){
            map.put((char)(65+i), (char)(90-i));
            map.put((char)('a'+i), (char)('z'-i));
        }

        for(int i=0; i<word.length(); i++){
            char w = word.charAt(i);

            if(w == ' '){                // 공백처리
                answer += w;
                continue;
            }

            answer += map.get(w);
        }

        return answer;
    }
}
