package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] alphabet = word.toCharArray();   // String을 char 배열로 만듦

        for (int i = 0; i < alphabet.length; i++) { // 배열의 각 요소에 접근해서 청개구리 사전에 따라 변환
            alphabet[i] = change(alphabet[i]);
        }

        String answer = String.valueOf(alphabet);   // char 배열을 다시 String 배열로 만듦
        return answer;
    }

    public static char change(char c) { // 알파벳을 청개구리 사전에 따라 변환
        int ascii = (int)c;

        // 변환할 알파벳의 아스키 코드와 변환 후 알파벳의 아스키 코드 합이 같음을 이용
        if ((ascii >= 65) && (ascii <= 90)) { // c가 대문자라면
            ascii = 155 - ascii;
            return (char)ascii;
        }
        if ((ascii >= 97) && (ascii <= 122)) { // c가 소문자라면
            ascii = 219 - ascii;
            return (char) ascii;
        }
        return c;
    }
}
