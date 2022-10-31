package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {

        int alphaNum = 26;
        Map<Character, Character> changeWords = new HashMap<>();

        for(int i = 0; i < alphaNum; i++){
            char A = 'A';
            char Z = 'Z';
            Character key = (char)((int)A + i);
            Character value = (char)((int)Z - i);
            changeWords.put(key, value);
        }

        for(int i = 0; i < alphaNum; i++){
            char a = 'a';
            char z = 'z';
            Character key = (char)((int)a + i);
            Character value = (char)((int)z - i);
            changeWords.put(key, value);
        }

        String answer = "";

        char[] words = word.toCharArray();

        for(int i = 0; i < words.length; i++){
            int nowAscii = (int)words[i];
            if( (int)'A' <= nowAscii && (int)'Z' >= nowAscii
                ||(int)'a' <= nowAscii && (int)'z' >= nowAscii
            ){
                answer += changeWords.get(words[i]);
            }
            else {
                answer += words[i];
            }
        }

        return answer;
    }
}
