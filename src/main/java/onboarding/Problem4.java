package onboarding;

/**
 * 기능 1: 알파벳인지 아닌지 판별하는 함수 작성
 * 기능 2: 소문자일때와 대문자일때 청개구리 문자로 변환해주는 함수 작성
 * 기능 3: 문자열을 순환하면서 변환해주는 기능 작성
 */
public class Problem4 {

    public static final int UPPER_PIVOT = 'A' + 'Z';
    public static final int LOWER_PIVOT = 'a' + 'z';

    public static boolean isAlphabet(char each) {
        if ((each >= 'a' && each <= 'z') || (each >= 'A' && each <= 'Z')) {
            return true;
        }
        return false;
    }

    public static char convertUpperCase(char letter) {
       return (char) (UPPER_PIVOT - letter);
    }

    public static char convertLowerCase(char letter) {
        return (char) (LOWER_PIVOT - letter);
    }


    public static String solution(String word) {
        String answer = "";

        return answer;
    }
}
