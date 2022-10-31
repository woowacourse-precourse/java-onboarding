package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // word 문자열을 한 자리마다 for문 돌리며 변환
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // 소문자, 대문자, 그 외 문자들로 케이스를 나누어 변환
            // 변환할 문자끼리 처음과 끝이 대칭이므로 끝 문자에서 해당 문자를 빼고 첫문자룰 더해준다.
            if ('a' <= ch && ch <= 'z') {
                answer += (char)('z' - ch + 'a');
            } else if ('A' <= ch && ch <= 'Z') {
                answer += (char)('Z' - ch + 'A');
            } else {
                answer += ch;
            }
        }

        return answer;
    }
}
