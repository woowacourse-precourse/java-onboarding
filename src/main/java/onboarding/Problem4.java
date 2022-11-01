package onboarding;

/*
* 1. 제한사항 알파벳 외의 문자는 변환하지 않기 때문에 알파벳인지 판별하는 메소드 구현
* 2. 대문자인지 소문자인지 판별하는 메소드 구현
* 3. 대문자 -> 대문자, 소문자 -> 소문자 구현
* 4. 최종 반환
* */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char isAlphabet(char alphabet) {
        if (Character.isAlphabetic(alphabet)) {
            return isUpperCaseLowerCase(alphabet);
        }
        return alphabet;
    }

    public static char isUpperCaseLowerCase(char alphabet) {
        if (Character.isUpperCase(alphabet)) {
            return changeUpperAlphabet(alphabet);
        }
        return changeLowerAlphabet(alphabet);
    }
}
