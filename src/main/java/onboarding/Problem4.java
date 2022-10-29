package onboarding;

public class Problem4 {

    // 주어진 문자열을 0번 인덱스부터 문자열 길이만큼 변환하는 기능
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(distinguishAlphabet(word.charAt(i)));
        }
        return sb.toString();
    }

    // 알파벳 대문자,소문자를 제외한 글자를 판별하는 기능
    private static char distinguishAlphabet(char alphabet) {
        if (Character.isUpperCase(alphabet)) {
            return toReverseUppercase(alphabet);
        }
        if (Character.isLowerCase(alphabet)) {
            return toReverseLowercase(alphabet);
        }
        return alphabet;
    }

    // 대문자를 청개구리 대문자로 번역하는 기능
    private static char toReverseUppercase(char alphabet) {
        return (char)(90-(alphabet-65));
    }

    // 소문자를 청개구리 소문자로 번역하는 기능
    private static char toReverseLowercase(char alphabet) {
        return (char)(122-(alphabet-97));
    }

}
