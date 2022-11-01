package onboarding;

/*
* 1. convert(char letter): 문자를 받아 알파벳의 대소문자를 구분하여 반대로 변환
*   1-1. 알파벳이 아닌 문자는 그대로 반환
* 2. isUppercaseAlphabet(char letter): 문자가 대문자 알파벳인지의 여부를 확인하는 메서드 추가
* 3. isLowercaseAlphabet(char letter): 문자가 소문자 알파벳인지의 여부를 확인하는 메서드 추가
*/

public class Problem4 {
    public static String solution(String word) {
        return word.chars()
                .map(letter -> convert((char) letter))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static boolean isUppercaseAlphabet(char letter) {
        return letter >= 'A' && letter <= 'Z';
    }

    private static boolean isLowercaseAlphabet(char letter) {
        return letter >= 'a' && letter <= 'z';
    }

    private static char convert(char letter) {
        if (isUppercaseAlphabet(letter)) {
            return (char) ('A' + 'Z' - letter);
        }
        if (isLowercaseAlphabet(letter)) {
            return (char) ('a' + 'z' - letter);
        }
        return letter;
    }
}
