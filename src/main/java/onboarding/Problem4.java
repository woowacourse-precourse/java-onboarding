package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> bigChar = List.of('Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S','R', 'Q', 'P', 'O',
                'N', 'M', 'L', 'K', 'J', 'I', 'H','G','F','E','D','C','B','A');
        List<Character> smallChar = List.of('z', 'y', 'x', 'w', 'v', 'u', 't', 's','r', 'q', 'p', 'o',
                'n', 'm', 'l', 'k', 'j', 'i', 'h','g','f','e','d','c','b','a');
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                answer += bigChar.get(word.charAt(i) - 65);
            }
            else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                answer += smallChar.get(word.charAt(i) - 97);
            }
            else
                answer += word.charAt(i);
        }
        return answer;
    }
}
