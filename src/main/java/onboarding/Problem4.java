package onboarding;

public class Problem4 {

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            char x = word.charAt(i);
            sb.append(transChar(x));
        }
        return sb.toString();
    }

    static char transChar(char x) {
        if (Character.isLowerCase(x)) {
            return (char)('a' + (25 - (x - 'a')));
        } else if (Character.isUpperCase(x)) {
            return (char)('A' + (25 - (x - 'A')));
        }
        return x;
    }
}
