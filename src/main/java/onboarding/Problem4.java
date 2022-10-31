package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character cur = word.charAt(i);
            if ('A' <= cur && cur <= 'Z') {
                // 영문자 일경우,
                int diff = cur - 'A';
                answer.append(Character.toChars('Z'-diff));
            }else if('a' <= cur && cur <= 'z'){
                int diff = cur - 'a';
                answer.append(Character.toChars('z'-diff));
            }
            else {
                answer.append(cur);
            }
        }
        return answer.toString();
    }
}
