package onboarding;

/**
 *  구현할 기능 목록
 *      1. 암호 해독하는 기능
 *          1.1. 주어진 문자와 사전을 대응시켜 변환
 *          1.2. 알파벳 외의 문자 변환하지 않는다.
 *
 */
public class Problem4 {
    public static String solution(String word) {

        StringBuilder sb = new StringBuilder();
        for (Character ch : word.toCharArray()) {
            // 알파벳 유무 확인
            if (!Character.isAlphabetic(ch)) {
                sb.append(ch);
                continue;
            }
            sb.append(decrypt(ch));
        }

        return sb.toString();
    }

    // 주어진 문자와 사전을 대응시켜 변환
    private static char decrypt(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - ch + 'a');
        } else {
            return (char) ('Z' - ch + 'A');
        }
    }

}
