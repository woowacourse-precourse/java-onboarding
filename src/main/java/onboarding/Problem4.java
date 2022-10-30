package onboarding;

import java.util.HashMap;

public class Problem4 {
    static final char[] ALPHABET_UPPERCASE = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    static final char[] ALPHABET_LOWERCASE = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static String solution(String word) {
        // 기능#1 문자열을 문자 배열로 쪼개는 기능
        char[] wordArray = word.toCharArray();

        // 문자 1개를 요구사항 표에 알맞는 변환 문자와 연결시킨다.
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        int indexNormal = 0, indexReverse = ALPHABET_UPPERCASE.length -1;
        while(true) {
            map.put(ALPHABET_UPPERCASE[indexNormal], ALPHABET_UPPERCASE[indexReverse]);
            map.put(ALPHABET_LOWERCASE[indexNormal++], ALPHABET_LOWERCASE[indexReverse--]);
            if(indexNormal == ALPHABET_LOWERCASE.length || indexReverse == 0)
                break;
        }

        // 기능#2 문자 1개를 요구사항 표에 맞추어 변환하는 기능
        for(int index = 0; index < wordArray.length; ++index) {
            char character = wordArray[index];
            if(map.containsKey(character))
                wordArray[index] = map.get(wordArray[index]);
        }

        // 기능#3 문자 배열을 합쳐 하나의 문자열로 만드는 기능
        return String.valueOf(wordArray);
    }
}
