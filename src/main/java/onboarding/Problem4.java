package onboarding;

/**
 * [풀이 방법]
 * 대문자와 소문자의 경우에 따라 아스키코드 값을 조절하여 변경해준다.
 * - 대문자 일 경우 -> 'Z'에서 현재 단어를 빼준 뒤, 'A'+1 즉 65만큼 더해준다
 * - 소문자 일 경우 -> 'z'에서 현재 단어를 빼준 뒤, 'a'+1 즉 97만큼 더해준다
 *
 * - > 제한사항에서 알파벳을 제외한 모든 문자는 그대로 출력된다는것을 발견 (예외사항)
 * 기존 코드에서 빈칸 만 그대로 출력되게 했던 것을 수정함.
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c >= 65 && c <= 90) { // 대문자에 해당하는 경우
                sb.append((char) ('Z' - c + 65));
            } else if (c >= 97 && c <= 122) { // 소문자에 해당하는 경우
                sb.append((char) ('z' - c + 97));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
