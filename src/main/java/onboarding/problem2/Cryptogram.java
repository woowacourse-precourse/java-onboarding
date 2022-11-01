package onboarding.problem2;

public class Cryptogram {

    public static void validate(String code) {
        isLength(code);
        isLowerCase(code);
    }

    // 길이가 1 이상 1000 이하인 문자열이다.
    public static void isLength(String code){
        if (code.length() < 1 || code.length() > 1000 ) {
            throw new IllegalArgumentException("문자열은 1이상 1000이하의 길이여야 합니다.");
        }
    }

    // 알파벳 소문자로만 이루어져 있다.
    public static void isLowerCase(String code) {
        char[] charArray = code.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])){
                throw new IllegalArgumentException("문자열은 소문자로만 이루어져야 합니다.");
            }
        }
    }

}
