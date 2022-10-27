package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] uppercase = makeUppercase();
        char[] lowercase = makeLowercase();
        return answer;
    }

    public static char[] makeUppercase() {
        char[] uppercase = new char[26];
        for (int i = 0; i < 26; i++) {
            uppercase[i] = (char) (i + 65);
        }
        return uppercase;
    }

    private static char[] makeLowercase() {
        char[] lowercase = new char[26];
        for (int i = 0; i < 26; i++) {
            lowercase[i] = (char) (i + 97);
        }
        return lowercase;
    }
}
