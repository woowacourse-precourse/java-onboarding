package onboarding;

public class Problem4 {

    // 1. word 예외처리 : 길이가 1 ~ 1000
    public static boolean isException(Integer length){
        if(length >= 1 && length <= 1000){
            return true;
        }
        return false;
    }

    // 2. 알파벳 변환 함수 만들기.
    public static String changeWord(String word){
        char[] chars = word.toCharArray();
        // k번째
        int k = 0;
        // char ascii값.
        int char_ascii = 0;

        for(char c : chars){
            if(Character.isUpperCase(c)){// char가 대문자인 경우
                int ascii_code = (int)c;
                char_ascii = ascii_code-65;
                chars[k] = (char)(90 - char_ascii);

            }else if(Character.isLowerCase(c)){ // char가 소문자인 경우
                int ascii_code = (int)c;
                char_ascii = ascii_code-97;
                chars[k] = (char)(122 - char_ascii);
            }
            k++;
        }
        return new String(chars);
    }

    public static String solution(String word) {
        String answer = "";
        int length = word.length();
        // 길이 유효성 체크
        if(isException(length)){
            answer = changeWord(word);
        }
        return answer;
    }
}
