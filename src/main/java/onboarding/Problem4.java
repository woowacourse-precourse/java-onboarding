package onboarding;


public class Problem4 {
    public static String solution(String word) {
        return Convert(word);
    }

    private static String Convert(String word) {

        StringBuilder s = new StringBuilder();

        for (int k = 0; k < word.length(); k++) {
            int a = word.charAt(k);
            s.append(ConvertChar(a));
        }
        return s.toString();
    }

    private static char ConvertChar(int a) {

        if (a >= 65 && a <= 90) {
            return UpperCase(a);
        }
        if (a >= 97 && a <= 122) {
            return LowerCase(a);
        }
        return (char)a;
    }

    private static char UpperCase(int a) {
        return (char)(155 - a);
    }

    private static char LowerCase(int a) {
        return (char)(219 - a);
    }
}