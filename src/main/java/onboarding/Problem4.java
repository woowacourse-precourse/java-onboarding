package onboarding;

public class Problem4 {
    static char changeCharacter(char c) {
        int asciiCode = c;
        if (65 <= asciiCode && asciiCode <= 90)
            return (char) (155 - asciiCode);

        return (char) (219 - asciiCode);
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
