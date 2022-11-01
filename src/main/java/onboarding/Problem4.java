package onboarding;

import java.util.HashMap;

public class Problem4 {
    /**
     * 대문자가 키인 해쉬매과 소문자가 키인 해쉬 맵을 만든다.
     * 해당 word에 각 자리 글자를 맵에서 찾아 매핑한다.
     * */
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> up = upInit();//대문자와 소문자 매칭
        HashMap<Character, Character> low = lowInit();//소문자와 대문자 매칭


        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ' ') {
                answer += word.charAt(i);
            }
            else if(isIn(word.charAt(i), up)) {
                answer += up.get(word.charAt(i));
            }
            else
            {
                answer += low.get(word.charAt(i));
            }
        }

        System.out.println("word\tresult");

        System.out.println(word + "\t" + answer);

        return answer;
    }

    public static HashMap<Character, Character> upInit() {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put((char)(65 + i), (char)(90 - i));
        }

        return map;
    }

    public static HashMap<Character, Character> lowInit() {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put((char)(97 + i), (char)(122 - i));
        }

        return map;
    }

    public static boolean isIn(Character c, HashMap<Character, Character> up) {
        if(up.containsKey(c)) {
            return true;
        }
        else
        {
            return false;
        }
    }
}
