package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // O(n)
        for (int i = 0; i < word.length(); i++){
            // 대문자일 경우
            if (Character.isUpperCase(word.charAt(i)))
                answer += Character.toString(90 - (word.charAt(i) - 65));
            // 소문자일 경우
            else if (Character.isLowerCase(word.charAt(i)))
                answer += Character.toString(122 - (word.charAt(i) - 97));
            // 그 외
            else
                answer += word.charAt(i);
        }

        return answer;
    }
}
