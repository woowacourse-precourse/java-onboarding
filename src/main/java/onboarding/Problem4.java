package onboarding;

import java.util.HashMap;

/*  요구사항
* 문자열이 주어지면, 알파벳을 변환하는 기능
* - 대문자는 대문자로, 소문자는 소문자로 요구사항 표에 맞게 변환한다.
* - 아래의 표에는 대문자만 기술되어 있으나, 소문자에도 적용된다.
* - 알파벳 이외의 문자는 변환하지 않는다.
* */
public class Problem4 {

    // 대문자 변환을 위한 대문자 모음집 생성
    static final char[] ALPHABET_UPPERCASE = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // 소문자 변환을 위한 소문자 모음집 생성
    static final char[] ALPHABET_LOWERCASE = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    /*
    * 역할: 기능1(문자열을 요구사항의 표에 맞는 문자열로 변환)
    * 입력: String (변환이 필요한 문자열)
    * 결과: String (요구사항에 따른 변환이 완료된 문자열)
    * */
    public static String solution(String word) {
        // 동작1. 기능 요구사항의 표를 Map에 저장한다.
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        int indexNormal = 0, indexReverse = ALPHABET_UPPERCASE.length -1;
        while(true) {
            map.put(ALPHABET_UPPERCASE[indexNormal], ALPHABET_UPPERCASE[indexReverse]);
            map.put(ALPHABET_LOWERCASE[indexNormal++], ALPHABET_LOWERCASE[indexReverse--]);
            if(indexNormal == ALPHABET_LOWERCASE.length || indexReverse == 0)
                break;
        }

        // 동작2. 주어진 문자열을 문자배열로 쪼개어 반복하는데, 한 문자마다 알파벳이면 Map을 통해 변환한다.
        char[] wordArray = word.toCharArray();
        for(int index = 0; index < wordArray.length; ++index) {
            char character = wordArray[index];
            if(map.containsKey(character))
                wordArray[index] = map.get(wordArray[index]);
        }

        // 동작3. 변환된 문자 배열을 문자열로 바꿔 반환한다.
        return String.valueOf(wordArray);
    }
}
