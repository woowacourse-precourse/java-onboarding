package onboarding;


import java.util.Stack;
import java.util.stream.Collectors;

/**
 * decodingCryptogram 메서드 암호문을 받은뒤 중복된 값을 제거하여 반환
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        return decodingCryptogram(cryptogram);
    }

    private static String decodingCryptogram(String cryptogram) {
        Stack stack = new Stack<>();
        char[] arrayOfCryptogram = cryptogram.toCharArray();
        stack.push(arrayOfCryptogram[0]);

        for (int i = 1; i < arrayOfCryptogram.length; i++) {
            if (!stack.empty() && stack.peek().equals(arrayOfCryptogram[i])) stack.pop();
            else if (arrayOfCryptogram[i - 1] == arrayOfCryptogram[i]) ;
            else stack.push(arrayOfCryptogram[i]);
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toString();

    }
}