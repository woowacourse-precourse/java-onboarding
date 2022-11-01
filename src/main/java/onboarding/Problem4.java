package onboarding;

public class Problem4 {
    public static Character conversionCase(Character alphabet) {
        if (alphabet >= 'a' && alphabet <= 'z') {
            return (char)((int)alphabet - 32);
        }
        if (alphabet >= 'A' && alphabet <= 'Z') {
            return (char)((int)alphabet + 32);
        }

        return alphabet;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
