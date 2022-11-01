package onboarding;


import java.util.Stack;
import java.util.stream.Collectors;

/**
 * decodingCryptogram 메서드 암호문을 받은뒤 중복된 값을 제거하여 반환
 * isProperCryptogram 메서드 암호문이 올바른지 확인
 */

public class Problem2 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String LOWERCASE = "^[a-z]*$";

    public static String solution(String cryptogram) {
        isProperCryptogram(cryptogram);
        return decodingCryptogram(cryptogram);
    }

    private static void isProperCryptogram(String cryptogram){
        if (!cryptogram.matches(LOWERCASE)) {
            throw new IllegalArgumentException("암호문은 소문자로만 이루어져 있어야합니다.");
        }
        if(cryptogram.length()<MIN_LENGTH || cryptogram.length()>MAX_LENGTH) {
            throw new IllegalArgumentException("암호문의 길이는 1이상 1000이하인 문자열입니다.");
        }
    }

    private static String decodingCryptogram(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));
        for (int i = 1; i < cryptogram.length(); i++) {
            if (!stack.empty() && stack.peek().equals(cryptogram.charAt(i))) stack.pop();
            else if (cryptogram.charAt(i-1) == cryptogram.charAt(i)) ;
            else stack.push(cryptogram.charAt(i));
        }
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}