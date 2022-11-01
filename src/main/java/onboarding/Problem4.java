package onboarding;

public class Problem4 {
    public static String reverse(String word) {
        char sentence[] = word.toCharArray();

        int ascii = 0;
        String answer = "";

        for (int i = 0; i < sentence.length; i++) {
            if (Character.isUpperCase(sentence[i])) //대문자
                ascii = 65;
            else if (Character.isLowerCase(sentence[i])) //소문자
                ascii = 97;
            else {
                answer += sentence[i];
                continue;
            }

        }

        return answer;
    }

    public static String solution(String word) {
        String answer = "";

        answer = reverse(word);

        return answer;
    }
}
