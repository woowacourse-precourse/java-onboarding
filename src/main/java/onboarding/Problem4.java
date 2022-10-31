package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // map 을 이용해 각각 반대의 키-값을 저장함
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (65 + i), (char) (90 - i));
        }

        for (int j = 0; j < word.length(); j++) {
            char tmp = word.charAt(j);
            if (Character.isUpperCase(tmp)) {
                tmp = map.get(tmp);
                answer = answer + (char) (tmp);
            }else if(Character.isLowerCase(tmp)){
                tmp = map.get((char)(tmp-32));
                answer = answer + (char)(tmp+32);
            }else{
                answer = answer + ' ';
            }
        }

        return answer;
    }
}
