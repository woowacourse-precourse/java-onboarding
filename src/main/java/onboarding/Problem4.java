package onboarding;

/**
 * 구현해야할 기능
 * A에서 Z, a 에서 Z 사이애서 중간 값을 기준으로 결과를 찾는다
 * 대문자 소문자 비교
 * 띄어쓰기는 넘어가기
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == ' ')
                sb.append(c);
            else if (isUpperCase(c))
                sb.append((char)(155 - c));
            else
                sb.append((char)(219 - c));
        }

        return sb.toString();
    }

    public static boolean isUpperCase(char c) {
        if (c >= 65 && c <= 90)
            return true;
        return false;
    }
}
