package onboarding;

public class Problem4 {

    public static String solution(String word) {
        return pro(word);
    }

    static String pro(String word) {
        String answer = "";

        // 65 - 90 (A ~ Z), 97 - 122 (a ~ z)
        // 알파벳 A의 int 값은 65이고, Z의 int 값은 90이므로 변환된 알파벳의 int 값은 (90 - idx + 65)가 될 것이다.
        // 마찬가지로 알파벳 a의 int 값은 97이고, z의 int 값은 122이므로 변환된 알파벳의 int 값은 (122 - idx + 97)이 될 것이다.

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' ') answer += String.valueOf(c); // 현재 문자가 공백일 경우

            int idx = (int) c; // (char) 알파벳의 int 값
            if(idx >= 65 && idx <= 90) answer += String.valueOf((char) (90 - idx + 65));   // 현재 문자가 대문자일 경우
            if(idx >= 97 && idx <= 122) answer += String.valueOf((char) (122 - idx + 97)); // 현재 문자가 소문자일 경우
        }

        return answer;
    }
}
