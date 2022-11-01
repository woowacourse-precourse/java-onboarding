package onboarding;

public class Problem4 {
    public static String reverse(String word) {
        char sentence[] = word.toCharArray();

        int ascii = 0, distance = 0;
        String answer = "";

        for (int i = 0; i < sentence.length; i++) {
            if (Character.isUpperCase(sentence[i]))
                ascii = 65;
            else if (Character.isLowerCase(sentence[i]))
                ascii = 97;
            else {
                answer += sentence[i];
                continue;
            }
            distance = Math.abs(ascii - sentence[i]);
            answer += (char)(ascii + 25 - distance);
        }

        return answer;
    }

    public static String solution(String word) {
        String answer = "";

        answer = reverse(word);

        return answer;
    }
}
